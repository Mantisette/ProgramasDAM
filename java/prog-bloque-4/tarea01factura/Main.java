package progbloque4.tarea01factura;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    ArrayList<Factura> lista=new ArrayList<>();
    Factura nueva;
    String entrada=null;

    for(int i=1;i<10;i++)
    {
      nueva=new Factura(Math.random()*10000);
      lista.add(nueva);
    }

    lista.get(2).pagar();
    lista.get(6).pagar();
    for(Factura f:lista) System.out.println(f);
    System.out.println("------------------------------------");
    System.out.println("Que factura quieres pagar (t->todas)");

    //DISYUNTIVA: debo aceptar tanto enteros como letras!!!
    try
    {
      entrada = sc.nextLine();
      int input = Integer.parseInt(entrada);
      if (input > 0 && input <= lista.size())
      {
        lista.get(input).pagar();
        System.out.println("Pagando factura " + input + "...");
      }
    }
    catch (IndexOutOfBoundsException e)
    {
      System.out.println("El ID introducido no es correcto");
    }
    catch(NumberFormatException e)
    {
      if (entrada == null)
      {
        System.out.println("No se ha elegido una opcion");
        return;
      }
      if (entrada.equalsIgnoreCase("t"))
      {
        for (Factura factura : lista)
          factura.pagar();
        System.out.println("Todas las facturas han sido pagadas");
      }
      else
        System.out.println("La opcion elegida no es valida");
    }
    finally
    {
      for(Factura f:lista)
        System.out.println(f);
    }
  }
}
