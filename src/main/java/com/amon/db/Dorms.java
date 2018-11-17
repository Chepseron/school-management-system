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
@Table(name = "dorms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dorms.findAll", query = "SELECT d FROM Dorms d")
    , @NamedQuery(name = "Dorms.findByIddorms", query = "SELECT d FROM Dorms d WHERE d.iddorms = :iddorms")
    , @NamedQuery(name = "Dorms.findByCode", query = "SELECT d FROM Dorms d WHERE d.code = :code")
    , @NamedQuery(name = "Dorms.findByName", query = "SELECT d FROM Dorms d WHERE d.name = :name")})
public class Dorms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddorms")
    private Integer iddorms;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dorm")
    private Collection<Student> studentCollection;

    public Dorms() {
    }

    public Dorms(Integer iddorms) {
        this.iddorms = iddorms;
    }

    public Dorms(Integer iddorms, String code, String name) {
        this.iddorms = iddorms;
        this.code = code;
        this.name = name;
    }

    public Integer getIddorms() {
        return iddorms;
    }

    public void setIddorms(Integer iddorms) {
        this.iddorms = iddorms;
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

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddorms != null ? iddorms.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dorms)) {
            return false;
        }
        Dorms other = (Dorms) object;
        if ((this.iddorms == null && other.iddorms != null) || (this.iddorms != null && !this.iddorms.equals(other.iddorms))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Dorms[ iddorms=" + iddorms + " ]";
    }
    
}
