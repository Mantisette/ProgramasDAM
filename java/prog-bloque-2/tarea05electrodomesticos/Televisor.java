package progbloque2.tarea05electrodomesticos;

public class Televisor extends Electrodomestico
{

  public static final String DESCRIPCION_DEFECTO = "Televisor";
  public static final int PULGADAS_DEFECTO = 20;
  public static final int PRECIO_PULGADAS_PLUS = 10;

  private final int pulgadas;

  public Televisor(String descripcion, Color color, Consumo consumo, double precioBase, int pulgadas)
  {
    super(descripcion, color, consumo, precioBase);
    this.pulgadas = pulgadas;

    if (pulgadas > PULGADAS_DEFECTO)
      this.precioExtra += (pulgadas-PULGADAS_DEFECTO) * PRECIO_PULGADAS_PLUS;
    calcularPrecioFinal(); // llamada redundante, funcionamiento esperado.
  }

  public Televisor()
  {
    this(DESCRIPCION_DEFECTO, COLOR_DEFECTO, CONSUMO_DEFECTO, PRECIO_DEFECTO, PULGADAS_DEFECTO);
  }

  @Override
  public String toString()
  {
    return super.toString() + " [" + pulgadas + "pulg.]";
  }

  public int getPulgadas()
  {
    return pulgadas;
  }
}
