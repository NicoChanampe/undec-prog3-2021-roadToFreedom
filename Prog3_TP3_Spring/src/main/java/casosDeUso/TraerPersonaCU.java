package casosDeUso;

import dominio.Persona;
import exceptions.exceptionPersona.ExceptionPersona;
import exceptions.exceptionPersona.ExceptionPersonaNoEncontrada;
import repositorio.ITraerPersona;

public class TraerPersonaCU {
    private ITraerPersona iTraerPersonaCU;
    public TraerPersonaCU(ITraerPersona iTraerPersona) {
        this.iTraerPersonaCU = iTraerPersona;
    }

    public Persona traerPersona(String dniBuscado) throws ExceptionPersona {
        Persona personaEncontrada = iTraerPersonaCU.damePersonaSegunDni(dniBuscado);
        if(personaEncontrada==null)
            throw new ExceptionPersonaNoEncontrada("La persona que busco no existe en la BD");
        return personaEncontrada;
    }
}
