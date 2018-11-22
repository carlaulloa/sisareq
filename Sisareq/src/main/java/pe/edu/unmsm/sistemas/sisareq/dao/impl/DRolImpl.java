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
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.sistemas.sisareq.dao.DRol;
import pe.edu.unmsm.sistemas.sisareq.domain.Rol;

/**
 *
 * @author ULLOA
 */
@Repository
public class DRolImpl extends DGenericoImpl implements DRol , Serializable {

    private Transaction tx;

    @Override
    public List<Rol> getAll() {
        List<Rol> lsRoles = null;
        String hql = "FROM Rol r"
                + " ORDER BY r.descripcion ASC";
        Session session = getCurrentSession();
        Query query = null;
        try {
        //    tx = session.beginTransaction();
            query = session.createQuery(hql);
            lsRoles = (List<Rol>) query.list();
          //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
            session.close();
        }*/
        return lsRoles;
    }

    @Override
    public Rol getByIdUser(Integer idUser) {
        Rol rol = null;
        String hql = "SELECT r.idRol, r.nombreRol, r.descripcion"
                + " FROM Usuario u "
                + " INNER JOIN u.rolId r "
                + " WHERE u.idUsuario = :idUser";
        Session session = getCurrentSession();
        Query query = null;
        try {
        //    tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idUser", idUser);
            List<Object[]> lsRoles = (List<Object[]>) query.list();
            if (!lsRoles.isEmpty()) {
                Object[] fila = lsRoles.get(0);
                Integer id = (Integer) fila[0];
                String nombre = (String) fila[1];
                String descripcion = (String) fila[2];
                rol = new Rol();
                rol.setIdRol(id);
                rol.setNombreRol(nombre);
                rol.setDescripcion(descripcion);
            }

          //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
            session.close();
        }*/
        return rol;
    }

}
