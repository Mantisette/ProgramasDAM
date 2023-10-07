package progbloque2.tarea13batalla;

public interface Combatiente
{

  String obtenerIdentificador();
  int obtenerFuerzaAtaque();

  default void atacar(Combatiente target)
  {
    if (esPosibleAtacar())
    {
      System.out.println(this.obtenerIdentificador() + " atacando a " + target.obtenerIdentificador());
      target.encajarAtaque(this.obtenerFuerzaAtaque());

      // Resultado
      System.out.println(this);
      System.out.println(target);
    }
  }

  boolean esPosibleAtacar();
  void encajarAtaque(int fuerza);
}
