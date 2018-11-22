/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.bo;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ULLOA
 */
public class ServicioBO {

    private Integer id;
    private Boolean autorizacion;
    private String nombre;
    private SlaBO slaBO;

    private List<ServicioBO> lsSubServicios;
    // en vez de la lista
    private HashMap<Integer, ServicioBO> mapSubServicios;

    private Integer nivel;
    private ServicioBO servicioPadre;

    private Integer numSubServicios;
    private Boolean estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SlaBO getSlaBO() {
        return slaBO;
    }

    public void setSlaBO(SlaBO slaBO) {
        this.slaBO = slaBO;
    }

    public List<ServicioBO> getLsSubServicios() {
        return lsSubServicios;
    }

    public void setLsSubServicios(List<ServicioBO> lsSubServicios) {
        this.lsSubServicios = lsSubServicios;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public ServicioBO getServicioPadre() {
        return servicioPadre;
    }

    public void setServicioPadre(ServicioBO servicioPadre) {
        this.servicioPadre = servicioPadre;
    }

    // añadido
    public HashMap<Integer, ServicioBO> getMapSubServicios() {
        return mapSubServicios;
    }

    public void setMapSubServicios(HashMap<Integer, ServicioBO> mapSubServicios) {
        this.mapSubServicios = mapSubServicios;
    }

    public Integer getNumSubServicios() {
        return numSubServicios;
    }

    public void setNumSubServicios(Integer numSubServicios) {
        this.numSubServicios = numSubServicios;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    
}
