/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "libraryauthors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libraryauthors.findAll", query = "SELECT l FROM Libraryauthors l")
    , @NamedQuery(name = "Libraryauthors.findByIdlibraryauthors", query = "SELECT l FROM Libraryauthors l WHERE l.idlibraryauthors = :idlibraryauthors")
    , @NamedQuery(name = "Libraryauthors.findByCode", query = "SELECT l FROM Libraryauthors l WHERE l.code = :code")
    , @NamedQuery(name = "Libraryauthors.findByName", query = "SELECT l FROM Libraryauthors l WHERE l.name = :name")})
public class Libraryauthors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibraryauthors")
    private Integer idlibraryauthors;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Collection<Librarycatalog> librarycatalogCollection;

    public Libraryauthors() {
    }

    public Libraryauthors(Integer idlibraryauthors) {
        this.idlibraryauthors = idlibraryauthors;
    }

    public Libraryauthors(Integer idlibraryauthors, String code, String name) {
        this.idlibraryauthors = idlibraryauthors;
        this.code = code;
        this.name = name;
    }

    public Integer getIdlibraryauthors() {
        return idlibraryauthors;
    }

    public void setIdlibraryauthors(Integer idlibraryauthors) {
        this.idlibraryauthors = idlibraryauthors;
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

    @XmlTransient
    public Collection<Librarycatalog> getLibrarycatalogCollection() {
        return librarycatalogCollection;
    }

    public void setLibrarycatalogCollection(Collection<Librarycatalog> librarycatalogCollection) {
        this.librarycatalogCollection = librarycatalogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibraryauthors != null ? idlibraryauthors.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libraryauthors)) {
            return false;
        }
        Libraryauthors other = (Libraryauthors) object;
        if ((this.idlibraryauthors == null && other.idlibraryauthors != null) || (this.idlibraryauthors != null && !this.idlibraryauthors.equals(other.idlibraryauthors))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Libraryauthors[ idlibraryauthors=" + idlibraryauthors + " ]";
    }
    
}
