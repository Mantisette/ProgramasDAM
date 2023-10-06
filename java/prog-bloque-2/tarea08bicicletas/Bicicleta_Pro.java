package progbloque2.tarea08bicicletas;

public class Bicicleta_Pro extends Bicicleta
{

  public static final int MIN_VELOCIDAD_TOTAL = 6;
  public static final int MIN_VELOCIDAD_ACTUAL = 1;
  public static final int VELOCIDAD_DEFECTO = 3;

  public static final float PRECIO_SUSPENSION = 120;
  public static final float PRECIO_DISCO      = 100;
  public static final float PRECIO_VELOCIDAD  = 10;

  private final boolean suspension;
  private final boolean disco;
  private final int velocidadTotal;
  private int velocidadActual;

  public Bicicleta_Pro(Tipo tipo, String color, Extra[] extras,
                       boolean suspension, boolean disco, int velocidades)
  {
    super(tipo, color, extras);
    this.suspension = suspension;
    this.disco = disco;
    this.velocidadTotal = velocidades;
    this.velocidadActual = VELOCIDAD_DEFECTO;

    // Calculo de precios
    if (suspension)
      this.precio += PRECIO_SUSPENSION;
    if (disco)
      this.precio += PRECIO_DISCO;
    for(int i = 0; i < this.velocidadTotal; i++)
      this.precio += PRECIO_VELOCIDAD;
  }

  public Bicicleta_Pro(Tipo tipo, String color, boolean suspension,
                       boolean disco, int velocidades)
  {
    this(tipo, color, null, suspension, disco, velocidades);
  }

  public Bicicleta_Pro()
  {
    this(TIPO_DEFECTO, COLOR_DEFECTO, false, false, MIN_VELOCIDAD_TOTAL);
  }

  public String rodar(int metros)
  {
    return super.rodar(metros) + " en plan 'pro'";
  }

  public void subir()
  {
    if (velocidadActual >= velocidadTotal)
    {
      System.out.println(velocidadTotal + " es la velocidad maxima");
      return;
    }
    System.out.println(id + "--> Subiendo de " + velocidadActual + " a " + ++velocidadActual);
  }

  public void bajar()
  {
    if (velocidadActual <= MIN_VELOCIDAD_ACTUAL)
    {
      System.out.println(MIN_VELOCIDAD_ACTUAL + " es la velocidad minima");
      return;
    }
    System.out.println("Bajando de " + velocidadActual + " a " + --velocidadActual);
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder();
    sb.append(super.toString());
    if (suspension)
      sb.append(" + SUSPENSION");
    if (disco)
      sb.append(" + DISCO");
    sb.append(" + ")
      .append(velocidadTotal)
      .append(" velocidades");

    return sb.toString();
  }
}
