/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao;

import pe.edu.unmsm.sistemas.sisareq.domain.Atencion;

/**
 *
 * @author ULLOA
 */
public interface DAtencion {
    public Object[] getByIdTicket(Integer idTicket);
    
    public Atencion insertarAtencion(Atencion nuevaAtencion);
}
