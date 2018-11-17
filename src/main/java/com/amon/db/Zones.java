/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "zones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zones.findAll", query = "SELECT z FROM Zones z")
    , @NamedQuery(name = "Zones.findByIdzones", query = "SELECT z FROM Zones z WHERE z.idzones = :idzones")
    , @NamedQuery(name = "Zones.findByCode", query = "SELECT z FROM Zones z WHERE z.code = :code")
    , @NamedQuery(name = "Zones.findByName", query = "SELECT z FROM Zones z WHERE z.name = :name")})
public class Zones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idzones")
    private Integer idzones;
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
    @JoinColumn(name = "division", referencedColumnName = "iddivisions")
    @ManyToOne(optional = false)
    private Divisions division;

    public Zones() {
    }

    public Zones(Integer idzones) {
        this.idzones = idzones;
    }

    public Zones(Integer idzones, String code, String name) {
        this.idzones = idzones;
        this.code = code;
        this.name = name;
    }

    public Integer getIdzones() {
        return idzones;
    }

    public void setIdzones(Integer idzones) {
        this.idzones = idzones;
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

    public Divisions getDivision() {
        return division;
    }

    public void setDivision(Divisions division) {
        this.division = division;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idzones != null ? idzones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zones)) {
            return false;
        }
        Zones other = (Zones) object;
        if ((this.idzones == null && other.idzones != null) || (this.idzones != null && !this.idzones.equals(other.idzones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Zones[ idzones=" + idzones + " ]";
    }
    
}
