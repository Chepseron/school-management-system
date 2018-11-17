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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "subj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subj.findAll", query = "SELECT s FROM Subj s")
    , @NamedQuery(name = "Subj.findByIdsubj", query = "SELECT s FROM Subj s WHERE s.idsubj = :idsubj")
    , @NamedQuery(name = "Subj.findByCode", query = "SELECT s FROM Subj s WHERE s.code = :code")
    , @NamedQuery(name = "Subj.findByName", query = "SELECT s FROM Subj s WHERE s.name = :name")
    , @NamedQuery(name = "Subj.findByShortname", query = "SELECT s FROM Subj s WHERE s.shortname = :shortname")
    , @NamedQuery(name = "Subj.findByOfficialcode", query = "SELECT s FROM Subj s WHERE s.officialcode = :officialcode")
    , @NamedQuery(name = "Subj.findByOffered", query = "SELECT s FROM Subj s WHERE s.offered = :offered")})
public class Subj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubj")
    private Integer idsubj;
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
    @Size(min = 1, max = 45)
    @Column(name = "shortname")
    private String shortname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "officialcode")
    private String officialcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "offered")
    private String offered;
    @JoinColumn(name = "category", referencedColumnName = "idsubjgroups")
    @ManyToOne(optional = false)
    private Subjgroups category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Collection<Examsubjectremarks> examsubjectremarksCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Collection<Studentsubjects> studentsubjectsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subjectid")
    private Collection<Subjectallocation> subjectallocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Collection<Examteachersetup> examteachersetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    private Collection<Librarycatalog> librarycatalogCollection;

    public Subj() {
    }

    public Subj(Integer idsubj) {
        this.idsubj = idsubj;
    }

    public Subj(Integer idsubj, String code, String name, String shortname, String officialcode, String offered) {
        this.idsubj = idsubj;
        this.code = code;
        this.name = name;
        this.shortname = shortname;
        this.officialcode = officialcode;
        this.offered = offered;
    }

    public Integer getIdsubj() {
        return idsubj;
    }

    public void setIdsubj(Integer idsubj) {
        this.idsubj = idsubj;
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getOfficialcode() {
        return officialcode;
    }

    public void setOfficialcode(String officialcode) {
        this.officialcode = officialcode;
    }

    public String getOffered() {
        return offered;
    }

    public void setOffered(String offered) {
        this.offered = offered;
    }

    public Subjgroups getCategory() {
        return category;
    }

    public void setCategory(Subjgroups category) {
        this.category = category;
    }

    @XmlTransient
    public Collection<Examsubjectremarks> getExamsubjectremarksCollection() {
        return examsubjectremarksCollection;
    }

    public void setExamsubjectremarksCollection(Collection<Examsubjectremarks> examsubjectremarksCollection) {
        this.examsubjectremarksCollection = examsubjectremarksCollection;
    }

    @XmlTransient
    public Collection<Studentsubjects> getStudentsubjectsCollection() {
        return studentsubjectsCollection;
    }

    public void setStudentsubjectsCollection(Collection<Studentsubjects> studentsubjectsCollection) {
        this.studentsubjectsCollection = studentsubjectsCollection;
    }

    @XmlTransient
    public Collection<Subjectallocation> getSubjectallocationCollection() {
        return subjectallocationCollection;
    }

    public void setSubjectallocationCollection(Collection<Subjectallocation> subjectallocationCollection) {
        this.subjectallocationCollection = subjectallocationCollection;
    }

    @XmlTransient
    public Collection<Examteachersetup> getExamteachersetupCollection() {
        return examteachersetupCollection;
    }

    public void setExamteachersetupCollection(Collection<Examteachersetup> examteachersetupCollection) {
        this.examteachersetupCollection = examteachersetupCollection;
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
        hash += (idsubj != null ? idsubj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subj)) {
            return false;
        }
        Subj other = (Subj) object;
        if ((this.idsubj == null && other.idsubj != null) || (this.idsubj != null && !this.idsubj.equals(other.idsubj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Subj[ idsubj=" + idsubj + " ]";
    }
    
}
