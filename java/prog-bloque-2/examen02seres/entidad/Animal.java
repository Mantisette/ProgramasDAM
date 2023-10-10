package progbloque2.examen02seres.entidad;

import progbloque2.examen02seres.posicion.*;

import java.util.Arrays;
import java.util.Comparator;

public final class Animal extends Biologico
{

  private final int alcance;

  public Animal(Punto punto, int alcance)
  {
    super(punto,true);
    this.alcance = alcance;
  }

  public Animal(int alcance)
  {
    this(Ubicaciones.puntoAlAzar(),alcance);
  }

  @Override
  public void alimentar()
  {
    super.alimentar();
    System.out.println("¡Ñam, ñam!");
  }

  public void detectar()
  {
    Ser[] todos = Ser.getSeres();
    Ser[] cercanos = new Ser[todos.length];
    int contador = 0;

    for(Ser s:todos)
      if(s.getPosicion().distanciaHasta(getPosicion()) <= alcance)
      {
        cercanos[contador] = s;
        contador++;
      }

    System.out.println(this + " detecto " + contador + " seres cerca");

    if(contador >= 1)
    {
      Arrays.sort(cercanos,0,contador, (Comparator) (o1, o2) -> {
        Ser s1 = (Ser)o1;
        Ser s2 = (Ser)o2;
        double d1 = s1.getPosicion().distanciaHasta(Animal.this.getPosicion());
        double d2 = s2.getPosicion().distanciaHasta(Animal.this.getPosicion());
        return (int)(d1-d2);
      });

      for(int i = 0;i<contador;i++)
        System.out.println("\t"+cercanos[i]);
    }
  }
}
