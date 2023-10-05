package progbloque2.tarea02vehiculos;

import java.util.Scanner;

public class Main
{

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    Coche deportivo = new Coche();
    Bicicleta bici = new Bicicleta();

    while (true)
    {
      System.out.println("VEHICULOS");
      System.out.println("=========");
      System.out.println("1. Anda con la bicicleta");
      System.out.println("2. Haz el caballito con la bicicleta");
      System.out.println("3. Anda con el coche");
      System.out.println("4. Quema rueda con el coche");
      System.out.println("5. Ver kilometraje de la bicicleta");
      System.out.println("6. Ver kilometraje del coche");
      System.out.println("7. Ver kilometraje total");
      System.out.println("8. Salir");
      System.out.println("Elige una opcion (1-8):");

      switch (sc.nextInt())
      {
        case 1 ->
        {
          System.out.println("¿Cuanto quieres andar?");
          bici.andar(sc.nextInt());
        }
        case 2 -> bici.caballito();
        case 3 ->
        {
          System.out.println("¿Cuanto quieres andar?");
          deportivo.andar(sc.nextInt());
        }
        case 4 -> deportivo.quemarRueda();
        case 5 -> System.out.println(bici.getKilometrosRecorridos());
        case 6 -> System.out.println(deportivo.getKilometrosRecorridos());
        case 7 -> System.out.println(Vehiculo.getKilometrosTotales());
        case 8 ->
        {
          return;
        }
      }
    }
  }
}
