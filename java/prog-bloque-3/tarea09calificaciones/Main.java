package progbloque3.tarea09calificaciones;

import java.util.Scanner;
import java.util.TreeSet;

public class Main
{

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args)
  {
    TreeSet<Alumno> clase = new TreeSet<>();

    while (true)
    {
      System.out.print("Introduzca el nombre del alumno (x para salir): ");
      String nombre = sc.nextLine();

      if (nombre.equals("x"))
        break;

      Alumno creando = new Alumno(nombre);

      System.out.println("A continuacion, introduzca sus calificaciones.");
      for (Asignatura asig : Asignatura.values())
      {
        System.out.print(asig.nombre + ": ");
        int nota;
        nota = sc.nextInt();
        creando.ponerNota(asig, nota);
      }

      sc.nextLine();
      clase.add(creando);
    }

    for (Alumno alumno : clase)
      System.out.println(alumno);
  }
}
