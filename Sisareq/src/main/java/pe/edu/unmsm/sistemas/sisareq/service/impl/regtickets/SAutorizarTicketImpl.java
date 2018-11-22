/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.impl.regtickets;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DTicket;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import pe.edu.unmsm.sistemas.sisareq.service.bo.EstadoBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.PrioridadBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SAutorizarTicket;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SAutorizarTicketImpl implements SAutorizarTicket{

    @Autowired
    private DTicket iTicketDAO;
        
    
    @Override
    public List<TicketBO> getByPorAutorizar(Integer idSolicitanteAv) {
        List<TicketBO> lsTicketsBO = new ArrayList<>();
        List<Object[]> lsTickets = iTicketDAO.getByPorAutorizar(idSolicitanteAv);
        
        for(Object[] row  : lsTickets){
           Integer idTicket = (Integer)row[0];
           String asunto = (String) row[1];
           String archivo = (String ) row[2];
           String descripcion = (String) row[3];
           Date fecha = (Date) row[4];
           Date hora = (Date) row[5];
           Boolean aprobacion = (Boolean) row[6];
           Integer idEstado = (Integer ) row[7];
           String nombreEstado = (String) row[8];
           Integer idPrioridad = (Integer) row[9];
           String nombrePrioridad = (String) row[10];
           Integer idServicio = (Integer) row[11];
           String nombreServicio = (String) row[12];
           Integer nivel = (Integer) row[13];
           Integer idUsuarioSol = (Integer) row[14];
           String nombreSol = (String) row[15];
           String apellidoPatSol = (String) row[16];
           String apellidoMatSol = (String) row[17];
           
           
           EstadoBO estadBO = new EstadoBO();
           estadBO.setId(idEstado);
           estadBO.setEstado(nombreEstado);
           
           PrioridadBO prioridadBO = new PrioridadBO();
           prioridadBO.setId(idPrioridad);
           prioridadBO.setPrioridad(nombrePrioridad);
           
           ServicioBO servicioBO = new ServicioBO();
           servicioBO.setId(idServicio);
           servicioBO.setNombre(nombreServicio);
           servicioBO.setNivel(nivel);
           
           UsuarioBO usuarioBO = new UsuarioBO();
           usuarioBO.setId(idUsuarioSol);
           usuarioBO.setNombre(nombreSol);
           usuarioBO.setApellidoPaterno(apellidoPatSol);
           usuarioBO.setApellidoMaterno(apellidoMatSol);
           
           TicketBO ticketBO = new TicketBO();
           ticketBO.setId(idTicket);
           ticketBO.setAsunto(asunto);
           ticketBO.setArchivo(archivo);
           ticketBO.setDescripcion(descripcion);
           ticketBO.setFecha(fecha);
           ticketBO.setHora(hora);
           ticketBO.setAprobado(aprobacion);
           
           ticketBO.setPrioridad(prioridadBO);
           ticketBO.setEstado(estadBO);
           ticketBO.setServicio(servicioBO);
           ticketBO.setUsuario(usuarioBO);
           
           lsTicketsBO.add(ticketBO);
       }
        
        return lsTicketsBO;        
    }

    @Override
     @Transactional(readOnly=false)
    public String setAutorizacion(Integer idTicket) {
        Ticket ticket = iTicketDAO.getById(idTicket);
        ticket.setAprobacion(Boolean.TRUE);
        String salida = iTicketDAO.update(ticket);
        return salida;
    }

    @Override
    public List<TicketBO> getByPorAutorizarRangoFechas(Integer idSolicitanteAv, Date fechaIni, Date fechaFin) {
       List<TicketBO> lsTicketsBO = new ArrayList<>();
        List<Object[]> lsTickets = iTicketDAO.getByPorAutorizar(idSolicitanteAv,fechaIni,fechaFin);
        
        for(Object[] row  : lsTickets){
           Integer idTicket = (Integer)row[0];
           String asunto = (String) row[1];
           String archivo = (String ) row[2];
           String descripcion = (String) row[3];
           Date fecha = (Date) row[4];
           Date hora = (Date) row[5];
           Boolean aprobacion = (Boolean) row[6];
           Integer idEstado = (Integer ) row[7];
           String nombreEstado = (String) row[8];
           Integer idPrioridad = (Integer) row[9];
           String nombrePrioridad = (String) row[10];
           Integer idServicio = (Integer) row[11];
           String nombreServicio = (String) row[12];
           Integer nivel = (Integer) row[13];
           Integer idUsuarioSol = (Integer) row[14];
           String nombreSol = (String) row[15];
           String apellidoPatSol = (String) row[16];
           String apellidoMatSol = (String) row[17];
           
           
           EstadoBO estadBO = new EstadoBO();
           estadBO.setId(idEstado);
           estadBO.setEstado(nombreEstado);
           
           PrioridadBO prioridadBO = new PrioridadBO();
           prioridadBO.setId(idPrioridad);
           prioridadBO.setPrioridad(nombrePrioridad);
           
           ServicioBO servicioBO = new ServicioBO();
           servicioBO.setId(idServicio);
           servicioBO.setNombre(nombreServicio);
           servicioBO.setNivel(nivel);
           
           UsuarioBO usuarioBO = new UsuarioBO();
           usuarioBO.setId(idUsuarioSol);
           usuarioBO.setNombre(nombreSol);
           usuarioBO.setApellidoPaterno(apellidoPatSol);
           usuarioBO.setApellidoMaterno(apellidoMatSol);
           
           TicketBO ticketBO = new TicketBO();
           ticketBO.setId(idTicket);
           ticketBO.setAsunto(asunto);
           ticketBO.setArchivo(archivo);
           ticketBO.setDescripcion(descripcion);
           ticketBO.setFecha(fecha);
           ticketBO.setHora(hora);
           ticketBO.setAprobado(aprobacion);
           
           ticketBO.setPrioridad(prioridadBO);
           ticketBO.setEstado(estadBO);
           ticketBO.setServicio(servicioBO);
           ticketBO.setUsuario(usuarioBO);
           
           lsTicketsBO.add(ticketBO);
       }
        
        return lsTicketsBO;   
    }


    
}
