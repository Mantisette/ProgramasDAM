package progbloque2.tarea12madmax;

public class Coche extends Vehiculo implements Motorizado
{

  private final int consumo;

  public Coche(int consumo)
  {
    //no hace falta 'super()'
    this.consumo = consumo;
  }

  @Override
  public int getConsumo()
  {
    return consumo;
  }

  @Override
  public String toString()
  {
    return super.toString() + "(" + consumo + "l/100km)";
  }
}
