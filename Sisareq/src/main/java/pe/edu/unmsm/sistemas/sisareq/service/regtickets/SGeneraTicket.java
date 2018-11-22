/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.regtickets;


import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.service.bo.PrioridadBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;

/**
 *
 * @author ULLOA
 */
public interface SGeneraTicket {
    public String registrar(TicketBO ticket);
    public String registrar(String asunto, String descripcion, Integer idPrioridad, Integer idServicio,String nombreUsuario,String archivo,Integer tipoSolicitante, byte[] adjunto,String contentType);
    public List<PrioridadBO> getPrioridades();
}
