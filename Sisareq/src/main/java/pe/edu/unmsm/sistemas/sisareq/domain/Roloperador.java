/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "roloperador")
@NamedQueries({
    @NamedQuery(name = "Roloperador.findAll", query = "SELECT r FROM Roloperador r")})
public class Roloperador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol_operador")
    private Integer idRolOperador;
    @Basic(optional = false)
    @Column(name = "nombre_rol_ope")
    private String nombreRolOpe;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "prestacionservicio", joinColumns = {
        @JoinColumn(name = "rol_operador_id", referencedColumnName = "id_rol_operador")}, inverseJoinColumns = {
        @JoinColumn(name = "servicio_id", referencedColumnName = "id_servicio")})
    @ManyToMany
    private List<Servicio> servicioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolOperadorId")
    private List<Operador> operadorList;

    public Roloperador() {
    }

    public Roloperador(Integer idRolOperador) {
        this.idRolOperador = idRolOperador;
    }

    public Roloperador(Integer idRolOperador, String nombreRolOpe, String descripcion) {
        this.idRolOperador = idRolOperador;
        this.nombreRolOpe = nombreRolOpe;
        this.descripcion = descripcion;
    }

    public Integer getIdRolOperador() {
        return idRolOperador;
    }

    public void setIdRolOperador(Integer idRolOperador) {
        this.idRolOperador = idRolOperador;
    }

    public String getNombreRolOpe() {
        return nombreRolOpe;
    }

    public void setNombreRolOpe(String nombreRolOpe) {
        this.nombreRolOpe = nombreRolOpe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    public List<Operador> getOperadorList() {
        return operadorList;
    }

    public void setOperadorList(List<Operador> operadorList) {
        this.operadorList = operadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolOperador != null ? idRolOperador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roloperador)) {
            return false;
        }
        Roloperador other = (Roloperador) object;
        if ((this.idRolOperador == null && other.idRolOperador != null) || (this.idRolOperador != null && !this.idRolOperador.equals(other.idRolOperador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Roloperador[ idRolOperador=" + idRolOperador + " ]";
    }
    
}
