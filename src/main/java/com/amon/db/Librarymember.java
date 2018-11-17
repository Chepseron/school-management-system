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
@Table(name = "librarymember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarymember.findAll", query = "SELECT l FROM Librarymember l")
    , @NamedQuery(name = "Librarymember.findByIdlibrarymember", query = "SELECT l FROM Librarymember l WHERE l.idlibrarymember = :idlibrarymember")
    , @NamedQuery(name = "Librarymember.findById", query = "SELECT l FROM Librarymember l WHERE l.id = :id")
    , @NamedQuery(name = "Librarymember.findByMember", query = "SELECT l FROM Librarymember l WHERE l.member = :member")
    , @NamedQuery(name = "Librarymember.findByMembertype", query = "SELECT l FROM Librarymember l WHERE l.membertype = :membertype")
    , @NamedQuery(name = "Librarymember.findByMobile", query = "SELECT l FROM Librarymember l WHERE l.mobile = :mobile")
    , @NamedQuery(name = "Librarymember.findByBorrowmax", query = "SELECT l FROM Librarymember l WHERE l.borrowmax = :borrowmax")
    , @NamedQuery(name = "Librarymember.findByJoindate", query = "SELECT l FROM Librarymember l WHERE l.joindate = :joindate")
    , @NamedQuery(name = "Librarymember.findByExpirydate", query = "SELECT l FROM Librarymember l WHERE l.expirydate = :expirydate")})
public class Librarymember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarymember")
    private Integer idlibrarymember;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "member")
    private String member;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "membertype")
    private String membertype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobile")
    private String mobile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "borrowmax")
    private int borrowmax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "joindate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date joindate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expirydate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirydate;

    public Librarymember() {
    }

    public Librarymember(Integer idlibrarymember) {
        this.idlibrarymember = idlibrarymember;
    }

    public Librarymember(Integer idlibrarymember, String id, String member, String membertype, String mobile, int borrowmax, Date joindate, Date expirydate) {
        this.idlibrarymember = idlibrarymember;
        this.id = id;
        this.member = member;
        this.membertype = membertype;
        this.mobile = mobile;
        this.borrowmax = borrowmax;
        this.joindate = joindate;
        this.expirydate = expirydate;
    }

    public Integer getIdlibrarymember() {
        return idlibrarymember;
    }

    public void setIdlibrarymember(Integer idlibrarymember) {
        this.idlibrarymember = idlibrarymember;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getMembertype() {
        return membertype;
    }

    public void setMembertype(String membertype) {
        this.membertype = membertype;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getBorrowmax() {
        return borrowmax;
    }

    public void setBorrowmax(int borrowmax) {
        this.borrowmax = borrowmax;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarymember != null ? idlibrarymember.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarymember)) {
            return false;
        }
        Librarymember other = (Librarymember) object;
        if ((this.idlibrarymember == null && other.idlibrarymember != null) || (this.idlibrarymember != null && !this.idlibrarymember.equals(other.idlibrarymember))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarymember[ idlibrarymember=" + idlibrarymember + " ]";
    }
    
}
