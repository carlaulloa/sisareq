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
import javax.persistence.Lob;
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
@Table(name = "errorconocido")
@NamedQueries({
    @NamedQuery(name = "Errorconocido.findAll", query = "SELECT e FROM Errorconocido e")})
public class Errorconocido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_error_conocido")
    private Integer idErrorConocido;
    @Basic(optional = false)
    @Column(name = "fecha_detecion")
    @Temporal(TemporalType.DATE)
    private Date fechaDetecion;
    @Basic(optional = false)
    @Lob
    @Column(name = "causas")
    private String causas;
    @Basic(optional = false)
    @Lob
    @Column(name = "documentacion")
    private String documentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "errorConocidoId")
    private List<Rfc> rfcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "errorConocidoId")
    private List<Soluciones> solucionesList;
    @JoinColumn(name = "problema_id", referencedColumnName = "id_problema")
    @ManyToOne(optional = false)
    private Problema problemaId;

    public Errorconocido() {
    }

    public Errorconocido(Integer idErrorConocido) {
        this.idErrorConocido = idErrorConocido;
    }

    public Errorconocido(Integer idErrorConocido, Date fechaDetecion, String causas, String documentacion) {
        this.idErrorConocido = idErrorConocido;
        this.fechaDetecion = fechaDetecion;
        this.causas = causas;
        this.documentacion = documentacion;
    }

    public Integer getIdErrorConocido() {
        return idErrorConocido;
    }

    public void setIdErrorConocido(Integer idErrorConocido) {
        this.idErrorConocido = idErrorConocido;
    }

    public Date getFechaDetecion() {
        return fechaDetecion;
    }

    public void setFechaDetecion(Date fechaDetecion) {
        this.fechaDetecion = fechaDetecion;
    }

    public String getCausas() {
        return causas;
    }

    public void setCausas(String causas) {
        this.causas = causas;
    }

    public String getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(String documentacion) {
        this.documentacion = documentacion;
    }

    public List<Rfc> getRfcList() {
        return rfcList;
    }

    public void setRfcList(List<Rfc> rfcList) {
        this.rfcList = rfcList;
    }

    public List<Soluciones> getSolucionesList() {
        return solucionesList;
    }

    public void setSolucionesList(List<Soluciones> solucionesList) {
        this.solucionesList = solucionesList;
    }

    public Problema getProblemaId() {
        return problemaId;
    }

    public void setProblemaId(Problema problemaId) {
        this.problemaId = problemaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idErrorConocido != null ? idErrorConocido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Errorconocido)) {
            return false;
        }
        Errorconocido other = (Errorconocido) object;
        if ((this.idErrorConocido == null && other.idErrorConocido != null) || (this.idErrorConocido != null && !this.idErrorConocido.equals(other.idErrorConocido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Errorconocido[ idErrorConocido=" + idErrorConocido + " ]";
    }
    
}
