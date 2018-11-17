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
@Table(name = "finyear")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finyear.findAll", query = "SELECT f FROM Finyear f")
    , @NamedQuery(name = "Finyear.findByIdfiyear", query = "SELECT f FROM Finyear f WHERE f.idfiyear = :idfiyear")
    , @NamedQuery(name = "Finyear.findByName", query = "SELECT f FROM Finyear f WHERE f.name = :name")
    , @NamedQuery(name = "Finyear.findByCode", query = "SELECT f FROM Finyear f WHERE f.code = :code")})
public class Finyear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfiyear")
    private Integer idfiyear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;

    public Finyear() {
    }

    public Finyear(Integer idfiyear) {
        this.idfiyear = idfiyear;
    }

    public Finyear(Integer idfiyear, String name, String code) {
        this.idfiyear = idfiyear;
        this.name = name;
        this.code = code;
    }

    public Integer getIdfiyear() {
        return idfiyear;
    }

    public void setIdfiyear(Integer idfiyear) {
        this.idfiyear = idfiyear;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfiyear != null ? idfiyear.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finyear)) {
            return false;
        }
        Finyear other = (Finyear) object;
        if ((this.idfiyear == null && other.idfiyear != null) || (this.idfiyear != null && !this.idfiyear.equals(other.idfiyear))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finyear[ idfiyear=" + idfiyear + " ]";
    }
    
}
