package progbloque3.tarea05ajedrez;

import java.util.ArrayList;

public class Main
{

  public static void main(String[] args)
  {
    ArrayList<Pieza> inicio = new ArrayList<>();
    ArrayList<Pieza> capturadas = new ArrayList<>();

    for (Pieza pieza : Pieza.values())
      for (int j = 0; j < pieza.limitePiezas; j++)
        inicio.add(pieza);

    System.out.println(inicio);

    System.out.println("Fichas capturadas por el jugador");
    int puntos = generaCapturas(inicio, capturadas);

    for (Pieza pieza : capturadas)
      System.out.println(pieza.nombre + " (" + pieza.valor + " peones)");

    System.out.println("Puntos totales: " + puntos + " peones");
  }

  /**
   * @param inicio El ArrayList total de piezas.
   * @param capturadas El ArrayList (vacío) de piezas capturadas. Se rellena aleatoriamente.
   * @return El número de puntos que suman las piezas capturadas.
   */
  public static int generaCapturas(ArrayList<Pieza> inicio, ArrayList<Pieza> capturadas)
  {
    int numCapturas = (int)(Math.random() * 16);
    int puntos = 0;

    for (int i = 0; i < numCapturas; i++)
    {
      int idxSeleccion = (int)(Math.random() * inicio.size());
      Pieza seleccion = inicio.get(idxSeleccion);
      if (seleccion.restantes <= 0)
      {
        --i;
        continue;
      }

      Pieza capturada = inicio.remove(idxSeleccion);
      capturadas.add(capturada);
      puntos += capturada.valor;
      seleccion.restantes--;
    }

    return puntos;
  }
}
