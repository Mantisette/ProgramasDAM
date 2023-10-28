package progbloque4.examen01finalfightmejorado;

// ¡¡¡IMPORTANTE!!!
// Si se quiere cambiar la probabilidad de aparrición de los villanos,
// se puede hacer aquí. Pero siempre deben sumar 1!!

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
