package progbloque2.tarea03animales;

public abstract class Ganado extends Animal implements Productivo
{

  public static int countGanado = 0;
  public final String producto;

  public Ganado(String producto)
  {
    super(++countGanado);
    this.producto = producto;
  }
}
