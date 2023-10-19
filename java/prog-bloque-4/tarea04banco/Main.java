package progbloque4.tarea04banco;

public class Main
{

  public static void main(String[] args)
  {
    CuentaCorriente cuenta1 = nuevaCuentaSegura();
    CuentaCorriente cuenta2 = nuevaCuentaSegura(1500);
    CuentaCorriente cuenta3 = nuevaCuentaSegura(6000);
    System.out.println(cuenta1);
    System.out.println(cuenta2);
    System.out.println(cuenta3);
    cuenta1.ingresar(2000);
    retirarSeguro(cuenta2, 5000);
    cuenta3.ingresar(75);
    retirarSeguro(cuenta1, 55);
    transferirSeguro(cuenta2, cuenta3, 100);
    System.out.println(cuenta1);
    System.out.println(cuenta2);
    System.out.println(cuenta3);
  }

  public static CuentaCorriente nuevaCuentaSegura()
  {
    return nuevaCuentaSegura(0);
  }

  public static CuentaCorriente nuevaCuentaSegura(double saldo)
  {
    try
    {
      return new CuentaCorriente(saldo);
    }
    catch (BalanceNegativoException e)
    {
      System.out.println(e.getMessage());
      return null;
    }
  }

  public static void retirarSeguro(CuentaCorriente source, double cantidad)
  {
    try
    {
      source.retirar(cantidad);
    }
    catch (BalanceNegativoException e)
    {
      System.out.println(e.getMessage());
    }
  }

  public static void transferirSeguro(CuentaCorriente source, CuentaCorriente target, double cantidad)
  {
    try
    {
      source.transferir(target, cantidad);
    }
    catch (BalanceNegativoException e)
    {
      System.out.println(e.getMessage());
    }
  }
}
