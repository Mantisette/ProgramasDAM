package progbloque3.tarea10incidencias;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Principal
{

  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    TreeMap<LocalDate, TreeSet<String>> datos = new TreeMap<>();
    DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // Si se usa otro formato al escribir casca

    while(true)
    {
      System.out.println("Dime el equipo que presentó incidencia");
      String equipo = sc.nextLine();

      if(equipo.equals("x"))
        break;

      System.out.println("Introduce la fecha de la incidencia (formato dd/mm/aaaa)");
      LocalDate fecha = LocalDate.parse(sc.nextLine(), formateador);

      if(datos.containsKey(fecha))
        datos.get(fecha).add(equipo);
      else
      {
        // Si la fecha es nueva
        TreeSet<String> conjuntoEquipos = new TreeSet<>();
        conjuntoEquipos.add(equipo);
        datos.put(fecha,  conjuntoEquipos);
      }
    }

    for(LocalDate c:datos.keySet())
    {
      TreeSet<String> conjuntoEquipos = datos.get(c);
      System.out.print(c.format(formateador) + " ");

      for(String s : conjuntoEquipos)
        System.out.print(s + " ");

      System.out.println("\n");
    }
  }
}
