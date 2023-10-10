package progbloque2.examen02seres.entidad;

import progbloque2.examen02seres.posicion.*;

public class Herramienta extends Mecanico implements Manipulable
{

  public Herramienta(Punto punto)
  {
    super(punto,false);
  }

  @Override
  public void serManipulado()
  {
    if (isEncendido())
      System.out.println(id + ": BROM! PLAS! CRANCK!");
    else
      System.out.println("..." + id + "...esta apagado");
  }
}
