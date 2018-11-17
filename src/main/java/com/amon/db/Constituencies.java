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
@Table(name = "constituencies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constituencies.findAll", query = "SELECT c FROM Constituencies c")
    , @NamedQuery(name = "Constituencies.findByIdconstituencies", query = "SELECT c FROM Constituencies c WHERE c.idconstituencies = :idconstituencies")
    , @NamedQuery(name = "Constituencies.findByName", query = "SELECT c FROM Constituencies c WHERE c.name = :name")
    , @NamedQuery(name = "Constituencies.findByCode", query = "SELECT c FROM Constituencies c WHERE c.code = :code")})
public class Constituencies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconstituencies")
    private Integer idconstituencies;
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

    public Constituencies() {
    }

    public Constituencies(Integer idconstituencies) {
        this.idconstituencies = idconstituencies;
    }

    public Constituencies(Integer idconstituencies, String name, String code) {
        this.idconstituencies = idconstituencies;
        this.name = name;
        this.code = code;
    }

    public Integer getIdconstituencies() {
        return idconstituencies;
    }

    public void setIdconstituencies(Integer idconstituencies) {
        this.idconstituencies = idconstituencies;
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
        hash += (idconstituencies != null ? idconstituencies.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constituencies)) {
            return false;
        }
        Constituencies other = (Constituencies) object;
        if ((this.idconstituencies == null && other.idconstituencies != null) || (this.idconstituencies != null && !this.idconstituencies.equals(other.idconstituencies))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Constituencies[ idconstituencies=" + idconstituencies + " ]";
    }
    
}
