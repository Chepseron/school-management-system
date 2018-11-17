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
@Table(name = "librarypublishers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarypublishers.findAll", query = "SELECT l FROM Librarypublishers l")
    , @NamedQuery(name = "Librarypublishers.findByIdlibrarypublishers", query = "SELECT l FROM Librarypublishers l WHERE l.idlibrarypublishers = :idlibrarypublishers")
    , @NamedQuery(name = "Librarypublishers.findByCode", query = "SELECT l FROM Librarypublishers l WHERE l.code = :code")
    , @NamedQuery(name = "Librarypublishers.findByName", query = "SELECT l FROM Librarypublishers l WHERE l.name = :name")})
public class Librarypublishers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarypublishers")
    private Integer idlibrarypublishers;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
    private Collection<Librarycatalog> librarycatalogCollection;

    public Librarypublishers() {
    }

    public Librarypublishers(Integer idlibrarypublishers) {
        this.idlibrarypublishers = idlibrarypublishers;
    }

    public Librarypublishers(Integer idlibrarypublishers, String code, String name) {
        this.idlibrarypublishers = idlibrarypublishers;
        this.code = code;
        this.name = name;
    }

    public Integer getIdlibrarypublishers() {
        return idlibrarypublishers;
    }

    public void setIdlibrarypublishers(Integer idlibrarypublishers) {
        this.idlibrarypublishers = idlibrarypublishers;
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
    public Collection<Librarycatalog> getLibrarycatalogCollection() {
        return librarycatalogCollection;
    }

    public void setLibrarycatalogCollection(Collection<Librarycatalog> librarycatalogCollection) {
        this.librarycatalogCollection = librarycatalogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarypublishers != null ? idlibrarypublishers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarypublishers)) {
            return false;
        }
        Librarypublishers other = (Librarypublishers) object;
        if ((this.idlibrarypublishers == null && other.idlibrarypublishers != null) || (this.idlibrarypublishers != null && !this.idlibrarypublishers.equals(other.idlibrarypublishers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarypublishers[ idlibrarypublishers=" + idlibrarypublishers + " ]";
    }
    
}
