/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.impl.configuracion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DServicio;
import pe.edu.unmsm.sistemas.sisareq.domain.Servicio;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.SlaBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SSLA;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SServicio;
import pe.edu.unmsm.sistemas.sisareq.service.transformer.ServicioTransformer;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SServicioImpl implements SServicio {

    @Autowired
    private DServicio iServicioDAO;
    @Autowired
    private SSLA iSLAService;

    @Override
     @Transactional(readOnly=false)
    public String registrar(ServicioBO servicioBO) {
        servicioBO.setEstado(Boolean.TRUE);
        return iServicioDAO.insert(ServicioTransformer.boToEntity(servicioBO));
    }

    @Override
     @Transactional(readOnly=false)
    public String actualizar(ServicioBO servicioBO) {
        String salida = null;
        ServicioBO servicioBOAntiguo = getById(servicioBO.getId());
        SlaBO slaBO = iSLAService.getByServicio(servicioBOAntiguo.getId());
        servicioBOAntiguo.setSlaBO(slaBO);
        servicioBOAntiguo.setServicioPadre(ServicioTransformer.entityToBO(iServicioDAO.getPadre(servicioBO.getId())));

        ServicioBO servicioBOPadre = ServicioTransformer.entityToBO(iServicioDAO.getPadre(servicioBO.getId()));
        servicioBO.setServicioPadre(servicioBOPadre);

        boolean nombreIgual = servicioBOAntiguo.getNombre().toUpperCase().equals(servicioBO.getNombre().toUpperCase());
        boolean autorizacionIgual = servicioBOAntiguo.getAutorizacion().equals(servicioBO.getAutorizacion());
        boolean slaIgual = slaBO.getId().equals(servicioBO.getSlaBO().getId());

        if (!nombreIgual || !autorizacionIgual || !slaIgual) {
            if (!slaIgual || !autorizacionIgual) {
                // deshabilitamos el servicio antiguo
                servicioBOAntiguo.setEstado(Boolean.FALSE);
                salida = iServicioDAO.update(ServicioTransformer.boToEntity(servicioBOAntiguo));
                if (salida.equals("ok")) {
                    servicioBO.setId(null);
                    servicioBO.setEstado(Boolean.TRUE);
                    
                    SlaBO sla = iSLAService.getById(servicioBO.getSlaBO().getId());
                    servicioBO.setSlaBO(sla);
                    salida = iServicioDAO.insert(ServicioTransformer.boToEntity(servicioBO));
                }else{
                    salida = "error";
                }
            } else {
                servicioBO.setSlaBO(slaBO);
                salida = iServicioDAO.update(ServicioTransformer.boToEntity(servicioBO));
            }
        }

        return salida;
    }

    @Override
     @Transactional(readOnly=false)
    public String eliminar(Integer idServicio) {
        Servicio servicio = iServicioDAO.getById(idServicio);
        servicio.setEstado(Boolean.FALSE);
        return iServicioDAO.update(servicio);
    }

    @Override
    public List<ServicioBO> getByPadre(Integer idPadre) {
        ServicioBO servicioBOPadre = ServicioTransformer.entityToBO(iServicioDAO.getById(idPadre));
        ServicioBO servicioBOAbuelo = null;
        if (servicioBOPadre.getNivel() == 2) {
            servicioBOAbuelo = ServicioTransformer.entityToBO(iServicioDAO.getPadre(idPadre));
            servicioBOPadre.setServicioPadre(servicioBOAbuelo);
        }
        // pasamos no solo la lista de servicio si no sus antecesores para asi poderlos mostrar 
        // en las vistas correspondientes
        List<ServicioBO> lsServiciosBO = ServicioTransformer.listEntityToListBO(iServicioDAO.getByPadre(idPadre), servicioBOPadre);

        for (ServicioBO servicioBO : lsServiciosBO) {
            Integer numSubservicios = iServicioDAO.getNumSubservicios(servicioBO.getId());
            SlaBO slaBO = iSLAService.getByServicio(servicioBO.getId());
            servicioBO.setNumSubServicios(numSubservicios);
            servicioBO.setSlaBO(slaBO);
        }

        return lsServiciosBO;
    }

    @Override
    public List<ServicioBO> getByNivelUno() {
        return ServicioTransformer.listEntityToListBO(iServicioDAO.getByNivel(1));
    }

    @Override
    public List<ServicioBO> filterByName(String filtro) {
        List<ServicioBO> lsServiciosBO = null;

        lsServiciosBO = ServicioTransformer.listEntityToListBO(iServicioDAO.filterByName(filtro));

        for (ServicioBO servicioBO : lsServiciosBO) {
            if (servicioBO.getNivel() == 1) {
                Integer numSub = iServicioDAO.getNumSubservicios(servicioBO.getId());
                servicioBO.setNumSubServicios(numSub);
            } else {
                if (servicioBO.getNivel() == 2) {
                    Integer numSub = iServicioDAO.getNumSubservicios(servicioBO.getId());
                    ServicioBO servicioBOPadre = ServicioTransformer.entityToBO(iServicioDAO.getById(servicioBO.getId()));
                    servicioBO.setServicioPadre(servicioBOPadre);
                    servicioBO.setNumSubServicios(numSub);
                } else {
                    if (servicioBO.getNivel() == 3) {
                        ServicioBO servicioBOPadre = ServicioTransformer.entityToBO(iServicioDAO.getPadre(servicioBO.getId()));
                        servicioBO.setServicioPadre(servicioBOPadre);
                        ServicioBO servicioBOAbuelo = ServicioTransformer.entityToBO(iServicioDAO.getPadre(servicioBOPadre.getId()));
                        servicioBOPadre.setServicioPadre(servicioBOAbuelo);
                    }
                }
            }
            SlaBO slaBO = iSLAService.getByServicio(servicioBO.getId());
            servicioBO.setSlaBO(slaBO);
        }

        return lsServiciosBO;
    }

    @Override
    public ServicioBO getById(Integer idServicio) {
        return ServicioTransformer.entityToBO(iServicioDAO.getById(idServicio));
    }

    
    
}
