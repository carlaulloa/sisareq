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
public interface SConsultaTicket {

    public List<TicketBO> getByIdSolicitante(Integer idSolicitante);

    public List<TicketBO> getByIdSolicitante(Integer idSolicitante, Date fechaIni, Date fechaFin);
}
