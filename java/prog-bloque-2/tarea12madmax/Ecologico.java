package progbloque2.tarea12madmax;

public interface Ecologico
{
  default void montar(int km)
  {
    System.out.println(this + ": Recorriendo ecologicamente " + km + " km.");
    Vehiculo.setKmTotal(Vehiculo.getKmTotal() + km);
  }
}
