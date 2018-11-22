/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "rfc")
@NamedQueries({
    @NamedQuery(name = "Rfc.findAll", query = "SELECT r FROM Rfc r")})
public class Rfc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rfc")
    private Integer idRfc;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "proposito")
    private String proposito;
    @Basic(optional = false)
    @Column(name = "motivacion")
    private String motivacion;
    @Column(name = "estimacion_recursos")
    private String estimacionRecursos;
    @Basic(optional = false)
    @Column(name = "estimacion_tiempo")
    private int estimacionTiempo;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "prioridad")
    private String prioridad;
    @ManyToMany(mappedBy = "rfcList")
    private List<Activosti> activostiList;
    @JoinColumn(name = "operador_id", referencedColumnName = "id_operador")
    @ManyToOne(optional = false)
    private Operador operadorId;
    @JoinColumn(name = "error_conocido_id", referencedColumnName = "id_error_conocido")
    @ManyToOne(optional = false)
    private Errorconocido errorConocidoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rfcId")
    private List<Per> perList;

    public Rfc() {
    }

    public Rfc(Integer idRfc) {
        this.idRfc = idRfc;
    }

    public Rfc(Integer idRfc, String nombre, Date fecha, String estado, String proposito, String motivacion, int estimacionTiempo) {
        this.idRfc = idRfc;
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
        this.proposito = proposito;
        this.motivacion = motivacion;
        this.estimacionTiempo = estimacionTiempo;
    }

    public Integer getIdRfc() {
        return idRfc;
    }

    public void setIdRfc(Integer idRfc) {
        this.idRfc = idRfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getMotivacion() {
        return motivacion;
    }

    public void setMotivacion(String motivacion) {
        this.motivacion = motivacion;
    }

    public String getEstimacionRecursos() {
        return estimacionRecursos;
    }

    public void setEstimacionRecursos(String estimacionRecursos) {
        this.estimacionRecursos = estimacionRecursos;
    }

    public int getEstimacionTiempo() {
        return estimacionTiempo;
    }

    public void setEstimacionTiempo(int estimacionTiempo) {
        this.estimacionTiempo = estimacionTiempo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public List<Activosti> getActivostiList() {
        return activostiList;
    }

    public void setActivostiList(List<Activosti> activostiList) {
        this.activostiList = activostiList;
    }

    public Operador getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Operador operadorId) {
        this.operadorId = operadorId;
    }

    public Errorconocido getErrorConocidoId() {
        return errorConocidoId;
    }

    public void setErrorConocidoId(Errorconocido errorConocidoId) {
        this.errorConocidoId = errorConocidoId;
    }

    public List<Per> getPerList() {
        return perList;
    }

    public void setPerList(List<Per> perList) {
        this.perList = perList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRfc != null ? idRfc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rfc)) {
            return false;
        }
        Rfc other = (Rfc) object;
        if ((this.idRfc == null && other.idRfc != null) || (this.idRfc != null && !this.idRfc.equals(other.idRfc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Rfc[ idRfc=" + idRfc + " ]";
    }
    
}
