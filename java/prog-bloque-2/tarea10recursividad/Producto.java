package progbloque2.tarea10recursividad;

public final class Producto extends PiezaCompuesta
{

  private final double precioVenta;

  public Producto(String nombre, Pieza[] componentes, int[] cantidades, double precioVenta)
  {
    super(nombre, componentes, cantidades);
    this.precioVenta = precioVenta;
  }

  public Producto(String nombre, Pieza[] componentes, int[] cantidades, int margen)
  {
    super(nombre, componentes, cantidades);
    this.precioVenta = coste * (1+margen / 100f); // la vd es q no entiendo esto pero ok, funca.
  }

  @Override
  public String toString()
  {
    return "[" + id + "] " + nombre + ' ' + "coste: " + coste + "euros" + ' ' + "pvp: " + precioVenta + "euros";
  }
}
