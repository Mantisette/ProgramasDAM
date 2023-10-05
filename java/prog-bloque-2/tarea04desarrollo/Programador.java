package progbloque2.tarea04desarrollo;

public class Programador
{

  public static final String NOMBRE_DEFECTO = "NP"; // nuevo programador
    // pendiente de contratar
  public static final double SUELDO_DEFECTO = 1000;

  public static int countProgramadores = 0;

  private final int id;
  private final String nombre;
  private final double sueldo;

  public Programador(String nombre, double sueldo)
  {
    this.id = ++countProgramadores;
    this.nombre = nombre;
    this.sueldo = sueldo;
  }

  public Programador()
  {
    this(NOMBRE_DEFECTO, SUELDO_DEFECTO);
  }

  @Override
  public String toString()
  {
    return "\t" + id + " - " + nombre;
  }

  public double getSueldo()
  {
    return sueldo;
  }
}
