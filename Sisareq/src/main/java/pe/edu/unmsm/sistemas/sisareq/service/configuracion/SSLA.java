/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.configuracion;

import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.service.bo.SlaBO;

/**
 *
 * @author ULLOA
 */
public interface SSLA {
    public List<SlaBO> getAll();
    public SlaBO getByServicio(Integer idServicio);
    public String registrar(SlaBO slaBO);
    public String actualizar(SlaBO slaBO);
    public String eliminar(Integer idSla);
    public SlaBO getById(Integer idSla);
    public List<SlaBO> filtrarByNombre(String nombre);
}
