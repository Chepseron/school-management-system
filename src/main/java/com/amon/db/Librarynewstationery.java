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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "librarynewstationery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarynewstationery.findAll", query = "SELECT l FROM Librarynewstationery l")
    , @NamedQuery(name = "Librarynewstationery.findByIdlibrarynewstationery", query = "SELECT l FROM Librarynewstationery l WHERE l.idlibrarynewstationery = :idlibrarynewstationery")
    , @NamedQuery(name = "Librarynewstationery.findByDteacquired", query = "SELECT l FROM Librarynewstationery l WHERE l.dteacquired = :dteacquired")
    , @NamedQuery(name = "Librarynewstationery.findByQtyonhand", query = "SELECT l FROM Librarynewstationery l WHERE l.qtyonhand = :qtyonhand")
    , @NamedQuery(name = "Librarynewstationery.findByCost", query = "SELECT l FROM Librarynewstationery l WHERE l.cost = :cost")})
public class Librarynewstationery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarynewstationery")
    private Integer idlibrarynewstationery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dteacquired")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dteacquired;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtyonhand")
    private int qtyonhand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private int cost;
    @JoinColumn(name = "stationery", referencedColumnName = "idlibrarystationerycategories")
    @ManyToOne(optional = false)
    private Librarystationerycategories stationery;
    @JoinColumn(name = "supplier", referencedColumnName = "idlibrarysuppliers")
    @ManyToOne(optional = false)
    private Librarysuppliers supplier;

    public Librarynewstationery() {
    }

    public Librarynewstationery(Integer idlibrarynewstationery) {
        this.idlibrarynewstationery = idlibrarynewstationery;
    }

    public Librarynewstationery(Integer idlibrarynewstationery, Date dteacquired, int qtyonhand, int cost) {
        this.idlibrarynewstationery = idlibrarynewstationery;
        this.dteacquired = dteacquired;
        this.qtyonhand = qtyonhand;
        this.cost = cost;
    }

    public Integer getIdlibrarynewstationery() {
        return idlibrarynewstationery;
    }

    public void setIdlibrarynewstationery(Integer idlibrarynewstationery) {
        this.idlibrarynewstationery = idlibrarynewstationery;
    }

    public Date getDteacquired() {
        return dteacquired;
    }

    public void setDteacquired(Date dteacquired) {
        this.dteacquired = dteacquired;
    }

    public int getQtyonhand() {
        return qtyonhand;
    }

    public void setQtyonhand(int qtyonhand) {
        this.qtyonhand = qtyonhand;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Librarystationerycategories getStationery() {
        return stationery;
    }

    public void setStationery(Librarystationerycategories stationery) {
        this.stationery = stationery;
    }

    public Librarysuppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Librarysuppliers supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarynewstationery != null ? idlibrarynewstationery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarynewstationery)) {
            return false;
        }
        Librarynewstationery other = (Librarynewstationery) object;
        if ((this.idlibrarynewstationery == null && other.idlibrarynewstationery != null) || (this.idlibrarynewstationery != null && !this.idlibrarynewstationery.equals(other.idlibrarynewstationery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarynewstationery[ idlibrarynewstationery=" + idlibrarynewstationery + " ]";
    }
    
}
