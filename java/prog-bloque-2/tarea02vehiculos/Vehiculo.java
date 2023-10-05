package progbloque2.tarea02vehiculos;

public abstract class Vehiculo
{

  private static int vehiculosCreados;
  private static int kilometrosTotales;

  int kilometrosRecorridos;

  Vehiculo()
  {
    vehiculosCreados++;
    this.kilometrosRecorridos = 0;
  }

  public static int getKilometrosTotales()
  {
    return kilometrosTotales;
  }

  void andar(int duracion)
  {
    System.out.println("Recorriendo " + duracion + " kilometros");
    kilometrosRecorridos += duracion;
    kilometrosTotales += duracion;
  }
}
