package casosDeUso;

import dominio.Persona;
import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaExiste;
import repositorio.IGuardarPersona;
import repositorio.IBuscarPersona;

public class GuardarPersonaCU {
    private IGuardarPersona iGuardarPersonaCU;
    private IBuscarPersona iBuscarPersonaCU;

    public GuardarPersonaCU(IGuardarPersona iGuardarPersona, IBuscarPersona iBuscarPersona) {
        this.iGuardarPersonaCU = iGuardarPersona;
        this.iBuscarPersonaCU = iBuscarPersona;
    }

    public boolean cargarPersona(Persona nuevaPersona) throws ExceptionPersona {
        if(iBuscarPersonaCU.buscarPersonaPorDni(nuevaPersona.getDni()))
            throw new ExceptionPersonaExiste("La persona buscada ya se encuentra en la BD");
        return iGuardarPersonaCU.guardarPersona(nuevaPersona);
    }
}
