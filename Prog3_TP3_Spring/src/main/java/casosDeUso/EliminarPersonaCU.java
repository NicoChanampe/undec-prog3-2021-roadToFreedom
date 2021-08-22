package casosDeUso;

import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaNoEncontrada;
import repositorio.IBuscarPersona;
import repositorio.IEliminarPersona;

public class EliminarPersonaCU {
    private IBuscarPersona iBuscarPersonaCU;
    private IEliminarPersona iEliminarPersonaCU;

    public EliminarPersonaCU(IBuscarPersona iBuscarPersona, IEliminarPersona iEliminarPersona) {
        this.iBuscarPersonaCU = iBuscarPersona;
        this.iEliminarPersonaCU = iEliminarPersona;
    }

    public boolean darDeBajaPersona(String dniPersonaEliminar) throws ExceptionPersona {
        if(!iBuscarPersonaCU.buscarPersonaPorDni(dniPersonaEliminar))
            throw new ExceptionPersonaNoEncontrada("La persona no se encuentra en la BD");
        return iEliminarPersonaCU.darBajaPersona(dniPersonaEliminar);
    }
}
