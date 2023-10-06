package progbloque2.tarea05electrodomesticos;

import java.util.Arrays;

public class Electrodomestico
{

  public static final String DESCRIPCION_DEFECTO = "Generico";
  public static final double PRECIO_DEFECTO = 100;
  public static final Color COLOR_DEFECTO = Color.BLANCO;
  public static final Consumo CONSUMO_DEFECTO = Consumo.A;

  public static final int TOPE_ELEC = 100;
  private static int countElectrodomesticos = 0;
  private static final Electrodomestico[] almacen = new Electrodomestico[TOPE_ELEC];

  private final int id;
  private final String descripcion;
  private final Color color;
  private final Consumo consumo;

  private final double precioBase;
  double precioExtra;
  double precioFinal; // atencion!! visibilidad
  private boolean vendido = false;

  public Electrodomestico(String descripcion, Color color, Consumo consumo, double precioBase)
  {
    this.id = ++countElectrodomesticos;

    switch(descripcion)
    {
      // atencion!! mantener si se añaden mas electrodomesticos
      case DESCRIPCION_DEFECTO, Lavadora.DESCRIPCION_DEFECTO, Televisor.DESCRIPCION_DEFECTO
        -> this.descripcion = descripcion + "-" + id;
      default -> this.descripcion = descripcion;
    }

    this.precioBase = precioBase;
    this.color = color;
    this.consumo = consumo;

    precioExtra += consumo.precio;
    calcularPrecioFinal();

    almacen[countElectrodomesticos-1] = this;
  }

  public Electrodomestico()
  {
    this(DESCRIPCION_DEFECTO, COLOR_DEFECTO, CONSUMO_DEFECTO, PRECIO_DEFECTO);
  }

  // se resetea el precioFinal y se vuelve a asignar con los parametros indicados.
  void calcularPrecioFinal()
  {
    this.precioFinal = this.precioBase + this.precioExtra;
  }

  // sustituye al getter de valorVendido
  public static double calcularValorVendido()
  {
    double valorVendido = 0;
    for(int i = 0; i < countElectrodomesticos; i++)
      if (almacen[i].vendido)
        valorVendido += almacen[i].precioFinal;
    return valorVendido;
  }

  // sustituye al getter de valorStock
  public static double calcularValorStock()
  {
    double valorStock = 0;
    for(int i = 0; i < countElectrodomesticos; i++)
      if (!almacen[i].vendido)
        valorStock += almacen[i].precioFinal;
    return valorStock;
  }

  public static void vender(int id)
  {
    if (id <= 0 || id > countElectrodomesticos)
    {
      System.out.println("Ese producto no existe");
      return;
    }

    Electrodomestico actual = almacen[id - 1];
    System.out.println("Preparando venta de " + actual);

    if (actual.vendido)
    {
      System.out.println("... La venta no se ha podido realizar.");
      System.out.println("(Ese producto ya se ha vendido)");
      return;
    }

    System.out.println("... ¡VENDIDO!");
    actual.vendido = true;
    // los valores solo se actualizan cuando se pide un calculo mediante calcularValorX()
  }

  @Override
  public String toString()
  {
    return "(" + id + ") " + ((vendido) ? "***VENDIDO*** " : "") +
      descripcion + " " + color + " " + consumo + " " + precioBase +
      " " + "(+" + precioExtra + ")euros";
  }

  public static int getCountElectrodomesticos()
  {
    return countElectrodomesticos;
  }

  public static Electrodomestico[] getAlmacen()
  {
    return Arrays.copyOf(almacen, countElectrodomesticos);
  }

  public int getId()
  {
    return id;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public Color getColor()
  {
    return color;
  }

  public Consumo getConsumo()
  {
    return consumo;
  }

  double getPrecioBase()
  {
    return precioBase;
  }
}
