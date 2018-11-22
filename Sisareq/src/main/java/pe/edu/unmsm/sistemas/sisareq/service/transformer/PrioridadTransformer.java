/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Prioridad;
import pe.edu.unmsm.sistemas.sisareq.service.bo.PrioridadBO;

/**
 *
 * @author ULLOA
 */
public class PrioridadTransformer {
    
    public static Prioridad boToEntity(PrioridadBO prioridadBO){
        Prioridad prioridad = null;
        if (prioridadBO!=null) {
            prioridad = new Prioridad();
            prioridad.setIdPrioridad(prioridadBO.getId());
            prioridad.setNombrePrioridad(prioridadBO.getPrioridad());
        }
        return prioridad;
    }
    
    public static PrioridadBO entityToBO(Prioridad prioridad){
        PrioridadBO prioridadBO = null;
        if (prioridad!=null) {
            prioridadBO = new PrioridadBO();
            prioridadBO.setId(prioridad.getIdPrioridad());
            prioridadBO.setPrioridad(prioridad.getNombrePrioridad());
        }
        return prioridadBO;
    }
    
    public static List<PrioridadBO> listEntityToListBO(List<Prioridad> lsPrioridades){
        List<PrioridadBO> lsPrioridadesBO = new ArrayList<>();
        
        for(Prioridad p : lsPrioridades){
            PrioridadBO prioridadBO = PrioridadTransformer.entityToBO(p);
            lsPrioridadesBO.add(prioridadBO);
        }
        return lsPrioridadesBO;
    }
}
