package progbloque2.tarea01fabrica;

public enum Puertas
{

  HATCHBACK(3),
  FAMILIAR(5);

  private final int puertas;

  Puertas(int puertas)
  {
    this.puertas = puertas;
  }

  @Override
  public String toString()
  {
    return puertas + " puertas";
  }
}
