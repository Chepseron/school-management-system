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
@Table(name = "examgradingsystemglobalsetup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examgradingsystemglobalsetup.findAll", query = "SELECT e FROM Examgradingsystemglobalsetup e")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByIdexamgradingsystemglobalsetup", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.idexamgradingsystemglobalsetup = :idexamgradingsystemglobalsetup")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByNoofsubjects", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.noofsubjects = :noofsubjects")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByMinimalsubjects", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.minimalsubjects = :minimalsubjects")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByCat1", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.cat1 = :cat1")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByCat2", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.cat2 = :cat2")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByCat3", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.cat3 = :cat3")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByCat4", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.cat4 = :cat4")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByCatcontributions", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.catcontributions = :catcontributions")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByExam1", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.exam1 = :exam1")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByExam2", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.exam2 = :exam2")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByExam3", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.exam3 = :exam3")
    , @NamedQuery(name = "Examgradingsystemglobalsetup.findByExamcontributions", query = "SELECT e FROM Examgradingsystemglobalsetup e WHERE e.examcontributions = :examcontributions")})
public class Examgradingsystemglobalsetup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamgradingsystemglobalsetup")
    private Integer idexamgradingsystemglobalsetup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noofsubjects")
    private int noofsubjects;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minimalsubjects")
    private int minimalsubjects;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cat1")
    private int cat1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cat2")
    private int cat2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cat3")
    private int cat3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cat4")
    private int cat4;
    @Basic(optional = false)
    @NotNull
    @Column(name = "catcontributions")
    private int catcontributions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exam1")
    private int exam1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exam2")
    private int exam2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "exam3")
    private int exam3;
    @Basic(optional = false)
    @NotNull
    @Column(name = "examcontributions")
    private int examcontributions;
    @JoinColumn(name = "term", referencedColumnName = "idcalterm")
    @ManyToOne(optional = false)
    private Calterm term;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "form", referencedColumnName = "idforms")
    @ManyToOne(optional = false)
    private Forms form;
    @JoinColumn(name = "grading", referencedColumnName = "idexamgradingsystem")
    @ManyToOne(optional = false)
    private Examgradingsystem grading;

    public Examgradingsystemglobalsetup() {
    }

    public Examgradingsystemglobalsetup(Integer idexamgradingsystemglobalsetup) {
        this.idexamgradingsystemglobalsetup = idexamgradingsystemglobalsetup;
    }

    public Examgradingsystemglobalsetup(Integer idexamgradingsystemglobalsetup, int noofsubjects, int minimalsubjects, int cat1, int cat2, int cat3, int cat4, int catcontributions, int exam1, int exam2, int exam3, int examcontributions) {
        this.idexamgradingsystemglobalsetup = idexamgradingsystemglobalsetup;
        this.noofsubjects = noofsubjects;
        this.minimalsubjects = minimalsubjects;
        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
        this.cat4 = cat4;
        this.catcontributions = catcontributions;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
        this.examcontributions = examcontributions;
    }

    public Integer getIdexamgradingsystemglobalsetup() {
        return idexamgradingsystemglobalsetup;
    }

    public void setIdexamgradingsystemglobalsetup(Integer idexamgradingsystemglobalsetup) {
        this.idexamgradingsystemglobalsetup = idexamgradingsystemglobalsetup;
    }

    public int getNoofsubjects() {
        return noofsubjects;
    }

    public void setNoofsubjects(int noofsubjects) {
        this.noofsubjects = noofsubjects;
    }

    public int getMinimalsubjects() {
        return minimalsubjects;
    }

    public void setMinimalsubjects(int minimalsubjects) {
        this.minimalsubjects = minimalsubjects;
    }

    public int getCat1() {
        return cat1;
    }

    public void setCat1(int cat1) {
        this.cat1 = cat1;
    }

    public int getCat2() {
        return cat2;
    }

    public void setCat2(int cat2) {
        this.cat2 = cat2;
    }

    public int getCat3() {
        return cat3;
    }

    public void setCat3(int cat3) {
        this.cat3 = cat3;
    }

    public int getCat4() {
        return cat4;
    }

    public void setCat4(int cat4) {
        this.cat4 = cat4;
    }

    public int getCatcontributions() {
        return catcontributions;
    }

    public void setCatcontributions(int catcontributions) {
        this.catcontributions = catcontributions;
    }

    public int getExam1() {
        return exam1;
    }

    public void setExam1(int exam1) {
        this.exam1 = exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public void setExam2(int exam2) {
        this.exam2 = exam2;
    }

    public int getExam3() {
        return exam3;
    }

    public void setExam3(int exam3) {
        this.exam3 = exam3;
    }

    public int getExamcontributions() {
        return examcontributions;
    }

    public void setExamcontributions(int examcontributions) {
        this.examcontributions = examcontributions;
    }

    public Calterm getTerm() {
        return term;
    }

    public void setTerm(Calterm term) {
        this.term = term;
    }

    public Calyear getYear() {
        return year;
    }

    public void setYear(Calyear year) {
        this.year = year;
    }

    public Forms getForm() {
        return form;
    }

    public void setForm(Forms form) {
        this.form = form;
    }

    public Examgradingsystem getGrading() {
        return grading;
    }

    public void setGrading(Examgradingsystem grading) {
        this.grading = grading;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamgradingsystemglobalsetup != null ? idexamgradingsystemglobalsetup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examgradingsystemglobalsetup)) {
            return false;
        }
        Examgradingsystemglobalsetup other = (Examgradingsystemglobalsetup) object;
        if ((this.idexamgradingsystemglobalsetup == null && other.idexamgradingsystemglobalsetup != null) || (this.idexamgradingsystemglobalsetup != null && !this.idexamgradingsystemglobalsetup.equals(other.idexamgradingsystemglobalsetup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Examgradingsystemglobalsetup[ idexamgradingsystemglobalsetup=" + idexamgradingsystemglobalsetup + " ]";
    }
    
}
