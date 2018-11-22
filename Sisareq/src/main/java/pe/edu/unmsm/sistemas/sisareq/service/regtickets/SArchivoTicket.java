/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.regtickets;

import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ArchivoTicketBO;

/**
 *
 * @author ULLOA
 */

public interface SArchivoTicket {
    public ArchivoTicketBO getFileByIdTicket(Integer idTicket);
}
