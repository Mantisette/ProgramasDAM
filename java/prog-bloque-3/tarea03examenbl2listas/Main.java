package progbloque3.tarea03examenbl2listas;

import progbloque3.tarea03examenbl2listas.entidad.*;
import progbloque3.tarea03examenbl2listas.posicion.Punto;
import progbloque3.tarea03examenbl2listas.posicion.Ubicaciones;

import java.util.*;

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
    ArrayList<Biologico> lista1 = new ArrayList<>();

    lista1.add(h1);
    lista1.add(h2);
    lista1.add(a3);
    lista1.add(a4);
    lista1.add(p5);
    lista1.add(p6);

    for(Biologico x : lista1)
    {
      x.sufrir((int)(Math.random()*50));
      System.out.println(x);
    }

    System.out.println("\nTODOS Mostrados segun su orden natural con nulos al principio:");
    System.out.println("-------------------------------------------------------------");
    ArrayList<Ser> todos = new ArrayList<>(Ser.getSeres());
    todos.set(2, null);
    todos.set(4, null);
    // DONE: Ordenar array todos, nulls al principio
    todos.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
    for(Ser x:todos) System.out.println(x);

    Robot r7 = new Robot(Ubicaciones.OESTE.getPunto());
    Herramienta h8 = new Herramienta(Ubicaciones.NORTE.getPunto());
    Robot r9 = new Robot(Ubicaciones.SUR.getPunto());
    Herramienta h10 = new Herramienta(Ubicaciones.ESTE.getPunto());

    System.out.println("\nDetectando:");
    System.out.println("----------");
    //Creamos un animal en una posición al azar y hacemos que detecte lo que haya cerca
    Animal olisqueador=new Animal(new Punto(0, 0), 10);
    olisqueador.detectar();

    System.out.println("\nManipulaciones:");
    System.out.println("--------------");
    ArrayList<Mecanico> lista2 = new ArrayList<>();

    lista2.add(r7);
    lista2.add(h8);
    lista2.add(r9);
    lista2.add(h10);

    lista2.get(0).encender();
    lista2.get(1).encender();

    // A continuación, recorre el array lista1 con un 'for mejorado'. Para
    // cada elemento de lista1 que pueda manipular, haz que manipule todos los
    // elementos que pueda de lista2
    for (Ser ser : lista1)
    {
      if (ser instanceof Inteligencia manipulador)
      {
        for (Mecanico mecanico : lista2)
          if (mecanico instanceof Manipulable)
            manipulador.manipular((Manipulable) mecanico);
      }
    }
  }
}
