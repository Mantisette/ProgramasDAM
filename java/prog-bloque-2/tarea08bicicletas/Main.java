package progbloque2.tarea08bicicletas;

public class Main
{

  public static void main(String[] args)
  {
    Bicicleta b1 = new Bicicleta(Tipo.CARBONO, "Transparente", new Extra[]{Extra.GUARDABARROS, Extra.SOPORTE_MOVIL});
    System.out.println(b1);
    System.out.println(b1.rodar(5));

    Bicicleta b2 = new Bicicleta(Tipo.MADERA, "Ebano");
    System.out.println(b2);
    System.out.println(b2.rodar(7));

    Bicicleta b3 = new Bicicleta();
    System.out.println(b3);
    System.out.println(b3.rodar(123));

    Bicicleta_Pro b4 = new Bicicleta_Pro(Tipo.MADERA, "Marfil", new Extra[]{Extra.SOPORTE_MOVIL, Extra.LUCES, Extra.RUEDA_GORDA}, true, true, 50);
    System.out.println(b4);
    System.out.println(b4.rodar(1000));

    Bicicleta_Pro b5 = new Bicicleta_Pro(Tipo.ALUMINIO, "Acero Templado", true, false, 20);
    System.out.println(b5);
    System.out.println(b5.rodar(2000));
    b5.bajar();

    Bicicleta_Pro b6 = new Bicicleta_Pro();
    System.out.println(b6);
    System.out.println(b6.rodar(3000));
    b6.subir();
    b6.subir();
    b6.subir();
    b6.subir();
  }
}
