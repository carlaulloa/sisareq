package pe.edu.unmsm.sistemas.sisareq.dao.impl;

import pe.edu.unmsm.sistemas.sisareq.dao.DTicket;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("dTicket")
public class DTicketImpl extends DGenericoImpl<Ticket, Integer> implements Serializable, DTicket{
    
    @Override
    public List<Ticket> listarTickets() {
        try {
            List<Ticket> lista = null;
            Session sesion = getCurrentSession();
            lista = sesion
                    .createQuery("from Ticket")
                    .list();
            return lista;
        } catch (HibernateException he) {
            throw he;
        }
    }
//
//    @Override
//    public void insertarTicket(Ticket ticket) {
//        try {
//            insertar(ticket);
//        } catch (HibernateException he) {
//            throw he;
//        }
//    }
//
    @Override
    public Ticket buscar(int id) {
        try {
            Ticket ticket = null;
            Session sesion = getCurrentSession();
            ticket = (Ticket)sesion
                    .createQuery("from Ticket t"
                            + " where t.idTicket = :id")
                    .setParameter("id", id)
                    .uniqueResult();
            return ticket;
        } catch (HibernateException he) {
            throw he;
        }
    }

    @Override
    public void actualizarEstadoTicket(int idTicket, int nuevoEstado) {
        try {
            Session sesion = getCurrentSession();
            sesion
                    .createSQLQuery("update ticket"
                            + " set estado_id = :estado"
                            + " where ticket.id_ticket = :id")
                    .setParameter("id", idTicket)
                    .setParameter("estado", nuevoEstado)
                    .executeUpdate();
        } catch (HibernateException he) {
            throw he;
        }
    }
//
//    @Override
//    public void actualizarTicketAProblema(int idTicket) {
//        try {
//            Session sesion = getCurrentSession();
//            sesion
//                    .createSQLQuery("update ticket"
//                            + " set esProblema = :estadoProblema"
//                            + " where ticket.id_ticket = :id")
//                    .setParameter("id", idTicket)
//                    .setParameter("estadoProblema", 1)
//                    .executeUpdate();
//        } catch (HibernateException he) {
//            throw he;
//        }
//    }
    
    
    
    // MODULO REGISTRO DE TICKETS
    
@Override
    public String insert(Ticket ticket) {
        String salida = null;
        Session session = getCurrentSession();
        try {
          //  tx = session.beginTransaction();
            salida = String.valueOf(session.save(ticket));
            session.flush();
            session.evict(ticket);
          //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
            session.close();
        }*/

        return salida;
    }

    @Override
    public Ticket getById(Integer id) {
        Ticket ticket = null;
        Session session = getCurrentSession();
        String hql = "FROM Ticket t WHERE t.idTicket = :id";
        Query query = null;

        try {
           // tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setInteger("id", id);
            ticket = (Ticket) query.uniqueResult();
           // tx.commit();
        } catch (HibernateException he) {
            System.out.println("Excepcion en TicketDAO");
            he.printStackTrace();
        } /*finally {
            session.close();
        }*/

        return ticket;
    }

    @Override
    public String update(Ticket ticket) {
        String salida = null;
        Session session = getCurrentSession();
        try {
           // tx = session.beginTransaction();
            session.update(ticket);
            salida = "ok";
            session.flush();
            
            session.evict(ticket);
           // tx.commit();
            
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
            session.close();
        }*/

        return salida;
    }

    /*
     este metodo devuelve los tickets + prioridad + estado + servicio 
     id ticket,  asunto, archivo, descripcion, fecha , hora , aprobacion
     estado id, nombre
     prioridad id, nombre
     servicio id , nombre , nivel
     */
    @Override
    public List<Object[]> getByIdSolicitante(Integer idSolicitante) {
        List<Object[]> lsTickets = null;
        String hql = "SELECT t.idTicket,"
                + "t.asunto,"
                + "t.archivo,"
                + "t.descripcion,"
                + "t.fechaGen,"
                + "t.horaGen,"
                + "t.aprobacion,"
                + "e.idEstado,"
                + "e.nombreEstado,"
                + "p.idPrioridad,"
                + "p.nombrePrioridad,"
                + "s.idServicio,"
                + "s.nombre,"
                + "s.nivel "
                + "FROM Ticket t "
                + "INNER JOIN  t.estadoId e "
                + "INNER JOIN  t.prioridadId p "
                + "INNER JOIN  t.servicioId s "
                + "WHERE t.usuarioId.idUsuario = :idSolicitante "
                + "ORDER BY t.fechaGen DESC , t.horaGen DESC";
        Session session = getCurrentSession();
        Query query = null;
        try {
           // tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idSolicitante", idSolicitante);
            lsTickets = (List<Object[]>) query.list();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
            session.close();
        }*/
        return lsTickets;
    }

