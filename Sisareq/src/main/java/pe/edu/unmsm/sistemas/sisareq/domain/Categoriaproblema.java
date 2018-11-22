/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "categoriaproblema")
@NamedQueries({
    @NamedQuery(name = "Categoriaproblema.findAll", query = "SELECT c FROM Categoriaproblema c")})
public class Categoriaproblema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_problema")
    private Integer idCategoriaProblema;
    @Basic(optional = false)
    @Column(name = "nombre_cat_prob")
    private String nombreCatProb;
    @Basic(optional = false)
    @Column(name = "urgencia")
    private String urgencia;
    @Basic(optional = false)
    @Column(name = "Impacto")
    private String impacto;
    @OneToMany(mappedBy = "categoriaProblemaId")
    private List<Problema> problemaList;

    public Categoriaproblema() {
    }

    public Categoriaproblema(Integer idCategoriaProblema) {
        this.idCategoriaProblema = idCategoriaProblema;
    }

    public Categoriaproblema(Integer idCategoriaProblema, String nombreCatProb, String urgencia, String impacto) {
        this.idCategoriaProblema = idCategoriaProblema;
        this.nombreCatProb = nombreCatProb;
        this.urgencia = urgencia;
        this.impacto = impacto;
    }

    public Integer getIdCategoriaProblema() {
        return idCategoriaProblema;
    }

    public void setIdCategoriaProblema(Integer idCategoriaProblema) {
        this.idCategoriaProblema = idCategoriaProblema;
    }

    public String getNombreCatProb() {
        return nombreCatProb;
    }

    public void setNombreCatProb(String nombreCatProb) {
        this.nombreCatProb = nombreCatProb;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public List<Problema> getProblemaList() {
        return problemaList;
    }

    public void setProblemaList(List<Problema> problemaList) {
        this.problemaList = problemaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaProblema != null ? idCategoriaProblema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoriaproblema)) {
            return false;
        }
        Categoriaproblema other = (Categoriaproblema) object;
        if ((this.idCategoriaProblema == null && other.idCategoriaProblema != null) || (this.idCategoriaProblema != null && !this.idCategoriaProblema.equals(other.idCategoriaProblema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Categoriaproblema[ idCategoriaProblema=" + idCategoriaProblema + " ]";
    }
    
}
