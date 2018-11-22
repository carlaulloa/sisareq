/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.bo;

/**
 *
 * @author ULLOA
 */
public class SlaBO {
    private Integer id;
    private String nombre;

    private Integer resolucionHoras;
    private Integer resolucionMinutos;
    private Integer resolucionDias;
    
    private Integer respuestaHoras;
    private Integer respuestaMinutos;
    private Integer respuestaDias;
    
    private Boolean estado;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getResolucionHoras() {
        return resolucionHoras;
    }

    public void setResolucionHoras(Integer resolucionHoras) {
        this.resolucionHoras = resolucionHoras;
    }

    public Integer getResolucionMinutos() {
        return resolucionMinutos;
    }

    public void setResolucionMinutos(Integer resolucionMinutos) {
        this.resolucionMinutos = resolucionMinutos;
    }

    public Integer getResolucionDias() {
        return resolucionDias;
    }

    public void setResolucionDias(Integer resolucionDias) {
        this.resolucionDias = resolucionDias;
    }

    public Integer getRespuestaHoras() {
        return respuestaHoras;
    }

    public void setRespuestaHoras(Integer respuestaHoras) {
        this.respuestaHoras = respuestaHoras;
    }

    public Integer getRespuestaMinutos() {
        return respuestaMinutos;
    }

    public void setRespuestaMinutos(Integer respuestaMinutos) {
        this.respuestaMinutos = respuestaMinutos;
    }

    public Integer getRespuestaDias() {
        return respuestaDias;
    }

    public void setRespuestaDias(Integer respuestaDias) {
        this.respuestaDias = respuestaDias;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    
    
}
