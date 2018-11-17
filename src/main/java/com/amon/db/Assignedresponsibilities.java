/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "assignedresponsibilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assignedresponsibilities.findAll", query = "SELECT a FROM Assignedresponsibilities a")
    , @NamedQuery(name = "Assignedresponsibilities.findByIdteacherresponsibilities", query = "SELECT a FROM Assignedresponsibilities a WHERE a.idteacherresponsibilities = :idteacherresponsibilities")
    , @NamedQuery(name = "Assignedresponsibilities.findByAssignedfrom", query = "SELECT a FROM Assignedresponsibilities a WHERE a.assignedfrom = :assignedfrom")
    , @NamedQuery(name = "Assignedresponsibilities.findByAssignedto", query = "SELECT a FROM Assignedresponsibilities a WHERE a.assignedto = :assignedto")})
public class Assignedresponsibilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idteacherresponsibilities")
    private Integer idteacherresponsibilities;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assignedfrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedfrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assignedto")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedto;
    @JoinColumn(name = "teacher", referencedColumnName = "idteachers")
    @ManyToOne
    private Teachers teacher;
    @JoinColumn(name = "student", referencedColumnName = "idstudent")
    @ManyToOne
    private Student student;
    @JoinColumn(name = "responsibility", referencedColumnName = "idresponsibilities")
    @ManyToOne(optional = false)
    private Responsibilities responsibility;

    public Assignedresponsibilities() {
    }

    public Assignedresponsibilities(Integer idteacherresponsibilities) {
        this.idteacherresponsibilities = idteacherresponsibilities;
    }

    public Assignedresponsibilities(Integer idteacherresponsibilities, Date assignedfrom, Date assignedto) {
        this.idteacherresponsibilities = idteacherresponsibilities;
        this.assignedfrom = assignedfrom;
        this.assignedto = assignedto;
    }

    public Integer getIdteacherresponsibilities() {
        return idteacherresponsibilities;
    }

    public void setIdteacherresponsibilities(Integer idteacherresponsibilities) {
        this.idteacherresponsibilities = idteacherresponsibilities;
    }

    public Date getAssignedfrom() {
        return assignedfrom;
    }

    public void setAssignedfrom(Date assignedfrom) {
        this.assignedfrom = assignedfrom;
    }

    public Date getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(Date assignedto) {
        this.assignedto = assignedto;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Responsibilities getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(Responsibilities responsibility) {
        this.responsibility = responsibility;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idteacherresponsibilities != null ? idteacherresponsibilities.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assignedresponsibilities)) {
            return false;
        }
        Assignedresponsibilities other = (Assignedresponsibilities) object;
        if ((this.idteacherresponsibilities == null && other.idteacherresponsibilities != null) || (this.idteacherresponsibilities != null && !this.idteacherresponsibilities.equals(other.idteacherresponsibilities))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Assignedresponsibilities[ idteacherresponsibilities=" + idteacherresponsibilities + " ]";
    }
    
}
