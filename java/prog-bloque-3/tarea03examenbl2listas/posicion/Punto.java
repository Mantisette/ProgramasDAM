package progbloque3.tarea03examenbl2listas.posicion;

public class Punto
{

  //Estos son los límites de un hipotético 'tablero de juego'
  public static final int X_MAX = 100;
  public static final int X_MIN = -100;
  public static final int Y_MAX = 100;
  public static final int Y_MIN = -100;
  int x;
  int y;

  public Punto(int x, int y)
  {
    this.x = restringeX(x);
    this.y = restringeY(y);
  }

  public double distanciaHasta(Punto punto)
  {
    return Math.sqrt(Math.pow(x - punto.x, 2)+Math.pow(y - punto.y, 2));
  }

  @Override
  public String toString()
  {
    return String.format("(%d,%d)", x, y);
  }

  public int getX()
  {
    return x;
  }
  public int getY()
  {
    return y;
  }

  public void setX(int x)
  {
    this.x = restringeX(x);
  }
  public void setY(int y)
  {
    this.y = restringeY(y);
  }

  //Para mantener la coordenadas dentro de un 'tablero de juego'
  private int restringeX(int x)
  {
    if (x > X_MAX)
      return X_MAX;
    if (x < X_MIN)
      return X_MIN;

    return x;
  }

  private int restringeY(int y)
  {
    if (y > Y_MAX)
      return Y_MAX;
    if (y < Y_MIN)
      return Y_MIN;

    return y;
  }
}
