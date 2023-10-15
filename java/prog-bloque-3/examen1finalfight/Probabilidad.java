package progbloque3.examen1finalfight;

public enum Probabilidad
{
  GUERRERO(0.75),
  NIGROMANTE(0.25);

  final double valor;

  Probabilidad(double valor)
  {
    this.valor = valor;
  }
}
