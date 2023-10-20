package progbloque4.tarea08facturasbinario;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{

  private static final Scanner sc = new Scanner(System.in);
  private static final Gson gson = new GsonBuilder()
    .enableComplexMapKeySerialization()
    .serializeNulls()
    .setPrettyPrinting()
    .create();
  private static final String ARCHIVO = "facturas.json";
  private static ArrayList<Factura> papeleo = new ArrayList<>();
  private static boolean encendido = true;

  public static void main(String[] args)
  {
    while (encendido)
    {
      try
      {
        mostrarMenu();
        System.out.print("Seleccion: ");
        seleccionMenu();
      }
      catch (NumberFormatException | InputMismatchException e)
      {
        System.out.println("La opcion elegida no es valida");
      }
    }
  }

  public static void mostrarMenu()
  {
    System.out.println("1) Crear facturas");
    System.out.println("2) Guardar facturas en archivo");
    System.out.println("3) Importar facturas de archivo");
    System.out.println("4) Mostrar facturas");
    System.out.println("5) Salir");
  }

  public static void seleccionMenu() throws NumberFormatException, InputMismatchException
  {
    int seleccion = sc.nextInt();
    sc.nextLine();
    switch (seleccion)
    {
      case 1 ->
      {
        try
        {
          papeleo.add(crearFactura());
        }
        catch (NumberFormatException | InputMismatchException e)
        {
          System.out.println("Opcion invalida. Volviendo al menu");
        }
      }
      case 2 ->
      {
        if (papeleo.isEmpty())
        {
          System.out.println("No hay facturas. Cree o importe una factura y vuelva a intentarlo");
        }
        else
          guardarCambios();
      }
      case 3 ->
        importarFacturas();
      case 4 ->
      {
        if (papeleo.isEmpty())
          System.out.println("No hay facturas. Cree o importe una factura y vuelva a intentarlo");
        else
          for (Factura factura : papeleo)
            System.out.println(factura);
      }
      case 5 ->
      {
        System.out.println("Saliendo...");
        encendido = false;
      }
      default ->
        System.out.println("La opcion elegida no es valida");
    }
  }

  public static Factura crearFactura() throws NumberFormatException, InputMismatchException
  {
    String referencia;
    double importe;
    boolean abonada;

    System.out.print("Introduzca la referencia: ");
    referencia = sc.nextLine();

    System.out.print("Introduzca el importe: ");
    importe = sc.nextDouble();

    System.out.print("¿Abonada? (S/N): ");
    abonada = switch (sc.next())
    {
      case "S", "s" -> true;
      default -> false;
    };

    return new Factura(referencia, importe, abonada);
  }

  public static void guardarCambios()
  {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO)))
    {
      bw.write(gson.toJson(papeleo));
      System.out.println("Guardado con exito");
    }
    catch (IOException e)
    {
      System.out.println("Error al guardar los cambios");
    }
  }

  public static void importarFacturas()
  {
    try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO)))
    {
      Type tipoArrayList = new TypeToken<ArrayList<Factura>>(){}.getType();
      papeleo = gson.fromJson(br, tipoArrayList);
      System.out.println("Importado con exito");
    }
    catch (FileNotFoundException e)
    {
      System.out.println("No se ha encontrado el archivo: " + ARCHIVO);
    }
    catch (IOException e)
    {
      System.out.println("Error al leer el archivo: " + ARCHIVO);
    }
  }
}
