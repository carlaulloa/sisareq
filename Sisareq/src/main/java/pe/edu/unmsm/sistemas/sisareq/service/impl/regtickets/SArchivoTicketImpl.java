/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.impl.regtickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DTicket;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ArchivoTicketBO;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SArchivoTicket;
import pe.edu.unmsm.sistemas.sisareq.service.transformer.ArchivoTicketTransformer;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SArchivoTicketImpl implements SArchivoTicket{

    @Autowired
    private DTicket iTicketDAO;
    
    @Override
    public ArchivoTicketBO getFileByIdTicket(Integer idTicket) {
        Object[] archivoInfo = iTicketDAO.getFileByIdTicket(idTicket);
        return ArchivoTicketTransformer.transformToBO(archivoInfo);
    }
    
}
