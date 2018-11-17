/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "teachers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teachers.findAll", query = "SELECT t FROM Teachers t")
    , @NamedQuery(name = "Teachers.findByIdteachers", query = "SELECT t FROM Teachers t WHERE t.idteachers = :idteachers")
    , @NamedQuery(name = "Teachers.findByNo", query = "SELECT t FROM Teachers t WHERE t.no = :no")
    , @NamedQuery(name = "Teachers.findByTitle", query = "SELECT t FROM Teachers t WHERE t.title = :title")
    , @NamedQuery(name = "Teachers.findByFullnames", query = "SELECT t FROM Teachers t WHERE t.fullnames = :fullnames")
    , @NamedQuery(name = "Teachers.findByInitial", query = "SELECT t FROM Teachers t WHERE t.initial = :initial")
    , @NamedQuery(name = "Teachers.findByDepartment", query = "SELECT t FROM Teachers t WHERE t.department = :department")
    , @NamedQuery(name = "Teachers.findByEmployedOn", query = "SELECT t FROM Teachers t WHERE t.employedOn = :employedOn")
    , @NamedQuery(name = "Teachers.findByQualification", query = "SELECT t FROM Teachers t WHERE t.qualification = :qualification")
    , @NamedQuery(name = "Teachers.findBySignature", query = "SELECT t FROM Teachers t WHERE t.signature = :signature")
    , @NamedQuery(name = "Teachers.findByBirthdate", query = "SELECT t FROM Teachers t WHERE t.birthdate = :birthdate")
    , @NamedQuery(name = "Teachers.findByNationalId", query = "SELECT t FROM Teachers t WHERE t.nationalId = :nationalId")
    , @NamedQuery(name = "Teachers.findByGender", query = "SELECT t FROM Teachers t WHERE t.gender = :gender")
    , @NamedQuery(name = "Teachers.findByReligion", query = "SELECT t FROM Teachers t WHERE t.religion = :religion")
    , @NamedQuery(name = "Teachers.findByMaritalStatus", query = "SELECT t FROM Teachers t WHERE t.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Teachers.findByPassowrd", query = "SELECT t FROM Teachers t WHERE t.passowrd = :passowrd")
    , @NamedQuery(name = "Teachers.findByMobilephone", query = "SELECT t FROM Teachers t WHERE t.mobilephone = :mobilephone")
    , @NamedQuery(name = "Teachers.findByPostalcode", query = "SELECT t FROM Teachers t WHERE t.postalcode = :postalcode")
    , @NamedQuery(name = "Teachers.findByAddress", query = "SELECT t FROM Teachers t WHERE t.address = :address")
    , @NamedQuery(name = "Teachers.findByResidence", query = "SELECT t FROM Teachers t WHERE t.residence = :residence")
    , @NamedQuery(name = "Teachers.findByPersonalemail", query = "SELECT t FROM Teachers t WHERE t.personalemail = :personalemail")})
public class Teachers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idteachers")
    private Integer idteachers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no")
    private int no;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "fullnames")
    private String fullnames;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "initial")
    private String initial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "department")
    private int department;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employedOn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date employedOn;
    @Size(max = 45)
    @Column(name = "qualification")
    private String qualification;
    @Size(max = 45)
    @Column(name = "signature")
    private String signature;
    @Column(name = "birthdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
    @Size(max = 45)
    @Column(name = "nationalId")
    private String nationalId;
    @Size(max = 45)
    @Column(name = "gender")
    private String gender;
    @Size(max = 45)
    @Column(name = "religion")
    private String religion;
    @Size(max = 45)
    @Column(name = "maritalStatus")
    private String maritalStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "passowrd")
    private String passowrd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "mobilephone")
    private String mobilephone;
    @Size(max = 45)
    @Column(name = "postalcode")
    private String postalcode;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 200)
    @Column(name = "residence")
    private String residence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "personalemail")
    private String personalemail;
    @OneToMany(mappedBy = "teacher")
    private Collection<Assignedresponsibilities> assignedresponsibilitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<Subjectallocation> subjectallocationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<Examteachersetup> examteachersetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<Classteacher> classteacherCollection;

    public Teachers() {
    }

    public Teachers(Integer idteachers) {
        this.idteachers = idteachers;
    }

    public Teachers(Integer idteachers, int no, String title, String fullnames, String initial, int department, Date employedOn, String passowrd, String mobilephone, String personalemail) {
        this.idteachers = idteachers;
        this.no = no;
        this.title = title;
        this.fullnames = fullnames;
        this.initial = initial;
        this.department = department;
        this.employedOn = employedOn;
        this.passowrd = passowrd;
        this.mobilephone = mobilephone;
        this.personalemail = personalemail;
    }

    public Integer getIdteachers() {
        return idteachers;
    }

    public void setIdteachers(Integer idteachers) {
        this.idteachers = idteachers;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public Date getEmployedOn() {
        return employedOn;
    }

    public void setEmployedOn(Date employedOn) {
        this.employedOn = employedOn;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPersonalemail() {
        return personalemail;
    }

    public void setPersonalemail(String personalemail) {
        this.personalemail = personalemail;
    }

    @XmlTransient
    public Collection<Assignedresponsibilities> getAssignedresponsibilitiesCollection() {
        return assignedresponsibilitiesCollection;
    }

    public void setAssignedresponsibilitiesCollection(Collection<Assignedresponsibilities> assignedresponsibilitiesCollection) {
        this.assignedresponsibilitiesCollection = assignedresponsibilitiesCollection;
    }

    @XmlTransient
    public Collection<Subjectallocation> getSubjectallocationCollection() {
        return subjectallocationCollection;
    }

    public void setSubjectallocationCollection(Collection<Subjectallocation> subjectallocationCollection) {
        this.subjectallocationCollection = subjectallocationCollection;
    }

    @XmlTransient
    public Collection<Examteachersetup> getExamteachersetupCollection() {
        return examteachersetupCollection;
    }

    public void setExamteachersetupCollection(Collection<Examteachersetup> examteachersetupCollection) {
        this.examteachersetupCollection = examteachersetupCollection;
    }

    @XmlTransient
    public Collection<Classteacher> getClassteacherCollection() {
        return classteacherCollection;
    }

    public void setClassteacherCollection(Collection<Classteacher> classteacherCollection) {
        this.classteacherCollection = classteacherCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idteachers != null ? idteachers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teachers)) {
            return false;
        }
        Teachers other = (Teachers) object;
        if ((this.idteachers == null && other.idteachers != null) || (this.idteachers != null && !this.idteachers.equals(other.idteachers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Teachers[ idteachers=" + idteachers + " ]";
    }
    
}
