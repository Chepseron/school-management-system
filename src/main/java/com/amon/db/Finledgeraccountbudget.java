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
@Table(name = "finledgeraccountbudget")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finledgeraccountbudget.findAll", query = "SELECT f FROM Finledgeraccountbudget f")
    , @NamedQuery(name = "Finledgeraccountbudget.findByIdfinledgeraccountbudget", query = "SELECT f FROM Finledgeraccountbudget f WHERE f.idfinledgeraccountbudget = :idfinledgeraccountbudget")
    , @NamedQuery(name = "Finledgeraccountbudget.findByMonth", query = "SELECT f FROM Finledgeraccountbudget f WHERE f.month = :month")
    , @NamedQuery(name = "Finledgeraccountbudget.findByAmount", query = "SELECT f FROM Finledgeraccountbudget f WHERE f.amount = :amount")})
public class Finledgeraccountbudget implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinledgeraccountbudget")
    private Integer idfinledgeraccountbudget;
    @Basic(optional = false)
    @NotNull
    @Column(name = "month")
    private int month;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "year", referencedColumnName = "idcalyear")
    @ManyToOne(optional = false)
    private Calyear year;
    @JoinColumn(name = "account", referencedColumnName = "idfinledgeraccounts")
    @ManyToOne(optional = false)
    private Finledgeraccounts account;

    public Finledgeraccountbudget() {
    }

    public Finledgeraccountbudget(Integer idfinledgeraccountbudget) {
        this.idfinledgeraccountbudget = idfinledgeraccountbudget;
    }

    public Finledgeraccountbudget(Integer idfinledgeraccountbudget, int month, int amount) {
        this.idfinledgeraccountbudget = idfinledgeraccountbudget;
        this.month = month;
        this.amount = amount;
    }

    public Integer getIdfinledgeraccountbudget() {
        return idfinledgeraccountbudget;
    }

    public void setIdfinledgeraccountbudget(Integer idfinledgeraccountbudget) {
        this.idfinledgeraccountbudget = idfinledgeraccountbudget;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
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

    public Finledgeraccounts getAccount() {
        return account;
    }

    public void setAccount(Finledgeraccounts account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinledgeraccountbudget != null ? idfinledgeraccountbudget.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finledgeraccountbudget)) {
            return false;
        }
        Finledgeraccountbudget other = (Finledgeraccountbudget) object;
        if ((this.idfinledgeraccountbudget == null && other.idfinledgeraccountbudget != null) || (this.idfinledgeraccountbudget != null && !this.idfinledgeraccountbudget.equals(other.idfinledgeraccountbudget))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finledgeraccountbudget[ idfinledgeraccountbudget=" + idfinledgeraccountbudget + " ]";
    }
    
}
