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
@Table(name = "subjcombination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjcombination.findAll", query = "SELECT s FROM Subjcombination s")
    , @NamedQuery(name = "Subjcombination.findByIdsubjcombination", query = "SELECT s FROM Subjcombination s WHERE s.idsubjcombination = :idsubjcombination")
    , @NamedQuery(name = "Subjcombination.findByCombicode", query = "SELECT s FROM Subjcombination s WHERE s.combicode = :combicode")
    , @NamedQuery(name = "Subjcombination.findByCompulsory", query = "SELECT s FROM Subjcombination s WHERE s.compulsory = :compulsory")
    , @NamedQuery(name = "Subjcombination.findByCombinationname", query = "SELECT s FROM Subjcombination s WHERE s.combinationname = :combinationname")})
public class Subjcombination implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubjcombination")
    private Integer idsubjcombination;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "combicode")
    private String combicode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "compulsory")
    private int compulsory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "combinationname")
    private String combinationname;

    public Subjcombination() {
    }

    public Subjcombination(Integer idsubjcombination) {
        this.idsubjcombination = idsubjcombination;
    }

    public Subjcombination(Integer idsubjcombination, String combicode, int compulsory, String combinationname) {
        this.idsubjcombination = idsubjcombination;
        this.combicode = combicode;
        this.compulsory = compulsory;
        this.combinationname = combinationname;
    }

    public Integer getIdsubjcombination() {
        return idsubjcombination;
    }

    public void setIdsubjcombination(Integer idsubjcombination) {
        this.idsubjcombination = idsubjcombination;
    }

    public String getCombicode() {
        return combicode;
    }

    public void setCombicode(String combicode) {
        this.combicode = combicode;
    }

    public int getCompulsory() {
        return compulsory;
    }

    public void setCompulsory(int compulsory) {
        this.compulsory = compulsory;
    }

    public String getCombinationname() {
        return combinationname;
    }

    public void setCombinationname(String combinationname) {
        this.combinationname = combinationname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubjcombination != null ? idsubjcombination.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjcombination)) {
            return false;
        }
        Subjcombination other = (Subjcombination) object;
        if ((this.idsubjcombination == null && other.idsubjcombination != null) || (this.idsubjcombination != null && !this.idsubjcombination.equals(other.idsubjcombination))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Subjcombination[ idsubjcombination=" + idsubjcombination + " ]";
    }
    
}
