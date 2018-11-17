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
@Table(name = "dept")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d")
    , @NamedQuery(name = "Dept.findByIddept", query = "SELECT d FROM Dept d WHERE d.iddept = :iddept")
    , @NamedQuery(name = "Dept.findByName", query = "SELECT d FROM Dept d WHERE d.name = :name")
    , @NamedQuery(name = "Dept.findByCode", query = "SELECT d FROM Dept d WHERE d.code = :code")})
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddept")
    private Integer iddept;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Collection<Users> usersCollection;

    public Dept() {
    }

    public Dept(Integer iddept) {
        this.iddept = iddept;
    }

    public Dept(Integer iddept, String name, String code) {
        this.iddept = iddept;
        this.name = name;
        this.code = code;
    }

    public Integer getIddept() {
        return iddept;
    }

    public void setIddept(Integer iddept) {
        this.iddept = iddept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddept != null ? iddept.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dept)) {
            return false;
        }
        Dept other = (Dept) object;
        if ((this.iddept == null && other.iddept != null) || (this.iddept != null && !this.iddept.equals(other.iddept))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Dept[ iddept=" + iddept + " ]";
    }
    
}
