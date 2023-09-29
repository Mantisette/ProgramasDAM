package progbloque1.tarea03terminal;

public class Terminal
{
  final String numTelefono;
  int segundosLlamada;

  public Terminal(String numTelefono)
  {
    this.numTelefono = numTelefono;
    this.segundosLlamada = 0;
  }

  @Override
  public String toString()
  {
    return ("Num: " + numTelefono + " - " + segundosLlamada + "s de conversacion");
  }

  public void llama(Terminal target, int segundosLlamada)
  {
    this.segundosLlamada += segundosLlamada;
    target.segundosLlamada += segundosLlamada;
  }

  // Probando sobrecarga de métodos
  void bonificar(int segundosSustraendo)
  {
    this.segundosLlamada -= segundosSustraendo;
  }

  // Si se llama al método con un número de segundos, se eliminan esos
  // segundos. Si se llama al mismo método sin parámetros, los segundos se
  // ponen a 0.
  void bonificar()
  {
    bonificar(segundosLlamada);
  }
}
