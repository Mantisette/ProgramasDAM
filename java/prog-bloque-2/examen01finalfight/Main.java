package progbloque2.examen01finalfight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main
{

  // Las fuerzas del mal solo tienen 1000 unidades
  // Si las matas todas -> ganas el juego
  private static final Scanner sc = new Scanner(System.in);
  private static final Villano[] villanos = new Villano[Villano.TOPE_ENEMIGOS];
  private static Heroe heroe;
  private static int contadorTurno;
  private static int resultadoTurno;

  public static void main(String[] args)
  {
    Villano v;
    //Bucle de las partidas
    while (true)
    {
      //Inicializa datos de la partida
      inicializaPartida();
      //Bucle de los turnos. Infinito. Solo se saldra si te matan o los matas a todos
      while (resultadoTurno == 0)
      {
        contadorTurno++;
        System.out.println("---------------------------------------------------- TURNO "+contadorTurno);
        resultadoTurno = procesaTurno();
      }

      //Fin de la partida
      if (heroe.getEnergia()>0)
        System.out.println("**** LO CONSEGUISTE! Has ganado ("+heroe.getBajas()+" bajas) *****");
      else
        System.out.println("******* GAME OVER! Has muerto ("+heroe.getBajas()+" bajas) *******");

      System.out.print("Quieres otra partida (s/n)? ");
      if (!sc.nextLine().equals("s")) break;
    }

    System.out.println("Adios, cobarde!");
  }

  static void inicializaPartida()
  {
    System.out.println("****************************************************");
    System.out.println("******************* FINAL FIGHT ! ******************");
    System.out.println("****************************************************");
    contadorTurno = 0;
    resultadoTurno = 0;
    Villano.setContadorTotal(0);;
    Villano.setContadorVivos(0);
    Arrays.fill(villanos, null);
    //Crea el heroe, y los dos villanos iniciales
    String nombre;
    System.out.print("Dime un nombre para el Heroe: ");
    nombre = sc.nextLine();
    heroe = new Heroe(nombre, Arma.CUCHILLOS); // se le puede poner cualquiera, porque...
    heroe.pideArma(); // ... a continuacion se le pide al usuario que elija una
    nuevoVillano();
    nuevoVillano();
    nuevoVillano();
    nuevoVillano();
    nuevoVillano();
  }

  static int procesaTurno()
  {
    boolean algunoEscondido = false;
    String opcion = "";
    int numero;
    Villano v;
    Villano atacante;
    Villano victima;
    Villano[] victimas;
    Villano refuerzo;
    boolean ataqueLetal = false;
    boolean enemigoValido;

    //Si hay mas de uno, intenta esconder uno de los enemigos (como mucho uno)
    if (Villano.getContadorVivos() > 1)
      for (Villano villano : villanos)
      {
        v = villano;
        if (v == null)
          break; //por la ordenacion que tiene, los null estan al final
        if (!algunoEscondido)
          algunoEscondido = v.ocultar();
        else
          v.setOculto(false);
      }
    else
    {
      //Si solo hay uno, no lo podemos esconder!!!
      for (Villano villano : villanos)
      {
        v = villano;
        if (v == null)
          break; //por la ordenacion que tiene, los null estan al final
        v.setOculto(false);
      }
    }

    //Muestra la lista de enemigos salvo los ocultos
    System.out.print("-1.Mele ");
    for(int i = 0; i < villanos.length; i++)
    {
      v = villanos[i];
      if (v == null)
        break; // por la ordenacion que tiene, los null estan al final
      if (v.isOculto())
        continue;
      System.out.print(i + "." + v + " ");
    }
    System.out.println("\n");

    //Muestra los datos del heroe y le da a elegir entre cambiar de arma o atacar
    while (!opcion.equals("c") && !opcion.equals("a"))
    {
      System.out.print(heroe+" Elige (c)ambiar de arma o (a)tacar: ");
      opcion = sc.nextLine();
    }

    //Si elige cambio de arma ... la cambia pero no ataca
    if (opcion.equals("c"))
      heroe.pideArma();
    else
    {
      //Ataca a un enemigo
      enemigoValido = false;
      while (!enemigoValido)
      {
        System.out.print("Introduce el nº del enemigo: ");
        numero = Utilidades.pideInt();
        if (numero == -1)
        {
          // para evitar problemas
        }
        else if (numero < 0 || numero >= Villano.getContadorVivos() || villanos[numero].isOculto())
        {
          System.out.print("Nº no valido. ");
          continue;
        }
        enemigoValido = true;

        //Construyo un array con las victimas (bajas) de mi ataque
        if (numero >= 0)
        {
          //Si he elegido un enemigo concreto, la lista de bajas puede ser de 0 o 1
          victima = villanos[numero];
          heroe.atacar(victima);
          if (victima.getEnergia() <= 0)
          {
            victimas = new Villano[1];
            victimas[0] = victima;
          }
          else
            victimas = new Villano[0];
        }
        else
          //Si he elegido un ataque mele, la lista sera la que me devuelva el metodo
          victimas = heroe.ataqueMele(villanos);
        if (victimas.length>0)
          ataqueLetal = true;

        //Cada victima tiene la oportunidad de ser resucitada por los nigromantes
        for(Villano muerto:victimas)
          for(Villano x:villanos)
          {
            if (x == null)
              break;

            if (x.getClass().getSimpleName().equals("Nigromante"))
            {
              //... y si hay nigromantes ...
              if (x.getEnergia() <= 0)
                continue; //... vivos ...
              if (((Nigromante)x).vidaDeSangre(muerto))
                // ... intentan resucitar a la ultima victima...
                break; // ... y si uno lo consigue, los demas ya no lo intentan
            }
          }
        quitaVillanosMuertos();//por si me he cargado alguno y no ha sido resucitado
      }
    }

    //Si no quedan enemigos, se acabo
    if (Villano.getContadorVivos() <= 0) return 1;

    //Despues de la decision del heroe, le toca a un enemigo al azar
    atacante = villanos[(int)(Math.random()*Villano.getContadorVivos())];
    if (atacante.getClass().getSimpleName().equals("Nigromante"))
    {
      // ...los nigromantes atacan...
      ((Nigromante)atacante).lanzaAtaqueMasivo(villanos,heroe); //... al heroe y al resto de villanos ...
      quitaVillanosMuertos(); //por si alguno ha muerto a consecuencia del ataque de un nigromante
    }
    else
      atacante.atacar(heroe); //Los demas solo atacan al heroe

    //Si he hecho un ataque mortal y sigo vivo. Alguno llama refuerzos
    if (ataqueLetal && heroe.getEnergia()>0)
      for(Villano cobarde:villanos)
        if (cobarde.getEnergia()>0)
        {
          refuerzo = cobarde.pedirAyuda();
          if (refuerzo != null)
            //Si hay refuerzo, se añade en la primera que no esta ocupada...
            villanos[Villano.getContadorVivos()-1] = refuerzo;//...segun quedo tras la ultima ordenacion
          break;
        }

    if (heroe.getEnergia() <= 0)
      //Si en ese turno el guerrero ha muerto, devuelve -1 (muerte)
      return -1;
    else if (Villano.getContadorVivos() <= 0)
      //Si en ese turno ya no quedan enemigos vivos, devuelve 1 (victoria)
      return 1;
    else
      return 0; //En un turno normal, devuelve 0;
  }

  //---------------------- AUXILIARES ----------------------------------------
  static void nuevoVillano()
  {
    Villano v = Villano.generaVillanoaleatorio();
    villanos[v.getId()] = v;
  }

  static void quitaVillanosMuertos()
  {
    int tope = Villano.getContadorVivos();
    for(int i = 0; i < tope; i++)
      if (villanos[i].getEnergia() <= 0)
      {
        villanos[i] = null;
        Villano.reduceContadorVivos(1);
      }
    //Ordena el array de enemigos, poniendo todos al principio y dejando los huecos nulos al final
    Arrays.sort(villanos, Comparator.nullsLast(Comparator.naturalOrder()));
  }
}
