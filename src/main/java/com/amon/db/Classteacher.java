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
@Table(name = "classteacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classteacher.findAll", query = "SELECT c FROM Classteacher c")
    , @NamedQuery(name = "Classteacher.findByIdclassteacher", query = "SELECT c FROM Classteacher c WHERE c.idclassteacher = :idclassteacher")})
public class Classteacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclassteacher")
    private Integer idclassteacher;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "teacher", referencedColumnName = "idteachers")
    @ManyToOne(optional = false)
    private Teachers teacher;
    @JoinColumn(name = "form", referencedColumnName = "idforms")
    @ManyToOne(optional = false)
    private Forms form;
    @JoinColumn(name = "stream", referencedColumnName = "idstreams")
    @ManyToOne(optional = false)
    private Streams stream;

    public Classteacher() {
    }

    public Classteacher(Integer idclassteacher) {
        this.idclassteacher = idclassteacher;
    }

    public Integer getIdclassteacher() {
        return idclassteacher;
    }

    public void setIdclassteacher(Integer idclassteacher) {
        this.idclassteacher = idclassteacher;
    }

    public Calyear getYear() {
        return year;
    }

    public void setYear(Calyear year) {
        this.year = year;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public Forms getForm() {
        return form;
    }

    public void setForm(Forms form) {
        this.form = form;
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
        hash += (idclassteacher != null ? idclassteacher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classteacher)) {
            return false;
        }
        Classteacher other = (Classteacher) object;
        if ((this.idclassteacher == null && other.idclassteacher != null) || (this.idclassteacher != null && !this.idclassteacher.equals(other.idclassteacher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Classteacher[ idclassteacher=" + idclassteacher + " ]";
    }
    
}
