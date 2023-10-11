package progbloque3.tarea03examenbl2listas.entidad;

import progbloque3.tarea03examenbl2listas.posicion.Punto;
import progbloque3.tarea03examenbl2listas.posicion.Ubicaciones;

import java.util.ArrayList;
import java.util.Comparator;

public final class Animal extends Biologico
{

  private final int alcance;

  public Animal(Punto punto, int alcance)
  {
    super(punto,true);
    this.alcance=alcance;
  }

  public Animal(int alcance)
  {
    this(Ubicaciones.puntoAlAzar(), alcance);
  }

  @Override
  public void alimentar()
  {
    super.alimentar();
    System.out.println("¡Ñam, ñam!");
  }

  public void detectar()
  {
    ArrayList<Ser> existentes = new ArrayList<>(getSeres());
    ArrayList<Ser> detectados = new ArrayList<>();
    double distancia;

    for (Ser serChecking : existentes)
    {
      distancia = this.posicion.distanciaHasta(serChecking.posicion);
      if (distancia <= this.alcance && serChecking != this)
        detectados.add(serChecking);
    }

    detectados.sort(new Comparator<>()
    {
      @Override
      public int compare(Ser ser1, Ser ser2)
      {
        double dist1 = Animal.this.posicion.distanciaHasta(ser1.posicion);
        double dist2 = Animal.this.posicion.distanciaHasta(ser2.posicion);

        if ((int) (dist1 - dist2) == 0)
          return ser1.id.compareToIgnoreCase(ser2.id);

        return (int) (dist1 - dist2);
      }
    });

    System.out.println(this + ": detecto " + detectados.size() + " seres: ");
    for (Ser target : detectados)
    {
      System.out.print('\t');
      System.out.println(target);
    }
  }
}
