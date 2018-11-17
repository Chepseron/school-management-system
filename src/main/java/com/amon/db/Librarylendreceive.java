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
@Table(name = "librarylendreceive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarylendreceive.findAll", query = "SELECT l FROM Librarylendreceive l")
    , @NamedQuery(name = "Librarylendreceive.findByIdlibrarylend", query = "SELECT l FROM Librarylendreceive l WHERE l.idlibrarylend = :idlibrarylend")
    , @NamedQuery(name = "Librarylendreceive.findByDayslent", query = "SELECT l FROM Librarylendreceive l WHERE l.dayslent = :dayslent")
    , @NamedQuery(name = "Librarylendreceive.findByDuedate", query = "SELECT l FROM Librarylendreceive l WHERE l.duedate = :duedate")})
public class Librarylendreceive implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarylend")
    private Integer idlibrarylend;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dayslent")
    private int dayslent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date duedate;
    @JoinColumn(name = "member", referencedColumnName = "idlibrarymembertypes")
    @ManyToOne(optional = false)
    private Librarymembertypes member1;
    @JoinColumn(name = "book", referencedColumnName = "idlibrarybookcategories")
    @ManyToOne(optional = false)
    private Librarybookcategories book;

    public Librarylendreceive() {
    }

    public Librarylendreceive(Integer idlibrarylend) {
        this.idlibrarylend = idlibrarylend;
    }

    public Librarylendreceive(Integer idlibrarylend, int dayslent, Date duedate) {
        this.idlibrarylend = idlibrarylend;
        this.dayslent = dayslent;
        this.duedate = duedate;
    }

    public Integer getIdlibrarylend() {
        return idlibrarylend;
    }

    public void setIdlibrarylend(Integer idlibrarylend) {
        this.idlibrarylend = idlibrarylend;
    }

    public int getDayslent() {
        return dayslent;
    }

    public void setDayslent(int dayslent) {
        this.dayslent = dayslent;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public Librarymembertypes getMember1() {
        return member1;
    }

    public void setMember1(Librarymembertypes member1) {
        this.member1 = member1;
    }

    public Librarybookcategories getBook() {
        return book;
    }

    public void setBook(Librarybookcategories book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarylend != null ? idlibrarylend.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarylendreceive)) {
            return false;
        }
        Librarylendreceive other = (Librarylendreceive) object;
        if ((this.idlibrarylend == null && other.idlibrarylend != null) || (this.idlibrarylend != null && !this.idlibrarylend.equals(other.idlibrarylend))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarylendreceive[ idlibrarylend=" + idlibrarylend + " ]";
    }
    
}
