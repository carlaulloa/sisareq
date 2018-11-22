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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "servicio")
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Basic(optional = false)
    @Column(name = "si_autorizacion")
    private boolean siAutorizacion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nivel")
    private int nivel;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @ManyToMany(mappedBy = "servicioList")
    private List<Roloperador> roloperadorList;
    @OneToMany(mappedBy = "servicioPadre")
    private List<Servicio> servicioList;
    @JoinColumn(name = "servicio_padre", referencedColumnName = "id_servicio")
    @ManyToOne
    private Servicio servicioPadre;
    @JoinColumn(name = "sla_id", referencedColumnName = "id_sla")
    @ManyToOne(optional = false)
    private Sla slaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioId")
    private List<Ticket> ticketList;

    public Servicio() {
    }

    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio(Integer idServicio, boolean siAutorizacion, String nombre, int nivel, boolean estado) {
        this.idServicio = idServicio;
        this.siAutorizacion = siAutorizacion;
        this.nombre = nombre;
        this.nivel = nivel;
        this.estado = estado;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public boolean getSiAutorizacion() {
        return siAutorizacion;
    }

    public void setSiAutorizacion(boolean siAutorizacion) {
        this.siAutorizacion = siAutorizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public List<Roloperador> getRoloperadorList() {
        return roloperadorList;
    }

    public void setRoloperadorList(List<Roloperador> roloperadorList) {
        this.roloperadorList = roloperadorList;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    public Servicio getServicioPadre() {
        return servicioPadre;
    }

    public void setServicioPadre(Servicio servicioPadre) {
        this.servicioPadre = servicioPadre;
    }

    public Sla getSlaId() {
        return slaId;
    }

    public void setSlaId(Sla slaId) {
        this.slaId = slaId;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}
