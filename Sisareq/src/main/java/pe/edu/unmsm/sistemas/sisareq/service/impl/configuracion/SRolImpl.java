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
import pe.edu.unmsm.sistemas.sisareq.dao.DRol;
import pe.edu.unmsm.sistemas.sisareq.service.bo.RolBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SRol;
import pe.edu.unmsm.sistemas.sisareq.service.transformer.RolTransformer;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SRolImpl implements SRol{

    @Autowired
    private DRol iRolDAO;
    
    @Override
    public List<RolBO> getAll() {
        return RolTransformer.listEntityToListBO(iRolDAO.getAll());
    }
    
}
