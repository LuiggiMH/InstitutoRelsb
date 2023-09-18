package sys.dao;

import sys.modelo.Usuarios;

public interface UsuarioDAO {

    public Usuarios search(Usuarios usuario);

    public Usuarios login(Usuarios usuario);
}
