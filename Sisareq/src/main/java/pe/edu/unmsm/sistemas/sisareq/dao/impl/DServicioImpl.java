/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.edu.unmsm.sistemas.sisareq.dao.DServicio;
import pe.edu.unmsm.sistemas.sisareq.domain.Servicio;

/**
 *
 * @author ULLOA
 */
@Repository
public class DServicioImpl extends DGenericoImpl implements DServicio, Serializable {

    private Transaction tx;
    /*
     @Override
     public List<Servicio> getByIdCategoria(Integer idCategoria) {
     List<Servicio> lsServicios = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
     String hql = "FROM Servicio s WHERE s.categoria.id = :idCategoria ";
     Query query = null;
     try {
     tx = session.beginTransaction();
     query = session.createQuery(hql);
     query.setInteger("idCategoria", idCategoria);
     lsServicios = (List<Servicio>) query.list();
     tx.commit();
     } catch (HibernateException he) {
     he.printStackTrace();
     } finally {
     session.close();
     }
     return lsServicios;
     }
     */

    @Override
    public Servicio getById(Integer id) {
        Servicio servicio = null;
        Session session = getCurrentSession();
        String hql = "FROM Servicio s WHERE s.idServicio = :idServicio ";
        Query query = null;
        try {
            //    tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setInteger("idServicio", id);
            servicio = (Servicio) query.uniqueResult();
            //  tx.commit();
            session.evict(servicio);
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
         session.close();
         }*/

        return servicio;
    }

    @Override
    public List<Servicio> getByNivel(Integer nivel) {
        List<Servicio> lsServicios = null;
        String hql = "FROM Servicio s WHERE s.nivel = :nivel "
                + "  AND s.estado = true";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //   tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setInteger("nivel", nivel);
            lsServicios = (List<Servicio>) query.list();
            //  tx.commit();
        } catch (HibernateException he) {
            System.out.println("Excepcion en ServicioDAO");
            he.printStackTrace();
        }/* finally {
         session.close();
         }*/

        return lsServicios;
    }

    @Override
    public List<Servicio> getByPadre(Integer idServicio) {
        List<Servicio> lsServicios = null;
        String hql = "FROM Servicio s WHERE s.servicioPadre.idServicio = :idPadre "
                + " AND s.estado = true";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //  tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setInteger("idPadre", idServicio);
            lsServicios = (List<Servicio>) query.list();
            // tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
         session.close();
         }*/

        return lsServicios;
    }

    @Override
    public Integer getMaxNivel() {
        Integer max = null;
        Session session = getCurrentSession();
        try {
            // tx = session.beginTransaction();
            Criteria criteria = session
                    .createCriteria(Servicio.class)
                    .setProjection(Projections.max("nivel"));
            max = (Integer) criteria.uniqueResult();
            // tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
         session.close();
         }*/

        return max;
    }

    @Override
    public Servicio getPadre(Integer idHijo) {
        Servicio servicio = null;
        Session session = getCurrentSession();
        String hql = " SELECT sPadre.idServicio , sPadre.nivel ,  sPadre.nombre , sPadre.siAutorizacion  "
                + "  FROM Servicio s  "
                + "  INNER JOIN s.servicioPadre sPadre "
                + " WHERE s.idServicio = :idServicio "
                + " AND s.estado = true ";
        Query query = null;
        try {
            // tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setInteger("idServicio", idHijo);
            List<Object[]> lsServicios = (List<Object[]>) query.list();
            if (!lsServicios.isEmpty()) {
                servicio = new Servicio();
                Object[] fila = lsServicios.get(0);
                servicio.setIdServicio((Integer) fila[0]);
                servicio.setNivel((Integer) fila[1]);
                servicio.setNombre((String) fila[2]);
                servicio.setSiAutorizacion((Boolean) fila[3]);
            }
            // tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
         session.close();
         }*/

        return servicio;
    }

    @Override
    public String insert(Servicio servicio) {
        String salida = null;
        Session session = getCurrentSession();
        try {
            //  tx = session.beginTransaction();
            salida = String.valueOf(session.save(servicio));
            session.flush();
            session.evict(servicio);
            // tx.commit();
        } catch (HibernateException he) {
            salida = "error";
            he.printStackTrace();
        }/* finally {
         session.close();
         }*/

        return salida;
    }

    @Override
    public String update(Servicio servicio) {
        String salida = null;
        Session session = getCurrentSession();
        try {
            //  tx = session.beginTransaction();
            session.update(servicio);
            salida = "ok";
            session.flush();
            session.evict(servicio);
          //  tx.commit();

        } catch (HibernateException he) {
            he.printStackTrace();
        }/* finally {
         session.close();
         }*/

        return salida;
    }

    @Override
    public List<Servicio> filterByName(String filterName) {
        List<Servicio> lsServicios = null;
        String hql = " FROM Servicio s "
                + " WHERE s.nombre LIKE CONCAT('%', :filtro , '%') "
                + " AND s.estado = true";
        Session session = getCurrentSession();
        Query query = null;
        try {
            //    tx = session.beginTransaction();
            query = session.createQuery(hql);
            query.setParameter("filtro", filterName);
            lsServicios = (List<Servicio>) query.list();
            //  tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
         session.close();
         }*/

        return lsServicios;
    }

    @Override
    public Integer getNumSubservicios(Integer idServicio) {
        Integer count = null;
        Session session = getCurrentSession();
        try {
            //   tx = session.beginTransaction();
            Criteria criteria = session
                    .createCriteria(Servicio.class, "s")
                    .createAlias("s.servicioPadre", "sPadre")
                    .setProjection(Projections.rowCount())
                    .add(Restrictions.eq("sPadre.id", idServicio))
                    .add(Restrictions.eq("s.estado", Boolean.TRUE));

            count = (int) (long) criteria.uniqueResult();
            // tx.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } /*finally {
         session.close();
         }*/

        System.out.println(count);
        return count;
    }

}
