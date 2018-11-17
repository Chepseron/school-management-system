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
@Table(name = "calterm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calterm.findAll", query = "SELECT c FROM Calterm c")
    , @NamedQuery(name = "Calterm.findByIdcalterm", query = "SELECT c FROM Calterm c WHERE c.idcalterm = :idcalterm")
    , @NamedQuery(name = "Calterm.findByName", query = "SELECT c FROM Calterm c WHERE c.name = :name")
    , @NamedQuery(name = "Calterm.findByCode", query = "SELECT c FROM Calterm c WHERE c.code = :code")})
public class Calterm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcalterm")
    private Integer idcalterm;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Examgradingsystemglobalsetup> examgradingsystemglobalsetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Fininvoice> fininvoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Studentsubjects> studentsubjectsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Finreceipt> finreceiptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Examteachersetup> examteachersetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Finfeestructure> finfeestructureCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Finfeebalances> finfeebalancesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Attendance> attendanceCollection;

    public Calterm() {
    }

    public Calterm(Integer idcalterm) {
        this.idcalterm = idcalterm;
    }

    public Calterm(Integer idcalterm, String name, String code) {
        this.idcalterm = idcalterm;
        this.name = name;
        this.code = code;
    }

    public Integer getIdcalterm() {
        return idcalterm;
    }

    public void setIdcalterm(Integer idcalterm) {
        this.idcalterm = idcalterm;
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
        hash += (idcalterm != null ? idcalterm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calterm)) {
            return false;
        }
        Calterm other = (Calterm) object;
        if ((this.idcalterm == null && other.idcalterm != null) || (this.idcalterm != null && !this.idcalterm.equals(other.idcalterm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Calterm[ idcalterm=" + idcalterm + " ]";
    }
    
}
