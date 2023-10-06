package progbloque2.tarea08bicicletas;

import java.util.Arrays;

public class Bicicleta
{

  public static final int PRECIO_DEFECTO = 100;
  public static final Tipo TIPO_DEFECTO = Tipo.ALUMINIO;
  public static final String COLOR_DEFECTO = "Azul";
  public static int countBicicletas = 0;

  final int id; // secuencial
  private final Tipo tipo;
  private final String color;
  private final Extra[] extras; // falta al crear la bici, hacer una copia del array
  double precio;

  public Bicicleta(Tipo tipo, String color, Extra[] extras)
  {
    this.id = ++countBicicletas;
    this.tipo = tipo;
    this.color = color;

    // Calculo de precios prematuro para cortocircuitar si extras == null
    this.precio = PRECIO_DEFECTO;
    this.precio += tipo.costeTipo;

    if (extras == null)
    {
      this.extras = null;
      return;
    }
    else
      this.extras = Arrays.copyOf(extras, extras.length);

    // Sabiendo que hay extras, suma de precio
    for (Extra e : extras)
      if (e != null)
        this.precio += e.costeExtra;
  }

  public Bicicleta(Tipo tipo, String color)
  {
    this(tipo, color, null);
  }

  public Bicicleta()
  {
    this(TIPO_DEFECTO, COLOR_DEFECTO);
  }

  public String rodar(int metros)
  {
    return id + " --> rodando " + metros + " metros";
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder();
    sb.append("(")
      .append(id)
      .append(") --> ")
      .append(String.format("%.2feuros", precio))
      .append(" ")
      .append(tipo)
      .append(" ")
      .append(color);

    if (extras != null)
      for (Extra e : extras)
      {
        sb.append(" + ");
        sb.append(e);
      }

    return sb.toString();
  }
}
