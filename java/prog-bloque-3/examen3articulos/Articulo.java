package progbloque3.examen3articulos;

import java.util.TreeMap;

public class Articulo implements Comparable<Articulo>
{

  private static int contador=0;
  private static final TreeMap<Integer, Articulo> catalogo = new TreeMap<>();

  final int id;
  final String nombre;
  final float precio;

  public Articulo(String nombre, float precio)
  {
    id = contador++;
    this.nombre = nombre;
    this.precio = precio;

    catalogo.put(id, this);
  }

  @Override
  public String toString()
  {
    return "(" + id + ")" + nombre + " - " + String.format("%.2f", precio) + "€";
  }

  @Override
  public int compareTo(Articulo articulo)
  {
    return this.id - articulo.id;
  }

  public static Articulo recuperaArticulo(int id)
  {
    //No me molesto en devolver una copia, porque todas sus propiedades son final
    return catalogo.get(id);
  }

  public static void muestraCatalogo()
  {
    System.out.println("Catálogo: ");
    for (Integer id : catalogo.keySet())
      System.out.println(catalogo.get(id));
  }
}
