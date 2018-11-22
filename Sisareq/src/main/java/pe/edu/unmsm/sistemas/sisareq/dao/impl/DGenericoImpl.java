package pe.edu.unmsm.sistemas.sisareq.dao.impl;

import pe.edu.unmsm.sistemas.sisareq.dao.DGenerico;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dGenerico")
public class DGenericoImpl<Entidad, Id> implements DGenerico<Entidad, Id>{
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Entidad> listarTodos(Class<Entidad> clase) {
        try {
            getCurrentSession().flush();
            List<Entidad> lista = getCurrentSession().createCriteria(clase).list();
            return lista;
        } catch (HibernateException he) {
            System.err.println("Error");
            throw he;
        }
    }

    @Override
    public void insertar(Entidad entidad) {
        try {
            getCurrentSession().save(entidad);
            getCurrentSession().flush();
            getCurrentSession().evict(entidad);
            
        } catch (HibernateException he) {
            System.err.println("Error");
            throw he;
        }
    }

    @Override
    public Entidad buscarPorId(Class<Entidad> clase, Serializable id) {
        try {
            return (Entidad) getCurrentSession().createCriteria(clase).add(Restrictions.idEq(id)).uniqueResult();
        } catch (HibernateException he) {
            System.err.println("Error");
            throw he;
        }
    }

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    
}
