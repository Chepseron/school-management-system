/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "library")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Library.findAll", query = "SELECT l FROM Library l")
    , @NamedQuery(name = "Library.findByIdlibrary", query = "SELECT l FROM Library l WHERE l.idlibrary = :idlibrary")
    , @NamedQuery(name = "Library.findByName", query = "SELECT l FROM Library l WHERE l.name = :name")
    , @NamedQuery(name = "Library.findByOpeningtime", query = "SELECT l FROM Library l WHERE l.openingtime = :openingtime")
    , @NamedQuery(name = "Library.findByClosingtime", query = "SELECT l FROM Library l WHERE l.closingtime = :closingtime")
    , @NamedQuery(name = "Library.findByMaxholdingtime", query = "SELECT l FROM Library l WHERE l.maxholdingtime = :maxholdingtime")
    , @NamedQuery(name = "Library.findByPhysicaladdress", query = "SELECT l FROM Library l WHERE l.physicaladdress = :physicaladdress")
    , @NamedQuery(name = "Library.findByMobilephone", query = "SELECT l FROM Library l WHERE l.mobilephone = :mobilephone")
    , @NamedQuery(name = "Library.findByEmail", query = "SELECT l FROM Library l WHERE l.email = :email")})
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrary")
    private Integer idlibrary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "openingtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openingtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "closingtime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date closingtime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "maxholdingtime")
    private int maxholdingtime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "physicaladdress")
    private String physicaladdress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobilephone")
    private String mobilephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;

    public Library() {
    }

    public Library(Integer idlibrary) {
        this.idlibrary = idlibrary;
    }

    public Library(Integer idlibrary, String name, Date openingtime, Date closingtime, int maxholdingtime, String physicaladdress, String mobilephone, String email) {
        this.idlibrary = idlibrary;
        this.name = name;
        this.openingtime = openingtime;
        this.closingtime = closingtime;
        this.maxholdingtime = maxholdingtime;
        this.physicaladdress = physicaladdress;
        this.mobilephone = mobilephone;
        this.email = email;
    }

    public Integer getIdlibrary() {
        return idlibrary;
    }

    public void setIdlibrary(Integer idlibrary) {
        this.idlibrary = idlibrary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOpeningtime() {
        return openingtime;
    }

    public void setOpeningtime(Date openingtime) {
        this.openingtime = openingtime;
    }

    public Date getClosingtime() {
        return closingtime;
    }

    public void setClosingtime(Date closingtime) {
        this.closingtime = closingtime;
    }

    public int getMaxholdingtime() {
        return maxholdingtime;
    }

    public void setMaxholdingtime(int maxholdingtime) {
        this.maxholdingtime = maxholdingtime;
    }

    public String getPhysicaladdress() {
        return physicaladdress;
    }

    public void setPhysicaladdress(String physicaladdress) {
        this.physicaladdress = physicaladdress;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrary != null ? idlibrary.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Library)) {
            return false;
        }
        Library other = (Library) object;
        if ((this.idlibrary == null && other.idlibrary != null) || (this.idlibrary != null && !this.idlibrary.equals(other.idlibrary))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Library[ idlibrary=" + idlibrary + " ]";
    }
    
}
