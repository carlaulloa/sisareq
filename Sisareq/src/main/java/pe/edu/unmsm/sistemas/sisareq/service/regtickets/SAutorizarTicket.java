/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.regtickets;


import java.util.Date;
import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;

/**
 *
 * @author ULLOA
 */
public interface SAutorizarTicket {
    public List<TicketBO> getByPorAutorizar(Integer idSolicitanteAv);
    public String setAutorizacion(Integer idTicket);
    public List<TicketBO> getByPorAutorizarRangoFechas(Integer idSolicitanteAv,Date fechaIni, Date fechaFin);
}
