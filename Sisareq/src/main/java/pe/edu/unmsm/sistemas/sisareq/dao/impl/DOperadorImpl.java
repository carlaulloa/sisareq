package pe.edu.unmsm.sistemas.sisareq.dao.impl;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.sistemas.sisareq.dao.DOperador;
import pe.edu.unmsm.sistemas.sisareq.domain.Operador;

@Repository("dOperador")
public class DOperadorImpl extends DGenericoImpl<Operador, Integer> implements DOperador, Serializable{

    @Override
    public Operador obtenerOperadorPorUsuario(String userName) {
        try {
            Operador operador = null;
            Session sesion = getCurrentSession();
            operador = (Operador)sesion
                    .createQuery("select oper"
                            + " from Operador oper, Usuario u"
                            + " where oper.usuarioId = u"
                            + " and u.nombreUsuario = :user")
                    .setParameter("user", userName)
                    .uniqueResult();
            return operador;
        } catch (HibernateException he) {
            throw he;
        }
    }
    
}
