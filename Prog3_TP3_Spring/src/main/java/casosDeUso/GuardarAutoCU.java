package casosDeUso;

import dominio.Auto;
import repositorio.IBuscarAuto;
import repositorio.IGuardarAuto;

public class GuardarAutoCU {
    private IGuardarAuto iGuardarAutoCU;
    private IBuscarAuto iBuscarAutoCU;

    public GuardarAutoCU(IGuardarAuto iGuardarAuto, IBuscarAuto iBuscarAuto) {
        this.iGuardarAutoCU = iGuardarAuto;
        this.iBuscarAutoCU = iBuscarAuto;
    }


    public boolean guardarAuto(Auto unAutito) {
        if(iBuscarAutoCU.buscarAutoByPatente(unAutito.getPatente()))
            return false;
        return iGuardarAutoCU.cargarAuto(unAutito);
    }
}
