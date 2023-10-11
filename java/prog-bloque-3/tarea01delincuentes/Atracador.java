package progbloque3.tarea01delincuentes;

public class Atracador
{

  private final String nombre;
  private final Sexo sexo;

  public Atracador(String nombre, Sexo sexo)
  {
    this.nombre = nombre;
    this.sexo = sexo;
  }

  @Override
  public String toString()
  {
    return nombre + "(" + sexo + ")";
  }
}
