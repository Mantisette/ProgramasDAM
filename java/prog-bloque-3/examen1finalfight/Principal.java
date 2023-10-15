package progbloque3.examen1finalfight;

import java.util.*;

public class Principal
{

  private static final Scanner sc=new Scanner(System.in);
  private static final ArrayList<Villano> villanos=new ArrayList<>();
  private static final TreeMap<Heroe, ArrayList<String>> tablaPuntos = new TreeMap<>(new Comparator<Heroe>()
  {
    @Override
    public int compare(Heroe o1, Heroe o2)
    {
      if (o1.getBajas() > o2.getBajas())
        return -1;
      else if (o1.getBajas() < o2.getBajas())
        return 1;
      else
        return o1.getNombreHeroe().compareToIgnoreCase(o2.getNombreHeroe());
    }
  });

  public static final ArrayList<String> eliminados = new ArrayList<>();

  private static Heroe heroe;
  private static int contadorTurno;
  private static int resultadoTurno;

  public static void main(String[] args)
  {
    //Bucle de las partidas
    while (true)
    {
      //Inicializa datos de la partida
      inicializaPartida();
      //Bucle de los turnos. Infinito. Sólo se saldrá si te matan o los matas a todos
      while (resultadoTurno==0)
      {
        contadorTurno++;
        System.out.println("---------------------------------------------------- TURNO "+contadorTurno);
        resultadoTurno=procesaTurno();
      }
      //Fin de la partida
      if (heroe.getEnergia()>0)
        System.out.println("**** LO CONSEGUISTE! Has ganado ("+heroe.getBajas()+" bajas) *****");
      else
        System.out.println("******* GAME OVER! Has muerto ("+heroe.getBajas()+" bajas) *******");

      tablaPuntos.put(heroe, new ArrayList<>(eliminados));

      System.out.println("********** HALL OF FAME **********");

      for (Map.Entry<Heroe, ArrayList<String>> heroe1 : tablaPuntos.entrySet())
      {
        StringBuilder sb = new StringBuilder();
        sb.append(heroe1.getKey().getNombre())
          .append("(")
          .append(heroe1.getKey().getArma().nombre).append("/").append(heroe1.getKey().getBajas())
          .append(") --> ")
          .append(heroe1.getValue());
        System.out.println(sb);
      }

      System.out.println("**********************************");

      System.out.print("Quieres otra partida (s/n)? ");
      if (!sc.nextLine().equals("s")) break;
    }
    System.out.println("Adiós, cobarde!");
  }

  static void inicializaPartida()
  {
    villanos.clear();
    eliminados.clear();

    System.out.println("****************************************************");
    System.out.println("******************* FINAL FIGHT ! ******************");
    System.out.println("****************************************************");
    contadorTurno=0;
    resultadoTurno=0;
    Villano.setContadorTotal(0);
    Villano.setContadorVivos(0);
    //Crea el héroe, y los dos villanos iniciales
    heroe = new Heroe(pideNombre(), Arma.CUCHILLOS);//se le puede poner cualquiera, porque ...
    heroe.pideArma();//... a continuación se le pide al usuario que elija una
    nuevoVillano();
    nuevoVillano();
  }

