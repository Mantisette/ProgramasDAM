package progbloque3.tarea03examenbl2listas.entidad;

import progbloque3.tarea03examenbl2listas.posicion.Punto;

public final class Herramienta extends Mecanico implements Manipulable
{

  public Herramienta(Punto punto)
  {
    super(punto, false);
  }

  @Override
  public void serManipulado()
  {
    if (isEncendido())
      System.out.println(this.id + ": BROM! PLAS! CRANCK!");
    else
      System.out.println(this.id + "... esta apagado.");
  }
}
