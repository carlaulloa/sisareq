/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.configuracion;


import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;

/**
 *
 * @author ULLOA
 */
public interface SUsuario {
    public UsuarioBO getByNombreUsuario(String nombreUsuario);
    public UsuarioBO getAllDataByNombreUsuario(String nombreUsuario);
     public UsuarioBO getAllDataByNombrePersona(String nombre);
    public String registrar(UsuarioBO usuarioBO);
    public List<UsuarioBO> getAllActivos();
    public UsuarioBO getById(Integer idUsuario);
    public List<UsuarioBO> getByRol(Integer idRol);
    public List<UsuarioBO> getSupervisores();
    public String deleteUsuario(Integer idUser);
    public String updateUsuario(UsuarioBO usuarioBO);
}
