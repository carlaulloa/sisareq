/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.regtickets;

import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;

/**
 *
 * @author ULLOA
 */
public interface SCatalogo {
    public List<ServicioBO> getCatalogo();
    public void formarCatalogo( ServicioBO servicioBO, Integer maxNivel);
    public Integer getMaxNivel();
}
