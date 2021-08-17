package casosDeUso;

import dominio.Persona;
import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaExiste;
import repositorio.IGuardarPersona;
import repositorio.ILeerPersona;

public class GuardarPersonaCU {
    private IGuardarPersona iGuardarPersonaCU;
    private ILeerPersona iLeerPersonaCU;

    public GuardarPersonaCU(IGuardarPersona iGuardarPersona, ILeerPersona iLeerPersona) {
        this.iGuardarPersonaCU = iGuardarPersona;
        this.iLeerPersonaCU = iLeerPersona;
    }

    public boolean cargarPersona(Persona nuevaPersona) throws ExceptionPersona {
        if(iLeerPersonaCU.buscarPersonaPorDni(nuevaPersona.getDni()))
            throw new ExceptionPersonaExiste("La persona buscada ya se encuentra en la BD");
        return iGuardarPersonaCU.guardarPersona(nuevaPersona);
    }
}
