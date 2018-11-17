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
@Table(name = "houses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Houses.findAll", query = "SELECT h FROM Houses h")
    , @NamedQuery(name = "Houses.findByIdhouses", query = "SELECT h FROM Houses h WHERE h.idhouses = :idhouses")
    , @NamedQuery(name = "Houses.findByCode", query = "SELECT h FROM Houses h WHERE h.code = :code")
    , @NamedQuery(name = "Houses.findByName", query = "SELECT h FROM Houses h WHERE h.name = :name")})
public class Houses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhouses")
    private Integer idhouses;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "house")
    private Collection<Student> studentCollection;

    public Houses() {
    }

    public Houses(Integer idhouses) {
        this.idhouses = idhouses;
    }

    public Houses(Integer idhouses, String code, String name) {
        this.idhouses = idhouses;
        this.code = code;
        this.name = name;
    }

    public Integer getIdhouses() {
        return idhouses;
    }

    public void setIdhouses(Integer idhouses) {
        this.idhouses = idhouses;
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
        hash += (idhouses != null ? idhouses.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Houses)) {
            return false;
        }
        Houses other = (Houses) object;
        if ((this.idhouses == null && other.idhouses != null) || (this.idhouses != null && !this.idhouses.equals(other.idhouses))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Houses[ idhouses=" + idhouses + " ]";
    }
    
}
