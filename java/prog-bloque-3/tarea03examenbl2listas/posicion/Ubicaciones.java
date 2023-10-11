package progbloque3.tarea03examenbl2listas.posicion;

public enum Ubicaciones
{

  ORIGEN(new Punto(0, 0)),
  NORTE(new Punto(0, 10)),
  SUR(new Punto(0, -10)),
  ESTE(new Punto(10, 0)),
  OESTE(new Punto(-10, 0));

  final Punto punto;
  final int x;
  final int y;

  Ubicaciones(Punto punto)
  {
    this.punto = punto;
    this.x = punto.x;
    this.y = punto.y;
  }

  //Getters
  public Punto getPunto()
  {
    return new Punto(punto.x,punto.y);
  }

  public static Punto puntoAlAzar()
  {
    Ubicaciones select = Ubicaciones.values()[(int)(Math.random() * values().length)];

    return new Punto(select.x, select.y);
  }
}
