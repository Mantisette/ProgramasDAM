package progbloque2.tarea06domino;

public class Ficha
{

  int caraIzquierda;
  int caraDerecha;

  public Ficha(int caraIzquierda, int caraDerecha)
  {
    this.caraIzquierda = caraIzquierda;
    this.caraDerecha = caraDerecha;
  }

  @Override
  public String toString()
  {
    return "[" + ((caraIzquierda == 0) ? " " : caraIzquierda) + "|" + ((caraDerecha == 0) ? " " : caraDerecha) + "]";
  }

  public Ficha voltea()

  {
    int aux = caraIzquierda;
    caraIzquierda = caraDerecha;
    caraDerecha = aux;
    return this;
  }

  public boolean encaja(Ficha target)
  {
    return (this.caraIzquierda == target.caraIzquierda)
      || (this.caraIzquierda == target.caraDerecha)
      || (this.caraDerecha == target.caraIzquierda)
      || (this.caraDerecha == target.caraDerecha);
  }
}
