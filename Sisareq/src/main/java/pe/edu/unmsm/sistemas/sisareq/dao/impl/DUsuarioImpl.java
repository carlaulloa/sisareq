/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.sistemas.sisareq.dao.DUsuario;
import pe.edu.unmsm.sistemas.sisareq.domain.Usuario;

/**
 *
 * @author ULLOA
 */
@Repository
public class DUsuarioImpl extends DGenericoImpl implements DUsuario, Serializable {

    private Transaction tx;

    @Override
    public Usuario buscarPorNombre(String login) {
        Usuario usuario = null;
        Session session = getCurrentSession();
        Query query;
        try {
            // tx = session.beginTransaction();
            query = session.createSQLQuery("SELECT * FROM usuario where nombre_usuario = ?").addEntity(Usuario.class);
            query.setString(0, login);
            usuario = (Usuario) query.uniqueResult();
           // tx.commit();

        } catch (HibernateException | SecurityException e) {
            System.out.println("Excepcion en UsuarioDAO");
            e.printStackTrace();
        }/*finally{
         session.close();
         }*/

        System.out.println("el user : " + usuario);
        return usuario;
    }

    @Override
    public String insert(Usuario usuario) {
        String salida = null;
        Session session = getCurrentSession();
        try {
            //   tx = session.beginTransaction();
            salida = String.valueOf(session.save(usuario));
            session.flush();
            session.evict(usuario);
            //  tx.commit();
        } catch (ConstraintViolationException ce) {
            salida = "duplicado";
            ce.printStackTrace();
        } catch (HibernateException he) {
            salida = "error";
            he.printStackTrace();
        }/* finally {
         session.close();
         }*/

        return salida;
    }

    @Override
    public List<Object[]> getAll() {
        List<Object[]> lsUsuarios = null;
        String hql = "SELECT u.idUsuario, "
                + " u.nombreUsuario , "
                + " u.contrasenia , "
                + " u.nombre , "
                + " u.apellidoPat, "
                + " u.apellidoMat, "
                + " u.estado, "
                + " r.idRol, "
                + " r.nombreRol, "
                + " r.descripcion "
                + " FROM Usuario u "
                + " INNER JOIN u.rolId r ";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //   tx = session.beginTransaction();
            query = session.createQuery(hql);
            lsUsuarios = (List<Object[]>) query.list();
            //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/*finally{
         session.close();
         }*/

