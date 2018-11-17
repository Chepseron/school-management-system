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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "ntspta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ntspta.findAll", query = "SELECT n FROM Ntspta n")
    , @NamedQuery(name = "Ntspta.findByIdntspta", query = "SELECT n FROM Ntspta n WHERE n.idntspta = :idntspta")
    , @NamedQuery(name = "Ntspta.findByMembernumber", query = "SELECT n FROM Ntspta n WHERE n.membernumber = :membernumber")
    , @NamedQuery(name = "Ntspta.findByName", query = "SELECT n FROM Ntspta n WHERE n.name = :name")
    , @NamedQuery(name = "Ntspta.findBySalutation", query = "SELECT n FROM Ntspta n WHERE n.salutation = :salutation")
    , @NamedQuery(name = "Ntspta.findByGender", query = "SELECT n FROM Ntspta n WHERE n.gender = :gender")
    , @NamedQuery(name = "Ntspta.findByMobile", query = "SELECT n FROM Ntspta n WHERE n.mobile = :mobile")
    , @NamedQuery(name = "Ntspta.findByResidence", query = "SELECT n FROM Ntspta n WHERE n.residence = :residence")})
public class Ntspta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idntspta")
    private Integer idntspta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "membernumber")
    private String membernumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "salutation")
    private String salutation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobile")
    private String mobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "residence")
    private String residence;
    @JoinColumn(name = "ntsptacategory", referencedColumnName = "idntsptacategory")
    @ManyToOne(optional = false)
    private Ntsptacategory ntsptacategory;
    @JoinColumn(name = "stream", referencedColumnName = "idstreams")
    @ManyToOne(optional = false)
    private Streams stream;

    public Ntspta() {
    }

    public Ntspta(Integer idntspta) {
        this.idntspta = idntspta;
    }

    public Ntspta(Integer idntspta, String membernumber, String name, String salutation, String gender, String mobile, String residence) {
        this.idntspta = idntspta;
        this.membernumber = membernumber;
        this.name = name;
        this.salutation = salutation;
        this.gender = gender;
        this.mobile = mobile;
        this.residence = residence;
    }

    public Integer getIdntspta() {
        return idntspta;
    }

    public void setIdntspta(Integer idntspta) {
        this.idntspta = idntspta;
    }

    public String getMembernumber() {
        return membernumber;
    }

    public void setMembernumber(String membernumber) {
        this.membernumber = membernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Ntsptacategory getNtsptacategory() {
        return ntsptacategory;
    }

    public void setNtsptacategory(Ntsptacategory ntsptacategory) {
        this.ntsptacategory = ntsptacategory;
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
        hash += (idntspta != null ? idntspta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ntspta)) {
            return false;
        }
        Ntspta other = (Ntspta) object;
        if ((this.idntspta == null && other.idntspta != null) || (this.idntspta != null && !this.idntspta.equals(other.idntspta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Ntspta[ idntspta=" + idntspta + " ]";
    }
    
}
