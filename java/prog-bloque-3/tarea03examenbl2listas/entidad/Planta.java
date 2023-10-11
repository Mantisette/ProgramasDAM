package progbloque3.tarea03examenbl2listas.entidad;

import progbloque3.tarea03examenbl2listas.posicion.Punto;

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
