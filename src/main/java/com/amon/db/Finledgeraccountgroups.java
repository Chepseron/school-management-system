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
@Table(name = "finledgeraccountgroups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finledgeraccountgroups.findAll", query = "SELECT f FROM Finledgeraccountgroups f")
    , @NamedQuery(name = "Finledgeraccountgroups.findByIdfinledgeraccountgroups", query = "SELECT f FROM Finledgeraccountgroups f WHERE f.idfinledgeraccountgroups = :idfinledgeraccountgroups")
    , @NamedQuery(name = "Finledgeraccountgroups.findByCode", query = "SELECT f FROM Finledgeraccountgroups f WHERE f.code = :code")
    , @NamedQuery(name = "Finledgeraccountgroups.findByName", query = "SELECT f FROM Finledgeraccountgroups f WHERE f.name = :name")})
public class Finledgeraccountgroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinledgeraccountgroups")
    private Integer idfinledgeraccountgroups;
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
    @JoinColumn(name = "category", referencedColumnName = "idfinledgergroupcategories")
    @ManyToOne(optional = false)
    private Finledgergroupcategories category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group1")
    private Collection<Finledgeraccounts> finledgeraccountsCollection;

    public Finledgeraccountgroups() {
    }

    public Finledgeraccountgroups(Integer idfinledgeraccountgroups) {
        this.idfinledgeraccountgroups = idfinledgeraccountgroups;
    }

    public Finledgeraccountgroups(Integer idfinledgeraccountgroups, String code, String name) {
        this.idfinledgeraccountgroups = idfinledgeraccountgroups;
        this.code = code;
        this.name = name;
    }

    public Integer getIdfinledgeraccountgroups() {
        return idfinledgeraccountgroups;
    }

    public void setIdfinledgeraccountgroups(Integer idfinledgeraccountgroups) {
        this.idfinledgeraccountgroups = idfinledgeraccountgroups;
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

    public Finledgergroupcategories getCategory() {
        return category;
    }

    public void setCategory(Finledgergroupcategories category) {
        this.category = category;
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
        hash += (idfinledgeraccountgroups != null ? idfinledgeraccountgroups.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finledgeraccountgroups)) {
            return false;
        }
        Finledgeraccountgroups other = (Finledgeraccountgroups) object;
        if ((this.idfinledgeraccountgroups == null && other.idfinledgeraccountgroups != null) || (this.idfinledgeraccountgroups != null && !this.idfinledgeraccountgroups.equals(other.idfinledgeraccountgroups))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finledgeraccountgroups[ idfinledgeraccountgroups=" + idfinledgeraccountgroups + " ]";
    }
    
}
