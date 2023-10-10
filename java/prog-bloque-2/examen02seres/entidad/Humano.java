package progbloque2.examen02seres.entidad;

import progbloque2.examen02seres.posicion.*;

public final class Humano extends Biologico implements Inteligencia
{

  private final String nombre;

  public Humano(Punto punto, String nombre)
  {
    super(punto,true);
    this.nombre = nombre;
  }

  public Humano(String nombre)
  {
    this(Ubicaciones.puntoAlAzar(),nombre);
  }

  @Override
  public void alimentar()
  {
    super.alimentar();
    System.out.println("¡Esta bueno esto!");
  }

  @Override
  public String toString()
  {
    return super.toString() + " (" + nombre + ")";
  }
}
