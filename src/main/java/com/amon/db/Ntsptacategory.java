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
@Table(name = "ntsptacategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ntsptacategory.findAll", query = "SELECT n FROM Ntsptacategory n")
    , @NamedQuery(name = "Ntsptacategory.findByIdntsptacategory", query = "SELECT n FROM Ntsptacategory n WHERE n.idntsptacategory = :idntsptacategory")
    , @NamedQuery(name = "Ntsptacategory.findByCode", query = "SELECT n FROM Ntsptacategory n WHERE n.code = :code")
    , @NamedQuery(name = "Ntsptacategory.findByName", query = "SELECT n FROM Ntsptacategory n WHERE n.name = :name")})
public class Ntsptacategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idntsptacategory")
    private Integer idntsptacategory;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ntsptacategory")
    private Collection<Ntspta> ntsptaCollection;

    public Ntsptacategory() {
    }

    public Ntsptacategory(Integer idntsptacategory) {
        this.idntsptacategory = idntsptacategory;
    }

    public Ntsptacategory(Integer idntsptacategory, String code, String name) {
        this.idntsptacategory = idntsptacategory;
        this.code = code;
        this.name = name;
    }

    public Integer getIdntsptacategory() {
        return idntsptacategory;
    }

    public void setIdntsptacategory(Integer idntsptacategory) {
        this.idntsptacategory = idntsptacategory;
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
    public Collection<Ntspta> getNtsptaCollection() {
        return ntsptaCollection;
    }

    public void setNtsptaCollection(Collection<Ntspta> ntsptaCollection) {
        this.ntsptaCollection = ntsptaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idntsptacategory != null ? idntsptacategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ntsptacategory)) {
            return false;
        }
        Ntsptacategory other = (Ntsptacategory) object;
        if ((this.idntsptacategory == null && other.idntsptacategory != null) || (this.idntsptacategory != null && !this.idntsptacategory.equals(other.idntsptacategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Ntsptacategory[ idntsptacategory=" + idntsptacategory + " ]";
    }
    
}
