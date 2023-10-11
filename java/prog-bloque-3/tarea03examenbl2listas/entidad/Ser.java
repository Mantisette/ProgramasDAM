package progbloque3.tarea03examenbl2listas.entidad;

import progbloque3.tarea03examenbl2listas.posicion.Punto;

import java.util.ArrayList;
import java.util.List;

public abstract class Ser implements Comparable
{

  private static final ArrayList<Ser> seres=new ArrayList<>();

  final String id;
  Punto posicion;
  final boolean movil;

  public Ser(Punto punto,boolean movil)
  {
    seres.add(this);
    this.posicion = new Punto(punto.getX(),punto.getY());
    this.id=getClass().getSimpleName()+seres.size();
    this.movil=movil;
  }

  public void moverA(Punto p)
  {
    if(movil)
    {
      System.out.println(id+": desplazandome a "+p);
      this.posicion = new Punto(p.getX(),p.getY());
    }
    else
      System.out.println(id+": ¡carezco de movilidad!");
  }

  @Override
  public String toString()
  {
    return posicion.toString() + id;
  }

  public static List<Ser> getSeres()
  { // Hay que hacerlo public y static para llamarlo en el main()
    return List.copyOf(seres);
  }

  Punto getPosicion()
  {
    return new Punto(posicion.getX(),posicion.getY());
  }

  @Override
  public int compareTo(Object o)
  {
    if (!(o instanceof Ser target))
      return 1; // nullsFirst

    return (this.id.compareTo(target.id));
  }
}
