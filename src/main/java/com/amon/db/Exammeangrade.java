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
@Table(name = "exammeangrade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exammeangrade.findAll", query = "SELECT e FROM Exammeangrade e")
    , @NamedQuery(name = "Exammeangrade.findByIdexammeangrade", query = "SELECT e FROM Exammeangrade e WHERE e.idexammeangrade = :idexammeangrade")
    , @NamedQuery(name = "Exammeangrade.findByCode", query = "SELECT e FROM Exammeangrade e WHERE e.code = :code")
    , @NamedQuery(name = "Exammeangrade.findByMin", query = "SELECT e FROM Exammeangrade e WHERE e.min = :min")
    , @NamedQuery(name = "Exammeangrade.findByMax", query = "SELECT e FROM Exammeangrade e WHERE e.max = :max")
    , @NamedQuery(name = "Exammeangrade.findByMarks", query = "SELECT e FROM Exammeangrade e WHERE e.marks = :marks")})
public class Exammeangrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexammeangrade")
    private Integer idexammeangrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "min")
    private int min;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max")
    private int max;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marks")
    private int marks;

    public Exammeangrade() {
    }

    public Exammeangrade(Integer idexammeangrade) {
        this.idexammeangrade = idexammeangrade;
    }

    public Exammeangrade(Integer idexammeangrade, String code, int min, int max, int marks) {
        this.idexammeangrade = idexammeangrade;
        this.code = code;
        this.min = min;
        this.max = max;
        this.marks = marks;
    }

    public Integer getIdexammeangrade() {
        return idexammeangrade;
    }

    public void setIdexammeangrade(Integer idexammeangrade) {
        this.idexammeangrade = idexammeangrade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexammeangrade != null ? idexammeangrade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exammeangrade)) {
            return false;
        }
        Exammeangrade other = (Exammeangrade) object;
        if ((this.idexammeangrade == null && other.idexammeangrade != null) || (this.idexammeangrade != null && !this.idexammeangrade.equals(other.idexammeangrade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Exammeangrade[ idexammeangrade=" + idexammeangrade + " ]";
    }
    
}
