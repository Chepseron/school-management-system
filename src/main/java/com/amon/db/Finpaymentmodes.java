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
@Table(name = "finpaymentmodes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finpaymentmodes.findAll", query = "SELECT f FROM Finpaymentmodes f")
    , @NamedQuery(name = "Finpaymentmodes.findByIdfinpaymentmodes", query = "SELECT f FROM Finpaymentmodes f WHERE f.idfinpaymentmodes = :idfinpaymentmodes")
    , @NamedQuery(name = "Finpaymentmodes.findByCode", query = "SELECT f FROM Finpaymentmodes f WHERE f.code = :code")
    , @NamedQuery(name = "Finpaymentmodes.findByDescription", query = "SELECT f FROM Finpaymentmodes f WHERE f.description = :description")
    , @NamedQuery(name = "Finpaymentmodes.findByName", query = "SELECT f FROM Finpaymentmodes f WHERE f.name = :name")})
public class Finpaymentmodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinpaymentmodes")
    private Integer idfinpaymentmodes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymode")
    private Collection<Finreceipt> finreceiptCollection;

    public Finpaymentmodes() {
    }

    public Finpaymentmodes(Integer idfinpaymentmodes) {
        this.idfinpaymentmodes = idfinpaymentmodes;
    }

    public Finpaymentmodes(Integer idfinpaymentmodes, String code, String description, String name) {
        this.idfinpaymentmodes = idfinpaymentmodes;
        this.code = code;
        this.description = description;
        this.name = name;
    }

    public Integer getIdfinpaymentmodes() {
        return idfinpaymentmodes;
    }

    public void setIdfinpaymentmodes(Integer idfinpaymentmodes) {
        this.idfinpaymentmodes = idfinpaymentmodes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Finreceipt> getFinreceiptCollection() {
        return finreceiptCollection;
    }

    public void setFinreceiptCollection(Collection<Finreceipt> finreceiptCollection) {
        this.finreceiptCollection = finreceiptCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinpaymentmodes != null ? idfinpaymentmodes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finpaymentmodes)) {
            return false;
        }
        Finpaymentmodes other = (Finpaymentmodes) object;
        if ((this.idfinpaymentmodes == null && other.idfinpaymentmodes != null) || (this.idfinpaymentmodes != null && !this.idfinpaymentmodes.equals(other.idfinpaymentmodes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finpaymentmodes[ idfinpaymentmodes=" + idfinpaymentmodes + " ]";
    }
    
}
