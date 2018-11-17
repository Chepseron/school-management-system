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
@Table(name = "finuom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finuom.findAll", query = "SELECT f FROM Finuom f")
    , @NamedQuery(name = "Finuom.findByIdfinuon", query = "SELECT f FROM Finuom f WHERE f.idfinuon = :idfinuon")
    , @NamedQuery(name = "Finuom.findByCode", query = "SELECT f FROM Finuom f WHERE f.code = :code")
    , @NamedQuery(name = "Finuom.findByName", query = "SELECT f FROM Finuom f WHERE f.name = :name")})
public class Finuom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinuon")
    private Integer idfinuon;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "uom")
    private Collection<Finfeeitems> finfeeitemsCollection;

    public Finuom() {
    }

    public Finuom(Integer idfinuon) {
        this.idfinuon = idfinuon;
    }

    public Finuom(Integer idfinuon, String code, String name) {
        this.idfinuon = idfinuon;
        this.code = code;
        this.name = name;
    }

    public Integer getIdfinuon() {
        return idfinuon;
    }

    public void setIdfinuon(Integer idfinuon) {
        this.idfinuon = idfinuon;
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
    public Collection<Finfeeitems> getFinfeeitemsCollection() {
        return finfeeitemsCollection;
    }

    public void setFinfeeitemsCollection(Collection<Finfeeitems> finfeeitemsCollection) {
        this.finfeeitemsCollection = finfeeitemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinuon != null ? idfinuon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finuom)) {
            return false;
        }
        Finuom other = (Finuom) object;
        if ((this.idfinuon == null && other.idfinuon != null) || (this.idfinuon != null && !this.idfinuon.equals(other.idfinuon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finuom[ idfinuon=" + idfinuon + " ]";
    }
    
}
