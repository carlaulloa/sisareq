/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;

import pe.edu.unmsm.sistemas.sisareq.domain.Atencion;
import pe.edu.unmsm.sistemas.sisareq.service.bo.AtencionBO;



/**
 *
 * @author ULLOA
 */
public class AtencionTransformer {
    
    public static AtencionBO entityToBO(Atencion atencion){
        AtencionBO atencionBO = null;
        if (atencion!=null) {
            atencionBO = new AtencionBO();
            atencionBO.setId(atencion.getIdAtencion());
            atencionBO.setDescripcion(atencion.getDescripcion());
            atencionBO.setFecha(atencion.getFecha());
            atencionBO.setHora(atencion.getHora());
            
        }
        return atencionBO;
    }
    
}
