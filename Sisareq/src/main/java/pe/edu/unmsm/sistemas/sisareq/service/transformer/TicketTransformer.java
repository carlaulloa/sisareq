/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;

import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;


/**
 *
 * @author ULLOA
 */
public class TicketTransformer {

    public static Ticket boToEntity(TicketBO ticketBO) {
        Ticket ticket = null;
        if (ticketBO != null) {
            ticket = new Ticket();
            ticket.setIdTicket(ticketBO.getId());
            ticket.setArchivo(ticketBO.getArchivo());
            ticket.setAdjunto(ticketBO.getAdjunto());
            ticket.setAsunto(ticketBO.getAsunto());
            ticket.setDescripcion(ticketBO.getDescripcion());
            ticket.setAprobacion(ticketBO.getAprobado());
            ticket.setFechaGen(ticketBO.getFecha());
            ticket.setHoraGen(ticketBO.getHora());
            
            ticket.setServicioId(ServicioTransformer.boToEntity(ticketBO.getServicio()));
            ticket.setEstadoId(EstadoTransformer.boToEntity(ticketBO.getEstado()));
            ticket.setPrioridadId(PrioridadTransformer.boToEntity(ticketBO.getPrioridad()));
            ticket.setUsuarioId(UsuarioTransformer.boToEntity(ticketBO.getUsuario()));
        }
        return ticket;
    }
}
