package progbloque3.tarea03examenbl2listas.entidad;

import progbloque3.tarea03examenbl2listas.posicion.Punto;

public abstract class Mecanico extends Ser
{

  private boolean encendido;

  public Mecanico(Punto punto,boolean movil)
  {
    super(punto,movil);
    encendido=false;
  }

  public final void encender()
  {
    System.out.println(id+": ...ON...");
    encendido=true;
  }

  public final void apagar()
  {
    System.out.println(id+": ...OFF...");
    encendido=false;
  }

  public boolean isEncendido()
  {
    return encendido;
  }

  @Override
  public String toString()
  {
    return super.toString() + "(" + (encendido ? "ON" : "OFF") + ")";
  }
}
