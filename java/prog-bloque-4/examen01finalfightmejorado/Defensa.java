package progbloque4.examen01finalfightmejorado;

public interface Defensa
{
  double ESQUIVA_MINIMA=0.1;
  double ESQUIVA_MAXIMA=0.9;
  double PARADA_MINIMA=0;
  double PARADA_MAXIMA=0.9;

  default boolean esquivar(int energiaDefensor, Arma armaDefensiva)
  {
    double probabilidad = armaDefensiva.esquive * energiaDefensor / 100;
    probabilidad = Math.max(ESQUIVA_MINIMA, probabilidad);
    probabilidad = Math.min(ESQUIVA_MAXIMA, probabilidad);
    return Math.random() < probabilidad;
  }

  default int parar(int fuerzaAtaque, int energiaDefensor, Arma armaDefensiva)
  {
    double porcentajeDefensa = armaDefensiva.parada * energiaDefensor / 100;
    porcentajeDefensa = Math.max(PARADA_MINIMA, porcentajeDefensa);
    porcentajeDefensa = Math.min(porcentajeDefensa, PARADA_MAXIMA);
    return (int)(fuerzaAtaque * (1 - porcentajeDefensa));
  }
}
