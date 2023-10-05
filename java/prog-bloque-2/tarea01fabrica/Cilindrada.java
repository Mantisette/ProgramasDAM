package progbloque2.tarea01fabrica;

public enum Cilindrada
{

  MINIMA(1.2f),
  MENOR(1.4f),
  MEDIA(1.6f),
  MAYOR(1.9f),
  MAXIMA(2.5f);

  private final float cilindrada;

  Cilindrada(float cilindrada)
  {
    this.cilindrada = cilindrada;
  }

  @Override
  public String toString()
  {
    return cilindrada + "l";
  }
}
