/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao;

import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Rol;

/**
 *
 * @author ULLOA
 */
public interface DRol {
    public List<Rol> getAll();
    public Rol getByIdUser(Integer idUser);
}
