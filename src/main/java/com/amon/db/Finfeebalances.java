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
@Table(name = "finfeebalances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finfeebalances.findAll", query = "SELECT f FROM Finfeebalances f")
    , @NamedQuery(name = "Finfeebalances.findByIdfinfeebalances", query = "SELECT f FROM Finfeebalances f WHERE f.idfinfeebalances = :idfinfeebalances")
    , @NamedQuery(name = "Finfeebalances.findByBalance", query = "SELECT f FROM Finfeebalances f WHERE f.balance = :balance")})
public class Finfeebalances implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinfeebalances")
    private Integer idfinfeebalances;
    @Basic(optional = false)
    @NotNull
    @Column(name = "balance")
    private int balance;
    @JoinColumn(name = "student", referencedColumnName = "idstudent")
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "term", referencedColumnName = "idcalterm")
    @ManyToOne(optional = false)
    private Calterm term;
    @JoinColumn(name = "form", referencedColumnName = "idforms")
    @ManyToOne(optional = false)
    private Forms form;

    public Finfeebalances() {
    }

    public Finfeebalances(Integer idfinfeebalances) {
        this.idfinfeebalances = idfinfeebalances;
    }

    public Finfeebalances(Integer idfinfeebalances, int balance) {
        this.idfinfeebalances = idfinfeebalances;
        this.balance = balance;
    }

    public Integer getIdfinfeebalances() {
        return idfinfeebalances;
    }

    public void setIdfinfeebalances(Integer idfinfeebalances) {
        this.idfinfeebalances = idfinfeebalances;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public Forms getForm() {
        return form;
    }

    public void setForm(Forms form) {
        this.form = form;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinfeebalances != null ? idfinfeebalances.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finfeebalances)) {
            return false;
        }
        Finfeebalances other = (Finfeebalances) object;
        if ((this.idfinfeebalances == null && other.idfinfeebalances != null) || (this.idfinfeebalances != null && !this.idfinfeebalances.equals(other.idfinfeebalances))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finfeebalances[ idfinfeebalances=" + idfinfeebalances + " ]";
    }
    
}
