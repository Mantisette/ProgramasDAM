package progbloque4.tarea05numerosprimos;

import java.io.*;

public class Main
{

  static final int LIMITE = 500;
  static final File ARCHIVO = new File("pruebaPrimos.txt");

  public static void main(String[] args)
  {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO)))
    {
      for (int i = 1; i <= LIMITE; i++)
        if (esPrimo(i))
          bw.write("" + i + " ");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO)))
    {
      String linea = "";
      while (linea != null)
      {
        System.out.println(linea);
        linea = br.readLine();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  static boolean esPrimo(int n)
  {
    for (int i = 2; i <= n/2; i++)
      if (n % i == 0)
        return false;

    return true;
  }
}
