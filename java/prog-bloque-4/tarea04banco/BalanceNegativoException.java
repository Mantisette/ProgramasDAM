package progbloque4.tarea04banco;

public class BalanceNegativoException extends Exception
{

  public BalanceNegativoException(String message)
  {
    super(message + "No se puede realizar la operación.");
  }
}
