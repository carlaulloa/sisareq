/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao;

import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Prioridad;

/**
 *
 * @author ULLOA
 */
public interface DPrioridad {
    public Prioridad getById(Integer id);
    public List<Prioridad> getAll();
}
