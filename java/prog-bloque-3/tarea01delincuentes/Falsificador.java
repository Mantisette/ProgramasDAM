package progbloque3.tarea01delincuentes;

public class Falsificador
{

  String nombre;
  String material;

  public Falsificador(String nombre, String material)
  {
    this.nombre = nombre;
    this.material = material;
  }

  @Override
  public String toString()
  {
    return nombre + "(" + material + ")";
  }
}
