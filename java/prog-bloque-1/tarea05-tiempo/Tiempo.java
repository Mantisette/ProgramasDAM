package progbloque1.tarea07tiempo;

public class Tiempo
{
  private final int horas;
  private final int minutos;
  private final int segundos;

  public Tiempo(int horas, int minutos, int segundos)
  {
    int[] tiempos = fixTiempos(horas, minutos, segundos);
    this.horas = tiempos[0];
    this.minutos = tiempos[1];
    this.segundos = tiempos[2];
  }

  int[] fixTiempos(int horas, int minutos, int segundos)
  {
    if (horas < 0)
    {
      System.out.println("Parametros incorrectos. El tiempo es 0h, 0m, 0s");
      return new int[]{0, 0, 0};
    }

    while (minutos < 0)
    {
      minutos += 60;
      horas--;
    }
    while (segundos < 0)
    {
      segundos += 60;
      minutos--;
    }
    while (segundos >= 60)
    {
      segundos -= 60;
      minutos++;
    }
    while (minutos >= 60)
    {
      minutos -= 60;
      horas++;
    }
    return new int[]{horas, minutos, segundos};
  }

  @Override
  public String toString()
  {
    return horas + "h " + minutos + "m " + segundos + "s";
  }

  Tiempo suma(Tiempo sumando)
  {
    return new Tiempo(
      this.horas + sumando.horas,
      this.minutos + sumando.minutos,
      this.segundos + sumando.segundos
    );
  }

  Tiempo resta(Tiempo sumando)
  {
    return new Tiempo(
      this.horas - sumando.horas,
      this.minutos - sumando.minutos,
      this.segundos - sumando.segundos
    );
  }
}
