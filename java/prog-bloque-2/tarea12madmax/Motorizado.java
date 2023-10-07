package progbloque2.tarea12madmax;

public interface Motorizado
{

  int getConsumo();

  default void conducir(int km)
  {
    double cantidadNecesaria=(double)(km*getConsumo())/100;

    if(Gasolina.getStock()<cantidadNecesaria)
      System.out.println(this + ": No tienes suficiente gasolina para recorrer " + km + "km.");
    else
    {
      System.out.println(this + ": Quemando rueda y gasolina durante " + km + "km.");
      Vehiculo.setKmTotal(Vehiculo.getKmTotal() + km);
      Gasolina.setStock(Gasolina.getStock()-cantidadNecesaria);
    }
  }
}
