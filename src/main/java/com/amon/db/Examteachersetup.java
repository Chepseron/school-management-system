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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "examteachersetup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examteachersetup.findAll", query = "SELECT e FROM Examteachersetup e")
    , @NamedQuery(name = "Examteachersetup.findByIdexamteachersetup", query = "SELECT e FROM Examteachersetup e WHERE e.idexamteachersetup = :idexamteachersetup")
    , @NamedQuery(name = "Examteachersetup.findByCat", query = "SELECT e FROM Examteachersetup e WHERE e.cat = :cat")
    , @NamedQuery(name = "Examteachersetup.findByExam", query = "SELECT e FROM Examteachersetup e WHERE e.exam = :exam")})
public class Examteachersetup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamteachersetup")
    private Integer idexamteachersetup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cat")
    private int cat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exam")
    private int exam;
    @JoinColumn(name = "teacher", referencedColumnName = "idteachers")
    @ManyToOne(optional = false)
    private Teachers teacher;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "stream", referencedColumnName = "idstreams")
    @ManyToOne(optional = false)
    private Streams stream;
    @JoinColumn(name = "term", referencedColumnName = "idcalterm")
    @ManyToOne(optional = false)
    private Calterm term;
    @JoinColumn(name = "subject", referencedColumnName = "idsubj")
    @ManyToOne(optional = false)
    private Subj subject;
    @JoinColumn(name = "student", referencedColumnName = "idstudent")
    @ManyToOne(optional = false)
    private Student student;

    public Examteachersetup() {
    }

    public Examteachersetup(Integer idexamteachersetup) {
        this.idexamteachersetup = idexamteachersetup;
    }

    public Examteachersetup(Integer idexamteachersetup, int cat, int exam) {
        this.idexamteachersetup = idexamteachersetup;
        this.cat = cat;
        this.exam = exam;
    }

    public Integer getIdexamteachersetup() {
        return idexamteachersetup;
    }

    public void setIdexamteachersetup(Integer idexamteachersetup) {
        this.idexamteachersetup = idexamteachersetup;
    }

    public int getCat() {
        return cat;
    }

    public void setCat(int cat) {
        this.cat = cat;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public Calyear getYear() {
        return year;
    }

    public void setYear(Calyear year) {
        this.year = year;
    }

    public Streams getStream() {
        return stream;
    }

    public void setStream(Streams stream) {
        this.stream = stream;
    }

    public Calterm getTerm() {
        return term;
    }

    public void setTerm(Calterm term) {
        this.term = term;
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
        hash += (idexamteachersetup != null ? idexamteachersetup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examteachersetup)) {
            return false;
        }
        Examteachersetup other = (Examteachersetup) object;
        if ((this.idexamteachersetup == null && other.idexamteachersetup != null) || (this.idexamteachersetup != null && !this.idexamteachersetup.equals(other.idexamteachersetup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Examteachersetup[ idexamteachersetup=" + idexamteachersetup + " ]";
    }
    
}
