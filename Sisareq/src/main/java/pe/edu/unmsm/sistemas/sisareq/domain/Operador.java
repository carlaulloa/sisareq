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
@Table(name = "operador")
@NamedQueries({
    @NamedQuery(name = "Operador.findAll", query = "SELECT o FROM Operador o")})
public class Operador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operador")
    private Integer idOperador;
    @Basic(optional = false)
    @Column(name = "nivel")
    private int nivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operadorId")
    private List<Problema> problemaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operadorId")
    private List<Rfc> rfcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operadorId")
    private List<Documentacionproblema> documentacionproblemaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operadorId")
    private List<Atencion> atencionList;
    @JoinColumn(name = "rol_operador_id", referencedColumnName = "id_rol_operador")
    @ManyToOne(optional = false)
    private Roloperador rolOperadorId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Operador() {
    }

    public Operador(Integer idOperador) {
        this.idOperador = idOperador;
    }

    public Operador(Integer idOperador, int nivel) {
        this.idOperador = idOperador;
        this.nivel = nivel;
    }

    public Integer getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Problema> getProblemaList() {
        return problemaList;
    }

    public void setProblemaList(List<Problema> problemaList) {
        this.problemaList = problemaList;
    }

    public List<Rfc> getRfcList() {
        return rfcList;
    }

    public void setRfcList(List<Rfc> rfcList) {
        this.rfcList = rfcList;
    }

    public List<Documentacionproblema> getDocumentacionproblemaList() {
        return documentacionproblemaList;
    }

    public void setDocumentacionproblemaList(List<Documentacionproblema> documentacionproblemaList) {
        this.documentacionproblemaList = documentacionproblemaList;
    }

    public List<Atencion> getAtencionList() {
        return atencionList;
    }

    public void setAtencionList(List<Atencion> atencionList) {
        this.atencionList = atencionList;
    }

    public Roloperador getRolOperadorId() {
        return rolOperadorId;
    }

    public void setRolOperadorId(Roloperador rolOperadorId) {
        this.rolOperadorId = rolOperadorId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperador != null ? idOperador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operador)) {
            return false;
        }
        Operador other = (Operador) object;
        if ((this.idOperador == null && other.idOperador != null) || (this.idOperador != null && !this.idOperador.equals(other.idOperador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Operador[ idOperador=" + idOperador + " ]";
    }
    
}
