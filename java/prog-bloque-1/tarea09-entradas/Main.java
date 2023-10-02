package progbloque1.tarea09entradas;

import java.util.Scanner;

public class Main
{

  public static final Scanner sc = new Scanner(System.in);

  public static final Zona Principal = new Zona(1000);
  public static final Zona CompraVenta = new Zona(200);
  public static final Zona Vip = new Zona(25);

  public static final String[] MENU =
    {
      "MENU PRINCIPAL",
      "1. Mostrar numero de entradas libres",
      "2. Vender entradas",
      "3. Salir"
    };

  public static void main(String[] args)
  {
    while (true)
    {
      // Mostrar menú
      for (String linea : MENU) {
        System.out.println(linea);
      }

      // Pedir opcion
      int opcion = 0;
      if (!sc.hasNextInt())
      {
        System.out.println("Opcion no valida, intentelo de nuevo.");
        sc.nextLine();
        continue;
      }

      opcion = sc.nextInt();
      switch (opcion)
      {
        case 1 ->
          System.out.println(mostrarEntradas());
        case 2 ->
          venderEntradas();
        case 3 -> {
          return;
        }
        default ->
          System.out.println("Opcion no valida, intentelo de nuevo.");
      }
    }
  }

  public static String mostrarEntradas()
  {
    // ¡MANTENER! La anchura del print() depende del número maximo de
    // entradas que se puedan vender en las salas (4 digitos en este caso)
    final StringBuilder sb = new StringBuilder();
    sb.append("Entradas disponibles: ")
      .append(String.format("%n"))
      .append(String.format("%4d", Principal.getEntradasPorVender()))
      .append(" para Sala Principal")
      .append(String.format("%n"))
      .append(String.format("%4d", CompraVenta.getEntradasPorVender()))
      .append(" para Sala Compra-Venta")
      .append(String.format("%n"))
      .append(String.format("%4d", Vip.getEntradasPorVender()))
      .append(" para Sala VIP")
      .append(String.format("%n"));
    return sb.toString();
  }

  public static void venderEntradas()
  {
    int seleccion = 0;
    int entradas = 0;

    System.out.print("Por favor, elija una sala (1. Principal, 2. Compra-Venta, 3. VIP): ");

    if (!sc.hasNextInt())
    {
      System.out.println("Opcion no valida, intentelo de nuevo.");
      sc.nextLine();
      return;
    }
    seleccion = sc.nextInt();

    if (seleccion < 1 || seleccion > 3)
    {
      System.out.println("La seleccion no es valida. Intentelo de nuevo");
      return;
    }

    System.out.print("Por favor, indique cuantas entradas quiere comprar: ");

    if (!sc.hasNextInt())
    {
      System.out.println("Opcion no valida, intentelo de nuevo.");
      sc.nextLine();
      return;
    }
    entradas = sc.nextInt();

    switch (seleccion)
    {
      case 1 -> Principal.vender(entradas);
      case 2 -> CompraVenta.vender(entradas);
      case 3 -> Vip.vender(entradas);
    }
  }
}
