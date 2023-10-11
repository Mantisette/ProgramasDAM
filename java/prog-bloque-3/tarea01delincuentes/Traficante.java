package progbloque3.tarea01delincuentes;

public class Traficante
{

  String nombre;
  String pais;

  public Traficante(String nombre, String pais)
  {
    this.nombre = nombre;
    this.pais = pais;
  }

  @Override
  public String toString()
  {
    return nombre + "(" + pais + ")";
  }
}
