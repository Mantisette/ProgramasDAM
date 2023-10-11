package progbloque3.tarea02genericos;

import java.util.Arrays;

public class Main
{

  public static void main(String[] args)
  {
    String[] test = new String[]{
      null,
      "3",
      "2",
      "1",
      null,
      "5",
      "4",
      "8",
      null,
      "5"
    };

    System.out.println(MatrixUtils.countNotNull(test));

    System.out.println(MatrixUtils.findFirstNotNull(test));

    System.out.println(Arrays.toString(test));
    String[] test2 = MatrixUtils.sortAndRemove(test);
    System.out.println(Arrays.toString(test2));
  }
}
