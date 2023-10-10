package progbloque2.examen02seres.posicion;

public enum Ubicaciones
{

  ORIGEN(new Punto(0,0)),
  ESTE(new Punto(10,0)),
  OESTE(new Punto(-10,0)),
  SUR(new Punto(0,-10)),
  NORTE(new Punto(0,10));

  private final Punto punto;

  Ubicaciones(Punto punto)
  {
    this.punto = punto;
  }

  //Getters
  public Punto getPunto()
  {
    return new Punto(punto.x,punto.y);
  }

  //Metodos de utilidad
  //Completa la firma y el cuerpo de este metodo
  public static Punto puntoAlAzar()
  {
    int largo = Ubicaciones.values().length;
    return Ubicaciones.values()[(int) (Math.random() * largo)].getPunto();
  }
}
