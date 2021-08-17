package casosDeUso;

import dominio.Persona;
import repositorio.IGuardarPersona;
import repositorio.ILeerPersona;

public class GuardarPersonaCU {
    private IGuardarPersona iGuardarPersonaCU;
    private ILeerPersona iLeerPersonaCU;

    public GuardarPersonaCU(IGuardarPersona iGuardarPersona, ILeerPersona iLeerPersona) {
        this.iGuardarPersonaCU = iGuardarPersona;
        this.iLeerPersonaCU = iLeerPersona;
    }

    public boolean cargarPersona(Persona nuevaPersona) {
        if(iLeerPersonaCU.buscarPersonaPorDni(nuevaPersona.getDni()))
            return false;
        return iGuardarPersonaCU.guardarPersona(nuevaPersona);
    }
}
