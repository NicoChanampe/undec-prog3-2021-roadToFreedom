package casosDeUso;

import dominio.Persona;
import exceptions.exceptionAuto.ExceptionAutoNoExiste;
import exceptions.exceptionPersona.*;
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
        validarDni(dni);
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        existePersona(personaAModificar);
        personaAModificar.actualizarPeso(nuevoPeso);
        return iModificarPersona.modificarPeso(personaAModificar);
    }

    public boolean modificarAlturaPersona(String dni, double nuevaAltura) throws ExceptionPersona{
        validarDni(dni);
        Persona personaAModificar = iTraerPersona.damePersonaSegunDni(dni);
        existePersona(personaAModificar);
        personaAModificar.actualizarAltura(nuevaAltura);
        return iModificarPersona.modificarAltura(personaAModificar);
    }

    private void existePersona(Persona personaBuscada) throws ExceptionPersona {
        if(personaBuscada == null)
            throw new ExceptionPersonaNoEncontrada("La persona que busca no existe en la BD");
    }

    private void validarDni(String dni) throws ExceptionPersona{
        if(dni.length() < 7 || dni.length() > 9)
            throw new ExceptionPersonaDniMalEscrito("El dni ingresado esta mal escrito (entre 7 y 9 numeros)");
        for(int i = 0;i<dni.length();i++){
            if(dni.codePointAt(i) < 48 || dni.codePointAt(i) > 57)
                throw new ExceptionPersonaDniMalEscrito("El dni ingresado esta mal escrito (solo debe tener numeros)");
        }
    }

    public boolean modificarDatosPersona(Persona personaActualizada) {
        Persona personaBuscada = iTraerPersona.damePersonaSegunDni(personaActualizada.getDni());
        personaBuscada.actualizarDatos(personaActualizada);
        return iModificarPersona.modificarDatos(personaBuscada);
    }
}
