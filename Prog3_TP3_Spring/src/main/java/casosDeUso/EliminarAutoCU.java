package casosDeUso;

import repositorio.IBuscarAuto;
import repositorio.IEliminarAuto;

public class EliminarAutoCU {
    private IEliminarAuto iEliminarAutoCU;
    private IBuscarAuto iBuscarAutoCU;

    public EliminarAutoCU(IEliminarAuto iEliminarAuto, IBuscarAuto iBuscarAuto) {
        this.iEliminarAutoCU = iEliminarAuto;
        this.iBuscarAutoCU = iBuscarAuto;
    }

    public boolean darBajaAuto(String patenteABuscar) {
        if (!iBuscarAutoCU.buscarAutoByPatente(patenteABuscar))
            return false;
        return iEliminarAutoCU.bajameAuto(patenteABuscar);
    }
}
