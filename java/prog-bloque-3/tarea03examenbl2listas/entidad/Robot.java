package progbloque3.tarea03examenbl2listas.entidad;

import progbloque3.tarea03examenbl2listas.posicion.Punto;

public final class Robot extends Mecanico implements Inteligencia
{

  public Robot(Punto punto)
  {
    super(punto,true);
  }

  @Override
  public void manipular(Manipulable target)
  {
    if (isEncendido())
      Inteligencia.super.manipular(target);
    else
      System.out.println(this + ": ...esta apagado.");
  }

  @Override
  public void aprender()
  {
    if (isEncendido())
      Inteligencia.super.aprender();
    else
      System.out.println(this + ": ...esta apagado.");
  }
}
