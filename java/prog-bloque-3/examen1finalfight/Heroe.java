package progbloque3.examen1finalfight;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

public final class Heroe extends Personaje implements Defensa
{

  //Constantes
  private static final int VIDA_INICIAL = 200;

  //Propiedades de instancia
  private Arma arma;
  private int bajas;
  private final String nombreHeroe;

  public Heroe(String nombre,Arma arma)
  {
    super(nombre, VIDA_INICIAL);
    this.arma = arma;
    bajas = 0;
    nombreHeroe = nombre;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Heroe heroe = (Heroe) o;
    return nombreHeroe.equals(heroe.nombreHeroe);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(nombreHeroe);
  }

  //------------------------  ACCIONES ---------------------------------------
  public LinkedHashSet<Villano> ataqueMele(ArrayList<Villano> villanos)
  {
    LinkedHashSet<Villano> victimas = new LinkedHashSet<>();//para los que mate
    LinkedHashSet<Villano> resultado = new LinkedHashSet<>();
    int contador;
    //Calculo cuántos hay 'atacables'
    int atacables = 0;
    for(Villano v:villanos)
    {
      if (v == null) break;//por la ordenación que tiene, los null están al final
      if (v.isOculto()) continue;//no puedo atacar a los que están ocultos
      atacables++;
    }

    //Si no puedo atacar a nadie, no hago nada
    if (atacables == 0)
    {
      decir("¿No hay nadie a quién atacar?");
      return new LinkedHashSet<>();
    }

    decir("¡Probad TODOS mi acero!");
    int fuerza = (int)Math.ceil((arma.ataque * getEnergia()) /atacables);//redondeo al alza para compensar las pérdidas por decimales
    victimas = new LinkedHashSet<>();
    contador = 0;
    for(Villano v:villanos)
    {
      if (v == null)
        break;//por la ordenación que tiene, los null están al final
      if (v.isOculto())
        continue;//no puedo atacar a los que están ocultos
      if (v.recibirAtaque(fuerza) == 1)
      {
        //Si el ataque tiene resultado de muerte...
        bajas++;//...contabilizo la baja
        setEnergia(getEnergia()+v.getRecompensa());//Me cobro la recompensa
        decir("¡¡¡ +"+v.getRecompensa()+" !!!");
        victimas.add(v);
        contador++;
      }
    }
    return resultado;
  }

  @Override
  public void atacar(Personaje p)
  {
    Villano v = (Villano)p;
    int miEnergia = getEnergia();
    decir("¡Prueba mi acero " + v.getNombre() + "!");
    int fuerza = (int)(arma.ataque * miEnergia);
    if (v.recibirAtaque(fuerza) == 1)
    {
      //Si el ataque tiene resultado de muerte...
      bajas++;//...contabilizo la baja
      setEnergia(miEnergia + v.getRecompensa());//Me cobro la recompensa
      decir("¡¡¡ +" + v.getRecompensa() + " !!!");
    }
  }

  @Override
  public int recibirAtaque(int fuerza)
  {
    int energiaInicial = getEnergia();
    if (esquivar(energiaInicial,arma))
    {
      decir("...esquivando...");
      return -1;
    }
    else
    {
      int danio = parar(fuerza, energiaInicial, arma);
      int energiaFinal = energiaInicial-danio;
      setEnergia(energiaFinal);
      if (energiaFinal>0)
      {
        decir("¡Oh! (-"+danio+")");
        return 0;
      }
      else
      {
        decir("¡NOOOOO! (-"+danio+")");
        return 1;
      }
    }
  }

  public void pideArma()
  {
    int opcion = -1;
    while (opcion < 0 || opcion >=  Arma.values().length)
    {
      System.out.print("Elige un arm ");
      for (int i = 0; i < Arma.values().length; i++)
      {
        System.out.print(i + ")" + Arma.values()[i] + " ");
      }
      System.out.print(": ");
      opcion  =  Utilidades.pideInt();
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

  public String getNombreHeroe()
  {
    return nombreHeroe;
  }
}
