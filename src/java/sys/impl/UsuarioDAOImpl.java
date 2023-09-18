package sys.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import sys.componentes.EncriptarPassword;
import sys.dao.UsuarioDAO;
import sys.modelo.Usuarios;
import sys.util.HibernateUtil;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuarios search(Usuarios usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuarios WHERE nombreUsuario=:nombreUsuario";
        Query query = session.createQuery(hql);
        query.setParameter("nombreUsuario", usuario.getNombreUsuario());
        return (Usuarios) query.uniqueResult();
    }

    @Override
    public Usuarios login(Usuarios usuario) {
        Usuarios usuarioLogin = search(usuario);
        if (usuarioLogin != null) {
            if (!usuarioLogin.getPassword().equals(EncriptarPassword.sha512(usuario.getPassword()))) {
                usuarioLogin = null;
            }
        }
        return usuarioLogin;
    }
}
