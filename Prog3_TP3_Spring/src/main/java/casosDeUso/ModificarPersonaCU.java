package casosDeUso;

import dominio.Persona;
import repositorio.IModificarPersona;
import repositorio.ITraerPersona;

public class ModificarPersonaCU {
    private ITraerPersona iTraerPersona;
    private IModificarPersona iModificarPersona;

    public ModificarPersonaCU(ITraerPersona iTraerPersona, IModificarPersona iModificarPersona) {
        this.iTraerPersona = iTraerPersona;
        this.iModificarPersona = iModificarPersona;
    }

    public boolean modificarPesoPersona(String dni,double nuevoPeso) {
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        personaAModificar.setPeso(nuevoPeso);
        return iModificarPersona.modificarPeso(personaAModificar);
    }
}
