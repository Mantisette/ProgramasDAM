package progbloque1.tarea11cuentacorriente;

public class Main
{

  public static void main(String[] args)
  {
    CuentaCorriente cuenta1 = new CuentaCorriente();
    CuentaCorriente cuenta2 = new CuentaCorriente(1500);
    CuentaCorriente cuenta3 = new CuentaCorriente(6000);
    System.out.println(cuenta1);
    System.out.println(cuenta2);
    System.out.println(cuenta3);
    cuenta1.ingresar(2000);
    cuenta2.gastar(600);
    cuenta3.ingresar(75);
    cuenta1.gastar(55);
    cuenta2.transferir(cuenta3, 100);
    System.out.println(cuenta1);
    System.out.println(cuenta2);
    System.out.println(cuenta3);

    CuentaCorriente cuenta4 = new CuentaCorriente();
    CuentaCorriente cuenta5 = new CuentaCorriente(1500);
    CuentaCorriente cuenta6 = new CuentaCorriente(6000);
    CuentaCorriente cuenta7 = new CuentaCorriente();
    CuentaCorriente cuenta8 = new CuentaCorriente(1500);
    CuentaCorriente cuenta9 = new CuentaCorriente(6000);
    System.out.println("-------");
    System.out.println(cuenta1);
    System.out.println(cuenta2);
    System.out.println(cuenta3);
    System.out.println(cuenta4);
    System.out.println(cuenta5);
    System.out.println(cuenta6);
    System.out.println(cuenta7);
    System.out.println(cuenta8);
    System.out.println(cuenta9);
  }
}
