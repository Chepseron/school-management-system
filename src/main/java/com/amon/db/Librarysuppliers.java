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
@Table(name = "librarysuppliers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarysuppliers.findAll", query = "SELECT l FROM Librarysuppliers l")
    , @NamedQuery(name = "Librarysuppliers.findByIdlibrarysuppliers", query = "SELECT l FROM Librarysuppliers l WHERE l.idlibrarysuppliers = :idlibrarysuppliers")
    , @NamedQuery(name = "Librarysuppliers.findByCode", query = "SELECT l FROM Librarysuppliers l WHERE l.code = :code")
    , @NamedQuery(name = "Librarysuppliers.findByName", query = "SELECT l FROM Librarysuppliers l WHERE l.name = :name")
    , @NamedQuery(name = "Librarysuppliers.findByMobile", query = "SELECT l FROM Librarysuppliers l WHERE l.mobile = :mobile")
    , @NamedQuery(name = "Librarysuppliers.findByEmail", query = "SELECT l FROM Librarysuppliers l WHERE l.email = :email")
    , @NamedQuery(name = "Librarysuppliers.findByTown", query = "SELECT l FROM Librarysuppliers l WHERE l.town = :town")})
public class Librarysuppliers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarysuppliers")
    private Integer idlibrarysuppliers;
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
    @Size(min = 1, max = 45)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "town")
    private String town;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Collection<Librarynewstationery> librarynewstationeryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Collection<Librarynewbookacquisition> librarynewbookacquisitionCollection;

    public Librarysuppliers() {
    }

    public Librarysuppliers(Integer idlibrarysuppliers) {
        this.idlibrarysuppliers = idlibrarysuppliers;
    }

    public Librarysuppliers(Integer idlibrarysuppliers, String code, String name, String mobile, String email, String town) {
        this.idlibrarysuppliers = idlibrarysuppliers;
        this.code = code;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.town = town;
    }

    public Integer getIdlibrarysuppliers() {
        return idlibrarysuppliers;
    }

    public void setIdlibrarysuppliers(Integer idlibrarysuppliers) {
        this.idlibrarysuppliers = idlibrarysuppliers;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @XmlTransient
    public Collection<Librarynewstationery> getLibrarynewstationeryCollection() {
        return librarynewstationeryCollection;
    }

    public void setLibrarynewstationeryCollection(Collection<Librarynewstationery> librarynewstationeryCollection) {
        this.librarynewstationeryCollection = librarynewstationeryCollection;
    }

    @XmlTransient
    public Collection<Librarynewbookacquisition> getLibrarynewbookacquisitionCollection() {
        return librarynewbookacquisitionCollection;
    }

    public void setLibrarynewbookacquisitionCollection(Collection<Librarynewbookacquisition> librarynewbookacquisitionCollection) {
        this.librarynewbookacquisitionCollection = librarynewbookacquisitionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarysuppliers != null ? idlibrarysuppliers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarysuppliers)) {
            return false;
        }
        Librarysuppliers other = (Librarysuppliers) object;
        if ((this.idlibrarysuppliers == null && other.idlibrarysuppliers != null) || (this.idlibrarysuppliers != null && !this.idlibrarysuppliers.equals(other.idlibrarysuppliers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarysuppliers[ idlibrarysuppliers=" + idlibrarysuppliers + " ]";
    }
    
}
