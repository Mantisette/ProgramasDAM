package progbloque4.tarea02_1excepcionesp1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{

  public static void main(String[] args)
  {
    final Scanner sc = new Scanner(System.in);
    final int LIMITE_NUMEROS = 6;

    int mayor = 0;
    int[] numeros = new int[LIMITE_NUMEROS];

    System.out.println("Introduce seis numeros: ");

    for (int i = 0; i < LIMITE_NUMEROS; i++)
    {
      try
      {
        int input = sc.nextInt();
        numeros[i] = input;
      }
      catch (InputMismatchException e)
      {
        System.out.println("El numero introducido no es valido");
        i--; // try again
      }
      finally
      {
        sc.nextLine();
      }
    }

    for (int i = 0; i < LIMITE_NUMEROS; i++)
      mayor = Math.max(mayor, numeros[i]);

    System.out.println("El mayor de los numeros es: " + mayor);
  }
}
