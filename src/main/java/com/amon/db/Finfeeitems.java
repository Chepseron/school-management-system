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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "finfeeitems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finfeeitems.findAll", query = "SELECT f FROM Finfeeitems f")
    , @NamedQuery(name = "Finfeeitems.findByIdfinfeeitems", query = "SELECT f FROM Finfeeitems f WHERE f.idfinfeeitems = :idfinfeeitems")
    , @NamedQuery(name = "Finfeeitems.findByName", query = "SELECT f FROM Finfeeitems f WHERE f.name = :name")
    , @NamedQuery(name = "Finfeeitems.findByCode", query = "SELECT f FROM Finfeeitems f WHERE f.code = :code")})
public class Finfeeitems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfinfeeitems")
    private Integer idfinfeeitems;
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
    @JoinColumn(name = "uom", referencedColumnName = "idfinuon")
    @ManyToOne(optional = false)
    private Finuom uom;
    @JoinColumn(name = "glacc", referencedColumnName = "idfinglaccount")
    @ManyToOne(optional = false)
    private Finglaccount glacc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "item")
    private Collection<Finfeestructure> finfeestructureCollection;

    public Finfeeitems() {
    }

    public Finfeeitems(Integer idfinfeeitems) {
        this.idfinfeeitems = idfinfeeitems;
    }

    public Finfeeitems(Integer idfinfeeitems, String name, String code) {
        this.idfinfeeitems = idfinfeeitems;
        this.name = name;
        this.code = code;
    }

    public Integer getIdfinfeeitems() {
        return idfinfeeitems;
    }

    public void setIdfinfeeitems(Integer idfinfeeitems) {
        this.idfinfeeitems = idfinfeeitems;
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

    public Finuom getUom() {
        return uom;
    }

    public void setUom(Finuom uom) {
        this.uom = uom;
    }

    public Finglaccount getGlacc() {
        return glacc;
    }

    public void setGlacc(Finglaccount glacc) {
        this.glacc = glacc;
    }

    @XmlTransient
    public Collection<Finfeestructure> getFinfeestructureCollection() {
        return finfeestructureCollection;
    }

    public void setFinfeestructureCollection(Collection<Finfeestructure> finfeestructureCollection) {
        this.finfeestructureCollection = finfeestructureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfinfeeitems != null ? idfinfeeitems.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finfeeitems)) {
            return false;
        }
        Finfeeitems other = (Finfeeitems) object;
        if ((this.idfinfeeitems == null && other.idfinfeeitems != null) || (this.idfinfeeitems != null && !this.idfinfeeitems.equals(other.idfinfeeitems))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Finfeeitems[ idfinfeeitems=" + idfinfeeitems + " ]";
    }
    
}
