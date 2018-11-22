/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;

import pe.edu.unmsm.sistemas.sisareq.domain.Soluciones;
import pe.edu.unmsm.sistemas.sisareq.service.bo.SolucionBO;


/**
 *
 * @author ULLOA
 */
public class SolucionTransformer {
    
    public static SolucionBO entityToBO(Soluciones soluciones){
        SolucionBO solucionBO = null;
        if (soluciones != null) {
            solucionBO = new SolucionBO();
            solucionBO.setId(soluciones.getIdSoluciones());
            solucionBO.setDocumentacion(soluciones.getDocumentacion());
            solucionBO.setFechaEnvio(soluciones.getFechaEnvio());
        }
        return solucionBO;
    }
    
}
