package progbloque2.tarea05electrodomesticos;

public class Lavadora extends Electrodomestico
{

  public static final String DESCRIPCION_DEFECTO = "Lavadora";
  public static final int CAPACIDAD_CARGA_DEFECTO = 5;
  public static final int CAPACIDAD_CARGA_GRATIS = 10;
  public static final int PRECIO_CARGA_PLUS = 30;

  private final int capacidadCarga;

  public Lavadora(String descripcion, Color color, Consumo consumo, double precioBase, int capacidadCarga)
  {
    super(descripcion, color, consumo, precioBase);
    this.capacidadCarga = capacidadCarga;

    if (capacidadCarga > CAPACIDAD_CARGA_GRATIS)
      this.precioExtra += PRECIO_CARGA_PLUS;
    calcularPrecioFinal(); // llamada redundante, funcionamiento esperado.
  }

  public Lavadora()
  {
    this(DESCRIPCION_DEFECTO, COLOR_DEFECTO, CONSUMO_DEFECTO, PRECIO_DEFECTO,
      CAPACIDAD_CARGA_DEFECTO);
  }

  @Override
  public String toString()
  {
    return super.toString() + " [" + capacidadCarga + "Kg.]";
  }

  public int getCapacidadCarga()
  {
    return capacidadCarga;
  }
}
