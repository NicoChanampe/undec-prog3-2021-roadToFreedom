package casosDeUso;

import repositorio.IBuscarAuto;

public class BuscarAutoCU {
    private IBuscarAuto iBuscarAutoCU;


    public BuscarAutoCU(IBuscarAuto iBuscarAuto) {
        this.iBuscarAutoCU = iBuscarAuto;
    }


    public boolean buscarAuto(String patenteBuscada) {
        return iBuscarAutoCU.buscarAutoByPatente(patenteBuscada);
    }
}
