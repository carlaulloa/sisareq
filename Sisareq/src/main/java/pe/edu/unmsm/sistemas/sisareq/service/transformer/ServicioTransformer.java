/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Servicio;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;


/**
 *
 * @author ULLOA
 */
public class ServicioTransformer {
    
    public static ServicioBO entityToBO(Servicio servicio){
        ServicioBO servicioBO = null;
        if(servicio != null){
            servicioBO = new ServicioBO();
            servicioBO.setId(servicio.getIdServicio());
            servicioBO.setNivel(servicio.getNivel());
            servicioBO.setNombre(servicio.getNombre());
            servicioBO.setAutorizacion(servicio.getSiAutorizacion());
        }
        return servicioBO;
    }
    
    public static List<ServicioBO> listEntityToListBO(List<Servicio> lsServicios){
        List<ServicioBO> lsServiciosBO = new ArrayList<>();
        
        for(Servicio servicio : lsServicios){
            ServicioBO servicioBO = ServicioTransformer.entityToBO(servicio);
            lsServiciosBO.add(servicioBO);
        }
        
        return lsServiciosBO;
    }
    
     public static List<ServicioBO> listEntityToListBO(List<Servicio> lsServicios, ServicioBO servicioPadre){
        List<ServicioBO> lsServiciosBO = new ArrayList<>();
        
        for(Servicio servicio : lsServicios){
            ServicioBO servicioBO = ServicioTransformer.entityToBO(servicio);
            servicioBO.setServicioPadre(servicioPadre);
            lsServiciosBO.add(servicioBO);
        }
        
        return lsServiciosBO;
    }
    
     public static HashMap<Integer,ServicioBO> listEntityToHashMapBO(List<Servicio> lsServicios){
        HashMap<Integer,ServicioBO> mapServiciosBO = new HashMap<>();
        for(Servicio servicio : lsServicios){
            ServicioBO servicioBO = ServicioTransformer.entityToBO(servicio);
            mapServiciosBO.put(servicioBO.getId(), servicioBO);
        }
        return mapServiciosBO;
    }
    
    
    public static Servicio boToEntity(ServicioBO servicioBO){
        Servicio servicio = null;
        if(servicioBO != null){
            servicio = new Servicio();
            servicio.setIdServicio(servicioBO.getId());
            servicio.setNombre(servicioBO.getNombre());
            servicio.setNivel(servicioBO.getNivel());
            servicio.setEstado(servicioBO.getEstado());
            servicio.setSiAutorizacion(servicioBO.getAutorizacion());
            servicio.setSlaId(SlaTransformer.boToEntity(servicioBO.getSlaBO()));
            Servicio sPadre = new Servicio ();
            sPadre.setIdServicio(servicioBO.getServicioPadre().getId());
            servicio.setServicioPadre(sPadre);
        }
        return servicio;
    }
    
}
