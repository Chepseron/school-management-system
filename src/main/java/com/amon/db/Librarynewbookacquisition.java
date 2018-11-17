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
@Table(name = "librarynewbookacquisition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarynewbookacquisition.findAll", query = "SELECT l FROM Librarynewbookacquisition l")
    , @NamedQuery(name = "Librarynewbookacquisition.findByIdlibrarynewbookacquisition", query = "SELECT l FROM Librarynewbookacquisition l WHERE l.idlibrarynewbookacquisition = :idlibrarynewbookacquisition")
    , @NamedQuery(name = "Librarynewbookacquisition.findByAcquisitiondate", query = "SELECT l FROM Librarynewbookacquisition l WHERE l.acquisitiondate = :acquisitiondate")
    , @NamedQuery(name = "Librarynewbookacquisition.findByQuantity", query = "SELECT l FROM Librarynewbookacquisition l WHERE l.quantity = :quantity")
    , @NamedQuery(name = "Librarynewbookacquisition.findByCost", query = "SELECT l FROM Librarynewbookacquisition l WHERE l.cost = :cost")})
public class Librarynewbookacquisition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarynewbookacquisition")
    private Integer idlibrarynewbookacquisition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "acquisitiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acquisitiondate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private int cost;
    @JoinColumn(name = "book", referencedColumnName = "idlibrarybookcategories")
    @ManyToOne(optional = false)
    private Librarybookcategories book;
    @JoinColumn(name = "supplier", referencedColumnName = "idlibrarysuppliers")
    @ManyToOne(optional = false)
    private Librarysuppliers supplier;

    public Librarynewbookacquisition() {
    }

    public Librarynewbookacquisition(Integer idlibrarynewbookacquisition) {
        this.idlibrarynewbookacquisition = idlibrarynewbookacquisition;
    }

    public Librarynewbookacquisition(Integer idlibrarynewbookacquisition, Date acquisitiondate, int quantity, int cost) {
        this.idlibrarynewbookacquisition = idlibrarynewbookacquisition;
        this.acquisitiondate = acquisitiondate;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Integer getIdlibrarynewbookacquisition() {
        return idlibrarynewbookacquisition;
    }

    public void setIdlibrarynewbookacquisition(Integer idlibrarynewbookacquisition) {
        this.idlibrarynewbookacquisition = idlibrarynewbookacquisition;
    }

    public Date getAcquisitiondate() {
        return acquisitiondate;
    }

    public void setAcquisitiondate(Date acquisitiondate) {
        this.acquisitiondate = acquisitiondate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Librarybookcategories getBook() {
        return book;
    }

    public void setBook(Librarybookcategories book) {
        this.book = book;
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
        hash += (idlibrarynewbookacquisition != null ? idlibrarynewbookacquisition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarynewbookacquisition)) {
            return false;
        }
        Librarynewbookacquisition other = (Librarynewbookacquisition) object;
        if ((this.idlibrarynewbookacquisition == null && other.idlibrarynewbookacquisition != null) || (this.idlibrarynewbookacquisition != null && !this.idlibrarynewbookacquisition.equals(other.idlibrarynewbookacquisition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarynewbookacquisition[ idlibrarynewbookacquisition=" + idlibrarynewbookacquisition + " ]";
    }
    
}
