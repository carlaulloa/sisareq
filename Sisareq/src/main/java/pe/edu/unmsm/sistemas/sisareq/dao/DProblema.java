/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.dao;

import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Problema;

/**
 *
 * @author Alex
 */
public interface DProblema {
    
    public List<Object[]> getAllActivos();
    public void insertarProblema(Problema problema);
}
