package progbloque3.tarea01delincuentes;

public class Main
{

  public static void main(String[] args)
  {
    Banda.nueva("Los tatos","Sevilla", 4, new Atracador("El tato",Sexo.V));
    Banda.nueva("Los chocos","Huelva", 6, new Falsificador("El choco","Pensamientos"));
    Banda.nueva("Los chocos","Cadiz", 3, new Traficante("El pisha","Trafiquistan"));

    System.out.println(Banda.recuperarListado());
  }
}
