package casosDeUso;

import dominio.Persona;
import repositorio.ITraerPersona;

public class TraerPersonaCU {
    private ITraerPersona iTraerPersonaCU;
    public TraerPersonaCU(ITraerPersona iTraerPersona) {
        this.iTraerPersonaCU = iTraerPersona;
    }

    public Persona traerPersona(String dniBuscado) {
        Persona personaEncontrada = iTraerPersonaCU.damePersonaSegunDni(dniBuscado);
        return personaEncontrada;
    }
}
