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
public class TicketBO {

    private Integer id;
    private EstadoBO estado;
    private PrioridadBO prioridad;
    private ServicioBO servicio;
    private UsuarioBO usuario;
    private String asunto;
    private String descripcion;
    private String archivo;
    private byte[] adjunto;
    private Date fecha;
    private Date hora;
    private Boolean aprobado;
    
    private AtencionBO atencion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadoBO getEstado() {
        return estado;
    }

    public void setEstado(EstadoBO estado) {
        this.estado = estado;
    }
/*
    public OperadorBO getOperador() {
        return operador;
    }

    public void setOperador(OperadorBO operador) {
        this.operador = operador;
    }*/

    public PrioridadBO getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadBO prioridad) {
        this.prioridad = prioridad;
    }

    public ServicioBO getServicio() {
        return servicio;
    }

    public void setServicio(ServicioBO servicio) {
        this.servicio = servicio;
    }

    public UsuarioBO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBO usuario) {
        this.usuario = usuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(byte[] adjunto) {
        this.adjunto = adjunto;
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

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public AtencionBO getAtencion() {
        return atencion;
    }

    public void setAtencion(AtencionBO atencion) {
        this.atencion = atencion;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    
    
}
