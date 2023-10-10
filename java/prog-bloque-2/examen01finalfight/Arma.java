package progbloque2.examen01finalfight;

public enum Arma
{

  CUCHILLOS("cuchillos",0.5f,0.25f,0.75f),
  ESPADA_ESCUDO("espada+escudo",0.75f,0.5f,0.25f),
  HACHA("hacha",1f,0.25f,0.25f);

  final String nombre;
  final float ataque;
  final float parada;
  final float esquive;

  Arma(String nombre, float ataque, float parada, float esquive)
  {
    this.nombre = nombre;
    this.ataque = ataque;
    this.parada = parada;
    this.esquive = esquive;
  }
}
