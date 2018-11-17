/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "responsibilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsibilities.findAll", query = "SELECT r FROM Responsibilities r")
    , @NamedQuery(name = "Responsibilities.findByIdresponsibilities", query = "SELECT r FROM Responsibilities r WHERE r.idresponsibilities = :idresponsibilities")
    , @NamedQuery(name = "Responsibilities.findByCode", query = "SELECT r FROM Responsibilities r WHERE r.code = :code")
    , @NamedQuery(name = "Responsibilities.findByName", query = "SELECT r FROM Responsibilities r WHERE r.name = :name")
    , @NamedQuery(name = "Responsibilities.findByIsteacherstudent", query = "SELECT r FROM Responsibilities r WHERE r.isteacherstudent = :isteacherstudent")})
public class Responsibilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresponsibilities")
    private Integer idresponsibilities;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isteacherstudent")
    private int isteacherstudent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "responsibility")
    private Collection<Assignedresponsibilities> assignedresponsibilitiesCollection;

    public Responsibilities() {
    }

    public Responsibilities(Integer idresponsibilities) {
        this.idresponsibilities = idresponsibilities;
    }

    public Responsibilities(Integer idresponsibilities, String code, String name, int isteacherstudent) {
        this.idresponsibilities = idresponsibilities;
        this.code = code;
        this.name = name;
        this.isteacherstudent = isteacherstudent;
    }

    public Integer getIdresponsibilities() {
        return idresponsibilities;
    }

    public void setIdresponsibilities(Integer idresponsibilities) {
        this.idresponsibilities = idresponsibilities;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsteacherstudent() {
        return isteacherstudent;
    }

    public void setIsteacherstudent(int isteacherstudent) {
        this.isteacherstudent = isteacherstudent;
    }

    @XmlTransient
    public Collection<Assignedresponsibilities> getAssignedresponsibilitiesCollection() {
        return assignedresponsibilitiesCollection;
    }

    public void setAssignedresponsibilitiesCollection(Collection<Assignedresponsibilities> assignedresponsibilitiesCollection) {
        this.assignedresponsibilitiesCollection = assignedresponsibilitiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresponsibilities != null ? idresponsibilities.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsibilities)) {
            return false;
        }
        Responsibilities other = (Responsibilities) object;
        if ((this.idresponsibilities == null && other.idresponsibilities != null) || (this.idresponsibilities != null && !this.idresponsibilities.equals(other.idresponsibilities))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Responsibilities[ idresponsibilities=" + idresponsibilities + " ]";
    }
    
}
