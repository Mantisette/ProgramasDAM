package progbloque1.tarea08puntoylinea;

public class Punto
{

  private final double coordenadaX;
  private final double coordenadaY;

  public Punto(double coordenadaX, double coordenadaY)
  {
    this.coordenadaX = coordenadaX;
    this.coordenadaY = coordenadaY;
  }

  @Override
  public String toString()
  {
    return "(" + coordenadaX + ", " + coordenadaY + ")";
  }
}
