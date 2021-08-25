package casosDeUso;

import dominio.Auto;
import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoNoExiste;
import repositorio.ITraerAuto;

public class TraerAutoCU {
    private ITraerAuto iTraerAutoCU;

    public TraerAutoCU(ITraerAuto iTraerAuto) {
        this.iTraerAutoCU = iTraerAuto;
    }

    public Auto traerAuto(String patenteAbuscar) throws ExceptionAuto {
        Auto autoBuscado = iTraerAutoCU.dameAuto(patenteAbuscar);
        if(autoBuscado == null)
            throw new ExceptionAutoNoExiste("El auto buscado no existe");
        return autoBuscado;
    }
}
