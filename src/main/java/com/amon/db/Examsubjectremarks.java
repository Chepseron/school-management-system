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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "examsubjectremarks")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examsubjectremarks.findAll", query = "SELECT e FROM Examsubjectremarks e")
    , @NamedQuery(name = "Examsubjectremarks.findByIdexamsubjectremarks", query = "SELECT e FROM Examsubjectremarks e WHERE e.idexamsubjectremarks = :idexamsubjectremarks")
    , @NamedQuery(name = "Examsubjectremarks.findByComments", query = "SELECT e FROM Examsubjectremarks e WHERE e.comments = :comments")})
public class Examsubjectremarks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamsubjectremarks")
    private Integer idexamsubjectremarks;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "subject", referencedColumnName = "idsubj")
    @ManyToOne(optional = false)
    private Subj subject;
    @JoinColumn(name = "grade", referencedColumnName = "idexamgradingsystem")
    @ManyToOne(optional = false)
    private Examgradingsystem grade;

    public Examsubjectremarks() {
    }

    public Examsubjectremarks(Integer idexamsubjectremarks) {
        this.idexamsubjectremarks = idexamsubjectremarks;
    }

    public Examsubjectremarks(Integer idexamsubjectremarks, String comments) {
        this.idexamsubjectremarks = idexamsubjectremarks;
        this.comments = comments;
    }

    public Integer getIdexamsubjectremarks() {
        return idexamsubjectremarks;
    }

    public void setIdexamsubjectremarks(Integer idexamsubjectremarks) {
        this.idexamsubjectremarks = idexamsubjectremarks;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Subj getSubject() {
        return subject;
    }

    public void setSubject(Subj subject) {
        this.subject = subject;
    }

    public Examgradingsystem getGrade() {
        return grade;
    }

    public void setGrade(Examgradingsystem grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamsubjectremarks != null ? idexamsubjectremarks.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examsubjectremarks)) {
            return false;
        }
        Examsubjectremarks other = (Examsubjectremarks) object;
        if ((this.idexamsubjectremarks == null && other.idexamsubjectremarks != null) || (this.idexamsubjectremarks != null && !this.idexamsubjectremarks.equals(other.idexamsubjectremarks))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Examsubjectremarks[ idexamsubjectremarks=" + idexamsubjectremarks + " ]";
    }
    
}
