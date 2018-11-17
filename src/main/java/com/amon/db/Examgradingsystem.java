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
@Table(name = "examgradingsystem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examgradingsystem.findAll", query = "SELECT e FROM Examgradingsystem e")
    , @NamedQuery(name = "Examgradingsystem.findByIdexamgradingsystem", query = "SELECT e FROM Examgradingsystem e WHERE e.idexamgradingsystem = :idexamgradingsystem")
    , @NamedQuery(name = "Examgradingsystem.findByCode", query = "SELECT e FROM Examgradingsystem e WHERE e.code = :code")
    , @NamedQuery(name = "Examgradingsystem.findByName", query = "SELECT e FROM Examgradingsystem e WHERE e.name = :name")})
public class Examgradingsystem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamgradingsystem")
    private Integer idexamgradingsystem;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gradingsystem")
    private Collection<Examgradingnewexamgrades> examgradingnewexamgradesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grading")
    private Collection<Examgradingsystemglobalsetup> examgradingsystemglobalsetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
    private Collection<Examsubjectremarks> examsubjectremarksCollection;

    public Examgradingsystem() {
    }

    public Examgradingsystem(Integer idexamgradingsystem) {
        this.idexamgradingsystem = idexamgradingsystem;
    }

    public Examgradingsystem(Integer idexamgradingsystem, String code, String name) {
        this.idexamgradingsystem = idexamgradingsystem;
        this.code = code;
        this.name = name;
    }

    public Integer getIdexamgradingsystem() {
        return idexamgradingsystem;
    }

    public void setIdexamgradingsystem(Integer idexamgradingsystem) {
        this.idexamgradingsystem = idexamgradingsystem;
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
    public Collection<Examgradingnewexamgrades> getExamgradingnewexamgradesCollection() {
        return examgradingnewexamgradesCollection;
    }

    public void setExamgradingnewexamgradesCollection(Collection<Examgradingnewexamgrades> examgradingnewexamgradesCollection) {
        this.examgradingnewexamgradesCollection = examgradingnewexamgradesCollection;
    }

    @XmlTransient
    public Collection<Examgradingsystemglobalsetup> getExamgradingsystemglobalsetupCollection() {
        return examgradingsystemglobalsetupCollection;
    }

    public void setExamgradingsystemglobalsetupCollection(Collection<Examgradingsystemglobalsetup> examgradingsystemglobalsetupCollection) {
        this.examgradingsystemglobalsetupCollection = examgradingsystemglobalsetupCollection;
    }

    @XmlTransient
    public Collection<Examsubjectremarks> getExamsubjectremarksCollection() {
        return examsubjectremarksCollection;
    }

    public void setExamsubjectremarksCollection(Collection<Examsubjectremarks> examsubjectremarksCollection) {
        this.examsubjectremarksCollection = examsubjectremarksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamgradingsystem != null ? idexamgradingsystem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examgradingsystem)) {
            return false;
        }
        Examgradingsystem other = (Examgradingsystem) object;
        if ((this.idexamgradingsystem == null && other.idexamgradingsystem != null) || (this.idexamgradingsystem != null && !this.idexamgradingsystem.equals(other.idexamgradingsystem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Examgradingsystem[ idexamgradingsystem=" + idexamgradingsystem + " ]";
    }
    
}
