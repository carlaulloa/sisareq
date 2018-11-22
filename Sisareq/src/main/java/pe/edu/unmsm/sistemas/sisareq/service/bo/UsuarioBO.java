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
public class UsuarioBO {
    private Integer id;
    private String nomUsuario;
    private String clave;
 //   private String rol;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Boolean estado;
    private RolBO rol;
    
    private UsuarioBO supervisor;
    
    public UsuarioBO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    /*
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
*/
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public RolBO getRol() {
        return rol;
    }

    public void setRol(RolBO rol) {
        this.rol = rol;
    }

    public UsuarioBO getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(UsuarioBO supervisor) {
        this.supervisor = supervisor;
    }

    
    

}
