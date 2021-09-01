package casosDeUso;

import dominio.Auto;
import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoNoExiste;
import repositorio.IModificarAuto;
import repositorio.ITraerAuto;

public class ModificarAutoCU {
    private IModificarAuto iModificarAutoCU;
    private ITraerAuto iTraerAutoCU;

    public ModificarAutoCU(IModificarAuto iModificarAuto, ITraerAuto iTraerAuto) {
        this.iModificarAutoCU = iModificarAuto;
        this.iTraerAutoCU = iTraerAuto;
    }

    public boolean actualizarDatos(Auto autoActualizado) throws ExceptionAuto {
        Auto autoBuscado = iTraerAutoCU.dameAuto(autoActualizado.getPatente());
        if (autoBuscado == null)
            throw new ExceptionAutoNoExiste("El auto buscado no existe en la BD");
        autoBuscado.actualizarAuto(autoActualizado);
        return iModificarAutoCU.modificarAuto(autoBuscado);
    }
}
