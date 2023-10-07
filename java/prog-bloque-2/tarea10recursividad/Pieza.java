package progbloque2.tarea10recursividad;

public class Pieza
{

  static int countPiezas;
  protected final int id;
  protected String nombre;
  protected double coste;

  public Pieza(String nombre, double coste)
  {
    this.id = ++countPiezas;
    this.nombre = nombre;
    this.coste = coste;
  }

  @Override
  public String toString()
  {
    return "[" + id + "] " + nombre + ' ' + "coste: " + coste + "euros" + " (E)";
  }

  public int getId()
  {
    return id;
  }
}
