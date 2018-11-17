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
@Table(name = "finledgergroupcategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finledgergroupcategories.findAll", query = "SELECT f FROM Finledgergroupcategories f")
    , @NamedQuery(name = "Finledgergroupcategories.findByIdfinledgergroupcategories", query = "SELECT f FROM Finledgergroupcategories f WHERE f.idfinledgergroupcategories = :idfinledgergroupcategories")
    , @NamedQuery(name = "Finledgergroupcategories.findByCode", query = "SELECT f FROM Finledgergroupcategories f WHERE f.code = :code")
    , @NamedQuery(name = "Finledgergroupcategories.findByName", query = "SELECT f FROM Finledgergroupcategories f WHERE f.name = :name")})
public class Finledgergroupcategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinledgergroupcategories")
    private Integer idfinledgergroupcategories;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Collection<Finledgeraccountgroups> finledgeraccountgroupsCollection;

    public Finledgergroupcategories() {
    }

    public Finledgergroupcategories(Integer idfinledgergroupcategories) {
        this.idfinledgergroupcategories = idfinledgergroupcategories;
    }

    public Finledgergroupcategories(Integer idfinledgergroupcategories, String code, String name) {
        this.idfinledgergroupcategories = idfinledgergroupcategories;
        this.code = code;
        this.name = name;
    }

    public Integer getIdfinledgergroupcategories() {
        return idfinledgergroupcategories;
    }

    public void setIdfinledgergroupcategories(Integer idfinledgergroupcategories) {
        this.idfinledgergroupcategories = idfinledgergroupcategories;
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
    public Collection<Finledgeraccountgroups> getFinledgeraccountgroupsCollection() {
        return finledgeraccountgroupsCollection;
    }

    public void setFinledgeraccountgroupsCollection(Collection<Finledgeraccountgroups> finledgeraccountgroupsCollection) {
        this.finledgeraccountgroupsCollection = finledgeraccountgroupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinledgergroupcategories != null ? idfinledgergroupcategories.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finledgergroupcategories)) {
            return false;
        }
        Finledgergroupcategories other = (Finledgergroupcategories) object;
        if ((this.idfinledgergroupcategories == null && other.idfinledgergroupcategories != null) || (this.idfinledgergroupcategories != null && !this.idfinledgergroupcategories.equals(other.idfinledgergroupcategories))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finledgergroupcategories[ idfinledgergroupcategories=" + idfinledgergroupcategories + " ]";
    }
    
}
