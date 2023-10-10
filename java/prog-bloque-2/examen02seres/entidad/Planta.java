package progbloque2.examen02seres.entidad;

import progbloque2.examen02seres.posicion.*;

public final class Planta extends Biologico implements Manipulable
{

  public Planta(Punto punto)
  {
    super(punto,false);
  }

  @Override
  public void alimentar()
  {
    super.alimentar();
    System.out.println("¡Savia va, savia viene!");
  }

  @Override
  public void serManipulado()
  {
    sufrir(10);
  }
}
