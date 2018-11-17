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
@Table(name = "subjectallocation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjectallocation.findAll", query = "SELECT s FROM Subjectallocation s")
    , @NamedQuery(name = "Subjectallocation.findByIdsubjectallocation", query = "SELECT s FROM Subjectallocation s WHERE s.idsubjectallocation = :idsubjectallocation")})
public class Subjectallocation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubjectallocation")
    private Integer idsubjectallocation;
    @JoinColumn(name = "teacher", referencedColumnName = "idteachers")
    @ManyToOne(optional = false)
    private Teachers teacher;
    @JoinColumn(name = "subjectid", referencedColumnName = "idsubj")
    @ManyToOne(optional = false)
    private Subj subjectid;
    @JoinColumn(name = "stream", referencedColumnName = "idstreams")
    @ManyToOne(optional = false)
    private Streams stream;
    @JoinColumn(name = "year", referencedColumnName = "idcaltermyear")
    @ManyToOne(optional = false)
    private Caltermyear year;

    public Subjectallocation() {
    }

    public Subjectallocation(Integer idsubjectallocation) {
        this.idsubjectallocation = idsubjectallocation;
    }

    public Integer getIdsubjectallocation() {
        return idsubjectallocation;
    }

    public void setIdsubjectallocation(Integer idsubjectallocation) {
        this.idsubjectallocation = idsubjectallocation;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public Subj getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Subj subjectid) {
        this.subjectid = subjectid;
    }

    public Streams getStream() {
        return stream;
    }

    public void setStream(Streams stream) {
        this.stream = stream;
    }

    public Caltermyear getYear() {
        return year;
    }

    public void setYear(Caltermyear year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubjectallocation != null ? idsubjectallocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjectallocation)) {
            return false;
        }
        Subjectallocation other = (Subjectallocation) object;
        if ((this.idsubjectallocation == null && other.idsubjectallocation != null) || (this.idsubjectallocation != null && !this.idsubjectallocation.equals(other.idsubjectallocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Subjectallocation[ idsubjectallocation=" + idsubjectallocation + " ]";
    }
    
}
