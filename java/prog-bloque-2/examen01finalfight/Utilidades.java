package progbloque2.examen01finalfight;

import java.util.Scanner;

public class Utilidades
{

  private static final Scanner sc=new Scanner(System.in);

  static int pideInt()
  {
    //Para que solo acepte enteros
    int i = 0;
    boolean valido = false;
    while (!valido)
      if (sc.hasNextInt())
      {
        i = sc.nextInt();
        sc.nextLine();
        valido = true;
      }
      else
        sc.nextLine();

    return i;
  }
}