  static int procesaTurno()
  {
    boolean algunoEscondido=false;
    String opcion="";
    int numero;
    Villano v;
    Villano atacante;
    Villano victima;
    LinkedHashSet<Villano> victimas = new LinkedHashSet<>();
    Villano refuerzo;
    boolean ataqueLetal=false;
    boolean enemigoValido;

    //Si hay más de uno, intenta esconder uno de los enemigos (como mucho uno)
    if (Villano.getContadorVivos()>1)
      for(Villano villano : villanos)
        if (!algunoEscondido)
          algunoEscondido=villano.ocultar();
        else
          villano.setOculto(false);
    else//Si sólo hay uno, no lo podemos esconder!!!
      for(Villano villano : villanos)
        villano.setOculto(false);

    //Muestra la lista de enemigos salvo los ocultos
    System.out.print("-1.Mele ");
    for (int i = 0; i < villanos.size(); i++)
    {
      Villano villano = villanos.get(i);
      if (villano.isOculto()) continue;
      System.out.print(i+"."+villano+" ");
      //FIXME: normalmente sale un numero no valido
    }

    System.out.println();

    //Muestra los datos del héroe y le da a elegir entre cambiar de arma o atacar
    while (!opcion.equals("c") && !opcion.equals("a"))
    {
      System.out.print(heroe+" Elige (c)ambiar de arma o (a)tacar: ");
      opcion=sc.nextLine();
    }
    if (opcion.equals("c"))
    {
      //Si elige cambio de arma ... la cambia pero no ataca
      heroe.pideArma();
      return 0;
    }
    //Ataca a un enemigo
    enemigoValido=false;
    while (!enemigoValido)
    {
      System.out.print("Introduce el nº del enemigo: ");
      numero=Utilidades.pideInt();
      if (numero==-1)
      { /* para evitar problemas */ }
      else if (numero<0 || numero>=Villano.getContadorVivos() || villanos.get(numero).isOculto())
      {
        System.out.print("Nº no válido. ");
        continue;
      }
      enemigoValido=true;

      //Construyo un array con las víctimas (bajas) de mi ataque
      if (numero>=0)
      {
        //Si he elegido un enemigo concreto, la lista de bajas puede ser de 0 ó 1
        victima = villanos.get(numero);
        heroe.atacar(victima);
        if (victima.getEnergia() <= 0)
          victimas.add(victima);
      }
      else
        //Si he elegido un ataque melé, la lista será la que me devuelva el método
        victimas.addAll((heroe.ataqueMele(villanos)));

      //Cada víctima tiene la oportunidad de ser resucitada por los nigromantes
      for(Villano muerto:victimas)
        for(Villano x:villanos)
          if (x.getClass().getSimpleName().equals("Nigromante"))
          {
            //... y si hay nigromantes ...
            if (x.getEnergia()<=0) continue; //... vivos ...
            if (((Nigromante)x).vidaDeSangre(muerto))
              // ... intentan resucitar a la última víctima...
              break; // ... y si uno lo consigue, los demás ya no lo intentan
          }
      quitaVillanosMuertos(); //por si me he cargado alguno y no ha sido resucitado
    }

    // Luma: antes de salir del turno, guarda las victimas en el ArrayList de eliminados
    for (Villano villano : victimas)
      eliminados.add(villano.getNombre());

    //Si no quedan enemigos, se acabó
    if (Villano.getContadorVivos()<=0) return 1;

    //Después de la decisión del héroe, le toca a un enemigo al azar
    atacante= villanos.get((int) (Math.random() * Villano.getContadorVivos()));
    if (atacante.getClass().getSimpleName().equals("Nigromante"))
    {
      // ...los nigromantes atacan...
      ((Nigromante)atacante).lanzaAtaqueMasivo(villanos,heroe); //... al héroe y al resto de villanos ...
      quitaVillanosMuertos(); //por si alguno ha muerto a consecuencia del ataque de un nigromante
    }
    else
      atacante.atacar(heroe);//Los demás sólo atacan al héroe

    //Si he hecho un ataque mortal y sigo vivo. Alguno llama refuerzos
    if (ataqueLetal && heroe.getEnergia()>0)
      for(Villano cobarde:villanos)
        if (cobarde.getEnergia()>0)
        {
          refuerzo=cobarde.pedirAyuda();
          if (refuerzo!=null)
            //Si hay refuerzo, se añade
            villanos.add(refuerzo);
          break;
        }

    if (heroe.getEnergia()<=0)
      //Si en ese turno el guerrero ha muerto, devuelve -1 (muerte)
      return -1;
    else if (Villano.getContadorVivos()<=0)
      //Si en ese turno ya no quedan enemigos vivos, devuelve 1 (victoria)
      return 1;
    else
      return 0;//En un turno normal, devuelve 0;
  }

  //---------------------- AUXILIARES ----------------------------------------
  static void nuevoVillano()
  {
    villanos.add(Villano.generaVillanoaleatorio());
  }

  static void quitaVillanosMuertos()
  {
    Iterator<Villano> eliminaCadaveres = villanos.iterator();

    while (eliminaCadaveres.hasNext())
    {
      Villano villano = eliminaCadaveres.next();
      if (villano.getEnergia() <= 0)
      {
        eliminaCadaveres.remove();
        Villano.reduceContadorVivos(1);
      }
    }
    villanos.sort(Comparator.naturalOrder());
  }

  static String pideNombre()
  {
    String input;

    whileNombre: while (true)
    {
      System.out.print("Dime un nombre para el Héroe: ");
      input = sc.nextLine();

      for (Heroe heroe1 : tablaPuntos.keySet())
        if (input.equals(heroe1.getNombreHeroe()))
        {
          System.out.println("El nombre introducido no es válido.");
          continue whileNombre;
        }

      return input;
    }
  }
}
