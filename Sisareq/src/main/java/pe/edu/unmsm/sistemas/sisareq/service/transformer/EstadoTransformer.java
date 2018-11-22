/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;

import pe.edu.unmsm.sistemas.sisareq.domain.Estado;
import pe.edu.unmsm.sistemas.sisareq.service.bo.EstadoBO;


/**
 *
 * @author ULLOA
 */
public class EstadoTransformer {
    
    public static Estado boToEntity(EstadoBO estadoBO){
        Estado estado = null;
        if (estadoBO!=null) {
            estado.setIdEstado(estadoBO.getId());
            estado.setNombreEstado(estadoBO.getEstado());
        }
        return estado;
    }
    
}
