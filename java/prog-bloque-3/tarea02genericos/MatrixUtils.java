package progbloque3.tarea02genericos;

import java.util.Arrays;
import java.util.Comparator;

public final class MatrixUtils
{

  private MatrixUtils() {}

  public static <T> int countNotNull(T[] source)
  {
    int count = 0;
    for (T o : source)
      if (o != null)
        count++;

    return count;
  }

  public static <T> T findFirstNotNull(T[] source)
  {
    for (T o : source)
      if (o != null)
        return o;

    return null;
  }

  public static <T> T[] removeNull(T[] source)
  {
    int count = countNotNull(source);
    int pos = 0;
    T[] sol = Arrays.copyOf(source, count);

    for (T t : source)
      if (t != null)
      {
        sol[pos] = t;
        pos++;
      }

    return sol;
  }

  public static <T extends Comparable> T[] sortAndRemove(T[] source)
  {
    T[] sol = removeNull(source);
    Arrays.sort(sol, Comparator.nullsLast(Comparator.naturalOrder()));

    return sol;
  }
}
