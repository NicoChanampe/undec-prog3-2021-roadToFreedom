package casosDeUso;

import dominio.Auto;
import repositorio.ITraerAuto;

public class TraerAutoCU {
    private ITraerAuto iTraerAutoCU;

    public TraerAutoCU(ITraerAuto iTraerAuto) {
        this.iTraerAutoCU = iTraerAuto;
    }

    public Auto traerAuto(String patenteAbuscar) {
        return iTraerAutoCU.dameAuto(patenteAbuscar);
    }
}
