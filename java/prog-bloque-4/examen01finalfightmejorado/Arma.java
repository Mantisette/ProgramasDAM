package progbloque4.examen01finalfightmejorado;

public enum Arma
{
  // para ajustar la dificultad del juego
  CUCHILLOS("cuchillos",0.5,0.25,0.75),
  ESPADA_ESCUDO("espada+escudo",0.75,0.5,0.25),
  HACHA("hacha",1,0.25,0.25);

  final String nombre;
  final double ataque, parada, esquive;

  Arma(String nombre, double ataque, double parada, double esquive)
  {
    this.nombre = nombre;
    this.ataque = ataque;
    this.parada = parada;
    this.esquive = esquive;
  }
}
