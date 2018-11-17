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
@Table(name = "finledgeraccounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finledgeraccounts.findAll", query = "SELECT f FROM Finledgeraccounts f")
    , @NamedQuery(name = "Finledgeraccounts.findByIdfinledgeraccounts", query = "SELECT f FROM Finledgeraccounts f WHERE f.idfinledgeraccounts = :idfinledgeraccounts")
    , @NamedQuery(name = "Finledgeraccounts.findByCode", query = "SELECT f FROM Finledgeraccounts f WHERE f.code = :code")
    , @NamedQuery(name = "Finledgeraccounts.findByName", query = "SELECT f FROM Finledgeraccounts f WHERE f.name = :name")
    , @NamedQuery(name = "Finledgeraccounts.findByNormalbalance", query = "SELECT f FROM Finledgeraccounts f WHERE f.normalbalance = :normalbalance")})
public class Finledgeraccounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinledgeraccounts")
    private Integer idfinledgeraccounts;
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
    @Column(name = "normalbalance")
    private int normalbalance;
    @JoinColumn(name = "accountype", referencedColumnName = "idfinledgeraccountypes")
    @ManyToOne(optional = false)
    private Finledgeraccountypes accountype;
    @JoinColumn(name = "group", referencedColumnName = "idfinledgeraccountgroups")
    @ManyToOne(optional = false)
    private Finledgeraccountgroups group1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<Finledgeraccountbudget> finledgeraccountbudgetCollection;

    public Finledgeraccounts() {
    }

    public Finledgeraccounts(Integer idfinledgeraccounts) {
        this.idfinledgeraccounts = idfinledgeraccounts;
    }

    public Finledgeraccounts(Integer idfinledgeraccounts, String code, String name, int normalbalance) {
        this.idfinledgeraccounts = idfinledgeraccounts;
        this.code = code;
        this.name = name;
        this.normalbalance = normalbalance;
    }

    public Integer getIdfinledgeraccounts() {
        return idfinledgeraccounts;
    }

    public void setIdfinledgeraccounts(Integer idfinledgeraccounts) {
        this.idfinledgeraccounts = idfinledgeraccounts;
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

    public int getNormalbalance() {
        return normalbalance;
    }

    public void setNormalbalance(int normalbalance) {
        this.normalbalance = normalbalance;
    }

    public Finledgeraccountypes getAccountype() {
        return accountype;
    }

    public void setAccountype(Finledgeraccountypes accountype) {
        this.accountype = accountype;
    }

    public Finledgeraccountgroups getGroup1() {
        return group1;
    }

    public void setGroup1(Finledgeraccountgroups group1) {
        this.group1 = group1;
    }

    @XmlTransient
    public Collection<Finledgeraccountbudget> getFinledgeraccountbudgetCollection() {
        return finledgeraccountbudgetCollection;
    }

    public void setFinledgeraccountbudgetCollection(Collection<Finledgeraccountbudget> finledgeraccountbudgetCollection) {
        this.finledgeraccountbudgetCollection = finledgeraccountbudgetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinledgeraccounts != null ? idfinledgeraccounts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finledgeraccounts)) {
            return false;
        }
        Finledgeraccounts other = (Finledgeraccounts) object;
        if ((this.idfinledgeraccounts == null && other.idfinledgeraccounts != null) || (this.idfinledgeraccounts != null && !this.idfinledgeraccounts.equals(other.idfinledgeraccounts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finledgeraccounts[ idfinledgeraccounts=" + idfinledgeraccounts + " ]";
    }
    
}