    /*
    
     SELECT t.* , e.* , p.* , s.* , sol.*
     FROM ticket t, estado e, prioridad p , servicio s , usuario sol
     WHERE t.usuario_id  IN (SELECT u.id_usuario 
     FROM usuario u
     WHERE u.usuario_id = 1)
     AND t.estado_id = e.id_estado  
     AND t.prioridad_id = p.id_prioridad 
     AND t.servicio_id = s.id_servicio 
     AND t.usuario_id = sol.id_usuario 
     AND s.si_autorizacion = 1
     ORDER BY t.fecha_gen desc, hora_gen desc;
    
     */
    @Override
    public List<Object[]> getByPorAutorizar(Integer idSolicitanteAv) {
        List<Object[]> lsTickets = null;
        String hql = "SELECT t.idTicket,"
                + "t.asunto,"
                + "t.archivo,"
                + "t.descripcion,"
                + "t.fechaGen,"
                + "t.horaGen,"
                + "t.aprobacion,"
                + "e.idEstado,"
                + "e.nombreEstado,"
                + "p.idPrioridad,"
                + "p.nombrePrioridad,"
                + "s.idServicio,"
                + "s.nombre,"
                + "s.nivel ,"
                + "sol.idUsuario, "
                + "sol.nombre , "
                + "sol.apellidoPat, "
                + "sol.apellidoMat "
                + "FROM Ticket t "
                + "INNER JOIN  t.estadoId e "
                + "INNER JOIN  t.prioridadId p "
                + "INNER JOIN  t.servicioId s "
                + "INNER JOIN  t.usuarioId sol "
                + "WHERE t.usuarioId.idUsuario  "
                + "     IN (SELECT u.idUsuario "
                + "         FROM Usuario u "
                + "         WHERE u.usuarioId.idUsuario = :idSolicitanteAv) "
                + "AND s.siAutorizacion = 1 AND t.aprobacion = false "
                + "ORDER BY t.fechaGen DESC , t.horaGen DESC";

        Session session =getCurrentSession();
        Query query = null;
        try {
          //  tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idSolicitanteAv", idSolicitanteAv);
            lsTickets = (List<Object[]>) query.list();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
            session.close();
        }*/
        return lsTickets;
    }

    @Override
    public List<Object[]> getByPorAutorizar(Integer idSolicitanteAv, Date fechaIni, Date fechaFin) {
        List<Object[]> lsTickets = null;
        String hql = "SELECT t.idTicket,"
                + "t.asunto,"
                + "t.archivo,"
                + "t.descripcion,"
                + "t.fechaGen,"
                + "t.horaGen,"
                + "t.aprobacion,"
                + "e.idEstado,"
                + "e.nombreEstado,"
                + "p.idPrioridad,"
                + "p.nombrePrioridad,"
                + "s.idServicio,"
                + "s.nombre,"
                + "s.nivel ,"
                + "sol.idUsuario, "
                + "sol.nombre , "
                + "sol.apellidoPat, "
                + "sol.apellidoMat "
                + "FROM Ticket t "
                + "INNER JOIN  t.estadoId e "
                + "INNER JOIN  t.prioridadId p "
                + "INNER JOIN  t.servicioId s "
                + "INNER JOIN  t.usuarioId sol "
                + "WHERE t.usuarioId.idUsuario  "
                + "     IN (SELECT u.idUsuario "
                + "         FROM Usuario u "
                + "         WHERE u.usuarioId.idUsuario = :idSolicitanteAv) "
                + "AND s.siAutorizacion = 1  AND t.aprobacion = false "
                + "AND t.fechaGen BETWEEN :fechaIni AND :fechaFin "
                + "ORDER BY t.fechaGen DESC , t.horaGen DESC";

        Session session = getCurrentSession();
        Query query = null;
        try {
          //  tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idSolicitanteAv", idSolicitanteAv);
            query.setParameter("fechaIni", fechaIni);
            query.setParameter("fechaFin", fechaFin);
            lsTickets = (List<Object[]>) query.list();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
            session.close();
        }*/
        return lsTickets;
    }

    @Override
    public Object[] getFileByIdTicket(Integer idTicket) {
        Object[] row = null;
        String hql = "SELECT t.idTicket,"
                + "t.archivo,"
                + "t.adjunto, "
                + "t.contentType "
                + "FROM Ticket t "
                + "WHERE t.idTicket = :id ";
        Session session = getCurrentSession();
        Query query = null;
        try {
           // tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("id", idTicket);
            row = (Object[]) query.uniqueResult();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
            session.close();
        }*/
        return row;
    }

    @Override
    public List<Object[]> getByIdSolicitante(Integer idSolicitante, Date fechaIni, Date fechaFin) {
        List<Object[]> lsTickets = null;
        String hql = "SELECT t.idTicket,"
                + "t.asunto,"
                + "t.archivo,"
                + "t.descripcion,"
                + "t.fechaGen,"
                + "t.horaGen,"
                + "t.aprobacion,"
                + "e.idEstado,"
                + "e.nombreEstado,"
                + "p.idPrioridad,"
                + "p.nombrePrioridad,"
                + "s.idServicio,"
                + "s.nombre,"
                + "s.nivel "
                + "FROM Ticket t "
                + "INNER JOIN  t.estadoId e "
                + "INNER JOIN  t.prioridadId p "
                + "INNER JOIN  t.servicioId s "
                + "WHERE t.usuarioId.idUsuario = :idSolicitante "
                + "AND t.fechaGen BETWEEN :fechaIni AND :fechaFin "
                + "ORDER BY t.fechaGen DESC , t.horaGen DESC";
        Session session = getCurrentSession();
        Query query = null;
        try {
           // tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("idSolicitante", idSolicitante);
            query.setParameter("fechaIni", fechaIni);
            query.setParameter("fechaFin", fechaFin);
            lsTickets = (List<Object[]>) query.list();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
            session.close();
        }*/
        return lsTickets;   }





}
