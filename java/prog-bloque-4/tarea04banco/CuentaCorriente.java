package progbloque4.tarea04banco;

import java.util.HashSet;
import java.util.Objects;

public class CuentaCorriente implements Comparable<CuentaCorriente>
{

  private static final HashSet<String> conjuntoCuentas = new HashSet<>();

  private final String numero;
  private double saldo;

  public CuentaCorriente(double saldo) throws BalanceNegativoException
  {
    numero = generaNumero();
    if (saldo < 0)
      throw new BalanceNegativoException("CC nº " + numero + ": ");
    this.saldo = saldo;
  }

  //------------------------------Getters / Setters
  public String getNumero()
  {
    return numero;
  }

  public double getSaldo()
  {
    return saldo;
  }

  public static HashSet<String> getConjuntoCuentas()
  {
    return new HashSet<String>(conjuntoCuentas);
  }

  @Override
  public String toString()
  {
    return "CuentaCorriente{" + "numero=" + numero + ", saldo=" + saldo + '}';
  }

  //////////////// AUXILIARES ////////////////////////

  private static String generaNumero()
  {
    StringBuilder sb=new StringBuilder("");
    int digito;
    do
    {
      sb.setLength(0);
      for (int i = 0; i < 10; i++)
      {
        digito=(int)(Math.random()*10);
        sb.append(digito);
      }
    } while (!conjuntoCuentas.add(sb.toString()));

    return sb.toString();
  }

  public void ingresar (double importe)
  {
    saldo += importe;
  }

  public void retirar (double importe) throws BalanceNegativoException
  {
    if (importe > saldo) throw new BalanceNegativoException("CC nº " + numero + ": ");
    saldo -= importe;
  }

  public void transferir (CuentaCorriente destino, double importe) throws BalanceNegativoException
  {
    if (importe > saldo) throw new BalanceNegativoException("CC nº " + numero + ": ");
    retirar(importe);
    destino.ingresar(importe);
  }

  //----------------------- Comparación e igualdad ---------------------
  @Override
  public int hashCode()
  {
    int hash = 3;
    hash = 67 * hash + Objects.hashCode(this.numero);
    return hash;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final CuentaCorriente other = (CuentaCorriente) obj;

    return Objects.equals(this.numero, other.numero);
  }

  @Override
  public int compareTo(CuentaCorriente cc)
  {
    return numero.compareTo(cc.numero);
  }
}
