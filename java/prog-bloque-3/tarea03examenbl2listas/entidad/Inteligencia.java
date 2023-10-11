package progbloque3.tarea03examenbl2listas.entidad;

public interface Inteligencia
{

  default void manipular(Manipulable target)
  {
    System.out.println(this + " manipulando " + target);
    target.serManipulado();
  }

  default void aprender()
  {
    System.out.println(this + ": aprendiendo algo nuevo...");
  }
}
