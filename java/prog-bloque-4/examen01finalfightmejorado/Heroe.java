package progbloque4.examen01finalfightmejorado;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public final class Heroe extends Personaje implements Defensa,Comparable<Heroe>
{
  //Constantes
  private static final int VIDA_INICIAL=200;

  //Propiedades de instancia
  private Arma arma;
  private int bajas;
  private final String nombreHeroe;//Para no complicar el equals y el hashcode

  public Heroe(String nombre, Arma arma)
  {
    super(nombre, VIDA_INICIAL);
    this.arma = arma;
    bajas = 0;
    nombreHeroe = nombre;
  }

  //------------------------  ACCIONES ---------------------------------------
  public HashSet<Villano> ataqueMele(ArrayList<Villano> villanos)
  {
    HashSet<Villano> victimas=new HashSet<>(); // para los que mate

    int atacables = 0;
    for (Villano v : villanos)
    {
      if (v.isOculto())
        continue; // no puedo atacar a los que están ocultos
      atacables++;
    }

    //Esta situación no se puede dar, la dejo como chivato de que algo no va bien
    //Si no puedo atacar a nadie, no hago nada
    if(atacables == 0)
    {
      decir("¿No hay nadie a quién atacar?");
      return victimas; // si no hago aquí un return, más abajo saldra divby0!!!
    }

    decir("¡Probad TODOS mi acero!");
    int fuerza = (int)Math.ceil((arma.ataque * getEnergia()) / atacables);
    // redondeo al alza para compensar las pérdidas por decimales
    for (Villano v : villanos)
    {
      if (v.isOculto())
        continue; // no puedo atacar a los que están ocultos
      if (v.recibirAtaque(fuerza) == 1)
      {
        // Si el ataque tiene resultado de muerte...
        bajas++; // ...contabilizo la baja
        setEnergia(getEnergia() + v.getRecompensa());//Me cobro la recompensa
        decir("¡¡¡ +" + v.getRecompensa() + " !!!");
        victimas.add(v);
      }
    }
    return victimas;
  }

  @Override
  public void atacar(Personaje p)
  {
    Villano v = (Villano) p;
    int miEnergia = getEnergia();
    decir("¡Prueba mi acero " + v.getNombre() + "!");
    int fuerza = (int)(arma.ataque * miEnergia);
    if (v.recibirAtaque(fuerza) == 1)
    {
      // Si el ataque tiene resultado de muerte...
      bajas++; // ...contabilizo la baja
      setEnergia(miEnergia + v.getRecompensa()); // Me cobro la recompensa
      decir("¡¡¡ +" + v.getRecompensa() + " !!!");
    }
  }

  @Override
  public int recibirAtaque(int fuerza)
  {
    int energiaInicial = getEnergia();
    if (esquivar(energiaInicial, arma))
    {
      decir("...esquivando...");
      return -1;
    }

    int danio = parar(fuerza, energiaInicial, arma);
    int energiaFinal = energiaInicial - danio;
    setEnergia(energiaFinal);
    if (energiaFinal > 0)
    {
      decir("¡Oh! (-" + danio + ")");
      return 0;
    }
    else
    {
      decir("¡NOOOOO! (-" + danio + ")");
      return 1;
    }
  }

  public void pideArma()
  {
    int opcion = -1;
    while (opcion < 0 || opcion >= Arma.values().length)
    {
      System.out.print("Elige un arma ");
      for (int i = 0; i < Arma.values().length; i++)
      {
        System.out.print(i + ")" + Arma.values()[i] + " ");
      }
      System.out.print(": ");
      opcion = Utilidades.pideInt();
    }
    setArma(Arma.values()[opcion]);
  }

  //----------------------- PRESENTACIÓN ---------------------------------
  @Override
  public String toString()
  {
    return getNombre() + "(" + arma.nombre + "-" + getEnergia() + ")";
  }

  //---------------------- GETTERS y SETTERS ---------------------------------
  public Arma getArma()
  {
    return arma;
  }

  public void setArma(Arma arma)
  {
    this.arma = arma;
  }

  public int getBajas()
  {
    return bajas;
  }

  //--------------------- CMPARACION e IGUALDAD-------------------------------

  @Override
  public int compareTo(Heroe o)
  {
    // por bajas decreciente -> alfabetico creciente
    if(getBajas() < o.getBajas())
      return 1;
    else if (getBajas() > o.getBajas())
      return -1;
    else
      return getNombre().compareTo(o.getNombre());
  }

  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 37 * hash + this.bajas;
    hash = 37 * hash + Objects.hashCode(this.nombreHeroe);
    return hash;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;

    final Heroe otro = (Heroe) obj;
    if (this.bajas != otro.bajas)
      return false;

    return Objects.equals(this.nombreHeroe, otro.nombreHeroe);
  }
}
