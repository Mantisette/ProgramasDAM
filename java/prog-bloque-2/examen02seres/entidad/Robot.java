package progbloque2.examen02seres.entidad;

import progbloque2.examen02seres.posicion.*;

public class Robot extends Mecanico implements Inteligencia
{

  public Robot(Punto punto)
  {
    super(punto, true);
  }

  @Override
  public void manipular(Manipulable m)
  {
    if (isEncendido())
      Inteligencia.super.manipular(m);
    else
      System.out.println("..."+id+"...esta apagado");
  }

  @Override
  public void aprender()
  {
    if(isEncendido())
      Inteligencia.super.aprender();
    else
      System.out.println("..."+id+"...esta apagado");
  }
}
