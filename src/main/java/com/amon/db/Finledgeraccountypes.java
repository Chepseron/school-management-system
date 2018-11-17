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
@Table(name = "finledgeraccountypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finledgeraccountypes.findAll", query = "SELECT f FROM Finledgeraccountypes f")
    , @NamedQuery(name = "Finledgeraccountypes.findByIdfinledgeraccountypes", query = "SELECT f FROM Finledgeraccountypes f WHERE f.idfinledgeraccountypes = :idfinledgeraccountypes")
    , @NamedQuery(name = "Finledgeraccountypes.findByTypecode", query = "SELECT f FROM Finledgeraccountypes f WHERE f.typecode = :typecode")
    , @NamedQuery(name = "Finledgeraccountypes.findByTypename", query = "SELECT f FROM Finledgeraccountypes f WHERE f.typename = :typename")})
public class Finledgeraccountypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinledgeraccountypes")
    private Integer idfinledgeraccountypes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "typecode")
    private String typecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "typename")
    private String typename;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountype")
    private Collection<Finledgeraccounts> finledgeraccountsCollection;

    public Finledgeraccountypes() {
    }

    public Finledgeraccountypes(Integer idfinledgeraccountypes) {
        this.idfinledgeraccountypes = idfinledgeraccountypes;
    }

    public Finledgeraccountypes(Integer idfinledgeraccountypes, String typecode, String typename) {
        this.idfinledgeraccountypes = idfinledgeraccountypes;
        this.typecode = typecode;
        this.typename = typename;
    }

    public Integer getIdfinledgeraccountypes() {
        return idfinledgeraccountypes;
    }

    public void setIdfinledgeraccountypes(Integer idfinledgeraccountypes) {
        this.idfinledgeraccountypes = idfinledgeraccountypes;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @XmlTransient
    public Collection<Finledgeraccounts> getFinledgeraccountsCollection() {
        return finledgeraccountsCollection;
    }

    public void setFinledgeraccountsCollection(Collection<Finledgeraccounts> finledgeraccountsCollection) {
        this.finledgeraccountsCollection = finledgeraccountsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinledgeraccountypes != null ? idfinledgeraccountypes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finledgeraccountypes)) {
            return false;
        }
        Finledgeraccountypes other = (Finledgeraccountypes) object;
        if ((this.idfinledgeraccountypes == null && other.idfinledgeraccountypes != null) || (this.idfinledgeraccountypes != null && !this.idfinledgeraccountypes.equals(other.idfinledgeraccountypes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finledgeraccountypes[ idfinledgeraccountypes=" + idfinledgeraccountypes + " ]";
    }
    
}
