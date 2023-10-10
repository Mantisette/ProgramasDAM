package progbloque2.examen02seres;

import progbloque2.examen02seres.entidad.*;
import progbloque2.examen02seres.posicion.*;

import java.util.Arrays;
import java.util.Comparator;

public class Main
{

  public static void main(String[] args)
  {

    Humano h1 = new Humano(new Punto(1,0),"Ana");
    Humano h2 = new Humano("Bartolo");
    Animal a3 = new Animal(new Punto(5,0),7);
    Animal a4 = new Animal(2);
    Planta p5 = new Planta(new Punto(3,0));
    Planta p6 = new Planta(new Punto(5,5));

    System.out.println("\nRecien creados y con sufrimiento:");
    System.out.println("--------------------------------");
    Biologico[] lista1 = {h1,h2,a3,a4,p5,p6};
    for(Biologico x:lista1)
    {
      x.sufrir((int)(Math.random()*50));
      System.out.println(x);
    }

    System.out.println("\nTODOS Mostrados segun su orden natural con nulos al principio:");
    System.out.println("-------------------------------------------------------------");
    Ser[] todos = Ser.getSeres();
    todos[2] = null;
    todos[4] = null;
    Arrays.sort(todos, Comparator.nullsFirst(Comparator.naturalOrder()));
    for(Ser x:todos) System.out.println(x);

    Robot r7 = new Robot(Ubicaciones.OESTE.getPunto());
    Herramienta h8 = new Herramienta(Ubicaciones.NORTE.getPunto());
    Robot r9 = new Robot(Ubicaciones.SUR.getPunto());
    Herramienta h10 = new Herramienta(Ubicaciones.ESTE.getPunto());

    System.out.println("\nDetectando:");
    System.out.println("----------");
    //Creamos un animal en una posicion al azar y hacemos que detecte lo que haya cerca
    Animal olisqueador = new Animal(8);
    olisqueador.detectar();

    System.out.println("\nManipulaciones:");
    System.out.println("--------------");
    Mecanico[] lista2 = {r7,h8,r9,h10};
    lista2[0].encender();
    lista2[1].encender();

    // A continuacion, recorre el array lista1 con un 'for mejorado'. Para cada elemento de lista1 que pueda manipular, haz que manipule todos los elementos que pueda de lista2
    for(Biologico b:lista1)
      if(b instanceof Inteligencia)
        for(Mecanico m:lista2)
          if(m instanceof Manipulable)
            ((Inteligencia)b).manipular((Manipulable)m);
  }
}
