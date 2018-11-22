/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;


import java.util.ArrayList;
import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Rol;
import pe.edu.unmsm.sistemas.sisareq.service.bo.RolBO;

/**
 *
 * @author ULLOA
 */
public class RolTransformer {
    
    public static RolBO entityToBO(Rol rol){
        RolBO rolBO = null;
        if (rol!=null) {
            rolBO = new RolBO();
            rolBO.setId(rol.getIdRol());
            rolBO.setNombre(rol.getNombreRol());
            rolBO.setDescripcion(rol.getDescripcion());
            
        }
        return rolBO;
    }
    
    public static Rol boToEntity(RolBO rolBO){
        Rol rol = null;
        if (rolBO!=null) {
            rol = new Rol();
            rol.setIdRol(rolBO.getId());
            rol.setNombreRol(rolBO.getNombre());
            rol.setDescripcion(rolBO.getDescripcion());
            
        }
        return rol;
    }
    
    public static List<RolBO> listEntityToListBO(List<Rol> lsRoles){
        List<RolBO> lsRolesBO = new ArrayList<>();
        for(Rol rol : lsRoles){
            RolBO rolBO = RolTransformer.entityToBO(rol);
            lsRolesBO.add(rolBO);
        }
        return lsRolesBO;
    }
}
