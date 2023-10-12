package progbloque3.tarea04baraja;

public enum Valor
{

  AS      ("As", 1),
  DOS     ("2", 2),
  TRES    ("3", 3),
  CUATRO  ("4", 4),
  CINCO   ("5", 5),
  SEIS    ("6", 6),
  SIETE   ("7", 7),
  SOTA    ("Sota", 10),
  CABALLO ("Caballo", 11),
  REY     ("Rey", 12);

  final String valor;
  final int puntos;

  Valor(String valor, int puntos)
  {
    this.valor = valor;
    this.puntos = puntos;
  }
}
