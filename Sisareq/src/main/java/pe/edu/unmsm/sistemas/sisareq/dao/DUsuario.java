/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao;


import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Usuario;

/**
 *
 * @author ULLOA
 */
public interface DUsuario {
    public Usuario buscarPorNombre(String login);
    public String insert(Usuario usuario);
    public List<Object[]> getAll();
    public String update(Usuario usuario);
    public Object[] getById(Integer idUsuario);
    public Object[] getByNombreUsuario(String nombreUsuario);
      public Object[] getByNombrePersona(String nombre);
    public List<Object[]> getAllActivos();
    public List<Object[]> getByRol(Integer idRol);
    public List<Object[]> getSupervisores();
}
