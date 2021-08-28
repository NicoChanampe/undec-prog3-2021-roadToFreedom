package casosDeUso;

import dominio.Persona;
import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaAlturaErronea;
import exceptions.exceptionPersona.ExceptionPersonaNoEncontrada;
import exceptions.exceptionPersona.ExceptionPersonaPesoErroneo;
import repositorio.IModificarPersona;
import repositorio.ITraerPersona;

public class ModificarPersonaCU {
    private ITraerPersona iTraerPersona;
    private IModificarPersona iModificarPersona;

    public ModificarPersonaCU(ITraerPersona iTraerPersona, IModificarPersona iModificarPersona) {
        this.iTraerPersona = iTraerPersona;
        this.iModificarPersona = iModificarPersona;
    }

    public boolean modificarPesoPersona(String dni,double nuevoPeso) throws ExceptionPersona {
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        if(personaAModificar == null)
            throw new ExceptionPersonaNoEncontrada("La persona con dni: "+dni+" no existe en la BD");
        personaAModificar.actualizarPeso(nuevoPeso);
        return iModificarPersona.modificarPeso(personaAModificar);
    }

    public boolean modificarAlturaPersona(String dni, double nuevaAltura) throws ExceptionPersona{
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        personaAModificar.actualizarAltura(nuevaAltura);
        return iModificarPersona.modificarAltura(personaAModificar);
    }
}
