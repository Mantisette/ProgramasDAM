package progbloque2.tarea10recursividad;

public class PiezaCompuesta extends Pieza
{

  private final Pieza[] componentes;
  private final int[] cantidades;

  public PiezaCompuesta(String nombre, Pieza[] componentes, int[] cantidades)
  {
    super(nombre, calcularCosteTotal(componentes, cantidades));
    this.componentes = componentes;
    this.cantidades = cantidades;
  }

  @Override
  public String toString()
  {
    return "[" + id + "] " + nombre + ' ' + "coste: " + coste + "euros";
  }

  static double calcularCosteTotal(Pieza[] componentes, int[] cantidades)
  {
    double costeTotal = 0;
    for (int i = 0; i < componentes.length; i++)
      costeTotal += componentes[i].coste * cantidades[i];

    return costeTotal;
  }
}
