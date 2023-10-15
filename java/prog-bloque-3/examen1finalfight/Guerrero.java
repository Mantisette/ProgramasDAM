package progbloque3.examen1finalfight;

public final class Guerrero extends Villano implements Defensa
{

  public static final String INICIAL = "G";
  private static final int RECOMPENSA = 10;

  private final Arma arma;

  public Guerrero()
  {
    super(INICIAL,RECOMPENSA);
    arma = Arma.values()[(int) (Math.random() * Arma.values().length)];
  }

  //----------------------- PRESENTACIÓN ---------------------------------
  @Override
  public String toString()
  {
    String indicadorOculto = (isOculto()) ? "-H" : "";
    return getNombre() + "(" + arma.nombre + "-" + getEnergia() + indicadorOculto + ")";
  }


  //----------------------- ACCIONES ---------------------------------
  @Override
  public void atacar(Personaje p)
  {
    decir("¡Prepárate, " + p.getNombre() + "!");
    int fuerza = (int) (arma.ataque * getEnergia());
    p.recibirAtaque(fuerza);
  }

  @Override
  public int recibirAtaque(int fuerza)
  {
    int energiaInicial = getEnergia();
    if(esquivar(energiaInicial,arma))
    {
      decir("...tienes que mejorar...");
      return -1;
    }
    else
    {
      int danio = parar(fuerza, energiaInicial, arma);
      int energiaFinal = energiaInicial-danio;
      setEnergia(energiaFinal);

      if (energiaFinal > 0)
      {
        decir("¡Argh! (-" + danio + ")");
        return 0;
      }
      else
      {
        decir("¡AAAAAAARGH! (-" + danio + ")");
        return 1;
      }
    }
  }
}
