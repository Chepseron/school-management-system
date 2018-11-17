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
@Table(name = "kcpegrade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kcpegrade.findAll", query = "SELECT k FROM Kcpegrade k")
    , @NamedQuery(name = "Kcpegrade.findByIdkcpegrade", query = "SELECT k FROM Kcpegrade k WHERE k.idkcpegrade = :idkcpegrade")
    , @NamedQuery(name = "Kcpegrade.findByGrade", query = "SELECT k FROM Kcpegrade k WHERE k.grade = :grade")
    , @NamedQuery(name = "Kcpegrade.findByName", query = "SELECT k FROM Kcpegrade k WHERE k.name = :name")
    , @NamedQuery(name = "Kcpegrade.findByPoints", query = "SELECT k FROM Kcpegrade k WHERE k.points = :points")})
public class Kcpegrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idkcpegrade")
    private Integer idkcpegrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "grade")
    private String grade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private int points;

    public Kcpegrade() {
    }

    public Kcpegrade(Integer idkcpegrade) {
        this.idkcpegrade = idkcpegrade;
    }

    public Kcpegrade(Integer idkcpegrade, String grade, String name, int points) {
        this.idkcpegrade = idkcpegrade;
        this.grade = grade;
        this.name = name;
        this.points = points;
    }

    public Integer getIdkcpegrade() {
        return idkcpegrade;
    }

    public void setIdkcpegrade(Integer idkcpegrade) {
        this.idkcpegrade = idkcpegrade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkcpegrade != null ? idkcpegrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kcpegrade)) {
            return false;
        }
        Kcpegrade other = (Kcpegrade) object;
        if ((this.idkcpegrade == null && other.idkcpegrade != null) || (this.idkcpegrade != null && !this.idkcpegrade.equals(other.idkcpegrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Kcpegrade[ idkcpegrade=" + idkcpegrade + " ]";
    }
    
}
