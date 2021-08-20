package repositorio;

import dominio.Persona;

public interface ITraerPersona {
    Persona damePersonaSegunDni(String dniParaBuscar);
}
