package progbloque2.tarea01fabrica;

import java.util.Scanner;

public class Main
{

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int seleccion;

    System.out.println("En nuestra fabrica producimos " + Modelo.values().length
      + " modelos de coche diferentes:");
    for (Modelo m : Modelo.values())
      System.out.println(m.name() + ": " + m);

    while (true)
    {
      System.out.println("¿Cuantos coches quieres fabricar?");
      if (sc.hasNextInt())
      {
        seleccion = sc.nextInt();
        break;
      }
      else
        System.out.println("Por favor, introduzca datos validos");
    }

    for(int i = 0; i < seleccion; i++)
      System.out.println(new Coche());
  }
}
