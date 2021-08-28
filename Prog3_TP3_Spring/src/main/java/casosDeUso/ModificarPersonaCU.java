package casosDeUso;

import dominio.Persona;
import exceptions.exceptionAuto.ExceptionAutoNoExiste;
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
        existePersona(personaAModificar);
        personaAModificar.actualizarPeso(nuevoPeso);
        return iModificarPersona.modificarPeso(personaAModificar);
    }

    public boolean modificarAlturaPersona(String dni, double nuevaAltura) throws ExceptionPersona{
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        existePersona(personaAModificar);
        personaAModificar.actualizarAltura(nuevaAltura);
        return iModificarPersona.modificarAltura(personaAModificar);
    }

    private void existePersona(Persona personaBuscada) throws ExceptionPersona {
        if(personaBuscada == null)
            throw new ExceptionPersonaNoEncontrada("La persona que busca no existe en la BD");
    }
}
