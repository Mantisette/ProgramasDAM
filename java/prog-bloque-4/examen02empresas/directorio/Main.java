package progbloque4.examen02empresas.directorio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import progbloque4.examen02empresas.empresa.LumaException;
import progbloque4.examen02empresas.empresa.Empleado;
import progbloque4.examen02empresas.empresa.Empresa;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{

  private static Scanner sc;
  private static String tipo;
  private final static String ARCHIVO_BINARIO =
    "src\\progbloque4\\examen02empresas\\directorio\\empresas.ser";
  private final static String ARCHIVO_TEXTO =
    "src\\progbloque4\\examen02empresas\\directorio\\empresas.json";
  private static ArrayList<Empresa> directorio;
  private static Gson gson;

  private static final String ERROR_GUARDADO = "Error al guardar los cambios.";
  private static final String ERROR_LECTURA_NOT_FOUND = "No se ha encontrado el archivo: ";
  private static final String ERROR_LECTURA_IOEXC = "Error al leer el archivo: ";

  public static void main(String[] args)
  {
    sc = new Scanner(System.in);
    gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    directorio = new ArrayList<>();
    leerDatosIniciales();
    tratamiento();
  }

  private static void leerDatosIniciales()
  {
    do
    {
      System.out.println("¿Vas a trabajar con datos binarios(b) o de texto(t)?");
      tipo = sc.nextLine();
    } while (!tipo.equals("b") && !tipo.equals("t"));

    if(tipo.equals("b"))
    {
      //********** Inicio Ejercicio 9 *************//
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_BINARIO)))
      {
        directorio = (ArrayList<Empresa>) ois.readObject();
      }
      catch (FileNotFoundException e)
      {
        System.out.println(ERROR_LECTURA_NOT_FOUND + ARCHIVO_BINARIO);
      }
      catch (IOException e)
      {
        System.out.println(ERROR_LECTURA_IOEXC + ARCHIVO_BINARIO);
      }
      catch (ClassNotFoundException e)
      {
        System.out.println(e.getMessage());
      }

      //********** Fin Ejercicio 9 *************//
    }
    else
    {
      //********** Inicio Ejercicio 10 *************//
      try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_TEXTO)))
      {
        Type tipoDirectorio = new TypeToken<ArrayList<Empresa>>(){}.getType();
        directorio = gson.fromJson(br, tipoDirectorio);
      }
      catch (FileNotFoundException e)
      {
        System.out.println(ERROR_LECTURA_NOT_FOUND + ARCHIVO_TEXTO);
      }
      catch (IOException e)
      {
        System.out.println(ERROR_LECTURA_IOEXC + ARCHIVO_TEXTO);
      }
      //********** Fin Ejercicio 10 *************//
    }
  }

  private static void tratamiento()
  {
    String opcion = "";
    while (!opcion.equals("0"))
    {
      System.out.println();
      System.out.println("1) Mostrar directorio de empresas");
      System.out.println("2) Añadir nueva empresa");
      System.out.println("3) Guardar cambios");
      System.out.println("0) Salir");
      opcion = sc.nextLine();
      switch (opcion)
      {
        case "1":
          muestraDirectorio();
          break;
        case "2":
          nuevaEmpresa();
          break;
        case "3":
          guardarCambios();
          break;
        case "0":
          System.out.println("¡Hasta pronto!");
      }
    }
  }

  private static void muestraDirectorio()
  {
    int cantidad = directorio.size();
    if (cantidad == 0)
      System.out.println("El directorio no tiene empresas");
    else
    {
      System.out.println("Tenemos registradas " + cantidad + " empresas:");
      for (Empresa e:directorio)
        System.out.println(e);
    }
  }

  private static void nuevaEmpresa()
  {
    //Datos básicos
    System.out.println("Intoduce cif de la nueva empresa: ");
    String cif = sc.nextLine();
    System.out.println("Intoduce razon social de la nueva empresa: ");
    String razon = sc.nextLine();
    Empresa empresa = new Empresa(cif, razon);
    // Empleados de la empresa
    while (true)
    {
      System.out.println("Introduce el nif del empleado ('x' para terminar): ");
      String nif=sc.nextLine();
      if (nif.equals("x"))
        break;
      System.out.println("Introduce el nombre: ");
      String nombre=sc.nextLine();

      //********** Inicio Ejercicio 6 *************//
      System.out.println("Introduce el salario: ");
      try
      {
        float salario = sc.nextFloat();
        empresa.insertaEmpleado(Empleado.crearEmpleado(nif, nombre, salario));
      }
      catch (InputMismatchException e)
      {
        System.out.println("El salario introducido no es valido");
      }
      catch (LumaException e)
      {
        System.out.println(e.getMessage());
      }
      finally
      {
        sc.nextLine();
      }
      //********** Fin Ejercicio 6 *************//
    }
    directorio.add(empresa);
  }

  private static void guardarCambios()
  {
    if(tipo.equals("b"))
    {
      //********** Inicio Ejercicio 7 *************//
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_BINARIO)))
      {
        oos.writeObject(directorio);
        System.out.println("Guardado con éxito.");
      }
      catch (IOException e)
      {
        System.out.println(ERROR_GUARDADO);
      }
      //********** Fin Ejercicio 7 *************//
    }
    else
    {
      //********** Inicio Ejercicio 8 *************//
      try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_TEXTO)))
      {
        Type tipoDirectorio = new TypeToken<ArrayList<Empresa>>(){}.getType();
        gson.toJson(directorio, tipoDirectorio, bw);
      }
      catch (IOException e)
      {
        System.out.println(ERROR_GUARDADO);
      }
      //********** Fin Ejercicio 8 *************//
    }
  }
}
