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
@Table(name = "districts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Districts.findAll", query = "SELECT d FROM Districts d")
    , @NamedQuery(name = "Districts.findByIddistricts", query = "SELECT d FROM Districts d WHERE d.iddistricts = :iddistricts")
    , @NamedQuery(name = "Districts.findByName", query = "SELECT d FROM Districts d WHERE d.name = :name")
    , @NamedQuery(name = "Districts.findByCode", query = "SELECT d FROM Districts d WHERE d.code = :code")})
public class Districts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddistricts")
    private Integer iddistricts;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "district")
    private Collection<Divisions> divisionsCollection;
    @JoinColumn(name = "county", referencedColumnName = "idcounties")
    @ManyToOne(optional = false)
    private Counties county;

    public Districts() {
    }

    public Districts(Integer iddistricts) {
        this.iddistricts = iddistricts;
    }

    public Districts(Integer iddistricts, String name, String code) {
        this.iddistricts = iddistricts;
        this.name = name;
        this.code = code;
    }

    public Integer getIddistricts() {
        return iddistricts;
    }

    public void setIddistricts(Integer iddistricts) {
        this.iddistricts = iddistricts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<Divisions> getDivisionsCollection() {
        return divisionsCollection;
    }

    public void setDivisionsCollection(Collection<Divisions> divisionsCollection) {
        this.divisionsCollection = divisionsCollection;
    }

    public Counties getCounty() {
        return county;
    }

    public void setCounty(Counties county) {
        this.county = county;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddistricts != null ? iddistricts.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Districts)) {
            return false;
        }
        Districts other = (Districts) object;
        if ((this.iddistricts == null && other.iddistricts != null) || (this.iddistricts != null && !this.iddistricts.equals(other.iddistricts))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Districts[ iddistricts=" + iddistricts + " ]";
    }
    
}
