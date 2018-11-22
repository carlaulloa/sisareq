/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.impl.regtickets;


import com.sun.corba.se.spi.activation.ServerIdsHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DServicio;
import pe.edu.unmsm.sistemas.sisareq.domain.Servicio;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SCatalogo;
import pe.edu.unmsm.sistemas.sisareq.service.transformer.ServicioTransformer;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SCatalogoImpl implements SCatalogo {

    @Autowired
    private DServicio iServicioDAO;

    @Override
    public List<ServicioBO> getCatalogo() {
        List<Servicio> lsServiciosPrimNivel = iServicioDAO.getByNivel(1);
        List<ServicioBO> lsServiciosBO = ServicioTransformer.listEntityToListBO(lsServiciosPrimNivel);

        Integer maxNivel = iServicioDAO.getMaxNivel();
        System.out.println("max nivel " + maxNivel);
        for (int i = 0; i < lsServiciosBO.size(); i++) {
            formarCatalogo(lsServiciosBO.get(i), maxNivel);
        }

        return lsServiciosBO;
    }

    @Override
    public void formarCatalogo(ServicioBO servicioBO, Integer maxNivel) {
        if ((servicioBO.getNivel() + 1) == maxNivel) {
            List<Servicio> lsServicios = iServicioDAO.getByPadre(servicioBO.getId());
            System.out.println("lista " + lsServicios.size());

            List<ServicioBO> lsServiciosBO = ServicioTransformer.listEntityToListBO(lsServicios);
            servicioBO.setLsSubServicios(lsServiciosBO);

            HashMap<Integer, ServicioBO> mapServiciosBO = ServicioTransformer.listEntityToHashMapBO(lsServicios);
            servicioBO.setMapSubServicios(mapServiciosBO);

        } else {
            List<Servicio> lsSubServicios = iServicioDAO.getByPadre(servicioBO.getId());
            System.out.print("lista en else " + lsSubServicios.size());
            
            List<ServicioBO> lsSubServiciosBO = ServicioTransformer.listEntityToListBO(lsSubServicios);
            servicioBO.setLsSubServicios(lsSubServiciosBO);
            
            HashMap<Integer, ServicioBO> mapSubServiciosBO = ServicioTransformer.listEntityToHashMapBO(lsSubServicios);
            servicioBO.setMapSubServicios(mapSubServiciosBO);
            
            for (int i = 0; i < servicioBO.getLsSubServicios().size(); i++) {
                servicioBO.getLsSubServicios().get(i).setServicioPadre(servicioBO);
                /*
                Integer id = servicioBO.getLsSubServicios().get(i).getId();
                servicioBO.getMapSubServicios().get(id).setServicioPadre(servicioBO);
                */
                formarCatalogo(servicioBO.getLsSubServicios().get(i), maxNivel);
            }
            /*
            Set<Integer> setIdSubServicio = mapSubServiciosBO.keySet();

            for(Integer key: setIdSubServicio){
                servicioBO.getMapSubServicios().get(key).setServicioPadre(servicioBO);
                formarCatalogo(servicioBO.getMapSubServicios().get(key), maxNivel);
            }*/
            
        }
    }

    @Override
    public Integer getMaxNivel() {
        return iServicioDAO.getMaxNivel();
    }

}
