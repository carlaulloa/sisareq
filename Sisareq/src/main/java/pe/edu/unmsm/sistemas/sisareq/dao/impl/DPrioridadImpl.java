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
import pe.edu.unmsm.sistemas.sisareq.dao.DPrioridad;
import pe.edu.unmsm.sistemas.sisareq.domain.Prioridad;

/**
 *
 * @author ULLOA
 */
@Repository
public class DPrioridadImpl extends DGenericoImpl implements DPrioridad , Serializable {

    private Transaction tx;

    @Override
    public Prioridad getById(Integer id) {
        Prioridad prioridad = null;
        Session session = getCurrentSession();
        String hql = "FROM Prioridad p WHERE p.idPrioridad = :id";
        Query query = null;
        try {
           // tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setInteger("id", id);
            prioridad = (Prioridad) query.uniqueResult();
           // tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
            session.close();
        }*/
        return prioridad;
    }

    @Override
    public List<Prioridad> getAll() {
        List<Prioridad> lsPrioridades = null;
        String hql = "FROM Prioridad";
        Session session = getCurrentSession();
        Query query = null;
        try{
            //tx = session.beginTransaction();
            query = session.createQuery(hql);
            lsPrioridades = (List<Prioridad>) query.list();
            //tx.commit();
        }catch(HibernateException he){
            he.printStackTrace();
        }/*finally{
            session.close();
        }*/
        return lsPrioridades;
    }

}
