package progbloque4.examen02empresas.empresa;

import java.io.Serializable;

public class Empleado implements Serializable
{

  public static final float SALARIO_MINIMO=100.00f;

  private final String nif;
  private final String nombre;
  private final float salario;

  private Empleado(String nif, String nombre, float salario)
  {
    this.nif = nif;
    this.nombre = nombre;
    this.salario = salario;
  }

  public static Empleado crearEmpleado(String nif, String nombre, float salario) throws LumaException
  {
    if (salario < 100)
      throw new LumaException(Float.toString(salario));
    else
      return new Empleado(nif, nombre, salario);
  }

  @Override
  public String toString()
  {
    return nif + " " + nombre + " --> " + salario + "euros";
  }
}
