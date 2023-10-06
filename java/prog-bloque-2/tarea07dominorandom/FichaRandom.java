package progbloque2.tarea07dominorandom;

public class FichaRandom
{

  int caraIzquierda;
  int caraDerecha;

  public FichaRandom(int caraIzquierda, int caraDerecha)
  {
    this.caraIzquierda = caraIzquierda;
    this.caraDerecha = caraDerecha;
  }

  @Override
  public String toString()
  {
    return "[" + ((caraIzquierda == 0) ? " " : caraIzquierda) + "|" + ((caraDerecha == 0) ? " " : caraDerecha) + "]";
  }

  public boolean encaja(FichaRandom target)
  {
    return (this.caraDerecha == target.caraIzquierda);
  }

  public static FichaRandom generaFicha()
  {
    int random1 = (int)(Math.random()*7);
    int random2 = (int)(Math.random()*7);
    return new FichaRandom(random1, random2);
  }

  public static FichaRandom generaFicha(FichaRandom anterior)
  {
    while(true)
    {
      FichaRandom probando = generaFicha();
      if (anterior.encaja(probando))
        return probando;
    }
  }
}
