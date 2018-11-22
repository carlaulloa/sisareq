/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao;

import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Sla;

/**
 *
 * @author ULLOA
 */
public interface DSla {
    public List<Sla> getAll();
    public Sla getByIdServicio(Integer idServicio);
    public String insert(Sla sla);
    public String update(Sla sla);
    public Sla getById(Integer id);
    public List<Sla> filterByName(String nombre);
}
