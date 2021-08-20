package casosDeUso;

import repositorio.IBuscarPersona;

public class BuscarPersonaCU {
    private IBuscarPersona iBuscarPersonaCU;

    public BuscarPersonaCU(IBuscarPersona ileerPersona) {
        this.iBuscarPersonaCU = ileerPersona;
    }

    public boolean buscarPersona(String dniPersonaBuscada) {
        boolean personaExiste = iBuscarPersonaCU.buscarPersonaPorDni(dniPersonaBuscada);

        return personaExiste;
    }
}
