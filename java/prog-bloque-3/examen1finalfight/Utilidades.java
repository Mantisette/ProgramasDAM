package progbloque3.examen1finalfight;

import java.util.Scanner;

public class Utilidades
{
  public static final String VOCALES = "aeiou";
  public static final String CONSONANTES = "bcdfghjklmnpqrstvwxyz";

  private static final Scanner sc = new Scanner(System.in);

  static int pideInt()
  {
    //Para que sólo acepte enteros
    int i = 0;
    boolean valido = false;
    while (!valido)
    {
      if (sc.hasNextInt())
      {
        i = sc.nextInt();
        sc.nextLine();
        valido = true;
      }
      else
        sc.nextLine();
    }
    return i;
  }

  static String generaNombreAleatorio(String inicial)
  {
    StringBuilder nombre = new StringBuilder(inicial);
    nombre.append(vocalAleatoria());
    nombre.append(consonanteAleatoria());
    if (Math.random() < 0.5)
    {
      //por añadir un poco de variedad a la estructura
      nombre.append(vocalAleatoria());
      nombre.append(consonanteAleatoria());
    }
    else
    {
      nombre.append(consonanteAleatoria());
      nombre.append(vocalAleatoria());
    }
    return nombre.toString();
  }

  static String vocalAleatoria()
  {
    int pos = (int)(Math.random() * VOCALES.length());
    return VOCALES.substring(pos, pos+1);
  }

  static String consonanteAleatoria()
  {
    int pos = (int)(Math.random() * CONSONANTES.length());
    return CONSONANTES.substring(pos, pos+1);
  }
}
