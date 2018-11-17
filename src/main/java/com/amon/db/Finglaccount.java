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
@Table(name = "finglaccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finglaccount.findAll", query = "SELECT f FROM Finglaccount f")
    , @NamedQuery(name = "Finglaccount.findByIdfinglaccount", query = "SELECT f FROM Finglaccount f WHERE f.idfinglaccount = :idfinglaccount")
    , @NamedQuery(name = "Finglaccount.findByAccountnum", query = "SELECT f FROM Finglaccount f WHERE f.accountnum = :accountnum")
    , @NamedQuery(name = "Finglaccount.findByAccountname", query = "SELECT f FROM Finglaccount f WHERE f.accountname = :accountname")})
public class Finglaccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinglaccount")
    private Integer idfinglaccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "accountnum")
    private String accountnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "accountname")
    private String accountname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "glacc")
    private Collection<Finfeeitems> finfeeitemsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "glaccount")
    private Collection<Finbanks> finbanksCollection;

    public Finglaccount() {
    }

    public Finglaccount(Integer idfinglaccount) {
        this.idfinglaccount = idfinglaccount;
    }

    public Finglaccount(Integer idfinglaccount, String accountnum, String accountname) {
        this.idfinglaccount = idfinglaccount;
        this.accountnum = accountnum;
        this.accountname = accountname;
    }

    public Integer getIdfinglaccount() {
        return idfinglaccount;
    }

    public void setIdfinglaccount(Integer idfinglaccount) {
        this.idfinglaccount = idfinglaccount;
    }

    public String getAccountnum() {
        return accountnum;
    }

    public void setAccountnum(String accountnum) {
        this.accountnum = accountnum;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    @XmlTransient
    public Collection<Finfeeitems> getFinfeeitemsCollection() {
        return finfeeitemsCollection;
    }

    public void setFinfeeitemsCollection(Collection<Finfeeitems> finfeeitemsCollection) {
        this.finfeeitemsCollection = finfeeitemsCollection;
    }

    @XmlTransient
    public Collection<Finbanks> getFinbanksCollection() {
        return finbanksCollection;
    }

    public void setFinbanksCollection(Collection<Finbanks> finbanksCollection) {
        this.finbanksCollection = finbanksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinglaccount != null ? idfinglaccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finglaccount)) {
            return false;
        }
        Finglaccount other = (Finglaccount) object;
        if ((this.idfinglaccount == null && other.idfinglaccount != null) || (this.idfinglaccount != null && !this.idfinglaccount.equals(other.idfinglaccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finglaccount[ idfinglaccount=" + idfinglaccount + " ]";
    }
    
}
