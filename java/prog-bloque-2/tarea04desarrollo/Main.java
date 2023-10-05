package progbloque2.tarea04desarrollo;

public class Main
{

  public static void main(String[] args)
  {
    Jefe jorge = new Jefe("Jorge", 2200, 5000);
    Programador ana = new Programador("Ana", 1100);
    Programador blas = new Programador("Blas", 1200);
    Programador carlos = new Programador("Carlos", 1300);
    Programador[] prog_alfa = new Programador[]
      {
        ana, blas, carlos
      };

    Jefe juana = new Jefe("Juana", 2300, 6000);

    Equipo alfa = new Equipo("Alfa", jorge, prog_alfa);

    Equipo beta = new Equipo("Beta", juana, 4);

    Equipo gamma = new Equipo("Gamma", 2);

    System.out.println(alfa);
    System.out.println(beta);
    System.out.println(gamma);
  }
}
