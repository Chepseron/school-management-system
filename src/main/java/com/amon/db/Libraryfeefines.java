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
@Table(name = "libraryfeefines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libraryfeefines.findAll", query = "SELECT l FROM Libraryfeefines l")
    , @NamedQuery(name = "Libraryfeefines.findByIdlibraryfeefines", query = "SELECT l FROM Libraryfeefines l WHERE l.idlibraryfeefines = :idlibraryfeefines")
    , @NamedQuery(name = "Libraryfeefines.findByFeecode", query = "SELECT l FROM Libraryfeefines l WHERE l.feecode = :feecode")
    , @NamedQuery(name = "Libraryfeefines.findByName", query = "SELECT l FROM Libraryfeefines l WHERE l.name = :name")})
public class Libraryfeefines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibraryfeefines")
    private Integer idlibraryfeefines;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "feecode")
    private String feecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;

    public Libraryfeefines() {
    }

    public Libraryfeefines(Integer idlibraryfeefines) {
        this.idlibraryfeefines = idlibraryfeefines;
    }

    public Libraryfeefines(Integer idlibraryfeefines, String feecode, String name) {
        this.idlibraryfeefines = idlibraryfeefines;
        this.feecode = feecode;
        this.name = name;
    }

    public Integer getIdlibraryfeefines() {
        return idlibraryfeefines;
    }

    public void setIdlibraryfeefines(Integer idlibraryfeefines) {
        this.idlibraryfeefines = idlibraryfeefines;
    }

    public String getFeecode() {
        return feecode;
    }

    public void setFeecode(String feecode) {
        this.feecode = feecode;
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
        hash += (idlibraryfeefines != null ? idlibraryfeefines.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libraryfeefines)) {
            return false;
        }
        Libraryfeefines other = (Libraryfeefines) object;
        if ((this.idlibraryfeefines == null && other.idlibraryfeefines != null) || (this.idlibraryfeefines != null && !this.idlibraryfeefines.equals(other.idlibraryfeefines))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Libraryfeefines[ idlibraryfeefines=" + idlibraryfeefines + " ]";
    }
    
}
