package progbloque2.examen02seres.entidad;

import progbloque2.examen02seres.posicion.*;
import java.util.Arrays;

public abstract class Ser implements Comparable
{

  private static int contador;
  private static final Ser[] seres = new Ser[1000];

  final String id;
  private Punto posicion;
  final boolean movil;

  public Ser(Punto punto,boolean movil)
  {
    seres[contador] = this;
    this.posicion = new Punto(punto.getX(), punto.getY());
    contador++;
    this.id = getClass().getSimpleName() + contador;
    this.movil = movil;
  }

  ///////////////////////////     FUNCIONALIDAD       /////////////////////////////////////////////
  public void moverA(Punto p)
  {
    if(movil)
    {
      System.out.println(id + ": desplazandome a " + p);
      this.posicion = new Punto(p.getX(),p.getY());
    }
    else
      System.out.println(id + ": ¡carezco de movilidad!");
  }

  ///////////////////////////         ASPECTO       /////////////////////////////////////////////
  @Override
  public String toString()
  {
    return posicion.toString() + id;
  }

  ///////////////////////////     GETTERS Y SETTERS       /////////////////////////////////////////////
  public static Ser[] getSeres()
  {
    return Arrays.copyOf(seres,contador);
  }

  Punto getPosicion()
  {
    return new Punto(posicion.getX(),posicion.getY());
  }

  ////////////////////////////////     ORDENACIoN     ///////////////////////////////////////////

  @Override
  public int compareTo(Object o)
  {
    Ser otro = (Ser)o;
    return this.id.compareTo(otro.id);
  }
}
