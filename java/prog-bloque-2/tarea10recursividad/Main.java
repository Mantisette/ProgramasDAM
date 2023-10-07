package progbloque2.tarea10recursividad;

public class Main
{

  public static void main(String[] args)
  {
    Pieza tornillo = new Pieza("Tornillo", 0.1);
    Pieza tuerca = new Pieza("Tuerca", 0.2);
    Pieza arandela = new Pieza("Tuerca", 0.05);
    PiezaCompuesta cuarteto = new PiezaCompuesta(
      "Cuarteto",
      new Pieza[]
        {
          tornillo, tuerca, arandela
        },
      new int[]
        {
          1, 1, 2
        }
    );

    Pieza pata = new Pieza("Pata", 3.5);
    Pieza baseChica = new Pieza("Base Chica", 3.0);
    Pieza baseGrande = new Pieza("Base Grande", 5);

    Producto taburete = new Producto(
      "Taburete",
      new Pieza[]
        {
          pata, cuarteto, baseChica
        },
      new int[]
        {
          3, 3, 1
        },
      19.99
    );
    Producto mesa = new Producto(
      "Mesa",
      new Pieza[]
        {
          pata, cuarteto, baseGrande
        },
      new int[]
        {
          4, 4, 1
        },
      25
    );

    System.out.println(tornillo);
    System.out.println(tuerca);
    System.out.println(arandela);
    System.out.println(cuarteto);
    System.out.println();
    System.out.println(pata);
    System.out.println(baseChica);
    System.out.println(baseGrande);
    System.out.println();
    System.out.println(taburete);
    System.out.println(mesa);

    while (true)
    {
      printMenu();
      System.out.println("Seleccion: ");
      switch (Utilidades.inputInt())
      {
        case 0 -> { return; }
        case 1 -> nuevaElemental();
        default -> System.out.println("Opcion invalida.");
      }
    }
  }

  static void printMenu()
  {
    System.out.println("0) Salir");
    System.out.println("1) Pieza elemental");
    System.out.println("2) Pieza compuesta");
    System.out.println("3) Producto acabado");
    System.out.println("4) Lista piezas");
    System.out.println("5) Lista productos");
    System.out.println("6) Arbol");
  }

  static void nuevaElemental()
  {
    Pieza pieza;
    String nombre;
    double coste;

    System.out.println("Nombre de la pieza: ");
    nombre = Utilidades.inputString();
    System.out.println("Coste de la pieza: ");
    coste = Utilidades.inputDouble();
    pieza = new Pieza(nombre, coste);
    System.out.println("creando... " + pieza);
  }
}
