package progbloque4.examen02empresas.empresa;

public class LumaException extends Throwable
{

  public LumaException(String mensaje)
  {
    super ("No se puede contratar a alguien por " + mensaje + "euros. El salario mínimo es " + Empleado.SALARIO_MINIMO + "euros.");
  }
}
