package progbloque1.tarea11cuentacorriente;

public class CuentaCorriente
{

  public static final int MAXIMO_CUENTAS = 100;
  public static final String[] cuentasCreadas = new String[MAXIMO_CUENTAS];

  private static int countCuentas;

  private final String idCuenta;
  private int saldo;

  public CuentaCorriente(int saldo)
  {
    this.idCuenta = generaID();
    this.saldo = saldo;

    cuentasCreadas[countCuentas] = this.idCuenta;
    countCuentas++;
  }

  public CuentaCorriente()
  {
    this(0);
  }

  public String generaID()
  {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 10; i++)
      sb.append((int) (Math.random() * 10));

    return sb.toString();
  }

  @Override
  public String toString()
  {
    return "Numero de cta: " + idCuenta + " Saldo: " + saldo + " euros";
  }

  public boolean ingresar(int cantidad)
  {
    if (cantidad <= 0)
    {
      System.out.println("Cantidad incorrecta");
      return false;
    }
    this.saldo += cantidad;
    return true;
  }

  public boolean gastar(int cantidad)
  {
    if (cantidad <= 0)
    {
      System.out.println("Cantidad incorrecta");
      return false;
    }
    this.saldo -= cantidad;
    return true;
  }

  public void transferir(CuentaCorriente cuentaDestino, int cantidad)
  {
    if (cuentaDestino.ingresar(cantidad))
      this.gastar(cantidad);
  }
}
