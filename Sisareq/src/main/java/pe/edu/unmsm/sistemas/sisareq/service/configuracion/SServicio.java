/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.configuracion;

import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;

/**
 *
 * @author ULLOA
 */
public interface SServicio {
    public String registrar(ServicioBO servicioBO);
    public String actualizar(ServicioBO servicioBO);
    public String eliminar(Integer idServicio);
    public List<ServicioBO> getByPadre(Integer idPadre);
    public List<ServicioBO> getByNivelUno();
    public List<ServicioBO> filterByName(String filtro);
    public ServicioBO getById(Integer idServicio);
}
