/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import sys.dao.UsuarioDAO;
import sys.modelo.Usuario;
import sys.util.NewHibernateUtil;
import sys.component.EncriptarPassoword;
/**
 *
 * @author jeffa
 */
public class UsuarioDAOImplements implements UsuarioDAO{

    @Override
    public Usuario search(Usuario usuario) {
    Session session= NewHibernateUtil.getSessionFactory().openSession();
    String hgl="FROM Usuario WHERE nombreUsuario=:nombreUsuario";
    Query query=session.createQuery(hgl);
    query.setParameter("nombreUsuario", usuario.getNombreUsuario());
    return (Usuario) query.uniqueResult();
    }

    @Override
    public Usuario login(Usuario usuario) {
         Usuario usuarioLogin=search(usuario);
        if(usuarioLogin !=null){
            if(!usuarioLogin.getPassword().equals(EncriptarPassoword.sha512(usuario.getPassword()))){
                usuarioLogin=null;
            }
        }
        
        return usuarioLogin;
    }
    
}
