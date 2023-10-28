package progbloque4.examen01finalfightmejorado;

import java.util.ArrayList;

public final class Nigromante extends Villano
{

  //Constantes
  public static final String INICIAL = "N";
  private static final int RECOMPENSA = 20; // para ajustar la dificultad del juego
  private static final double PROB_EXITO_VIDA_DE_SANGRE = 0.25; // para ajustar la dificultad del juego

  public Nigromante()
  {
    super(INICIAL,RECOMPENSA);
  }

  //----------------------- PRESENTACIÓN ---------------------------------
  @Override
  public String toString()
  {
    String indicadorOculto = (isOculto()) ? "-H" : "";
    return getNombre() + "(" + getEnergia() + indicadorOculto + ")";
  }

  //-------------------------------- ACCIONES --------------------------------
  public void lanzaAtaqueMasivo(ArrayList<Villano> lista,Heroe heroe)
  {
    decir("¡Sentid mi poder!");
    atacar(heroe);
    for (Villano v : lista)
    {
      //...daña a otros enemigos...
      if (!v.getClass().getSimpleName().equals("Nigromante"))
        atacar(v); // ...que no sean nigromantes
    }
  }

  @Override
  public void atacar(Personaje p)
  {
    int fuerza = (int)(getEnergia() * 0.5);
    p.recibirAtaque(fuerza);
  }

  @Override
  public int recibirAtaque(int fuerza)
  {
    // Los nigromantes no evitan ni paran
    setEnergia(getEnergia() - fuerza);
    if (getEnergia() > 0)
    {
      decir("¡Demonios! (-" + fuerza + ")");
      return 0;
    }
    else
    {
      decir("¡MALDICIOOOÓN! (-" + fuerza + ")");
      return 1;
    }
  }

  public boolean vidaDeSangre(Villano v)
  {
    if (Math.random() < PROB_EXITO_VIDA_DE_SANGRE)
    {
      v.setEnergia(VIDA_INICIAL);
      System.out.println(getNombre() + ": ...vida de sangre..." + v.getNombre());
      return true;
    }
    else
      return false;
  }
}
