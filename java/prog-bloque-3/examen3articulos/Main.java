package progbloque3.examen3articulos;

import java.util.HashSet;

public class Main
{

  public static void main(String[] args)
  {
    pruebasArticulos();
    pruebasAlmacenes();
    pruebasContenedor();
  }

  private static void pruebasArticulos()
  {
    System.out.println("\n.......Creo unos cuantos artículos y muestro el catálogo........");
    new Articulo("Mesa de comedor",187.25f);
    new Articulo("Estantería",15f);
    new Articulo("Banqueta de baño",45.20f);
    new Articulo("Estantería",7.5f);
    Articulo.muestraCatalogo();

    System.out.println("\n.......Recupero un artículo válido y lo muestro por pantalla........");
    Articulo articulo2=Articulo.recuperaArticulo(2);
    System.out.println(articulo2);

    System.out.println("\n.......Recupero un artículo NO válido y lo muestro por pantalla........");
    Articulo articulo100=Articulo.recuperaArticulo(100);
    System.out.println(articulo100);
  }

  private static void pruebasAlmacenes()
  {
    System.out.println("\n.......Creo unos cuantos almacenes y muestro la red........");
    System.out.print(Almacen.nuevoAlmacen("Sevilla"));
    System.out.print("  |  ");
    System.out.print(Almacen.nuevoAlmacen(null));//Este debería ser false
    System.out.print("  |  ");
    System.out.print(Almacen.nuevoAlmacen("Huelva"));
    System.out.print("  |  ");
    System.out.print(Almacen.nuevoAlmacen("Málaga"));
    System.out.print("  |  ");
    System.out.print(Almacen.nuevoAlmacen("Cáceres"));
    System.out.print("  |  ");
    System.out.print(Almacen.nuevoAlmacen("Huelva"));//Este debería ser false
    System.out.println();
    Almacen.muestraRed();

    System.out.println("\n.......Recupero un almacén, recepciono artículos y muestro almacén........");
    Almacen a1=Almacen.recuperaAlmacen(2);
    System.out.print(a1.recibe(2,2));
    System.out.print("  |  ");
    System.out.print(a1.recibe(20,2));//esta petición debería devolver false
    System.out.print("  |  ");
    System.out.print(a1.recibe(2,-2));//esta petición debería devolver false
    System.out.print("  |  ");
    System.out.print(a1.recibe(0,3));
    System.out.print("  |  ");
    System.out.print(a1.recibe(0,1));
    System.out.println();
    a1.muestraExistencias();
  }

  private static void pruebasContenedor()
  {
    System.out.println("\n.......Creo un contenedor de Artículos........");
    Contenedor<Articulo> c1=new Contenedor<>("c1");
    Articulo a1=new Articulo("Piruleta",1f);
    Articulo a2=new Articulo("Vino",2f);
    Articulo a3=new Articulo("Arroz",3f);
    Articulo a4=new Articulo("Gel",4f);
    System.out.println(".......Guardo dentro varios artículos........");
    System.out.print(c1.guardar(a1));
    System.out.print("  |  ");
    System.out.print(c1.guardar(a1));//esto debería ser false (los contenedores no pueden almacenar duplicados)
    System.out.print("  |  ");
    System.out.print(c1.guardar(a2));
    System.out.print("  |  ");
    System.out.print(c1.guardar(null));//esto debería ser false (los contenedores no aceptan null)
    System.out.print("  |  ");
    System.out.print(c1.guardar(a3));
    System.out.print("  |  ");
    System.out.print(c1.guardar(a4));
    System.out.println();
    System.out.println(c1);
    System.out.println(".......Y saco un de ellos........");
    System.out.println(c1.sacar());
    System.out.println(".......Esto es lo que queda dentro........");
    System.out.println(c1);
    System.out.println(".......Saco los restantes y muestro lo que he sacado........");
    HashSet<Articulo> contenido= c1.sacarTodo();
    System.out.println(contenido);
    System.out.println(".......Saco los restantes(NADA) y muestro lo que he sacado(NADA)........");
    HashSet<Articulo> contenido2= c1.sacarTodo();
    System.out.println(contenido2);
  }
}
