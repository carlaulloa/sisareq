/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao;

import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Servicio;

/**
 *
 * @author ULLOA
 */
public interface DServicio {
  //  public List<Servicio> getByIdCategoria(Integer idCategoria);
  public Servicio getById(Integer id);
    public List<Servicio> getByNivel(Integer nivel);
    public List<Servicio> getByPadre(Integer idServicio);
    public Integer getMaxNivel();
    public Servicio getPadre(Integer idHijo);
    public String insert(Servicio servicio);
    public String update(Servicio servicio);
    public List<Servicio> filterByName(String filterName);
    public Integer getNumSubservicios(Integer idServicio);
}
