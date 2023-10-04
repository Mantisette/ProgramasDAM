package progbloque1.examen1facturas;

import java.util.Scanner;

public class Main{

  public static void main(String[] args){
    StringBuilder sb=new StringBuilder();
    Scanner sc = new Scanner(System.in);
    String opcion;
    int id;
    String cliente;
    double importe;

    Factura factura; //editable
    Factura[] facturas = new Factura[Factura.TOPE]; //DONE: completa la sentencia adecuadamente

    programa: while (true){
      System.out.println("1)CreaFactura 2)ModificaImporte 3)Abona 4)Lista 5)Resumen 6)Morosos");
      opcion = sc.nextLine();
      switch (opcion){
        case "1":
          System.out.println("Introduce cliente e importe (en dos líneas)");
          cliente=sc.nextLine();
          importe=sc.nextDouble();
          sc.nextLine();
          //DONE: crea la factura
          factura = new Factura(cliente, importe);
          facturas[Factura.getCountFacturasCreadas() - 1] = factura;
          //
          System.out.println("...creando factura... OK: " + factura);
          break;
        case "2":
          System.out.println("Introduce Id de la factura y nuevo importe (en dos líneas)");
          id = sc.nextInt();
          importe = sc.nextDouble();
          sc.nextLine();
          //@DONE modifica el importe de la factura que te digan (si no existe
          //  has de dar un mensaje de error)

          //en un mundo perfecto, este check va en un método aparte.
          if (id < 0 || id > Factura.getCountFacturasCreadas())
          {
            System.out.println("Esa factura no existe.");
            break;
          }
          factura = facturas[id-1];

          if (factura.isAbonada())
          {
            System.out.println("...modificando importe...ERROR. No se ha podido hacer: " + factura);
            break;
          }
          factura.setImporteNeto(importe);
          System.out.println("...modificando importe... OK: " + factura);
          //
          break;
        case "3":
          System.out.println("Introduce Id de la factura");
          id=sc.nextInt();
          sc.nextLine();
          //@DONE abona la factura que diga el usuario (si no existe o ya está abonada has de dar un error)
          if (id < 0 || id > Factura.getCountFacturasCreadas())
          {
            System.out.println("Esa factura no existe.");
            break;
          }
          factura = facturas[id-1];

          if (factura.isAbonada())
          {
            System.out.println("...abonando factura... ERROR. No se ha podido hacer: ");
            break;
          }
          factura.setAbonada(true);
          System.out.println("...abonando factura... OK: " + factura);
          //
          break;
        case "4":
          //@DONE muestra el listado de todas las facturas existentes
          for (int i = 0; i < Factura.getCountFacturasCreadas(); i++){
            System.out.println(facturas[i]);
          }
          //
          break;
        case "5":
          //@DONE muestra el resumen de abonadas y pendientes
          System.out.printf("Facturas abonadas (%d) --> %.2f€ %n",
            Factura.getCountFacturasAbonadas(),
            Factura.getImporteFacturasAbonadas());
          System.out.printf("Facturas pendientes (%d) --> %.2f€ %n",
            Factura.getCountFacturasPendientes(),
            Factura.getImporteFacturasPendientes());
          //
          break;
        case "6":
          //@DONE muestra los clientes que tienen facturas pendientes de pago
          for (int i = 0; i < Factura.getCountFacturasCreadas(); i++){
            if (!facturas[i].isAbonada())
            {
              System.out.printf("| %s |", facturas[i].getCliente());
            }
          }
          System.out.println();
          //
          break;
        default://Si elige cualquier otra opción se termina el programa
          System.out.println("Saliendo...");
          break programa;
      }
    }
  }
}
