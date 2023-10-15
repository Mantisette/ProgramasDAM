package progbloque3.examen3articulos;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.TreeMap;

public class Almacen
{

  private static final LinkedHashSet<Almacen> red = new LinkedHashSet<>();

  private final TreeMap<Articulo, Integer> reservas = new TreeMap<>();
  final String ciudad;

  private Almacen(String ciudad)
  {
    this.ciudad = ciudad;
    red.add(this);
  }

  public static boolean nuevoAlmacen(String ciudad)
  {
    if (ciudad == null)
      return false;

    for (Almacen almacen : red)
      if (almacen.ciudad.equals(ciudad))
        return false;

    new Almacen(ciudad);
    return true;
  }

  public static Almacen recuperaAlmacen(int id)
  {
    Almacen resultado=null;
    int contador=1;
    for (Almacen a:red)
    {
      if (contador==id)
      {
        resultado=a;
        break;
      }
      contador++;
    }
    return resultado;
  }

  public static void muestraRed()
  {
    System.out.println("Red de almacenes:");
    int countAlmacenes = 1;
    for (Almacen almacen : red)
    {
      System.out.println("\t" + countAlmacenes + "-" + almacen.ciudad);
      countAlmacenes++;
    }
  }

  public boolean recibe(int id, int cantidad)
  {
    if (cantidad <= 0)
      return false;

    Articulo recibido = Articulo.recuperaArticulo(id);

    if (recibido == null)
      return false;

    if (!reservas.containsKey(recibido))
      // Se introduce primero el articulo para poder sumarle la cantidad, por si no existe
      reservas.put(recibido, 0);
    reservas.put(recibido, reservas.get(recibido) + cantidad);

    return true;
  }

  public void muestraExistencias()
  {
    System.out.println("Reservas de " + this.ciudad + ":");

    for (Articulo articulo : reservas.keySet())
      System.out.println("\t" + articulo + "->" + reservas.get(articulo) + "ud");
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    Almacen almacen = (Almacen) o;
    return ciudad.equals(almacen.ciudad);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(ciudad);
  }
}
