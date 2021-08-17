package casosDeUso;

import dominio.Persona;
import repositorio.ILeerPersona;

public class BuscarPersonaCU {
    private ILeerPersona iLeerPersonaCU;

    public BuscarPersonaCU(ILeerPersona ileerPersona) {
        this.iLeerPersonaCU = ileerPersona;
    }

    public boolean buscarPersona(String dniPersonaBuscada) {
        boolean personaExiste = iLeerPersonaCU.buscarPersonaPorDni(dniPersonaBuscada);

        return personaExiste;
    }
}
