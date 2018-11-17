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
@Table(name = "ntsbogcategories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ntsbogcategories.findAll", query = "SELECT n FROM Ntsbogcategories n")
    , @NamedQuery(name = "Ntsbogcategories.findByIdntsbogcategories", query = "SELECT n FROM Ntsbogcategories n WHERE n.idntsbogcategories = :idntsbogcategories")
    , @NamedQuery(name = "Ntsbogcategories.findByCode", query = "SELECT n FROM Ntsbogcategories n WHERE n.code = :code")
    , @NamedQuery(name = "Ntsbogcategories.findByName", query = "SELECT n FROM Ntsbogcategories n WHERE n.name = :name")})
public class Ntsbogcategories implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idntsbogcategories")
    private Integer idntsbogcategories;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ntsbogcategory")
    private Collection<Ntsbog> ntsbogCollection;

    public Ntsbogcategories() {
    }

    public Ntsbogcategories(Integer idntsbogcategories) {
        this.idntsbogcategories = idntsbogcategories;
    }

    public Ntsbogcategories(Integer idntsbogcategories, String code, String name) {
        this.idntsbogcategories = idntsbogcategories;
        this.code = code;
        this.name = name;
    }

    public Integer getIdntsbogcategories() {
        return idntsbogcategories;
    }

    public void setIdntsbogcategories(Integer idntsbogcategories) {
        this.idntsbogcategories = idntsbogcategories;
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
    public Collection<Ntsbog> getNtsbogCollection() {
        return ntsbogCollection;
    }

    public void setNtsbogCollection(Collection<Ntsbog> ntsbogCollection) {
        this.ntsbogCollection = ntsbogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idntsbogcategories != null ? idntsbogcategories.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ntsbogcategories)) {
            return false;
        }
        Ntsbogcategories other = (Ntsbogcategories) object;
        if ((this.idntsbogcategories == null && other.idntsbogcategories != null) || (this.idntsbogcategories != null && !this.idntsbogcategories.equals(other.idntsbogcategories))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Ntsbogcategories[ idntsbogcategories=" + idntsbogcategories + " ]";
    }
    
}
