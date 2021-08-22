package casosDeUso;

import repositorio.IBuscarPersona;
import repositorio.IEliminarPersona;

public class EliminarPersonaCU {
    private IBuscarPersona iBuscarPersonaCU;
    private IEliminarPersona iEliminarPersonaCU;

    public EliminarPersonaCU(IBuscarPersona iBuscarPersona, IEliminarPersona iEliminarPersona) {
        this.iBuscarPersonaCU = iBuscarPersona;
        this.iEliminarPersonaCU = iEliminarPersona;
    }

    public boolean darDeBajaPersona(String dniPersonaEliminar) {
        if(!iBuscarPersonaCU.buscarPersonaPorDni(dniPersonaEliminar))
            return false;
        return iEliminarPersonaCU.darBajaPersona(dniPersonaEliminar);
    }
}
