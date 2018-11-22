/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.bo;

import java.util.Date;

/**
 *
 * @author ULLOA
 */
public class AtencionBO {
    private Integer id;
    private String descripcion;
    private Date fecha;
    private Date hora;
    private SolucionBO solucion;
    private Boolean siRespuesta;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public SolucionBO getSolucion() {
        return solucion;
    }

    public void setSolucion(SolucionBO solucion) {
        this.solucion = solucion;
    }

    public Boolean getSiRespuesta() {
        return siRespuesta;
    }

    public void setSiRespuesta(Boolean siRespuesta) {
        this.siRespuesta = siRespuesta;
    }
    
    
    
    
    
}
