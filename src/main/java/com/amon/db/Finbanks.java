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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "finbanks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finbanks.findAll", query = "SELECT f FROM Finbanks f")
    , @NamedQuery(name = "Finbanks.findByIdfinbanks", query = "SELECT f FROM Finbanks f WHERE f.idfinbanks = :idfinbanks")
    , @NamedQuery(name = "Finbanks.findByCode", query = "SELECT f FROM Finbanks f WHERE f.code = :code")
    , @NamedQuery(name = "Finbanks.findByShortname", query = "SELECT f FROM Finbanks f WHERE f.shortname = :shortname")
    , @NamedQuery(name = "Finbanks.findByBankname", query = "SELECT f FROM Finbanks f WHERE f.bankname = :bankname")
    , @NamedQuery(name = "Finbanks.findByBankaccount", query = "SELECT f FROM Finbanks f WHERE f.bankaccount = :bankaccount")
    , @NamedQuery(name = "Finbanks.findByCurrency", query = "SELECT f FROM Finbanks f WHERE f.currency = :currency")})
public class Finbanks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinbanks")
    private Integer idfinbanks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "shortname")
    private String shortname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bankname")
    private String bankname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bankaccount")
    private String bankaccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "currency")
    private String currency;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paybank")
    private Collection<Finreceipt> finreceiptCollection;
    @JoinColumn(name = "glaccount", referencedColumnName = "idfinglaccount")
    @ManyToOne(optional = false)
    private Finglaccount glaccount;

    public Finbanks() {
    }

    public Finbanks(Integer idfinbanks) {
        this.idfinbanks = idfinbanks;
    }

    public Finbanks(Integer idfinbanks, String code, String shortname, String bankname, String bankaccount, String currency) {
        this.idfinbanks = idfinbanks;
        this.code = code;
        this.shortname = shortname;
        this.bankname = bankname;
        this.bankaccount = bankaccount;
        this.currency = currency;
    }

    public Integer getIdfinbanks() {
        return idfinbanks;
    }

    public void setIdfinbanks(Integer idfinbanks) {
        this.idfinbanks = idfinbanks;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @XmlTransient
    public Collection<Finreceipt> getFinreceiptCollection() {
        return finreceiptCollection;
    }

    public void setFinreceiptCollection(Collection<Finreceipt> finreceiptCollection) {
        this.finreceiptCollection = finreceiptCollection;
    }

    public Finglaccount getGlaccount() {
        return glaccount;
    }

    public void setGlaccount(Finglaccount glaccount) {
        this.glaccount = glaccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinbanks != null ? idfinbanks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finbanks)) {
            return false;
        }
        Finbanks other = (Finbanks) object;
        if ((this.idfinbanks == null && other.idfinbanks != null) || (this.idfinbanks != null && !this.idfinbanks.equals(other.idfinbanks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finbanks[ idfinbanks=" + idfinbanks + " ]";
    }
    
}
