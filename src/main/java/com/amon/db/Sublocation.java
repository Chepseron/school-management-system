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
@Table(name = "sublocation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sublocation.findAll", query = "SELECT s FROM Sublocation s")
    , @NamedQuery(name = "Sublocation.findByIdsublocation", query = "SELECT s FROM Sublocation s WHERE s.idsublocation = :idsublocation")
    , @NamedQuery(name = "Sublocation.findByCode", query = "SELECT s FROM Sublocation s WHERE s.code = :code")
    , @NamedQuery(name = "Sublocation.findByName", query = "SELECT s FROM Sublocation s WHERE s.name = :name")})
public class Sublocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsublocation")
    private Integer idsublocation;
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
    @JoinColumn(name = "location", referencedColumnName = "idlocation")
    @ManyToOne(optional = false)
    private Location location;

    public Sublocation() {
    }

    public Sublocation(Integer idsublocation) {
        this.idsublocation = idsublocation;
    }

    public Sublocation(Integer idsublocation, String code, String name) {
        this.idsublocation = idsublocation;
        this.code = code;
        this.name = name;
    }

    public Integer getIdsublocation() {
        return idsublocation;
    }

    public void setIdsublocation(Integer idsublocation) {
        this.idsublocation = idsublocation;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsublocation != null ? idsublocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sublocation)) {
            return false;
        }
        Sublocation other = (Sublocation) object;
        if ((this.idsublocation == null && other.idsublocation != null) || (this.idsublocation != null && !this.idsublocation.equals(other.idsublocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Sublocation[ idsublocation=" + idsublocation + " ]";
    }
    
}
