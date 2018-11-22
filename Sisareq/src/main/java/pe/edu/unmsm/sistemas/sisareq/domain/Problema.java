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
@Table(name = "problema")
@NamedQueries({
    @NamedQuery(name = "Problema.findAll", query = "SELECT p FROM Problema p")})
public class Problema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_problema")
    private Integer idProblema;
    @Basic(optional = false)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha_de_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaDeRegistro;
    @Column(name = "documentacion_registro")
    private String documentacionRegistro;
    @Basic(optional = false)
    @Column(name = "tratamiento_previo")
    private String tratamientoPrevio;
    @Column(name = "estado_actual")
    private String estadoActual;
    @JoinColumn(name = "categoria_problema_id", referencedColumnName = "id_categoria_problema")
    @ManyToOne
    private Categoriaproblema categoriaProblemaId;
    @JoinColumn(name = "atencion_id", referencedColumnName = "id_atencion")
    @ManyToOne(optional = false)
    private Atencion atencionId;
    @JoinColumn(name = "operador_id", referencedColumnName = "id_operador")
    @ManyToOne(optional = false)
    private Operador operadorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "problemaId")
    private List<Errorconocido> errorconocidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "problema")
    private List<Documentacionproblema> documentacionproblemaList;

    public Problema() {
    }

    public Problema(Integer idProblema) {
        this.idProblema = idProblema;
    }

    public Problema(Integer idProblema, String asunto, String descripcion, Date fechaDeRegistro, String tratamientoPrevio) {
        this.idProblema = idProblema;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fechaDeRegistro = fechaDeRegistro;
        this.tratamientoPrevio = tratamientoPrevio;
    }

    public Integer getIdProblema() {
        return idProblema;
    }

    public void setIdProblema(Integer idProblema) {
        this.idProblema = idProblema;
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

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public String getDocumentacionRegistro() {
        return documentacionRegistro;
    }

    public void setDocumentacionRegistro(String documentacionRegistro) {
        this.documentacionRegistro = documentacionRegistro;
    }

    public String getTratamientoPrevio() {
        return tratamientoPrevio;
    }

    public void setTratamientoPrevio(String tratamientoPrevio) {
        this.tratamientoPrevio = tratamientoPrevio;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Categoriaproblema getCategoriaProblemaId() {
        return categoriaProblemaId;
    }

    public void setCategoriaProblemaId(Categoriaproblema categoriaProblemaId) {
        this.categoriaProblemaId = categoriaProblemaId;
    }

    public Atencion getAtencionId() {
        return atencionId;
    }

    public void setAtencionId(Atencion atencionId) {
        this.atencionId = atencionId;
    }

    public Operador getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Operador operadorId) {
        this.operadorId = operadorId;
    }

    public List<Errorconocido> getErrorconocidoList() {
        return errorconocidoList;
    }

    public void setErrorconocidoList(List<Errorconocido> errorconocidoList) {
        this.errorconocidoList = errorconocidoList;
    }

    public List<Documentacionproblema> getDocumentacionproblemaList() {
        return documentacionproblemaList;
    }

    public void setDocumentacionproblemaList(List<Documentacionproblema> documentacionproblemaList) {
        this.documentacionproblemaList = documentacionproblemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProblema != null ? idProblema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Problema)) {
            return false;
        }
        Problema other = (Problema) object;
        if ((this.idProblema == null && other.idProblema != null) || (this.idProblema != null && !this.idProblema.equals(other.idProblema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Problema[ idProblema=" + idProblema + " ]";
    }
    
}
