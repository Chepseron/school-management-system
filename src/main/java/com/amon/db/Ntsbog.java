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
@Table(name = "ntsbog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ntsbog.findAll", query = "SELECT n FROM Ntsbog n")
    , @NamedQuery(name = "Ntsbog.findByIdntsbog", query = "SELECT n FROM Ntsbog n WHERE n.idntsbog = :idntsbog")
    , @NamedQuery(name = "Ntsbog.findByName", query = "SELECT n FROM Ntsbog n WHERE n.name = :name")
    , @NamedQuery(name = "Ntsbog.findByNumber", query = "SELECT n FROM Ntsbog n WHERE n.number = :number")
    , @NamedQuery(name = "Ntsbog.findBySalutation", query = "SELECT n FROM Ntsbog n WHERE n.salutation = :salutation")
    , @NamedQuery(name = "Ntsbog.findByGender", query = "SELECT n FROM Ntsbog n WHERE n.gender = :gender")
    , @NamedQuery(name = "Ntsbog.findByMobile", query = "SELECT n FROM Ntsbog n WHERE n.mobile = :mobile")
    , @NamedQuery(name = "Ntsbog.findByResidence", query = "SELECT n FROM Ntsbog n WHERE n.residence = :residence")})
public class Ntsbog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idntsbog")
    private Integer idntsbog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "number")
    private String number;
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
    @JoinColumn(name = "ntsbogcategory", referencedColumnName = "idntsbogcategories")
    @ManyToOne(optional = false)
    private Ntsbogcategories ntsbogcategory;

    public Ntsbog() {
    }

    public Ntsbog(Integer idntsbog) {
        this.idntsbog = idntsbog;
    }

    public Ntsbog(Integer idntsbog, String name, String number, String salutation, String gender, String mobile, String residence) {
        this.idntsbog = idntsbog;
        this.name = name;
        this.number = number;
        this.salutation = salutation;
        this.gender = gender;
        this.mobile = mobile;
        this.residence = residence;
    }

    public Integer getIdntsbog() {
        return idntsbog;
    }

    public void setIdntsbog(Integer idntsbog) {
        this.idntsbog = idntsbog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Ntsbogcategories getNtsbogcategory() {
        return ntsbogcategory;
    }

    public void setNtsbogcategory(Ntsbogcategories ntsbogcategory) {
        this.ntsbogcategory = ntsbogcategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idntsbog != null ? idntsbog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ntsbog)) {
            return false;
        }
        Ntsbog other = (Ntsbog) object;
        if ((this.idntsbog == null && other.idntsbog != null) || (this.idntsbog != null && !this.idntsbog.equals(other.idntsbog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Ntsbog[ idntsbog=" + idntsbog + " ]";
    }
    
}
