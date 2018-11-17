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
@Table(name = "librarymembertypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarymembertypes.findAll", query = "SELECT l FROM Librarymembertypes l")
    , @NamedQuery(name = "Librarymembertypes.findByIdlibrarymembertypes", query = "SELECT l FROM Librarymembertypes l WHERE l.idlibrarymembertypes = :idlibrarymembertypes")
    , @NamedQuery(name = "Librarymembertypes.findByCode", query = "SELECT l FROM Librarymembertypes l WHERE l.code = :code")
    , @NamedQuery(name = "Librarymembertypes.findByName", query = "SELECT l FROM Librarymembertypes l WHERE l.name = :name")
    , @NamedQuery(name = "Librarymembertypes.findByIsstudent", query = "SELECT l FROM Librarymembertypes l WHERE l.isstudent = :isstudent")
    , @NamedQuery(name = "Librarymembertypes.findByMaxborrow", query = "SELECT l FROM Librarymembertypes l WHERE l.maxborrow = :maxborrow")
    , @NamedQuery(name = "Librarymembertypes.findByMaxlenddays", query = "SELECT l FROM Librarymembertypes l WHERE l.maxlenddays = :maxlenddays")})
public class Librarymembertypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarymembertypes")
    private Integer idlibrarymembertypes;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "isstudent")
    private int isstudent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxborrow")
    private int maxborrow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxlenddays")
    private int maxlenddays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member1")
    private Collection<Librarylendreceive> librarylendreceiveCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member1")
    private Collection<Librarylendstationery> librarylendstationeryCollection;

    public Librarymembertypes() {
    }

    public Librarymembertypes(Integer idlibrarymembertypes) {
        this.idlibrarymembertypes = idlibrarymembertypes;
    }

    public Librarymembertypes(Integer idlibrarymembertypes, String code, String name, int isstudent, int maxborrow, int maxlenddays) {
        this.idlibrarymembertypes = idlibrarymembertypes;
        this.code = code;
        this.name = name;
        this.isstudent = isstudent;
        this.maxborrow = maxborrow;
        this.maxlenddays = maxlenddays;
    }

    public Integer getIdlibrarymembertypes() {
        return idlibrarymembertypes;
    }

    public void setIdlibrarymembertypes(Integer idlibrarymembertypes) {
        this.idlibrarymembertypes = idlibrarymembertypes;
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

    public int getIsstudent() {
        return isstudent;
    }

    public void setIsstudent(int isstudent) {
        this.isstudent = isstudent;
    }

    public int getMaxborrow() {
        return maxborrow;
    }

    public void setMaxborrow(int maxborrow) {
        this.maxborrow = maxborrow;
    }

    public int getMaxlenddays() {
        return maxlenddays;
    }

    public void setMaxlenddays(int maxlenddays) {
        this.maxlenddays = maxlenddays;
    }

    @XmlTransient
    public Collection<Librarylendreceive> getLibrarylendreceiveCollection() {
        return librarylendreceiveCollection;
    }

    public void setLibrarylendreceiveCollection(Collection<Librarylendreceive> librarylendreceiveCollection) {
        this.librarylendreceiveCollection = librarylendreceiveCollection;
    }

    @XmlTransient
    public Collection<Librarylendstationery> getLibrarylendstationeryCollection() {
        return librarylendstationeryCollection;
    }

    public void setLibrarylendstationeryCollection(Collection<Librarylendstationery> librarylendstationeryCollection) {
        this.librarylendstationeryCollection = librarylendstationeryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarymembertypes != null ? idlibrarymembertypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarymembertypes)) {
            return false;
        }
        Librarymembertypes other = (Librarymembertypes) object;
        if ((this.idlibrarymembertypes == null && other.idlibrarymembertypes != null) || (this.idlibrarymembertypes != null && !this.idlibrarymembertypes.equals(other.idlibrarymembertypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarymembertypes[ idlibrarymembertypes=" + idlibrarymembertypes + " ]";
    }
    
}
