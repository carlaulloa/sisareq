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
import pe.edu.unmsm.sistemas.sisareq.dao.DSla;
import pe.edu.unmsm.sistemas.sisareq.domain.Sla;
import pe.edu.unmsm.sistemas.sisareq.service.bo.SlaBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SSLA;
import pe.edu.unmsm.sistemas.sisareq.service.transformer.SlaTransformer;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SSLAImpl  implements SSLA{
    
    @Autowired
    private DSla iSlaDAO;
    

    @Override
    public List<SlaBO> getAll() {
        return SlaTransformer.listEntityToListBO(iSlaDAO.getAll());
    }

    @Override
    public SlaBO getByServicio(Integer idServicio) {
        return SlaTransformer.entityToBO(iSlaDAO.getByIdServicio(idServicio));
    }

    @Override
    @Transactional(readOnly=false)
    public String registrar(SlaBO slaBO) {
        return iSlaDAO.insert(SlaTransformer.boToEntity(slaBO));
    }

    @Override
     @Transactional(readOnly=false)
    public String actualizar(SlaBO slaBO) {
        return iSlaDAO.update(SlaTransformer.boToEntity(slaBO));
    }

    @Override
     @Transactional(readOnly=false)
    public String eliminar(Integer idSla) {
        Sla sla = iSlaDAO.getById(idSla);
        sla.setEstado(Boolean.FALSE);
        return iSlaDAO.update(sla);
    }

    @Override
    public SlaBO getById(Integer idSla) {
        return SlaTransformer.entityToBO(iSlaDAO.getById(idSla));
    }

    @Override
    public List<SlaBO> filtrarByNombre(String nombre) {
        return SlaTransformer.listEntityToListBO(iSlaDAO.filterByName(nombre));
    }
    
}
