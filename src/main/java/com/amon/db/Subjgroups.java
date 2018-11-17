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
@Table(name = "subjgroups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjgroups.findAll", query = "SELECT s FROM Subjgroups s")
    , @NamedQuery(name = "Subjgroups.findByIdsubjgroups", query = "SELECT s FROM Subjgroups s WHERE s.idsubjgroups = :idsubjgroups")
    , @NamedQuery(name = "Subjgroups.findByCode", query = "SELECT s FROM Subjgroups s WHERE s.code = :code")
    , @NamedQuery(name = "Subjgroups.findByName", query = "SELECT s FROM Subjgroups s WHERE s.name = :name")
    , @NamedQuery(name = "Subjgroups.findByStartposition", query = "SELECT s FROM Subjgroups s WHERE s.startposition = :startposition")})
public class Subjgroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubjgroups")
    private Integer idsubjgroups;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "startposition")
    private int startposition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Collection<Subj> subjCollection;

    public Subjgroups() {
    }

    public Subjgroups(Integer idsubjgroups) {
        this.idsubjgroups = idsubjgroups;
    }

    public Subjgroups(Integer idsubjgroups, String code, String name, int startposition) {
        this.idsubjgroups = idsubjgroups;
        this.code = code;
        this.name = name;
        this.startposition = startposition;
    }

    public Integer getIdsubjgroups() {
        return idsubjgroups;
    }

    public void setIdsubjgroups(Integer idsubjgroups) {
        this.idsubjgroups = idsubjgroups;
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

    public int getStartposition() {
        return startposition;
    }

    public void setStartposition(int startposition) {
        this.startposition = startposition;
    }

    @XmlTransient
    public Collection<Subj> getSubjCollection() {
        return subjCollection;
    }

    public void setSubjCollection(Collection<Subj> subjCollection) {
        this.subjCollection = subjCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubjgroups != null ? idsubjgroups.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjgroups)) {
            return false;
        }
        Subjgroups other = (Subjgroups) object;
        if ((this.idsubjgroups == null && other.idsubjgroups != null) || (this.idsubjgroups != null && !this.idsubjgroups.equals(other.idsubjgroups))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Subjgroups[ idsubjgroups=" + idsubjgroups + " ]";
    }
    
}
