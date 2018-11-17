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
@Table(name = "finfeestructure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finfeestructure.findAll", query = "SELECT f FROM Finfeestructure f")
    , @NamedQuery(name = "Finfeestructure.findByIdfinfeestructure", query = "SELECT f FROM Finfeestructure f WHERE f.idfinfeestructure = :idfinfeestructure")
    , @NamedQuery(name = "Finfeestructure.findByAmount", query = "SELECT f FROM Finfeestructure f WHERE f.amount = :amount")})
public class Finfeestructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinfeestructure")
    private Integer idfinfeestructure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "term", referencedColumnName = "idcalterm")
    @ManyToOne(optional = false)
    private Calterm term;
    @JoinColumn(name = "form", referencedColumnName = "idforms")
    @ManyToOne(optional = false)
    private Forms form;
    @JoinColumn(name = "item", referencedColumnName = "idfinfeeitems")
    @ManyToOne(optional = false)
    private Finfeeitems item;

    public Finfeestructure() {
    }

    public Finfeestructure(Integer idfinfeestructure) {
        this.idfinfeestructure = idfinfeestructure;
    }

    public Finfeestructure(Integer idfinfeestructure, int amount) {
        this.idfinfeestructure = idfinfeestructure;
        this.amount = amount;
    }

    public Integer getIdfinfeestructure() {
        return idfinfeestructure;
    }

    public void setIdfinfeestructure(Integer idfinfeestructure) {
        this.idfinfeestructure = idfinfeestructure;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public Finfeeitems getItem() {
        return item;
    }

    public void setItem(Finfeeitems item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinfeestructure != null ? idfinfeestructure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finfeestructure)) {
            return false;
        }
        Finfeestructure other = (Finfeestructure) object;
        if ((this.idfinfeestructure == null && other.idfinfeestructure != null) || (this.idfinfeestructure != null && !this.idfinfeestructure.equals(other.idfinfeestructure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finfeestructure[ idfinfeestructure=" + idfinfeestructure + " ]";
    }
    
}
