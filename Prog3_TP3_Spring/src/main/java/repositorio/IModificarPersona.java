package repositorio;

import dominio.Persona;

public interface IModificarPersona {
    boolean modificarPeso(Persona nuevaPersona);

    boolean modificarAltura(Persona nuevaPersona);

    boolean modificarDatos(Persona personaActualizada);
}
