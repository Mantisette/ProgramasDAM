package progbloque2.tarea04desarrollo;

public class Jefe extends Programador
{

  public static final String NOMBRE_DEFECTO = "NJE";
  public static final double SUELDO_DEFECTO = 2000;
  public static final double BONUS_DEFECTO = 5000;

  private final double bonusAnual;

  public Jefe(String nombre, double sueldo, double bonusAnual)
  {
    super(nombre, sueldo);
    this.bonusAnual = bonusAnual;
  }

  public Jefe()
  {
    this(NOMBRE_DEFECTO, SUELDO_DEFECTO, BONUS_DEFECTO);
  }

  @Override
  public String toString()
  {
    return super.toString() + " [JE]";
  }

  public double getBonusAnual()
  {
    return bonusAnual;
  }
}
