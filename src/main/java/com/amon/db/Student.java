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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByIdstudent", query = "SELECT s FROM Student s WHERE s.idstudent = :idstudent")
    , @NamedQuery(name = "Student.findByAdmnum", query = "SELECT s FROM Student s WHERE s.admnum = :admnum")
    , @NamedQuery(name = "Student.findByFullnames", query = "SELECT s FROM Student s WHERE s.fullnames = :fullnames")
    , @NamedQuery(name = "Student.findByAdmissiondate", query = "SELECT s FROM Student s WHERE s.admissiondate = :admissiondate")
    , @NamedQuery(name = "Student.findByBirthdate", query = "SELECT s FROM Student s WHERE s.birthdate = :birthdate")
    , @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender")
    , @NamedQuery(name = "Student.findByReligion", query = "SELECT s FROM Student s WHERE s.religion = :religion")
    , @NamedQuery(name = "Student.findByEthnicity", query = "SELECT s FROM Student s WHERE s.ethnicity = :ethnicity")
    , @NamedQuery(name = "Student.findByMobilephone", query = "SELECT s FROM Student s WHERE s.mobilephone = :mobilephone")
    , @NamedQuery(name = "Student.findByPostalcode", query = "SELECT s FROM Student s WHERE s.postalcode = :postalcode")
    , @NamedQuery(name = "Student.findByAddress", query = "SELECT s FROM Student s WHERE s.address = :address")
    , @NamedQuery(name = "Student.findByResidence", query = "SELECT s FROM Student s WHERE s.residence = :residence")
    , @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")
    , @NamedQuery(name = "Student.findByCpeindex", query = "SELECT s FROM Student s WHERE s.cpeindex = :cpeindex")
    , @NamedQuery(name = "Student.findByCpemean", query = "SELECT s FROM Student s WHERE s.cpemean = :cpemean")
    , @NamedQuery(name = "Student.findByCpeenglish", query = "SELECT s FROM Student s WHERE s.cpeenglish = :cpeenglish")
    , @NamedQuery(name = "Student.findByCpemath", query = "SELECT s FROM Student s WHERE s.cpemath = :cpemath")
    , @NamedQuery(name = "Student.findByCpekiswahili", query = "SELECT s FROM Student s WHERE s.cpekiswahili = :cpekiswahili")
    , @NamedQuery(name = "Student.findByCpess", query = "SELECT s FROM Student s WHERE s.cpess = :cpess")
    , @NamedQuery(name = "Student.findByCpesci", query = "SELECT s FROM Student s WHERE s.cpesci = :cpesci")
    , @NamedQuery(name = "Student.findByCpegrade", query = "SELECT s FROM Student s WHERE s.cpegrade = :cpegrade")
    , @NamedQuery(name = "Student.findByCpemarks", query = "SELECT s FROM Student s WHERE s.cpemarks = :cpemarks")
    , @NamedQuery(name = "Student.findByMedicalcodition", query = "SELECT s FROM Student s WHERE s.medicalcodition = :medicalcodition")
    , @NamedQuery(name = "Student.findByAlergyies", query = "SELECT s FROM Student s WHERE s.alergyies = :alergyies")
    , @NamedQuery(name = "Student.findByPhotourl", query = "SELECT s FROM Student s WHERE s.photourl = :photourl")
    , @NamedQuery(name = "Student.findByPassword", query = "SELECT s FROM Student s WHERE s.password = :password")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstudent")
    private Integer idstudent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "admnum")
    private String admnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "fullnames")
    private String fullnames;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admissiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date admissiondate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "gender")
    private String gender;
    @Size(max = 45)
    @Column(name = "religion")
    private String religion;
    @Size(max = 100)
    @Column(name = "ethnicity")
    private String ethnicity;
    @Size(max = 45)
    @Column(name = "mobilephone")
    private String mobilephone;
    @Size(max = 45)
    @Column(name = "postalcode")
    private String postalcode;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 100)
    @Column(name = "residence")
    private String residence;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cpeindex")
    private String cpeindex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cpemean")
    private String cpemean;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpeenglish")
    private int cpeenglish;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpemath")
    private int cpemath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpekiswahili")
    private int cpekiswahili;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpess")
    private int cpess;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpesci")
    private int cpesci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cpegrade")
    private String cpegrade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpemarks")
    private int cpemarks;
    @Size(max = 400)
    @Column(name = "medicalcodition")
    private String medicalcodition;
    @Size(max = 400)
    @Column(name = "alergyies")
    private String alergyies;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "photourl")
    private String photourl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Studentsubjects> studentsubjectsCollection;
    @JoinColumn(name = "dorm", referencedColumnName = "iddorms")
    @ManyToOne(optional = false)
    private Dorms dorm;
    @JoinColumn(name = "house", referencedColumnName = "idhouses")
    @ManyToOne(optional = false)
    private Houses house;
    @JoinColumn(name = "currentclass", referencedColumnName = "idforms")
    @ManyToOne(optional = false)
    private Forms currentclass;
    @OneToMany(mappedBy = "student")
    private Collection<Assignedresponsibilities> assignedresponsibilitiesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Finreceipt> finreceiptCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Examteachersetup> examteachersetupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Collection<Finfeebalances> finfeebalancesCollection;

    public Student() {
    }

    public Student(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public Student(Integer idstudent, String admnum, String fullnames, Date admissiondate, Date birthdate, String gender, String cpeindex, String cpemean, int cpeenglish, int cpemath, int cpekiswahili, int cpess, int cpesci, String cpegrade, int cpemarks, String photourl, String password) {
        this.idstudent = idstudent;
        this.admnum = admnum;
        this.fullnames = fullnames;
        this.admissiondate = admissiondate;
        this.birthdate = birthdate;
        this.gender = gender;
        this.cpeindex = cpeindex;
        this.cpemean = cpemean;
        this.cpeenglish = cpeenglish;
        this.cpemath = cpemath;
        this.cpekiswahili = cpekiswahili;
        this.cpess = cpess;
        this.cpesci = cpesci;
        this.cpegrade = cpegrade;
        this.cpemarks = cpemarks;
        this.photourl = photourl;
        this.password = password;
    }

    public Integer getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public String getAdmnum() {
        return admnum;
    }

    public void setAdmnum(String admnum) {
        this.admnum = admnum;
    }

    public String getFullnames() {
        return fullnames;
    }

    public void setFullnames(String fullnames) {
        this.fullnames = fullnames;
    }

    public Date getAdmissiondate() {
        return admissiondate;
    }

    public void setAdmissiondate(Date admissiondate) {
        this.admissiondate = admissiondate;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
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

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpeindex() {
        return cpeindex;
    }

    public void setCpeindex(String cpeindex) {
        this.cpeindex = cpeindex;
    }

    public String getCpemean() {
        return cpemean;
    }

    public void setCpemean(String cpemean) {
        this.cpemean = cpemean;
    }

    public int getCpeenglish() {
        return cpeenglish;
    }

    public void setCpeenglish(int cpeenglish) {
        this.cpeenglish = cpeenglish;
    }

    public int getCpemath() {
        return cpemath;
    }

    public void setCpemath(int cpemath) {
        this.cpemath = cpemath;
    }

    public int getCpekiswahili() {
        return cpekiswahili;
    }

    public void setCpekiswahili(int cpekiswahili) {
        this.cpekiswahili = cpekiswahili;
    }

    public int getCpess() {
        return cpess;
    }

    public void setCpess(int cpess) {
        this.cpess = cpess;
    }

    public int getCpesci() {
        return cpesci;
    }

    public void setCpesci(int cpesci) {
        this.cpesci = cpesci;
    }

    public String getCpegrade() {
        return cpegrade;
    }

    public void setCpegrade(String cpegrade) {
        this.cpegrade = cpegrade;
    }

    public int getCpemarks() {
        return cpemarks;
    }

    public void setCpemarks(int cpemarks) {
        this.cpemarks = cpemarks;
    }

    public String getMedicalcodition() {
        return medicalcodition;
    }

    public void setMedicalcodition(String medicalcodition) {
        this.medicalcodition = medicalcodition;
    }

    public String getAlergyies() {
        return alergyies;
    }

    public void setAlergyies(String alergyies) {
        this.alergyies = alergyies;
    }

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Studentsubjects> getStudentsubjectsCollection() {
        return studentsubjectsCollection;
    }

    public void setStudentsubjectsCollection(Collection<Studentsubjects> studentsubjectsCollection) {
        this.studentsubjectsCollection = studentsubjectsCollection;
    }

    public Dorms getDorm() {
        return dorm;
    }

    public void setDorm(Dorms dorm) {
        this.dorm = dorm;
    }

    public Houses getHouse() {
        return house;
    }

    public void setHouse(Houses house) {
        this.house = house;
    }

    public Forms getCurrentclass() {
        return currentclass;
    }

    public void setCurrentclass(Forms currentclass) {
        this.currentclass = currentclass;
    }

    @XmlTransient
    public Collection<Assignedresponsibilities> getAssignedresponsibilitiesCollection() {
        return assignedresponsibilitiesCollection;
    }

    public void setAssignedresponsibilitiesCollection(Collection<Assignedresponsibilities> assignedresponsibilitiesCollection) {
        this.assignedresponsibilitiesCollection = assignedresponsibilitiesCollection;
    }

    @XmlTransient
    public Collection<Finreceipt> getFinreceiptCollection() {
        return finreceiptCollection;
    }

    public void setFinreceiptCollection(Collection<Finreceipt> finreceiptCollection) {
        this.finreceiptCollection = finreceiptCollection;
    }

    @XmlTransient
    public Collection<Examteachersetup> getExamteachersetupCollection() {
        return examteachersetupCollection;
    }

    public void setExamteachersetupCollection(Collection<Examteachersetup> examteachersetupCollection) {
        this.examteachersetupCollection = examteachersetupCollection;
    }

    @XmlTransient
    public Collection<Finfeebalances> getFinfeebalancesCollection() {
        return finfeebalancesCollection;
    }

    public void setFinfeebalancesCollection(Collection<Finfeebalances> finfeebalancesCollection) {
        this.finfeebalancesCollection = finfeebalancesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstudent != null ? idstudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idstudent == null && other.idstudent != null) || (this.idstudent != null && !this.idstudent.equals(other.idstudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Student[ idstudent=" + idstudent + " ]";
    }
    
}
