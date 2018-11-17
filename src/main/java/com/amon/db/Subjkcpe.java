/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "subjkcpe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjkcpe.findAll", query = "SELECT s FROM Subjkcpe s")
    , @NamedQuery(name = "Subjkcpe.findByIdsubjkcpe", query = "SELECT s FROM Subjkcpe s WHERE s.idsubjkcpe = :idsubjkcpe")
    , @NamedQuery(name = "Subjkcpe.findByCode", query = "SELECT s FROM Subjkcpe s WHERE s.code = :code")
    , @NamedQuery(name = "Subjkcpe.findByName", query = "SELECT s FROM Subjkcpe s WHERE s.name = :name")})
public class Subjkcpe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubjkcpe")
    private Integer idsubjkcpe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    public Subjkcpe() {
    }

    public Subjkcpe(Integer idsubjkcpe) {
        this.idsubjkcpe = idsubjkcpe;
    }

    public Subjkcpe(Integer idsubjkcpe, String code, String name) {
        this.idsubjkcpe = idsubjkcpe;
        this.code = code;
        this.name = name;
    }

    public Integer getIdsubjkcpe() {
        return idsubjkcpe;
    }

    public void setIdsubjkcpe(Integer idsubjkcpe) {
        this.idsubjkcpe = idsubjkcpe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubjkcpe != null ? idsubjkcpe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjkcpe)) {
            return false;
        }
        Subjkcpe other = (Subjkcpe) object;
        if ((this.idsubjkcpe == null && other.idsubjkcpe != null) || (this.idsubjkcpe != null && !this.idsubjkcpe.equals(other.idsubjkcpe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Subjkcpe[ idsubjkcpe=" + idsubjkcpe + " ]";
    }
    
}
