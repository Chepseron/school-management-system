/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "studentsubjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studentsubjects.findAll", query = "SELECT s FROM Studentsubjects s")
    , @NamedQuery(name = "Studentsubjects.findByIdstudentsubjects", query = "SELECT s FROM Studentsubjects s WHERE s.idstudentsubjects = :idstudentsubjects")})
public class Studentsubjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstudentsubjects")
    private Integer idstudentsubjects;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "term", referencedColumnName = "idcalterm")
    @ManyToOne(optional = false)
    private Calterm term;
    @JoinColumn(name = "form", referencedColumnName = "idforms")
    @ManyToOne(optional = false)
    private Forms form;
    @JoinColumn(name = "subject", referencedColumnName = "idsubj")
    @ManyToOne(optional = false)
    private Subj subject;
    @JoinColumn(name = "student", referencedColumnName = "idstudent")
    @ManyToOne(optional = false)
    private Student student;

    public Studentsubjects() {
    }

    public Studentsubjects(Integer idstudentsubjects) {
        this.idstudentsubjects = idstudentsubjects;
    }

    public Integer getIdstudentsubjects() {
        return idstudentsubjects;
    }

    public void setIdstudentsubjects(Integer idstudentsubjects) {
        this.idstudentsubjects = idstudentsubjects;
    }

    public Calyear getYear() {
        return year;
    }

    public void setYear(Calyear year) {
        this.year = year;
    }

    public Calterm getTerm() {
        return term;
    }

    public void setTerm(Calterm term) {
        this.term = term;
    }

    public Forms getForm() {
        return form;
    }

    public void setForm(Forms form) {
        this.form = form;
    }

    public Subj getSubject() {
        return subject;
    }

    public void setSubject(Subj subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstudentsubjects != null ? idstudentsubjects.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studentsubjects)) {
            return false;
        }
        Studentsubjects other = (Studentsubjects) object;
        if ((this.idstudentsubjects == null && other.idstudentsubjects != null) || (this.idstudentsubjects != null && !this.idstudentsubjects.equals(other.idstudentsubjects))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Studentsubjects[ idstudentsubjects=" + idstudentsubjects + " ]";
    }
    
}
