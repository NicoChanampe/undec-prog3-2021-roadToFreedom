package casosDeUso;

import dominio.Auto;
import exceptions.exceptionAuto.ExceptionAuto;
import exceptions.exceptionAuto.ExceptionAutoExistente;
import repositorio.IBuscarAuto;
import repositorio.IGuardarAuto;

public class GuardarAutoCU {
    private IGuardarAuto iGuardarAutoCU;
    private IBuscarAuto iBuscarAutoCU;

    public GuardarAutoCU(IGuardarAuto iGuardarAuto, IBuscarAuto iBuscarAuto) {
        this.iGuardarAutoCU = iGuardarAuto;
        this.iBuscarAutoCU = iBuscarAuto;
    }

    public boolean guardarAuto(Auto unAutito) throws ExceptionAuto {
        if(iBuscarAutoCU.buscarAutoByPatente(unAutito.getPatente()))
            throw new ExceptionAutoExistente("El auto existe en la BD");
        return iGuardarAutoCU.cargarAuto(unAutito);
    }
}
