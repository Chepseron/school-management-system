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
@Table(name = "streams")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Streams.findAll", query = "SELECT s FROM Streams s")
    , @NamedQuery(name = "Streams.findByIdstreams", query = "SELECT s FROM Streams s WHERE s.idstreams = :idstreams")
    , @NamedQuery(name = "Streams.findByCode", query = "SELECT s FROM Streams s WHERE s.code = :code")
    , @NamedQuery(name = "Streams.findByName", query = "SELECT s FROM Streams s WHERE s.name = :name")})
public class Streams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstreams")
    private Integer idstreams;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Collection<Ntspta> ntsptaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Collection<Fininvoice> fininvoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Collection<Finreceipt> finreceiptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Collection<Subjectallocation> subjectallocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Collection<Examteachersetup> examteachersetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Collection<Classteacher> classteacherCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stream")
    private Collection<Attendance> attendanceCollection;

    public Streams() {
    }

    public Streams(Integer idstreams) {
        this.idstreams = idstreams;
    }

    public Streams(Integer idstreams, String code, String name) {
        this.idstreams = idstreams;
        this.code = code;
        this.name = name;
    }

    public Integer getIdstreams() {
        return idstreams;
    }

    public void setIdstreams(Integer idstreams) {
        this.idstreams = idstreams;
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
    public Collection<Ntspta> getNtsptaCollection() {
        return ntsptaCollection;
    }

    public void setNtsptaCollection(Collection<Ntspta> ntsptaCollection) {
        this.ntsptaCollection = ntsptaCollection;
    }

    @XmlTransient
    public Collection<Fininvoice> getFininvoiceCollection() {
        return fininvoiceCollection;
    }

    public void setFininvoiceCollection(Collection<Fininvoice> fininvoiceCollection) {
        this.fininvoiceCollection = fininvoiceCollection;
    }

    @XmlTransient
    public Collection<Finreceipt> getFinreceiptCollection() {
        return finreceiptCollection;
    }

    public void setFinreceiptCollection(Collection<Finreceipt> finreceiptCollection) {
        this.finreceiptCollection = finreceiptCollection;
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
    public Collection<Classteacher> getClassteacherCollection() {
        return classteacherCollection;
    }

    public void setClassteacherCollection(Collection<Classteacher> classteacherCollection) {
        this.classteacherCollection = classteacherCollection;
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
        hash += (idstreams != null ? idstreams.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Streams)) {
            return false;
        }
        Streams other = (Streams) object;
        if ((this.idstreams == null && other.idstreams != null) || (this.idstreams != null && !this.idstreams.equals(other.idstreams))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Streams[ idstreams=" + idstreams + " ]";
    }
    
}
