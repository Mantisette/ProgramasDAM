package progbloque2.tarea13batalla;

import java.util.Arrays;
import java.util.Comparator;

public class Principal
{

  public static void main(String[] args)
  {
    System.out.println("\n---------------------------------- Creando protagonistas -------------");
    Escuadron alpha = new Escuadron(2);
    Escuadron beta = new Escuadron(10);
    Francotirador lobo = new Francotirador();
    EquipoMedico batas = new EquipoMedico(3);
    Carro tanque = new Carro(VariedadCarro.TANQUE);
    Carro blindado = new Carro(VariedadCarro.BLINDADO);
    Carro jeep = new Carro(VariedadCarro.JEEP);
    Arsenal almacen = new Arsenal(10);
    Recurso[] recursos = {alpha, beta, lobo, batas, tanque, blindado, jeep, almacen};
    Arrays.sort(recursos, Comparator.nullsLast(Comparator.naturalOrder()));

    for(Recurso r:recursos)System.out.println(r);


    System.out.println("\n---------------------------------- Ataque exitoso no letal -------------");
    lobo.atacar(alpha);

    System.out.println("\n---------------------------------- Ataque exitoso letal -------------");
    lobo.atacar(alpha);

    System.out.println("\n---------------------------------- Ataque fallido por atacante sin vida -------------");
    alpha.atacar(lobo);

    System.out.println("\n---------------------------------- Cura fallida por paciente muerto------------");
    batas.usarCon(alpha, 100);

    System.out.println("\n---------------------------------- Cura fallida por paciente no humano------------");
    batas.usarCon(blindado, 100);

    System.out.println("\n---------------------------------- Ataque exitoso letal -------------");
    lobo.atacar(jeep);

    System.out.println("\n---------------------------------- Ataques de carro a un escuadron -------------");
    tanque.atacar(beta);
    tanque.atacar(beta);
    tanque.atacar(beta);
    tanque.atacar(beta);

    System.out.println("\n---------------------------------- Reposicion desde arsenal -------------");
    almacen.usarCon(lobo, 10);
    almacen.usarCon(tanque, 10);
    almacen.usarCon(tanque, 10);

    System.out.println("\n---------------------------------- Ataques de carro al francotirador -------------");
    for(int i = 0; i < 10; i++)
      tanque.atacar(lobo);

    System.out.println("\n---------------------------------- Cura exitosa -------------");
    batas.usarCon(beta, 500);

    System.out.println("\n---------------------------------- Cura fallida por medicos agotados-------------");
    batas.usarCon(beta, 500);


    System.out.println("\n---------------------------------- ARRAY NUEVO -------------");
    Combatiente[] atacantes  =  new Combatiente[10];

    atacantes[0] = new Escuadron(5);
    atacantes[2] = new Francotirador();
    atacantes[4] = new Carro(VariedadCarro.BLINDADO);
    atacantes[6] = new Carro(VariedadCarro.JEEP);
    atacantes[8] = new Carro(VariedadCarro.TANQUE);

    Arrays.sort(atacantes, Comparator.nullsLast((Comparator) (o1, o2) -> {
      Combatiente c1 = (Combatiente) o1;
      Combatiente c2 = (Combatiente) o2;
      return c1.obtenerIdentificador().compareTo(c2.obtenerIdentificador());
    }));

    for(int i = 0; i < 10; i++)
      System.out.println(atacantes[i]);

    for(int i = 0; i < 10; i++)
    {
      if(atacantes[i] == null) break;
      atacantes[i].atacar(tanque);
    }
  }
}
