package progbloque3.tarea04baraja;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main
{

  static HashSet<Carta> baraja = new HashSet<>();

  public static void main(String[] args)
  {
    for (Palo palo : Palo.values())
      for (Valor valor : Valor.values())
        baraja.add(new Carta(palo, valor));

    System.out.println("Baraja inicial:");
    System.out.println(baraja);

    for (int i = 0; i < 5; i++)
    {
      TreeSet<Carta> mano = pideMano(10);
      muestraMano(mano);
      devuelveMano(mano);
    }
  }

  public static TreeSet<Carta> pideMano(int cantidad)

  {
    TreeSet<Carta> mano = new TreeSet<>();

    for (int i = 0; i < cantidad; i++)
    {
      Iterator<Carta> iterBaraja = baraja.iterator();
      int iteratorSteps = 1 + (int)(Math.random() * baraja.size());

      Carta escogida = null;
      for (int j = 0; j < iteratorSteps; j++)
        escogida = iterBaraja.next();

      mano.add(escogida);
      baraja.remove(escogida);
    }

    return mano;
  }

  public static void muestraMano(TreeSet<Carta> mano)
  {
    System.out.println(mano);
  }

  public static void devuelveMano(TreeSet<Carta> mano)
  {
    baraja.addAll(mano);
    mano.clear();
  }
}
