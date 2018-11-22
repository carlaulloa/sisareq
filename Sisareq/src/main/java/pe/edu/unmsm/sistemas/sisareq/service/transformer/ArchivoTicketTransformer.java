/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;

import pe.edu.unmsm.sistemas.sisareq.service.bo.ArchivoTicketBO;

/**
 *
 * @author ULLOA
 */
public class ArchivoTicketTransformer {
    
    public static ArchivoTicketBO transformToBO(Object[] row){
        ArchivoTicketBO archivoTicketBO = new ArchivoTicketBO();
        Integer idTicket =(Integer) row[0];
        String nombre = (String) row[1];
        byte[] archivo = (byte[]) row[2];
        String contentType = (String) row[3];
        
        archivoTicketBO.setIdTicket(idTicket);
        archivoTicketBO.setNombre(nombre);
        archivoTicketBO.setTipo(contentType);
        archivoTicketBO.setAdjunto(archivo);
        return archivoTicketBO;
    }
    
}
