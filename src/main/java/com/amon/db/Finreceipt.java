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
@Table(name = "finreceipt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finreceipt.findAll", query = "SELECT f FROM Finreceipt f")
    , @NamedQuery(name = "Finreceipt.findByIdfinreceipt", query = "SELECT f FROM Finreceipt f WHERE f.idfinreceipt = :idfinreceipt")
    , @NamedQuery(name = "Finreceipt.findByDatepaid", query = "SELECT f FROM Finreceipt f WHERE f.datepaid = :datepaid")
    , @NamedQuery(name = "Finreceipt.findByPayref", query = "SELECT f FROM Finreceipt f WHERE f.payref = :payref")
    , @NamedQuery(name = "Finreceipt.findByAmount", query = "SELECT f FROM Finreceipt f WHERE f.amount = :amount")})
public class Finreceipt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinreceipt")
    private Integer idfinreceipt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datepaid")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datepaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "payref")
    private String payref;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "student", referencedColumnName = "idstudent")
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "term", referencedColumnName = "idcalterm")
    @ManyToOne(optional = false)
    private Calterm term;
    @JoinColumn(name = "stream", referencedColumnName = "idstreams")
    @ManyToOne(optional = false)
    private Streams stream;
    @JoinColumn(name = "paybank", referencedColumnName = "idfinbanks")
    @ManyToOne(optional = false)
    private Finbanks paybank;
    @JoinColumn(name = "paymode", referencedColumnName = "idfinpaymentmodes")
    @ManyToOne(optional = false)
    private Finpaymentmodes paymode;

    public Finreceipt() {
    }

    public Finreceipt(Integer idfinreceipt) {
        this.idfinreceipt = idfinreceipt;
    }

    public Finreceipt(Integer idfinreceipt, Date datepaid, String payref, int amount) {
        this.idfinreceipt = idfinreceipt;
        this.datepaid = datepaid;
        this.payref = payref;
        this.amount = amount;
    }

    public Integer getIdfinreceipt() {
        return idfinreceipt;
    }

    public void setIdfinreceipt(Integer idfinreceipt) {
        this.idfinreceipt = idfinreceipt;
    }

    public Date getDatepaid() {
        return datepaid;
    }

    public void setDatepaid(Date datepaid) {
        this.datepaid = datepaid;
    }

    public String getPayref() {
        return payref;
    }

    public void setPayref(String payref) {
        this.payref = payref;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public Streams getStream() {
        return stream;
    }

    public void setStream(Streams stream) {
        this.stream = stream;
    }

    public Finbanks getPaybank() {
        return paybank;
    }

    public void setPaybank(Finbanks paybank) {
        this.paybank = paybank;
    }

    public Finpaymentmodes getPaymode() {
        return paymode;
    }

    public void setPaymode(Finpaymentmodes paymode) {
        this.paymode = paymode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinreceipt != null ? idfinreceipt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finreceipt)) {
            return false;
        }
        Finreceipt other = (Finreceipt) object;
        if ((this.idfinreceipt == null && other.idfinreceipt != null) || (this.idfinreceipt != null && !this.idfinreceipt.equals(other.idfinreceipt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finreceipt[ idfinreceipt=" + idfinreceipt + " ]";
    }
    
}
