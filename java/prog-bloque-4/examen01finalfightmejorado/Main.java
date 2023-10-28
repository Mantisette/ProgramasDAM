package progbloque4.examen01finalfightmejorado;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Main {
  //Las fuerzas del mal tienen unidades limitadas
  //Si las matas todas -> ganas el juego
  private static final Scanner sc = new Scanner(System.in);

  private static final ArrayList<Villano> villanos = new ArrayList<>();
  private static Heroe heroe;
  private static int contadorTurno;
  private static int resultadoTurno;
  //Para el Hall of fame. Digo TreeMap para que quede ordenado por la clave (que será por bajas)
  private static TreeMap<Heroe, String> tablaPuntos;
  private static ArrayList<String> bajas;

  public static void main(String[] args) {
    inicializaTablaPuntos();
    bajas = new ArrayList<>();
    //Bucle de las partidas
    while (true) {
      //Inicializa datos de la partida
      inicializaPartida();
      //Bucle de los turnos. Infinito. Sólo se saldrá si te matan o los matas a todos
      while (resultadoTurno == 0) {
        contadorTurno++;
        System.out.println("---------------------------------------------------- TURNO " + contadorTurno);
        resultadoTurno = procesaTurno();
      }
      //Fin de la partida
      if (heroe.getEnergia() > 0) {
        System.out.println("**** LO CONSEGUISTE! Has ganado (" + heroe.getBajas() + " bajas) *****");
      } else {
        System.out.println("******* GAME OVER! Has muerto (" + heroe.getBajas() + " bajas) *******");
      }
      tablaPuntos.put(heroe, bajas.toString());
      muestraTablaPuntos();
      System.out.print("Quieres otra partida (s/n)? ");
      if (!sc.nextLine().equals("s")) {
        break;
      }
    }
    System.out.println("Adiós, cobarde!");
  }

  static void inicializaPartida() {
    System.out.println("****************************************************");
    System.out.println("******************* FINAL FIGTH ! ******************");
    System.out.println("****************************************************");
    contadorTurno = 0;
    resultadoTurno = 0;
    Villano.setContadorTotal(0);;
    Villano.setContadorVivos(0);
    villanos.clear();
    //Crea el héroe, y los dos villanos iniciales
    heroe = new Heroe(pideNombre(), Arma.CUCHILLOS);//se le puede poner cualquiera, porque ...
    heroe.pideArma();//... a continuación se le pide al usuario que elija una
    nuevoVillano();
    nuevoVillano();
    bajas.clear();
  }

  static int procesaTurno() {
    boolean algunoEscondido = false;
    String opcion = "";
    boolean opcionValida=false;
    int numero;
    Villano v;
    Villano atacante;
    Villano victima;
    HashSet<Villano> victimas = new HashSet<>();
    Villano refuerzo;
    boolean ataqueLetal = false;
    boolean enemigoMataEnemigo = false;

    //Si hay más de uno, intenta esconder uno de los enemigos (como mucho uno)
    if (Villano.getContadorVivos() > 1) {
      for (Villano vil : villanos) {
        if (!algunoEscondido) {
          algunoEscondido = vil.ocultar();
        } else {
          vil.setOculto(false);
        }
      }
    } else {//Si sólo hay uno, no lo podemos esconder!!!
      for (Villano vil : villanos) {
        vil.setOculto(false);
      }
    }

    //Muestra la lista de enemigos salvo los ocultos
    for (int i = 0; i < villanos.size(); i++) {
      v = villanos.get(i);
      if (v.isOculto()) {
        continue;
      }
      System.out.print(i + "." + v + " ");
    }
    System.out.println("\n");


    //Muestra los datos del héroe y le da a elegir entre cambiar de arma o atacar
    while(!opcionValida){
      //...
      System.out.print(heroe + " Elige nº de enemigo, (a)taque melé, ó (c)ambiar de arma: ");
      //...
      //Llama al método para recuperar la opción elegida
      //...
    }


    if (opcion.equals("c")) {//Si elige cambio de arma ... la cambia pero no ataca
      heroe.pideArma();
    } else {//Ataca a un enemigo

      //Construyo un array con las víctimas (bajas) de mi ataque
      if(opcion.equals("a")){//Si he elegido un ataque melé, la lista será la que me devuelva el método
        victimas = heroe.ataqueMele(villanos);
      }else{//Si he elegido un enemigo concreto, la lista de bajas puede ser de 0 ó 1
        numero=Integer.parseInt(opcion);
        victima = villanos.get(numero);
        heroe.atacar(victima);
        if (victima.getEnergia() <= 0) {
          victimas.add(victima);
        }
      }

      if (!victimas.isEmpty()) {
        ataqueLetal = true;
        for (Villano vil : victimas) {
          bajas.add(vil.getNombre());
        }
      }

      //Cada víctima tiene la oportunidad de ser resucitada por los nigromantes
      for (Villano muerto : victimas) {
        for (Villano x : villanos) {
          if (x == null) {
            break;//esto sobra; es un vetigio de cuando era un array
          }
          if (x.getClass().getSimpleName().equals("Nigromante")) {//... y si hay nigromantes ...
            if (x.getEnergia() <= 0) {
              continue;//... vivos ...
            }
            if (((Nigromante) x).vidaDeSangre(muerto)) {// ... intentan resucitar a la última víctima...
              break;// ... y si uno lo consigue, los demás ya no lo intentan
            }
          }
        }
      }

      quitaVillanosMuertos();//por si me he cargado alguno y no ha sido resucitado

    }

    //Si no quedan enemigos, se acabó
    if (Villano.getContadorVivos() <= 0) {
      return 1;
    }

    //Después de la decisión del héroe, le toca a un enemigo al azar
    atacante = villanos.get((int) (Math.random() * Villano.getContadorVivos()));
    if (atacante.getClass().getSimpleName().equals("Nigromante")) {// ...los nigromantes atacan...
      ((Nigromante) atacante).lanzaAtaqueMasivo(villanos, heroe);//... al héroe y al resto de villanos ...
      //por si alguno ha muerto a consecuencia del ataque de un nigromante
      if (quitaVillanosMuertos() > 0) {
        enemigoMataEnemigo = true;
      }
    } else {
      atacante.atacar(heroe);//Los demás sólo atacan al héroe
    }

    //Si he hecho un ataque mortal y sigo vivo. Alguno llama refuerzos
    if ((ataqueLetal || enemigoMataEnemigo) && heroe.getEnergia() > 0) {
      for (Villano cobarde : villanos) {
        if (cobarde.getEnergia() > 0) {
          refuerzo = cobarde.pedirAyuda();
          if (refuerzo != null) {//Si hay refuerzo, se añade en la primera que no está ocupada...
            villanos.add(refuerzo);//...según quedó tras la última ordenación
          }
          break;
        }
      }
    }

    if (heroe.getEnergia() <= 0) {//Si en ese turno el guerrero ha muerto, devuelve -1 (muerte)
      return -1;
    } else if (Villano.getContadorVivos() <= 0) {//Si en ese turno ya no quedan enemigos vivos, devuelve 1 (victoria)
      return 1;
    } else {
      return 0;//En un turno normal, devuelve 0;
    }
  }

  //---------------------- AUXILIARES ----------------------------------------
  static void nuevoVillano() {
    Villano v = Villano.generaVillanoaleatorio();
    villanos.add(v);
  }

  static int quitaVillanosMuertos() {
//        //No puedo eliminar de una colección mientras estoy iterando. Uso una auxiliar
//        HashSet<Villano> fiambres=new HashSet<>();
//        for(Villano v:villanos){
//            if(v.getEnergia()<=0){
//                fiambres.add(v);
//                Villano.reduceContadorVivos(1);
//            }
//        }
//        villanos.removeAll(fiambres);

    //Otra forma de hacerlo (no la hemos visto en clase pero no es difícil)
    //Podemos usar un iterador, que mantiene su propia secuencia de elementos y,
    //por tanto, no causa problemas si eliminamos algún elemento de la
    //collección mientras estoy iterando
    int eliminados = 0;
    Iterator<Villano> iv = villanos.iterator();//iv será un objeto que implementa el inerfaz 'Iterator'
    while (iv.hasNext()) {//recorro los elementos del iterador (los de la colección)
      Villano candidato = iv.next();
      if (candidato.getEnergia() <= 0) {
        iv.remove();//Elimina de forma segura el elemento actual del iterador (en realidad, de la colección)
        eliminados++;
        Villano.reduceContadorVivos(1);
      }
    }

    //Ordena la lista de enemigos
    Collections.sort(villanos);//ya no hay nulos

//        return fiambres.size();
    return eliminados;
  }

  static String pideNombre() {
    String nombre;
    boolean repetido;
    do {
      System.out.print("Dime un nombre para el Héroe: ");
      nombre = sc.nextLine();
      repetido = false;
      for (Heroe h : tablaPuntos.keySet()) {
        if (h.getNombre().equals(nombre)) {
          repetido = true;
          System.out.print("Ya existe. ");
          break;
        }
      }
    } while (repetido);
    return nombre;
  }



  static void inicializaTablaPuntos() {
    tablaPuntos = new TreeMap<>();
  }

  static void muestraTablaPuntos() {
    Heroe h;
    String l;
    System.out.println("***************** Hall of fame *****************");
    for (Map.Entry<Heroe, String> entrada : tablaPuntos.entrySet()) {
      h = entrada.getKey();
      l = entrada.getValue();
      System.out.println(h.getNombre() + "(" + h.getArma().nombre + "/" + h.getBajas() + ") -->" + l);
    }
    System.out.println("************************************************");
  }
}
