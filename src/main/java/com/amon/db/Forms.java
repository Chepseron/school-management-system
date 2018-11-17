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
@Table(name = "forms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forms.findAll", query = "SELECT f FROM Forms f")
    , @NamedQuery(name = "Forms.findByIdforms", query = "SELECT f FROM Forms f WHERE f.idforms = :idforms")
    , @NamedQuery(name = "Forms.findByCode", query = "SELECT f FROM Forms f WHERE f.code = :code")
    , @NamedQuery(name = "Forms.findByName", query = "SELECT f FROM Forms f WHERE f.name = :name")
    , @NamedQuery(name = "Forms.findByStreams", query = "SELECT f FROM Forms f WHERE f.streams = :streams")})
public class Forms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforms")
    private Integer idforms;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "streams")
    private int streams;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
    private Collection<Examgradingsystemglobalsetup> examgradingsystemglobalsetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
    private Collection<Studentsubjects> studentsubjectsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currentclass")
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
    private Collection<Finfeestructure> finfeestructureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
    private Collection<Classteacher> classteacherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
    private Collection<Librarycatalog> librarycatalogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
    private Collection<Finfeebalances> finfeebalancesCollection;

    public Forms() {
    }

    public Forms(Integer idforms) {
        this.idforms = idforms;
    }

    public Forms(Integer idforms, String code, String name, int streams) {
        this.idforms = idforms;
        this.code = code;
        this.name = name;
        this.streams = streams;
    }

    public Integer getIdforms() {
        return idforms;
    }

    public void setIdforms(Integer idforms) {
        this.idforms = idforms;
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

    public int getStreams() {
        return streams;
    }

    public void setStreams(int streams) {
        this.streams = streams;
    }

    @XmlTransient
    public Collection<Examgradingsystemglobalsetup> getExamgradingsystemglobalsetupCollection() {
        return examgradingsystemglobalsetupCollection;
    }

    public void setExamgradingsystemglobalsetupCollection(Collection<Examgradingsystemglobalsetup> examgradingsystemglobalsetupCollection) {
        this.examgradingsystemglobalsetupCollection = examgradingsystemglobalsetupCollection;
    }

    @XmlTransient
    public Collection<Studentsubjects> getStudentsubjectsCollection() {
        return studentsubjectsCollection;
    }

    public void setStudentsubjectsCollection(Collection<Studentsubjects> studentsubjectsCollection) {
        this.studentsubjectsCollection = studentsubjectsCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Finfeestructure> getFinfeestructureCollection() {
        return finfeestructureCollection;
    }

    public void setFinfeestructureCollection(Collection<Finfeestructure> finfeestructureCollection) {
        this.finfeestructureCollection = finfeestructureCollection;
    }

    @XmlTransient
    public Collection<Classteacher> getClassteacherCollection() {
        return classteacherCollection;
    }

    public void setClassteacherCollection(Collection<Classteacher> classteacherCollection) {
        this.classteacherCollection = classteacherCollection;
    }

    @XmlTransient
    public Collection<Librarycatalog> getLibrarycatalogCollection() {
        return librarycatalogCollection;
    }

    public void setLibrarycatalogCollection(Collection<Librarycatalog> librarycatalogCollection) {
        this.librarycatalogCollection = librarycatalogCollection;
    }

    @XmlTransient
    public Collection<Finfeebalances> getFinfeebalancesCollection() {
        return finfeebalancesCollection;
    }

    public void setFinfeebalancesCollection(Collection<Finfeebalances> finfeebalancesCollection) {
        this.finfeebalancesCollection = finfeebalancesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idforms != null ? idforms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forms)) {
            return false;
        }
        Forms other = (Forms) object;
        if ((this.idforms == null && other.idforms != null) || (this.idforms != null && !this.idforms.equals(other.idforms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Forms[ idforms=" + idforms + " ]";
    }
    
}
