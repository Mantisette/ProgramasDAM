package progbloque4.tarea06numerosprimosbinario;

import java.io.*;

public class Main
{

  static final int LIMITE = 500;
  static final File ARCHIVO = new File("pruebaPrimos.bin");

  public static void main(String[] args)
  {
    try (DataOutputStream dis = new DataOutputStream(new FileOutputStream(ARCHIVO)))
    {
      for (int i = 1; i <= LIMITE; i++)
        if (esPrimo(i))
          dis.writeInt(i);
    }
    catch (IOException e)
    {
      System.out.println("Error al escribir en el archivo: " + ARCHIVO);
    }

    try (DataInputStream dis = new DataInputStream(new FileInputStream(ARCHIVO)))
    {
      int lectura = 0;
      while ((lectura = dis.readInt()) != -1)
        System.out.println(lectura);
    }
    catch (EOFException e)
    {
      System.out.println("Se ha alcanzado el final del archivo");
    }
    catch (IOException e)
    {
      System.out.println("Error al leer el archivo: " + ARCHIVO);
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
