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
@Table(name = "calyear")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calyear.findAll", query = "SELECT c FROM Calyear c")
    , @NamedQuery(name = "Calyear.findByIdcalyear", query = "SELECT c FROM Calyear c WHERE c.idcalyear = :idcalyear")
    , @NamedQuery(name = "Calyear.findByName", query = "SELECT c FROM Calyear c WHERE c.name = :name")
    , @NamedQuery(name = "Calyear.findByCode", query = "SELECT c FROM Calyear c WHERE c.code = :code")})
public class Calyear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcalyear")
    private Integer idcalyear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "name")
    private int name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Examgradingsystemglobalsetup> examgradingsystemglobalsetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Fininvoice> fininvoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Studentsubjects> studentsubjectsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Finledgeraccountbudget> finledgeraccountbudgetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Finreceipt> finreceiptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Examteachersetup> examteachersetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Finfeestructure> finfeestructureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Classteacher> classteacherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Finfeebalances> finfeebalancesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Attendance> attendanceCollection;

    public Calyear() {
    }

    public Calyear(Integer idcalyear) {
        this.idcalyear = idcalyear;
    }

    public Calyear(Integer idcalyear, int name, String code) {
        this.idcalyear = idcalyear;
        this.name = name;
        this.code = code;
    }

    public Integer getIdcalyear() {
        return idcalyear;
    }

    public void setIdcalyear(Integer idcalyear) {
        this.idcalyear = idcalyear;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<Examgradingsystemglobalsetup> getExamgradingsystemglobalsetupCollection() {
        return examgradingsystemglobalsetupCollection;
    }

    public void setExamgradingsystemglobalsetupCollection(Collection<Examgradingsystemglobalsetup> examgradingsystemglobalsetupCollection) {
        this.examgradingsystemglobalsetupCollection = examgradingsystemglobalsetupCollection;
    }

    @XmlTransient
    public Collection<Fininvoice> getFininvoiceCollection() {
        return fininvoiceCollection;
    }

    public void setFininvoiceCollection(Collection<Fininvoice> fininvoiceCollection) {
        this.fininvoiceCollection = fininvoiceCollection;
    }

    @XmlTransient
    public Collection<Studentsubjects> getStudentsubjectsCollection() {
        return studentsubjectsCollection;
    }

    public void setStudentsubjectsCollection(Collection<Studentsubjects> studentsubjectsCollection) {
        this.studentsubjectsCollection = studentsubjectsCollection;
    }

    @XmlTransient
    public Collection<Finledgeraccountbudget> getFinledgeraccountbudgetCollection() {
        return finledgeraccountbudgetCollection;
    }

    public void setFinledgeraccountbudgetCollection(Collection<Finledgeraccountbudget> finledgeraccountbudgetCollection) {
        this.finledgeraccountbudgetCollection = finledgeraccountbudgetCollection;
    }

    @XmlTransient
    public Collection<Finreceipt> getFinreceiptCollection() {
        return finreceiptCollection;
    }

    public void setFinreceiptCollection(Collection<Finreceipt> finreceiptCollection) {
        this.finreceiptCollection = finreceiptCollection;
    }

    @XmlTransient
    public Collection<Examteachersetup> getExamteachersetupCollection() {
        return examteachersetupCollection;
    }

    public void setExamteachersetupCollection(Collection<Examteachersetup> examteachersetupCollection) {
        this.examteachersetupCollection = examteachersetupCollection;
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
    public Collection<Finfeebalances> getFinfeebalancesCollection() {
        return finfeebalancesCollection;
    }

    public void setFinfeebalancesCollection(Collection<Finfeebalances> finfeebalancesCollection) {
        this.finfeebalancesCollection = finfeebalancesCollection;
    }

    @XmlTransient
    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcalyear != null ? idcalyear.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calyear)) {
            return false;
        }
        Calyear other = (Calyear) object;
        if ((this.idcalyear == null && other.idcalyear != null) || (this.idcalyear != null && !this.idcalyear.equals(other.idcalyear))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Calyear[ idcalyear=" + idcalyear + " ]";
    }
    
}
