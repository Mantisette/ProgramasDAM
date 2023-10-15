package progbloque3.examen2torneo;

import java.util.*;

public class Principal
{

  private static final int MAX_EQUIPOS_PAIS = 3;

  private static final Scanner sc = new Scanner (System.in);
  private static final TreeMap<String, LinkedHashSet<Equipo>> hojaRegistro = new TreeMap<>(
    new Comparator<String>()
    {
      @Override
      public int compare(String o1, String o2)
      {
        return o1.compareToIgnoreCase(o2);
      }
    }
  );

  public static void main(String[] args)
  {
    String opcion;
    do
    {
      System.out.println("\nElige una opción:");
      System.out.println("\ta) Inscribe un nuevo equipo");
      System.out.println("\tb) Lista los equipos de un país");
      System.out.println("\tc) Lista todos los equipos");
      System.out.println("\tx) Salir");
      opcion=sc.nextLine();
      switch (opcion)
      {
        case "a" -> inscribeEquipo();
        case "b" -> equiposPorPais();
        case "c" -> todosLosEquipos();
        case "x" -> System.out.println("¡Hasta otra!");
        default  -> System.out.println("Selección inválida");
      }
    } while (!opcion.equals("x"));
  }

  private static void inscribeEquipo()
  {
    String nombre, pais;
    Equipo equipo;

    //Pedimos los datos del equipo
    System.out.println("Nombre del equipo:");
    nombre=sc.nextLine();
    System.out.println("País por el que participa:");
    pais=sc.nextLine();
    equipo=new Equipo(nombre,pais);

    /*Inscribe el equipo.
    Ten en cuenta, que no se permiten más de 3 en cada país, ni repetir
    el nombre de un equipo dentro del mismo país*/
    //...Actividad 3

    if (hojaRegistro.containsKey(pais) && hojaRegistro.get(pais).size() >= MAX_EQUIPOS_PAIS)
    {
      System.out.println("Ya no se aceptan más equipos por " + pais);
      return;
    }

    //Añadimos al equipo los jugadores que queramos
    inscribeJugadoresEquipo(equipo);

    LinkedHashSet<Equipo> creandoEquipo = new LinkedHashSet<>();
    creandoEquipo.add(equipo);

    hojaRegistro.put(pais, creandoEquipo);
  }

  private static void inscribeJugadoresEquipo(Equipo equipo)
  {
    while(true)
    {
      System.out.println("Jugador ('x' para terminar):");
      String jugador = sc.nextLine();

      if (jugador.equals("x"))
        break;
      else
        equipo.inscribeJugador(jugador);
    }
  }

  private static void equiposPorPais()
  {
    String pais;
    System.out.println("Dime el país:");
    pais = sc.nextLine();

    if (!hojaRegistro.containsKey(pais))
    {
      System.out.println("No hay equipos registrados para " + pais);
      return;
    }

    System.out.println(pais);
    System.out.println(hojaRegistro.get(pais));
    //...Actividad 4
  }

  private static void todosLosEquipos()
  {
    if (hojaRegistro.isEmpty())
      System.out.println("No hay nada que mostrar.");
    //...Actividad 5
  }
}
