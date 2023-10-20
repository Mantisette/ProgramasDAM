package progbloque4.tarea07ordenararchivo;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;

public class Main
{

  static final File ARCHIVO_INICIAL = new File("palabras.txt");
  static final File ARCHIVO_RESULTANTE = new File("palabras_sort.txt");


  public static void main(String[] args)
  {
    escribePalabras();
    ordenaPalabras();
  }

  public static void escribePalabras()
  {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_INICIAL)))
    {
      bw.write("coche\n");
      bw.write("car\n");
      bw.write("gato\n");
      bw.write("cat\n");
      bw.write("perro\n");
      bw.write("dog\n");
      bw.write("casa\n");
      bw.write("house\n");
      bw.write("humano\n");
      bw.write("human\n");
      bw.write("madre\n");
      bw.write("mother\n");
      bw.write("padre\n");
      bw.write("father\n");
      bw.write("dinero\n");
      bw.write("money\n");
      bw.write("vida\n");
      bw.write("life\n");
      bw.write("medico\n");
      bw.write("medic\n");
    }
    catch (IOException e)
    {
      System.out.println("Error al abrir el archivo: " + ARCHIVO_INICIAL);
    }
  }

  public static void ordenaPalabras()
  {
    LinkedList<String> lista = new LinkedList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_INICIAL)))
    {
      String linea;
      while ((linea = br.readLine()) != null)
        lista.add(linea);
    }
    catch (FileNotFoundException e)
    {
      System.out.println("No se ha encontrado el archivo: " + ARCHIVO_INICIAL);
    }
    catch (IOException e)
    {
      System.out.println("Error al leer el archivo: " + ARCHIVO_INICIAL);
    }

    lista.sort(Comparator.naturalOrder());

    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_RESULTANTE)))
    {
      for (String s : lista)
      {
        bw.write(s);
        bw.write("\n");
      }
    }
    catch (IOException e)
    {
      System.out.println("Error al leer el archivo: " + ARCHIVO_RESULTANTE);
    }
  }
}
