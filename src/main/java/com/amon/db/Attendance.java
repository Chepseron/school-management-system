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
@Table(name = "attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a")
    , @NamedQuery(name = "Attendance.findByIdattendance", query = "SELECT a FROM Attendance a WHERE a.idattendance = :idattendance")
    , @NamedQuery(name = "Attendance.findByDate", query = "SELECT a FROM Attendance a WHERE a.date = :date")})
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idattendance")
    private Integer idattendance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "term", referencedColumnName = "idcalterm")
    @ManyToOne(optional = false)
    private Calterm term;
    @JoinColumn(name = "stream", referencedColumnName = "idstreams")
    @ManyToOne(optional = false)
    private Streams stream;

    public Attendance() {
    }

    public Attendance(Integer idattendance) {
        this.idattendance = idattendance;
    }

    public Attendance(Integer idattendance, Date date) {
        this.idattendance = idattendance;
        this.date = date;
    }

    public Integer getIdattendance() {
        return idattendance;
    }

    public void setIdattendance(Integer idattendance) {
        this.idattendance = idattendance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Streams getStream() {
        return stream;
    }

    public void setStream(Streams stream) {
        this.stream = stream;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idattendance != null ? idattendance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.idattendance == null && other.idattendance != null) || (this.idattendance != null && !this.idattendance.equals(other.idattendance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Attendance[ idattendance=" + idattendance + " ]";
    }
    
}
