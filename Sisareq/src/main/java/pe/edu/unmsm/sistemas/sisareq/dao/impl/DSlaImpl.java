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
import pe.edu.unmsm.sistemas.sisareq.dao.DSla;
import pe.edu.unmsm.sistemas.sisareq.domain.Sla;

/**
 *
 * @author ULLOA
 */
@Repository
public class DSlaImpl extends DGenericoImpl implements DSla , Serializable {

    private Transaction tx;
    
    @Override
    public List<Sla> getAll() {
        List<Sla> lsSlas = null;
        String hql = "FROM Sla s WHERE s.estado = true "
                + " ORDER BY s.nombreSla ASC ";
        Session session = getCurrentSession();
        Query query = null;
        try {
        //    tx = session.beginTransaction();
            query = session.createQuery(hql);
            lsSlas = (List<Sla>) query.list();
         //   tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
            session.close();
        }*/
        return lsSlas;
    }

    @Override
    public Sla getByIdServicio(Integer idServicio) {
        Sla sla = null;
        
        String hql = "SELECT sla.idSla , sla.nombreSla "
                + "   FROM Servicio s"
                + "   INNER JOIN s.slaId sla "
                + "   WHERE s.id = :idServicio "
                + "   ORDER BY sla.nombreSla ASC ";
        
        Session session = getCurrentSession();
        Query query = null;
        try{
           // tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idServicio", idServicio);
            List<Object[]> lsSlas =  (List<Object[]>) query.list();
            if (!lsSlas.isEmpty()) {
                Object[] fila = lsSlas.get(0);
                sla = new Sla();
                sla.setIdSla((Integer) fila[0]);
                sla.setNombreSla((String) fila[1]);
            }
          //  tx.commit();
        }catch(HibernateException he){
            he.printStackTrace();
        }/*finally{
            session.close();
        }*/
        
        return sla;
    }

    @Override
    public String insert(Sla sla) {
       String salida = null;
        Session session = getCurrentSession();
        try {
         //   tx = session.beginTransaction();
            salida = String.valueOf(session.save(sla));
            session.flush();
            session.evict(sla);
         //   tx.commit();
        } catch (ConstraintViolationException ce){
            salida = "duplicado";
            ce.printStackTrace();
        } 
        catch (HibernateException he) {
            salida = "error";
            he.printStackTrace();
        }/* finally {
            session.close();
        }*/

        return salida;
    }

    @Override
    public String update(Sla sla) {
       String salida = null;
        Session session = getCurrentSession();
        try {
        //    tx = session.beginTransaction();
            session.update(sla);
            session.flush();
            session.evict(sla);
        //    tx.commit();
            salida = "ok";
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
            session.close();
        }*/

        return salida;
    }

    @Override
    public Sla getById(Integer id) {
        Sla sla = null;
        Session session = getCurrentSession();
        String hql = "FROM Sla s WHERE s.idSla = :id";
        Query query = null;
        try {
          //  tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setInteger("id", id);
            sla = (Sla) query.uniqueResult();
           // tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
            session.close();
        }*/
        return sla;
    }

    @Override
    public List<Sla> filterByName(String nombre) {
         List<Sla> lsSlas = null;
        String hql = " FROM Sla s "
                + " WHERE s.nombreSla LIKE CONCAT('%', :filtro , '%') " 
               + " AND s.estado = true";
        Session session = getCurrentSession();
        Query query = null;
        try {
        //    tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("filtro", nombre);
            lsSlas = (List<Sla>) query.list();
         //   tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
            session.close();
        }*/

        return lsSlas;
    }
    
}
