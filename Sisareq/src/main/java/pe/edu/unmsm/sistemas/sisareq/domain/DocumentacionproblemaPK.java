/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Usuario
 */
@Embeddable
public class DocumentacionproblemaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "problema_id")
    private int problemaId;
    @Basic(optional = false)
    @Column(name = "id_documentacionproblema")
    private String idDocumentacionproblema;

    public DocumentacionproblemaPK() {
    }

    public DocumentacionproblemaPK(int problemaId, String idDocumentacionproblema) {
        this.problemaId = problemaId;
        this.idDocumentacionproblema = idDocumentacionproblema;
    }

    public int getProblemaId() {
        return problemaId;
    }

    public void setProblemaId(int problemaId) {
        this.problemaId = problemaId;
    }

    public String getIdDocumentacionproblema() {
        return idDocumentacionproblema;
    }

    public void setIdDocumentacionproblema(String idDocumentacionproblema) {
        this.idDocumentacionproblema = idDocumentacionproblema;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) problemaId;
        hash += (idDocumentacionproblema != null ? idDocumentacionproblema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentacionproblemaPK)) {
            return false;
        }
        DocumentacionproblemaPK other = (DocumentacionproblemaPK) object;
        if (this.problemaId != other.problemaId) {
            return false;
        }
        if ((this.idDocumentacionproblema == null && other.idDocumentacionproblema != null) || (this.idDocumentacionproblema != null && !this.idDocumentacionproblema.equals(other.idDocumentacionproblema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DocumentacionproblemaPK[ problemaId=" + problemaId + ", idDocumentacionproblema=" + idDocumentacionproblema + " ]";
    }
    
}
