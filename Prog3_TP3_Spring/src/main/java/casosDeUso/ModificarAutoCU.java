package casosDeUso;

import dominio.Auto;
import repositorio.IModificarAuto;
import repositorio.ITraerAuto;

public class ModificarAutoCU {
    private IModificarAuto iModificarAutoCU;
    private ITraerAuto iTraerAutoCU;

    public ModificarAutoCU(IModificarAuto iModificarAuto, ITraerAuto iTraerAuto) {
        this.iModificarAutoCU = iModificarAuto;
        this.iTraerAutoCU = iTraerAuto;
    }

    public boolean actualizarDatos(Auto autoActualizado) {
        Auto autoBuscado = iTraerAutoCU.dameAuto(autoActualizado.getPatente());
        autoBuscado.actualizarAuto(autoActualizado);
        return iModificarAutoCU.modificarAuto(autoBuscado);
    }
}
