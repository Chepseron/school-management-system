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
@Table(name = "commsmsgateways")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commsmsgateways.findAll", query = "SELECT c FROM Commsmsgateways c")
    , @NamedQuery(name = "Commsmsgateways.findByIdcommsmsgateways", query = "SELECT c FROM Commsmsgateways c WHERE c.idcommsmsgateways = :idcommsmsgateways")
    , @NamedQuery(name = "Commsmsgateways.findByName", query = "SELECT c FROM Commsmsgateways c WHERE c.name = :name")
    , @NamedQuery(name = "Commsmsgateways.findByUrl", query = "SELECT c FROM Commsmsgateways c WHERE c.url = :url")})
public class Commsmsgateways implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcommsmsgateways")
    private Integer idcommsmsgateways;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "url")
    private String url;

    public Commsmsgateways() {
    }

    public Commsmsgateways(Integer idcommsmsgateways) {
        this.idcommsmsgateways = idcommsmsgateways;
    }

    public Commsmsgateways(Integer idcommsmsgateways, String name, String url) {
        this.idcommsmsgateways = idcommsmsgateways;
        this.name = name;
        this.url = url;
    }

    public Integer getIdcommsmsgateways() {
        return idcommsmsgateways;
    }

    public void setIdcommsmsgateways(Integer idcommsmsgateways) {
        this.idcommsmsgateways = idcommsmsgateways;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommsmsgateways != null ? idcommsmsgateways.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commsmsgateways)) {
            return false;
        }
        Commsmsgateways other = (Commsmsgateways) object;
        if ((this.idcommsmsgateways == null && other.idcommsmsgateways != null) || (this.idcommsmsgateways != null && !this.idcommsmsgateways.equals(other.idcommsmsgateways))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Commsmsgateways[ idcommsmsgateways=" + idcommsmsgateways + " ]";
    }
    
}
