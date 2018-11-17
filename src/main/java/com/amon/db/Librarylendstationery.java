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
@Table(name = "librarylendstationery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarylendstationery.findAll", query = "SELECT l FROM Librarylendstationery l")
    , @NamedQuery(name = "Librarylendstationery.findByIdlibrarylendstationery", query = "SELECT l FROM Librarylendstationery l WHERE l.idlibrarylendstationery = :idlibrarylendstationery")
    , @NamedQuery(name = "Librarylendstationery.findByDateissued", query = "SELECT l FROM Librarylendstationery l WHERE l.dateissued = :dateissued")
    , @NamedQuery(name = "Librarylendstationery.findByQty", query = "SELECT l FROM Librarylendstationery l WHERE l.qty = :qty")
    , @NamedQuery(name = "Librarylendstationery.findByDescription", query = "SELECT l FROM Librarylendstationery l WHERE l.description = :description")})
public class Librarylendstationery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarylendstationery")
    private Integer idlibrarylendstationery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateissued")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateissued;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "member", referencedColumnName = "idlibrarymembertypes")
    @ManyToOne(optional = false)
    private Librarymembertypes member1;

    public Librarylendstationery() {
    }

    public Librarylendstationery(Integer idlibrarylendstationery) {
        this.idlibrarylendstationery = idlibrarylendstationery;
    }

    public Librarylendstationery(Integer idlibrarylendstationery, Date dateissued, int qty, String description) {
        this.idlibrarylendstationery = idlibrarylendstationery;
        this.dateissued = dateissued;
        this.qty = qty;
        this.description = description;
    }

    public Integer getIdlibrarylendstationery() {
        return idlibrarylendstationery;
    }

    public void setIdlibrarylendstationery(Integer idlibrarylendstationery) {
        this.idlibrarylendstationery = idlibrarylendstationery;
    }

    public Date getDateissued() {
        return dateissued;
    }

    public void setDateissued(Date dateissued) {
        this.dateissued = dateissued;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Librarymembertypes getMember1() {
        return member1;
    }

    public void setMember1(Librarymembertypes member1) {
        this.member1 = member1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarylendstationery != null ? idlibrarylendstationery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarylendstationery)) {
            return false;
        }
        Librarylendstationery other = (Librarylendstationery) object;
        if ((this.idlibrarylendstationery == null && other.idlibrarylendstationery != null) || (this.idlibrarylendstationery != null && !this.idlibrarylendstationery.equals(other.idlibrarylendstationery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarylendstationery[ idlibrarylendstationery=" + idlibrarylendstationery + " ]";
    }
    
}
