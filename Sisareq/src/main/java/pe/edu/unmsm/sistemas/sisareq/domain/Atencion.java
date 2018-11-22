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
@Table(name = "atencion")
@NamedQueries({
    @NamedQuery(name = "Atencion.findAll", query = "SELECT a FROM Atencion a")})
public class Atencion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_atencion")
    private Integer idAtencion;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @Column(name = "si_respuesta")
    private boolean siRespuesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atencionId")
    private List<Problema> problemaList;
    @JoinColumn(name = "operador_id", referencedColumnName = "id_operador")
    @ManyToOne(optional = false)
    private Operador operadorId;
    @JoinColumn(name = "soluciones_id", referencedColumnName = "id_soluciones")
    @ManyToOne
    private Soluciones solucionesId;
    @JoinColumn(name = "ticket_id", referencedColumnName = "id_ticket")
    @ManyToOne(optional = false)
    private Ticket ticketId;

    public Atencion() {
    }

    public Atencion(Integer idAtencion) {
        this.idAtencion = idAtencion;
    }

    public Atencion(Integer idAtencion, String descripcion, Date fecha, Date hora, boolean siRespuesta) {
        this.idAtencion = idAtencion;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.siRespuesta = siRespuesta;
    }

    public Integer getIdAtencion() {
        return idAtencion;
    }

    public void setIdAtencion(Integer idAtencion) {
        this.idAtencion = idAtencion;
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

    public boolean getSiRespuesta() {
        return siRespuesta;
    }

    public void setSiRespuesta(boolean siRespuesta) {
        this.siRespuesta = siRespuesta;
    }

    public List<Problema> getProblemaList() {
        return problemaList;
    }

    public void setProblemaList(List<Problema> problemaList) {
        this.problemaList = problemaList;
    }

    public Operador getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(Operador operadorId) {
        this.operadorId = operadorId;
    }

    public Soluciones getSolucionesId() {
        return solucionesId;
    }

    public void setSolucionesId(Soluciones solucionesId) {
        this.solucionesId = solucionesId;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtencion != null ? idAtencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atencion)) {
            return false;
        }
        Atencion other = (Atencion) object;
        if ((this.idAtencion == null && other.idAtencion != null) || (this.idAtencion != null && !this.idAtencion.equals(other.idAtencion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Atencion[ idAtencion=" + idAtencion + " ]";
    }
    
}
