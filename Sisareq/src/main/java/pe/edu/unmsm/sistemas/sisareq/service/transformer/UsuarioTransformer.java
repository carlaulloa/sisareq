/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;

import pe.edu.unmsm.sistemas.sisareq.domain.Usuario;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;


/**
 *
 * @author ULLOA
 */
public class UsuarioTransformer {

    public static UsuarioBO entityToBO(Usuario usuario) {
        UsuarioBO usuarioBO = null;
        if (usuario != null) {
            usuarioBO = new UsuarioBO();
            usuarioBO.setId(usuario.getIdUsuario());
         //   usuarioBO.setClave(usuario.getContrasenia());
            usuarioBO.setNomUsuario(usuario.getNombreUsuario());
            usuarioBO.setNombre(usuario.getNombre());
            usuarioBO.setApellidoPaterno(usuario.getApellidoPat());
            usuarioBO.setApellidoMaterno(usuario.getApellidoMat());
            usuarioBO.setEstado(usuario.getEstado());
        }
        return usuarioBO;
    }

    public static Usuario boToEntity(UsuarioBO usuarioBO) {
        Usuario usuario = null;
        if (usuarioBO != null) {
            usuario = new Usuario();
            usuario.setIdUsuario(usuarioBO.getId());
            usuario.setContrasenia(usuarioBO.getClave());
            usuario.setNombreUsuario(usuarioBO.getNomUsuario());
            usuario.setNombre(usuarioBO.getNombre());
            usuario.setApellidoPat(usuarioBO.getApellidoPaterno());
            usuario.setApellidoMat(usuarioBO.getApellidoMaterno());
            usuario.setEstado(usuarioBO.getEstado());
            usuario.setRolId(RolTransformer.boToEntity(usuarioBO.getRol()));
            if (usuarioBO.getSupervisor()!=null) {
                Integer idSuper = usuarioBO.getSupervisor().getId();
                Usuario supervi = new Usuario();
                supervi.setIdUsuario(idSuper);
                usuario.setUsuarioId(supervi);
            }
        }
        return usuario;
    }
}
