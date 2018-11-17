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
@Table(name = "school")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s")
    , @NamedQuery(name = "School.findByIdschool", query = "SELECT s FROM School s WHERE s.idschool = :idschool")
    , @NamedQuery(name = "School.findByCode", query = "SELECT s FROM School s WHERE s.code = :code")
    , @NamedQuery(name = "School.findByName", query = "SELECT s FROM School s WHERE s.name = :name")
    , @NamedQuery(name = "School.findByMoecode", query = "SELECT s FROM School s WHERE s.moecode = :moecode")
    , @NamedQuery(name = "School.findByTsccode", query = "SELECT s FROM School s WHERE s.tsccode = :tsccode")
    , @NamedQuery(name = "School.findByKneccode", query = "SELECT s FROM School s WHERE s.kneccode = :kneccode")
    , @NamedQuery(name = "School.findByMissn", query = "SELECT s FROM School s WHERE s.missn = :missn")
    , @NamedQuery(name = "School.findByVision", query = "SELECT s FROM School s WHERE s.vision = :vision")
    , @NamedQuery(name = "School.findByMotto", query = "SELECT s FROM School s WHERE s.motto = :motto")})
public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idschool")
    private Integer idschool;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "moecode")
    private String moecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tsccode")
    private String tsccode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "kneccode")
    private String kneccode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "missn")
    private String missn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "vision")
    private String vision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "motto")
    private String motto;

    public School() {
    }

    public School(Integer idschool) {
        this.idschool = idschool;
    }

    public School(Integer idschool, String code, String name, String moecode, String tsccode, String kneccode, String missn, String vision, String motto) {
        this.idschool = idschool;
        this.code = code;
        this.name = name;
        this.moecode = moecode;
        this.tsccode = tsccode;
        this.kneccode = kneccode;
        this.missn = missn;
        this.vision = vision;
        this.motto = motto;
    }

    public Integer getIdschool() {
        return idschool;
    }

    public void setIdschool(Integer idschool) {
        this.idschool = idschool;
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

    public String getMoecode() {
        return moecode;
    }

    public void setMoecode(String moecode) {
        this.moecode = moecode;
    }

    public String getTsccode() {
        return tsccode;
    }

    public void setTsccode(String tsccode) {
        this.tsccode = tsccode;
    }

    public String getKneccode() {
        return kneccode;
    }

    public void setKneccode(String kneccode) {
        this.kneccode = kneccode;
    }

    public String getMissn() {
        return missn;
    }

    public void setMissn(String missn) {
        this.missn = missn;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idschool != null ? idschool.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.idschool == null && other.idschool != null) || (this.idschool != null && !this.idschool.equals(other.idschool))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.School[ idschool=" + idschool + " ]";
    }
    
}
