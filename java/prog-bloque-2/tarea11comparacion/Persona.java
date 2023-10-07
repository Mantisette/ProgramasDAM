package progbloque2.tarea11comparacion;

public class Persona implements Comparable
{

  String nombre;
  String apellido1;
  String apellido2;

  public Persona(String nombre, String apellido1, String apellido2)
  {
    this.nombre = nombre;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
  }

  @Override
  public String toString()
  {
    return "Persona{" + "nombre='" + nombre + '\'' + ", apellido1='" + apellido1 + '\'' + ", apellido2='" + apellido2 + '\'' + '}';
  }

  @Override
  public int compareTo(Object o)
  {
    if (!(o instanceof Persona))
      return 1;
    if (this.apellido1.compareTo(((Persona) o).apellido1) > 0)
      return 1;
    else if (this.apellido1.compareTo(((Persona) o).apellido1) < 0)
      return -1;
    else
    {
      if (this.apellido2.compareTo(((Persona) o).apellido2) > 0)
        return 1;
      else if (this.apellido2.compareTo(((Persona) o).apellido2) < 0)
        return -1;
      else
        return (this.nombre.compareTo(((Persona) o).nombre));
    }
  }
}
