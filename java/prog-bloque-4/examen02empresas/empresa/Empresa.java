package progbloque4.examen02empresas.empresa;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable
{
  private final String cif;
  private final String razonSocial;
  private final ArrayList<Empleado> plantilla;

  public Empresa(String cif, String razonSocial)
  {
    this.cif = cif;
    this.razonSocial = razonSocial;
    this.plantilla = new ArrayList<>();
  }

  public void insertaEmpleado(Empleado nuevo)
  {
    plantilla.add(nuevo);
  }

  @Override
  public String toString()
  {
    StringBuilder sb=new StringBuilder("\n")
      .append(razonSocial.toUpperCase())
      .append("(").append(cif).append(")");
    for (Empleado e:plantilla)
    {
      sb.append("\n\t").append(e);
    }

    return sb.toString();
  }
}
