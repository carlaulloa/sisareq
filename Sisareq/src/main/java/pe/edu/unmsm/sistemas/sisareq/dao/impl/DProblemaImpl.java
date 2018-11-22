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


import pe.edu.unmsm.sistemas.sisareq.dao.DProblema;
import pe.edu.unmsm.sistemas.sisareq.domain.Problema;
/**
 *
 * @author Alex
 */
@Repository("dProblema")
public class DProblemaImpl extends DGenericoImpl<Problema, Integer> implements DProblema, Serializable {
    private Transaction tx;
    @Override
    public List<Object[]> getAllActivos() {
        List<Object[]> lsProblemas = null;
        String hql = "SELECT u.idProblema, u.asunto, u.enviado , u.fechaenvio , u.estado  FROM Problema u ";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //   tx = session.beginTransaction();
            query = session.createQuery(hql);
            lsProblemas = (List<Object[]>) query.list();
            //   tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/*finally{
         session.close();
         }*/
        return lsProblemas;
    }

    @Override
    public void insertarProblema(Problema problema) {
        insertar(problema);
    }
}
