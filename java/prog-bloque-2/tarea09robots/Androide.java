package progbloque2.tarea09robots;

public class Androide extends Robot implements Vida
{

  static final String NOMBRE_DEFECTO = "And";

  public Androide()
  {
    super(NOMBRE_DEFECTO);
  }

  @Override
  public void identificarNombreSelf()
  {
    System.out.println(id);
  }

  @Override
  public void saludar()
  {
    System.out.println(this + ": ¡Saludos! Bip-Bip");
  }

  @Override
  public void llorar()
  {
    System.out.println(this + ": ¡No quiero oxidarme!");
  }
}
