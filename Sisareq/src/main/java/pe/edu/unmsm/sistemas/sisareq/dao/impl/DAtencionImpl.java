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
import pe.edu.unmsm.sistemas.sisareq.dao.DAtencion;
import pe.edu.unmsm.sistemas.sisareq.domain.Atencion;

/**
 *
 * @author ULLOA
 */
@Repository
public class DAtencionImpl extends DGenericoImpl<Atencion, Integer> implements DAtencion, Serializable{

    private Transaction tx;
    
    @Override
    public Object[] getByIdTicket(Integer idTicket) {
       List<Object[]> lsAtenciones = null;
        String hql = "SELECT a.idAtencion, "
                + " a.descripcion , "
                + " a.fecha , "
                + " a.hora , "
                + " a.siRespuesta "
                + " FROM Atencion a "
                + " INNER JOIN a.ticketId t "
                + " WHERE t.idTicket = :idTicket "
                + " AND a.siRespuesta = true ";
        Session session = getCurrentSession();
        Query query = null;
        try{
           // tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idTicket", idTicket);
            lsAtenciones = (List<Object[]>) query.list();
           // tx.commit();
        }catch(HibernateException he){
            he.printStackTrace();
        }/*finally{
            session.close();
        }*/
        return (lsAtenciones.isEmpty() ? null : lsAtenciones.get(0));
    }

    @Override
    public Atencion insertarAtencion(Atencion nuevaAtencion) {
        insertar(nuevaAtencion);
        return nuevaAtencion;
    }
    
}
