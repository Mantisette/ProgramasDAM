package progbloque2.examen02seres.entidad;

public interface Inteligencia
{

  default void manipular(Manipulable m)
  {
    System.out.println(this + " manipulando " + m);
    m.serManipulado();
  }

  default void aprender()
  {
    System.out.println(this + "...aprendiendo algo nuevo");
  }
}
