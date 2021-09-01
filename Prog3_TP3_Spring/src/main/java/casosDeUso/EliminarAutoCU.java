package casosDeUso;

import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoNoExiste;
import repositorio.IBuscarAuto;
import repositorio.IEliminarAuto;

public class EliminarAutoCU {
    private IEliminarAuto iEliminarAutoCU;
    private IBuscarAuto iBuscarAutoCU;

    public EliminarAutoCU(IEliminarAuto iEliminarAuto, IBuscarAuto iBuscarAuto) {
        this.iEliminarAutoCU = iEliminarAuto;
        this.iBuscarAutoCU = iBuscarAuto;
    }

    public boolean darBajaAuto(String patenteABuscar) throws ExceptionAuto {
        if (!iBuscarAutoCU.buscarAutoByPatente(patenteABuscar))
            throw new ExceptionAutoNoExiste("La patente ingresada no pertenece a un auto de la BD");
        return iEliminarAutoCU.bajameAuto(patenteABuscar);
    }
}
