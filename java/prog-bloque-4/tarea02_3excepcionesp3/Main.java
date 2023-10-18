package progbloque4.tarea02_3excepcionesp3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main
{

  public static void main(String[] args)
  {
    Throwable[] excepciones = new Throwable[]
      {
        new NumberFormatException(),
        new IOException(),
        new FileNotFoundException(),
        new IndexOutOfBoundsException(),
        new ArithmeticException()
      };

    int random = (int)(Math.random() * excepciones.length);

    try
    {
      throw excepciones[random];
    }
    catch (Throwable e)
    {
      System.out.println(e);
    }
  }
}
