package progbloque4.tarea03facturap2;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal
{

  static final ArrayList<Factura> lista = new ArrayList<>();

  public static void main(String[] args)
  {
    Factura nueva;
    for (int i = 1; i < 10; i++)
    {
      nueva = new Factura(Math.random() * 10000);
      lista.add(nueva);
    }
    lista.get(2).pagar();
    lista.get(6).pagar();
    for(Factura f:lista)
      System.out.println(f);

    System.out.println("------------------------------------");

    //Dado que el método no captura y procesa las excepciones, tendrás que hacerlo aquí
    try
    {
      solicita_pago();
    }
    catch (NumberFormatException e)
    {
      System.out.println("Introduzca una opcion valida");
    }
    catch (IndexOutOfBoundsException e)
    {
      System.out.println("La factura elegida no existe");
    }

    for(Factura f:lista)
      System.out.println(f);
  }

  static void solicita_pago() throws NumberFormatException, IndexOutOfBoundsException
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Qué factura quieres pagar (t->todas)");
    String entrada = sc.nextLine();
    //Procesa aquí la entrada para tratar las diferentes opciones sin capturar las posibles excepciones
    if (entrada.equalsIgnoreCase("t"))
    {
      for (Factura factura : lista)
        factura.pagar();
      return;
    }
    int entradaValor = Integer.parseInt(entrada);
    lista.get(entradaValor).pagar();
  }
}