        return lsUsuarios;
    }

    @Override
    public String update(Usuario usuario) {
        String salida = null;
        Session session = getCurrentSession();
        try {
            // tx = session.beginTransaction();
            session.update(usuario);
            // tx.commit();            
            salida = "ok";
            session.flush();
            session.evict(usuario);
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
         session.close();
         }*/

        return salida;
    }

    @Override
    public Object[] getById(Integer idUsuario) {
        List<Object[]> lsUsuarios = null;
        String hql = "SELECT u.idUsuario, "
                + " u.nombreUsuario , "
                + " u.contrasenia , "
                + " u.nombre , "
                + " u.apellidoPat, "
                + " u.apellidoMat, "
                + " u.estado, "
                + " r.idRol, "
                + " r.nombreRol, "
                + " r.descripcion "
                + " FROM Usuario u "
                + " INNER JOIN u.rolId r "
                + " WHERE u.idUsuario = :idUser";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //  tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idUser", idUsuario);
            lsUsuarios = (List<Object[]>) query.list();
            // tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/*finally{
         session.close();
         }*/

        return (lsUsuarios.isEmpty() ? null : lsUsuarios.get(0));
    }

    @Override
    public Object[] getByNombreUsuario(String nombreUsuario) {
        Object[] usuario = null;
        String hql = "SELECT u.idUsuario, "
                + " u.nombreUsuario , "
                + " u.contrasenia , "
                + " u.nombre , "
                + " u.apellidoPat, "
                + " u.apellidoMat, "
                + " u.estado, "
                + " r.idRol, "
                + " r.nombreRol, "
                + " r.descripcion, "
                + " u.usuarioId.idUsuario"
                + " FROM Usuario u "
                + " INNER JOIN u.rolId r "
                + " WHERE u.nombreUsuario = :nomUser "
                + " AND u.estado = true "
                + " ORDER BY u.nombre ASC , u.apellidoPat ASC , u.apellidoMat ASC";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //  tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("nomUser", nombreUsuario);
            usuario = (Object[]) query.uniqueResult();
            //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/*finally{
         session.close();
         }*/

        return usuario;
    }

    @Override
    public List<Object[]> getAllActivos() {
        List<Object[]> lsUsuarios = null;
        String hql = "SELECT u.idUsuario, "
                + " u.nombreUsuario , "
                + " u.contrasenia , "
                + " u.nombre , "
                + " u.apellidoPat, "
                + " u.apellidoMat, "
                + " u.estado, "
                + " r.idRol, "
                + " r.nombreRol, "
                + " r.descripcion,"
                + " u.usuarioId.idUsuario "
                + " FROM Usuario u "
                + " INNER JOIN u.rolId r "
                + " WHERE u.estado = true "
                + " ORDER BY u.nombre ASC , u.apellidoPat ASC , u.apellidoMat ASC ";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //   tx = session.beginTransaction();
            query = session.createQuery(hql);
            lsUsuarios = (List<Object[]>) query.list();
            //   tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/*finally{
         session.close();
         }*/

        return lsUsuarios;
    }

    @Override
    public List<Object[]> getByRol(Integer idRol) {
        List<Object[]> lsUsuarios = null;
        String hql = "SELECT u.idUsuario, "
                + " u.nombreUsuario , "
                + " u.contrasenia , "
                + " u.nombre , "
                + " u.apellidoPat, "
                + " u.apellidoMat, "
                + " u.estado, "
                + " r.idRol, "
                + " r.nombreRol, "
                + " r.descripcion,"
                + " u.usuarioId.idUsuario "
                + " FROM Usuario u "
                + " INNER JOIN u.rolId r "
                + " WHERE u.estado = true "
                + " AND r.idRol = :idRol "
                + " ORDER BY u.nombre ASC , u.apellidoPat ASC , u.apellidoMat ASC";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //   tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idRol", idRol);
            lsUsuarios = (List<Object[]>) query.list();
            //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/*finally{
         session.close();
         }*/

        return lsUsuarios;
    }

    @Override
    public List<Object[]> getSupervisores() {
        List<Object[]> lsUsuarios = null;
        String hql = "SELECT s.idUsuario, "
                + " s.nombreUsuario , "
                + " s.contrasenia , "
                + " s.nombre , "
                + " s.apellidoPat, "
                + " s.apellidoMat, "
                + " s.estado, "
                + " r.idRol, "
                + " r.nombreRol, "
                + " r.descripcion "
                + " FROM Usuario s "
                + " INNER JOIN s.rolId r "
                + " WHERE s.estado = true "
                + " AND r.idRol = 2 "
                + " ORDER BY s.nombre ASC , s.apellidoPat ASC , s.apellidoMat ASC ";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //  tx = session.beginTransaction();
            query = session.createQuery(hql);
            lsUsuarios = (List<Object[]>) query.list();
            //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/*finally{
         session.close();
         }*/

        return lsUsuarios;
    }

    @Override
    public Object[] getByNombrePersona(String nombre) {
        Object[] usuario = null;
        String hql = "SELECT u.idUsuario, "
                + " u.nombreUsuario , "
                + " u.contrasenia , "
                + " u.nombre , "
                + " u.apellidoPat, "
                + " u.apellidoMat, "
                + " u.estado, "
                + " r.idRol, "
                + " r.nombreRol, "
                + " r.descripcion, "
                + " u.usuarioId.idUsuario"
                + " FROM Usuario u "
                + " INNER JOIN u.rolId r "
                + " WHERE u.nombre = :nomUser "
                + " AND u.estado = true "
                + " ORDER BY u.nombre ASC , u.apellidoPat ASC , u.apellidoMat ASC";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //  tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("nomUser", nombre);
            usuario = (Object[]) query.uniqueResult();
            //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/*finally{
         session.close();
         }*/

        return usuario;
    }

}
