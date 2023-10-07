package progbloque2.tarea10recursividad;

import java.util.Scanner;

public abstract class Utilidades
{

  static Scanner sc = new Scanner(System.in);
  static String inputString()
  {
    return sc.nextLine();
  }

  static int inputInt()
  {
    int input = 0;
    while (true)
    {
      if (sc.hasNextInt())
      {
        input = sc.nextInt();
        sc.nextLine();
        return input;
      }
      else
        System.out.println("El valor introducido no es valido.");
    }
  }

  static double inputDouble()
  {
    double input = 0;

    while (true)
    {
      if (sc.hasNextDouble())
      {
        input = sc.nextDouble();
        sc.nextLine();
        return input;
      }
      else
        System.out.println("El valor introducido no es valido.");
    }
  }
}
