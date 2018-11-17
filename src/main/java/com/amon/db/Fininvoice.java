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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "fininvoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fininvoice.findAll", query = "SELECT f FROM Fininvoice f")
    , @NamedQuery(name = "Fininvoice.findByIdfininvoice", query = "SELECT f FROM Fininvoice f WHERE f.idfininvoice = :idfininvoice")
    , @NamedQuery(name = "Fininvoice.findByInvoiceDate", query = "SELECT f FROM Fininvoice f WHERE f.invoiceDate = :invoiceDate")
    , @NamedQuery(name = "Fininvoice.findByDescription", query = "SELECT f FROM Fininvoice f WHERE f.description = :description")})
public class Fininvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfininvoice")
    private Integer idfininvoice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "invoiceDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "term", referencedColumnName = "idcalterm")
    @ManyToOne(optional = false)
    private Calterm term;
    @JoinColumn(name = "stream", referencedColumnName = "idstreams")
    @ManyToOne(optional = false)
    private Streams stream;

    public Fininvoice() {
    }

    public Fininvoice(Integer idfininvoice) {
        this.idfininvoice = idfininvoice;
    }

    public Fininvoice(Integer idfininvoice, Date invoiceDate, String description) {
        this.idfininvoice = idfininvoice;
        this.invoiceDate = invoiceDate;
        this.description = description;
    }

    public Integer getIdfininvoice() {
        return idfininvoice;
    }

    public void setIdfininvoice(Integer idfininvoice) {
        this.idfininvoice = idfininvoice;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (idfininvoice != null ? idfininvoice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fininvoice)) {
            return false;
        }
        Fininvoice other = (Fininvoice) object;
        if ((this.idfininvoice == null && other.idfininvoice != null) || (this.idfininvoice != null && !this.idfininvoice.equals(other.idfininvoice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Fininvoice[ idfininvoice=" + idfininvoice + " ]";
    }
    
}
