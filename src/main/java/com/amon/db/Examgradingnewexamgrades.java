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
@Table(name = "examgradingnewexamgrades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examgradingnewexamgrades.findAll", query = "SELECT e FROM Examgradingnewexamgrades e")
    , @NamedQuery(name = "Examgradingnewexamgrades.findByIdexamgradingnewexamgrades", query = "SELECT e FROM Examgradingnewexamgrades e WHERE e.idexamgradingnewexamgrades = :idexamgradingnewexamgrades")
    , @NamedQuery(name = "Examgradingnewexamgrades.findByMin", query = "SELECT e FROM Examgradingnewexamgrades e WHERE e.min = :min")
    , @NamedQuery(name = "Examgradingnewexamgrades.findByMax", query = "SELECT e FROM Examgradingnewexamgrades e WHERE e.max = :max")
    , @NamedQuery(name = "Examgradingnewexamgrades.findByGrade", query = "SELECT e FROM Examgradingnewexamgrades e WHERE e.grade = :grade")
    , @NamedQuery(name = "Examgradingnewexamgrades.findByPoints", query = "SELECT e FROM Examgradingnewexamgrades e WHERE e.points = :points")
    , @NamedQuery(name = "Examgradingnewexamgrades.findByTeachercomments", query = "SELECT e FROM Examgradingnewexamgrades e WHERE e.teachercomments = :teachercomments")
    , @NamedQuery(name = "Examgradingnewexamgrades.findByPrinccomments", query = "SELECT e FROM Examgradingnewexamgrades e WHERE e.princcomments = :princcomments")})
public class Examgradingnewexamgrades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamgradingnewexamgrades")
    private Integer idexamgradingnewexamgrades;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min")
    private int min;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max")
    private int max;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "grade")
    private String grade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private int points;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "teachercomments")
    private String teachercomments;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "princcomments")
    private String princcomments;
    @JoinColumn(name = "gradingsystem", referencedColumnName = "idexamgradingsystem")
    @ManyToOne(optional = false)
    private Examgradingsystem gradingsystem;

    public Examgradingnewexamgrades() {
    }

    public Examgradingnewexamgrades(Integer idexamgradingnewexamgrades) {
        this.idexamgradingnewexamgrades = idexamgradingnewexamgrades;
    }

    public Examgradingnewexamgrades(Integer idexamgradingnewexamgrades, int min, int max, String grade, int points, String teachercomments, String princcomments) {
        this.idexamgradingnewexamgrades = idexamgradingnewexamgrades;
        this.min = min;
        this.max = max;
        this.grade = grade;
        this.points = points;
        this.teachercomments = teachercomments;
        this.princcomments = princcomments;
    }

    public Integer getIdexamgradingnewexamgrades() {
        return idexamgradingnewexamgrades;
    }

    public void setIdexamgradingnewexamgrades(Integer idexamgradingnewexamgrades) {
        this.idexamgradingnewexamgrades = idexamgradingnewexamgrades;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTeachercomments() {
        return teachercomments;
    }

    public void setTeachercomments(String teachercomments) {
        this.teachercomments = teachercomments;
    }

    public String getPrinccomments() {
        return princcomments;
    }

    public void setPrinccomments(String princcomments) {
        this.princcomments = princcomments;
    }

    public Examgradingsystem getGradingsystem() {
        return gradingsystem;
    }

    public void setGradingsystem(Examgradingsystem gradingsystem) {
        this.gradingsystem = gradingsystem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamgradingnewexamgrades != null ? idexamgradingnewexamgrades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examgradingnewexamgrades)) {
            return false;
        }
        Examgradingnewexamgrades other = (Examgradingnewexamgrades) object;
        if ((this.idexamgradingnewexamgrades == null && other.idexamgradingnewexamgrades != null) || (this.idexamgradingnewexamgrades != null && !this.idexamgradingnewexamgrades.equals(other.idexamgradingnewexamgrades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Examgradingnewexamgrades[ idexamgradingnewexamgrades=" + idexamgradingnewexamgrades + " ]";
    }
    
}
