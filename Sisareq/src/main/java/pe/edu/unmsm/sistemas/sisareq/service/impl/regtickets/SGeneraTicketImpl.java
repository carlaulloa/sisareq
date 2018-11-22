/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.impl.regtickets;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DEstado;
import pe.edu.unmsm.sistemas.sisareq.dao.DPrioridad;
import pe.edu.unmsm.sistemas.sisareq.dao.DServicio;
import pe.edu.unmsm.sistemas.sisareq.dao.DTicket;
import pe.edu.unmsm.sistemas.sisareq.dao.DUsuario;
import pe.edu.unmsm.sistemas.sisareq.domain.Estado;
import pe.edu.unmsm.sistemas.sisareq.domain.Prioridad;
import pe.edu.unmsm.sistemas.sisareq.domain.Servicio;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import pe.edu.unmsm.sistemas.sisareq.domain.Usuario;
import pe.edu.unmsm.sistemas.sisareq.service.bo.PrioridadBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SGeneraTicket;
import pe.edu.unmsm.sistemas.sisareq.service.transformer.PrioridadTransformer;
import pe.edu.unmsm.sistemas.sisareq.service.transformer.TicketTransformer;
import pe.edu.unmsm.sistemas.sisareq.util.Tiempo;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SGeneraTicketImpl implements SGeneraTicket {

    @Autowired
    private DTicket iTicketDAO;
    @Autowired
    private DPrioridad iPrioridadDAO;
    @Autowired
    private DServicio iServicioDAO;
    @Autowired
    private DEstado iEstadoDAO;
    @Autowired
    private DUsuario iUsuarioDAO;

    @Override
    @Transactional(readOnly = false)
    public String registrar(TicketBO ticketBO) {
        return iTicketDAO.insert(TicketTransformer.boToEntity(ticketBO));
    }

    @Override
    public List<PrioridadBO> getPrioridades() {
        return PrioridadTransformer.listEntityToListBO(iPrioridadDAO.getAll());
    }

    @Override
    @Transactional(readOnly = false)
    public String registrar(String asunto,
            String descripcion,
            Integer idPrioridad,
            Integer idServicio,
            String nombreUsuario,
            String archivo,
            Integer tipoSolicitante,
            byte[] adjunto,
            String contentType
    ) {
        String salida = null;

        // caambiar codigo
        Prioridad prioridad = iPrioridadDAO.getById(idPrioridad);
        Servicio servicio = iServicioDAO.getById(idServicio);
        Estado estado = iEstadoDAO.getByNombre("Sin asignar");
        Usuario solicitante = iUsuarioDAO.buscarPorNombre(nombreUsuario);
        //esta linea debe ser cambiada 
        //Operador operador = IOperadorDAO.getById(1);       

        Ticket ticket = new Ticket();
        ticket.setAsunto(asunto);
        ticket.setDescripcion(descripcion);
        ticket.setPrioridadId(prioridad);
        ticket.setServicioId(servicio);
        ticket.setUsuarioId(solicitante);
        //    ticket.setOperador(operador);
        ticket.setEstadoId(estado);
        if (tipoSolicitante == 1) {
            if (servicio.getSiAutorizacion()) {
                ticket.setAprobacion(false);
            } else {
                ticket.setAprobacion(true);
            }
        } else {
            ticket.setAprobacion(true);
        }

        if (archivo.equals("")) {
            ticket.setArchivo(null);
            ticket.setAdjunto(adjunto);
            ticket.setContentType(null);
        } else {
            ticket.setArchivo(archivo);
            ticket.setAdjunto(adjunto);
            ticket.setContentType(contentType);
        }

        ticket.setFechaGen(Tiempo.getFecha());
        ticket.setHoraGen(Tiempo.getHora());

        salida = iTicketDAO.insert(ticket);

        return salida;
    }
}
