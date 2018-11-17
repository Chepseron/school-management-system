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
@Table(name = "divisions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Divisions.findAll", query = "SELECT d FROM Divisions d")
    , @NamedQuery(name = "Divisions.findByIddivisions", query = "SELECT d FROM Divisions d WHERE d.iddivisions = :iddivisions")
    , @NamedQuery(name = "Divisions.findByName", query = "SELECT d FROM Divisions d WHERE d.name = :name")
    , @NamedQuery(name = "Divisions.findByCode", query = "SELECT d FROM Divisions d WHERE d.code = :code")})
public class Divisions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddivisions")
    private Integer iddivisions;
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
    @JoinColumn(name = "district", referencedColumnName = "iddistricts")
    @ManyToOne(optional = false)
    private Districts district;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Collection<Zones> zonesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Collection<Location> locationCollection;

    public Divisions() {
    }

    public Divisions(Integer iddivisions) {
        this.iddivisions = iddivisions;
    }

    public Divisions(Integer iddivisions, String name, String code) {
        this.iddivisions = iddivisions;
        this.name = name;
        this.code = code;
    }

    public Integer getIddivisions() {
        return iddivisions;
    }

    public void setIddivisions(Integer iddivisions) {
        this.iddivisions = iddivisions;
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

    public Districts getDistrict() {
        return district;
    }

    public void setDistrict(Districts district) {
        this.district = district;
    }

    @XmlTransient
    public Collection<Zones> getZonesCollection() {
        return zonesCollection;
    }

    public void setZonesCollection(Collection<Zones> zonesCollection) {
        this.zonesCollection = zonesCollection;
    }

    @XmlTransient
    public Collection<Location> getLocationCollection() {
        return locationCollection;
    }

    public void setLocationCollection(Collection<Location> locationCollection) {
        this.locationCollection = locationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddivisions != null ? iddivisions.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Divisions)) {
            return false;
        }
        Divisions other = (Divisions) object;
        if ((this.iddivisions == null && other.iddivisions != null) || (this.iddivisions != null && !this.iddivisions.equals(other.iddivisions))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Divisions[ iddivisions=" + iddivisions + " ]";
    }
    
}
