/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao.impl;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.sistemas.sisareq.dao.DEstado;
import pe.edu.unmsm.sistemas.sisareq.domain.Estado;

/**
 *
 * @author ULLOA
*/
@Repository
public class DEstadoImpl extends DGenericoImpl implements DEstado , Serializable{

    private Transaction tx;
    
    @Override
    public Estado getByNombre(String nombre) {
        Estado estado = null;
        String hql = "FROM Estado e WHERE e.nombreEstado = :nombre";        
        Session session = getCurrentSession();
        Query query = null;
        try{
         //   tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setString("nombre", nombre);
            estado = (Estado) query.uniqueResult();
          //  tx.commit();
        }catch(HibernateException he){
            he.printStackTrace();
        }/*finally{
            session.close();
        }*/
        return estado;
    }
    
}
