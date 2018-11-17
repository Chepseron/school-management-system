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
@Table(name = "librarybookcategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarybookcategories.findAll", query = "SELECT l FROM Librarybookcategories l")
    , @NamedQuery(name = "Librarybookcategories.findByIdlibrarybookcategories", query = "SELECT l FROM Librarybookcategories l WHERE l.idlibrarybookcategories = :idlibrarybookcategories")
    , @NamedQuery(name = "Librarybookcategories.findByCode", query = "SELECT l FROM Librarybookcategories l WHERE l.code = :code")
    , @NamedQuery(name = "Librarybookcategories.findByName", query = "SELECT l FROM Librarybookcategories l WHERE l.name = :name")})
public class Librarybookcategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarybookcategories")
    private Integer idlibrarybookcategories;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<Librarylendreceive> librarylendreceiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<Librarynewbookacquisition> librarynewbookacquisitionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private Collection<Librarycatalog> librarycatalogCollection;

    public Librarybookcategories() {
    }

    public Librarybookcategories(Integer idlibrarybookcategories) {
        this.idlibrarybookcategories = idlibrarybookcategories;
    }

    public Librarybookcategories(Integer idlibrarybookcategories, String code, String name) {
        this.idlibrarybookcategories = idlibrarybookcategories;
        this.code = code;
        this.name = name;
    }

    public Integer getIdlibrarybookcategories() {
        return idlibrarybookcategories;
    }

    public void setIdlibrarybookcategories(Integer idlibrarybookcategories) {
        this.idlibrarybookcategories = idlibrarybookcategories;
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
    public Collection<Librarylendreceive> getLibrarylendreceiveCollection() {
        return librarylendreceiveCollection;
    }

    public void setLibrarylendreceiveCollection(Collection<Librarylendreceive> librarylendreceiveCollection) {
        this.librarylendreceiveCollection = librarylendreceiveCollection;
    }

    @XmlTransient
    public Collection<Librarynewbookacquisition> getLibrarynewbookacquisitionCollection() {
        return librarynewbookacquisitionCollection;
    }

    public void setLibrarynewbookacquisitionCollection(Collection<Librarynewbookacquisition> librarynewbookacquisitionCollection) {
        this.librarynewbookacquisitionCollection = librarynewbookacquisitionCollection;
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
        hash += (idlibrarybookcategories != null ? idlibrarybookcategories.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarybookcategories)) {
            return false;
        }
        Librarybookcategories other = (Librarybookcategories) object;
        if ((this.idlibrarybookcategories == null && other.idlibrarybookcategories != null) || (this.idlibrarybookcategories != null && !this.idlibrarybookcategories.equals(other.idlibrarybookcategories))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarybookcategories[ idlibrarybookcategories=" + idlibrarybookcategories + " ]";
    }
    
}
