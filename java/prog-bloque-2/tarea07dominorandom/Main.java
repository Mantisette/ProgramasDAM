package progbloque2.tarea07dominorandom;

public class Main
{

  public static void main(String[] args)
  {
    final int MAX_FICHAS = 100;

    FichaRandom[] arrayFichas = new FichaRandom[MAX_FICHAS];
    arrayFichas[0] = FichaRandom.generaFicha();

    for(int i = 1; i < MAX_FICHAS; i++)
      arrayFichas[i] = FichaRandom.generaFicha(arrayFichas[i-1]);

    for(int i = 0; i < MAX_FICHAS; i++)
      System.out.print(arrayFichas[i]);
  }
}
