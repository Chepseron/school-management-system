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
@Table(name = "libraryshelve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libraryshelve.findAll", query = "SELECT l FROM Libraryshelve l")
    , @NamedQuery(name = "Libraryshelve.findByIdlibraryshelve", query = "SELECT l FROM Libraryshelve l WHERE l.idlibraryshelve = :idlibraryshelve")
    , @NamedQuery(name = "Libraryshelve.findByCode", query = "SELECT l FROM Libraryshelve l WHERE l.code = :code")
    , @NamedQuery(name = "Libraryshelve.findByName", query = "SELECT l FROM Libraryshelve l WHERE l.name = :name")})
public class Libraryshelve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibraryshelve")
    private Integer idlibraryshelve;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shelve")
    private Collection<Librarycatalog> librarycatalogCollection;

    public Libraryshelve() {
    }

    public Libraryshelve(Integer idlibraryshelve) {
        this.idlibraryshelve = idlibraryshelve;
    }

    public Libraryshelve(Integer idlibraryshelve, String code, String name) {
        this.idlibraryshelve = idlibraryshelve;
        this.code = code;
        this.name = name;
    }

    public Integer getIdlibraryshelve() {
        return idlibraryshelve;
    }

    public void setIdlibraryshelve(Integer idlibraryshelve) {
        this.idlibraryshelve = idlibraryshelve;
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
        hash += (idlibraryshelve != null ? idlibraryshelve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libraryshelve)) {
            return false;
        }
        Libraryshelve other = (Libraryshelve) object;
        if ((this.idlibraryshelve == null && other.idlibraryshelve != null) || (this.idlibraryshelve != null && !this.idlibraryshelve.equals(other.idlibraryshelve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Libraryshelve[ idlibraryshelve=" + idlibraryshelve + " ]";
    }
    
}
