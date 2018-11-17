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
@Table(name = "counties")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Counties.findAll", query = "SELECT c FROM Counties c")
    , @NamedQuery(name = "Counties.findByIdcounties", query = "SELECT c FROM Counties c WHERE c.idcounties = :idcounties")
    , @NamedQuery(name = "Counties.findByName", query = "SELECT c FROM Counties c WHERE c.name = :name")
    , @NamedQuery(name = "Counties.findByCode", query = "SELECT c FROM Counties c WHERE c.code = :code")})
public class Counties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcounties")
    private Integer idcounties;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "county")
    private Collection<Districts> districtsCollection;

    public Counties() {
    }

    public Counties(Integer idcounties) {
        this.idcounties = idcounties;
    }

    public Counties(Integer idcounties, String name, String code) {
        this.idcounties = idcounties;
        this.name = name;
        this.code = code;
    }

    public Integer getIdcounties() {
        return idcounties;
    }

    public void setIdcounties(Integer idcounties) {
        this.idcounties = idcounties;
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
    public Collection<Districts> getDistrictsCollection() {
        return districtsCollection;
    }

    public void setDistrictsCollection(Collection<Districts> districtsCollection) {
        this.districtsCollection = districtsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcounties != null ? idcounties.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Counties)) {
            return false;
        }
        Counties other = (Counties) object;
        if ((this.idcounties == null && other.idcounties != null) || (this.idcounties != null && !this.idcounties.equals(other.idcounties))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Counties[ idcounties=" + idcounties + " ]";
    }
    
}
