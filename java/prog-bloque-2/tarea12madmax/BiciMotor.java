package progbloque2.tarea12madmax;

public class BiciMotor extends Vehiculo implements Motorizado,Ecologico
{

  private static final int CONSUMO=1;

  @Override
  public int getConsumo()
  {
    return CONSUMO;
  }
}
