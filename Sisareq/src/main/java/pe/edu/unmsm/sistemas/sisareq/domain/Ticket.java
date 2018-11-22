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
@Table(name = "ticket")
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ticket")
    private Integer idTicket;
    @Basic(optional = false)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Lob
    @Column(name = "archivo")
    private String archivo;
    @Basic(optional = false)
    @Column(name = "fecha_gen")
    @Temporal(TemporalType.DATE)
    private Date fechaGen;
    @Basic(optional = false)
    @Column(name = "hora_gen")
    @Temporal(TemporalType.TIME)
    private Date horaGen;
    @Basic(optional = false)
    @Column(name = "aprobacion")
    private boolean aprobacion;
    @Lob
    @Column(name = "adjunto")
    private byte[] adjunto;
    @Lob
    @Column(name = "content_type")
    private String contentType;
    @JoinColumn(name = "servicio_id", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicio servicioId;
    @JoinColumn(name = "estado_id", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private Estado estadoId;
    @JoinColumn(name = "prioridad_id", referencedColumnName = "id_prioridad")
    @ManyToOne(optional = false)
    private Prioridad prioridadId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
    private List<Atencion> atencionList;

    public Ticket() {
    }

    public Ticket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Ticket(Integer idTicket, String asunto, String descripcion, Date fechaGen, Date horaGen, boolean aprobacion) {
        this.idTicket = idTicket;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fechaGen = fechaGen;
        this.horaGen = horaGen;
        this.aprobacion = aprobacion;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
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

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Date getFechaGen() {
        return fechaGen;
    }

    public void setFechaGen(Date fechaGen) {
        this.fechaGen = fechaGen;
    }

    public Date getHoraGen() {
        return horaGen;
    }

    public void setHoraGen(Date horaGen) {
        this.horaGen = horaGen;
    }

    public boolean getAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(boolean aprobacion) {
        this.aprobacion = aprobacion;
    }

    public byte[] getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(byte[] adjunto) {
        this.adjunto = adjunto;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    
    

    public Servicio getServicioId() {
        return servicioId;
    }

    public void setServicioId(Servicio servicioId) {
        this.servicioId = servicioId;
    }

    public Estado getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Estado estadoId) {
        this.estadoId = estadoId;
    }

    public Prioridad getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(Prioridad prioridadId) {
        this.prioridadId = prioridadId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ticket[ idTicket=" + idTicket + " ]";
    }

}
