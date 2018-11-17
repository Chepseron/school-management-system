/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "caltermyear")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caltermyear.findAll", query = "SELECT c FROM Caltermyear c")
    , @NamedQuery(name = "Caltermyear.findByIdcaltermyear", query = "SELECT c FROM Caltermyear c WHERE c.idcaltermyear = :idcaltermyear")
    , @NamedQuery(name = "Caltermyear.findByYear", query = "SELECT c FROM Caltermyear c WHERE c.year = :year")
    , @NamedQuery(name = "Caltermyear.findByTerm", query = "SELECT c FROM Caltermyear c WHERE c.term = :term")
    , @NamedQuery(name = "Caltermyear.findByStartdate", query = "SELECT c FROM Caltermyear c WHERE c.startdate = :startdate")
    , @NamedQuery(name = "Caltermyear.findByEnddate", query = "SELECT c FROM Caltermyear c WHERE c.enddate = :enddate")
    , @NamedQuery(name = "Caltermyear.findByIsnext", query = "SELECT c FROM Caltermyear c WHERE c.isnext = :isnext")})
public class Caltermyear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcaltermyear")
    private Integer idcaltermyear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "year")
    private int year;
    @Basic(optional = false)
    @NotNull
    @Column(name = "term")
    private int term;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "isnext")
    private String isnext;
    @JoinColumn(name = "state", referencedColumnName = "idstatus")
    @ManyToOne(optional = false)
    private Status state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "year")
    private Collection<Subjectallocation> subjectallocationCollection;

    public Caltermyear() {
    }

    public Caltermyear(Integer idcaltermyear) {
        this.idcaltermyear = idcaltermyear;
    }

    public Caltermyear(Integer idcaltermyear, int year, int term, Date startdate, Date enddate, String isnext) {
        this.idcaltermyear = idcaltermyear;
        this.year = year;
        this.term = term;
        this.startdate = startdate;
        this.enddate = enddate;
        this.isnext = isnext;
    }

    public Integer getIdcaltermyear() {
        return idcaltermyear;
    }

    public void setIdcaltermyear(Integer idcaltermyear) {
        this.idcaltermyear = idcaltermyear;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getIsnext() {
        return isnext;
    }

    public void setIsnext(String isnext) {
        this.isnext = isnext;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Subjectallocation> getSubjectallocationCollection() {
        return subjectallocationCollection;
    }

    public void setSubjectallocationCollection(Collection<Subjectallocation> subjectallocationCollection) {
        this.subjectallocationCollection = subjectallocationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcaltermyear != null ? idcaltermyear.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caltermyear)) {
            return false;
        }
        Caltermyear other = (Caltermyear) object;
        if ((this.idcaltermyear == null && other.idcaltermyear != null) || (this.idcaltermyear != null && !this.idcaltermyear.equals(other.idcaltermyear))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Caltermyear[ idcaltermyear=" + idcaltermyear + " ]";
    }
    
}
