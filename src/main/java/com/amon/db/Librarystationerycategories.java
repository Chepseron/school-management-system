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
@Table(name = "librarystationerycategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarystationerycategories.findAll", query = "SELECT l FROM Librarystationerycategories l")
    , @NamedQuery(name = "Librarystationerycategories.findByIdlibrarystationerycategories", query = "SELECT l FROM Librarystationerycategories l WHERE l.idlibrarystationerycategories = :idlibrarystationerycategories")
    , @NamedQuery(name = "Librarystationerycategories.findByCode", query = "SELECT l FROM Librarystationerycategories l WHERE l.code = :code")
    , @NamedQuery(name = "Librarystationerycategories.findByName", query = "SELECT l FROM Librarystationerycategories l WHERE l.name = :name")})
public class Librarystationerycategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarystationerycategories")
    private Integer idlibrarystationerycategories;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stationery")
    private Collection<Librarynewstationery> librarynewstationeryCollection;

    public Librarystationerycategories() {
    }

    public Librarystationerycategories(Integer idlibrarystationerycategories) {
        this.idlibrarystationerycategories = idlibrarystationerycategories;
    }

    public Librarystationerycategories(Integer idlibrarystationerycategories, String code, String name) {
        this.idlibrarystationerycategories = idlibrarystationerycategories;
        this.code = code;
        this.name = name;
    }

    public Integer getIdlibrarystationerycategories() {
        return idlibrarystationerycategories;
    }

    public void setIdlibrarystationerycategories(Integer idlibrarystationerycategories) {
        this.idlibrarystationerycategories = idlibrarystationerycategories;
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
    public Collection<Librarynewstationery> getLibrarynewstationeryCollection() {
        return librarynewstationeryCollection;
    }

    public void setLibrarynewstationeryCollection(Collection<Librarynewstationery> librarynewstationeryCollection) {
        this.librarynewstationeryCollection = librarynewstationeryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarystationerycategories != null ? idlibrarystationerycategories.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarystationerycategories)) {
            return false;
        }
        Librarystationerycategories other = (Librarystationerycategories) object;
        if ((this.idlibrarystationerycategories == null && other.idlibrarystationerycategories != null) || (this.idlibrarystationerycategories != null && !this.idlibrarystationerycategories.equals(other.idlibrarystationerycategories))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarystationerycategories[ idlibrarystationerycategories=" + idlibrarystationerycategories + " ]";
    }
    
}
