/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amon.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author amon.sabul
 */
@Entity
@Table(name = "librarycatalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Librarycatalog.findAll", query = "SELECT l FROM Librarycatalog l")
    , @NamedQuery(name = "Librarycatalog.findByIdlibrarynewbook", query = "SELECT l FROM Librarycatalog l WHERE l.idlibrarynewbook = :idlibrarynewbook")
    , @NamedQuery(name = "Librarycatalog.findByIsbn", query = "SELECT l FROM Librarycatalog l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "Librarycatalog.findByBookseries", query = "SELECT l FROM Librarycatalog l WHERE l.bookseries = :bookseries")
    , @NamedQuery(name = "Librarycatalog.findByEdition", query = "SELECT l FROM Librarycatalog l WHERE l.edition = :edition")
    , @NamedQuery(name = "Librarycatalog.findByDatereceived", query = "SELECT l FROM Librarycatalog l WHERE l.datereceived = :datereceived")
    , @NamedQuery(name = "Librarycatalog.findByCopyrightyear", query = "SELECT l FROM Librarycatalog l WHERE l.copyrightyear = :copyrightyear")
    , @NamedQuery(name = "Librarycatalog.findByCategory", query = "SELECT l FROM Librarycatalog l WHERE l.category = :category")
    , @NamedQuery(name = "Librarycatalog.findByCopiesreceived", query = "SELECT l FROM Librarycatalog l WHERE l.copiesreceived = :copiesreceived")
    , @NamedQuery(name = "Librarycatalog.findByCostpercopy", query = "SELECT l FROM Librarycatalog l WHERE l.costpercopy = :costpercopy")})
public class Librarycatalog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlibrarynewbook")
    private Integer idlibrarynewbook;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bookseries")
    private String bookseries;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "edition")
    private String edition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datereceived")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datereceived;
    @Basic(optional = false)
    @NotNull
    @Column(name = "copyrightyear")
    private int copyrightyear;
    @Size(max = 45)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Column(name = "copiesreceived")
    private int copiesreceived;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costpercopy")
    private int costpercopy;
    @JoinColumn(name = "book", referencedColumnName = "idlibrarybookcategories")
    @ManyToOne(optional = false)
    private Librarybookcategories book;
    @JoinColumn(name = "subject", referencedColumnName = "idsubj")
    @ManyToOne(optional = false)
    private Subj subject;
    @JoinColumn(name = "form", referencedColumnName = "idforms")
    @ManyToOne(optional = false)
    private Forms form;
    @JoinColumn(name = "shelve", referencedColumnName = "idlibraryshelve")
    @ManyToOne(optional = false)
    private Libraryshelve shelve;
    @JoinColumn(name = "publisher", referencedColumnName = "idlibrarypublishers")
    @ManyToOne(optional = false)
    private Librarypublishers publisher;
    @JoinColumn(name = "author", referencedColumnName = "idlibraryauthors")
    @ManyToOne(optional = false)
    private Libraryauthors author;

    public Librarycatalog() {
    }

    public Librarycatalog(Integer idlibrarynewbook) {
        this.idlibrarynewbook = idlibrarynewbook;
    }

    public Librarycatalog(Integer idlibrarynewbook, String isbn, String bookseries, String edition, Date datereceived, int copyrightyear, int copiesreceived, int costpercopy) {
        this.idlibrarynewbook = idlibrarynewbook;
        this.isbn = isbn;
        this.bookseries = bookseries;
        this.edition = edition;
        this.datereceived = datereceived;
        this.copyrightyear = copyrightyear;
        this.copiesreceived = copiesreceived;
        this.costpercopy = costpercopy;
    }

    public Integer getIdlibrarynewbook() {
        return idlibrarynewbook;
    }

    public void setIdlibrarynewbook(Integer idlibrarynewbook) {
        this.idlibrarynewbook = idlibrarynewbook;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookseries() {
        return bookseries;
    }

    public void setBookseries(String bookseries) {
        this.bookseries = bookseries;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getDatereceived() {
        return datereceived;
    }

    public void setDatereceived(Date datereceived) {
        this.datereceived = datereceived;
    }

    public int getCopyrightyear() {
        return copyrightyear;
    }

    public void setCopyrightyear(int copyrightyear) {
        this.copyrightyear = copyrightyear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCopiesreceived() {
        return copiesreceived;
    }

    public void setCopiesreceived(int copiesreceived) {
        this.copiesreceived = copiesreceived;
    }

    public int getCostpercopy() {
        return costpercopy;
    }

    public void setCostpercopy(int costpercopy) {
        this.costpercopy = costpercopy;
    }

    public Librarybookcategories getBook() {
        return book;
    }

    public void setBook(Librarybookcategories book) {
        this.book = book;
    }

    public Subj getSubject() {
        return subject;
    }

    public void setSubject(Subj subject) {
        this.subject = subject;
    }

    public Forms getForm() {
        return form;
    }

    public void setForm(Forms form) {
        this.form = form;
    }

    public Libraryshelve getShelve() {
        return shelve;
    }

    public void setShelve(Libraryshelve shelve) {
        this.shelve = shelve;
    }

    public Librarypublishers getPublisher() {
        return publisher;
    }

    public void setPublisher(Librarypublishers publisher) {
        this.publisher = publisher;
    }

    public Libraryauthors getAuthor() {
        return author;
    }

    public void setAuthor(Libraryauthors author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibrarynewbook != null ? idlibrarynewbook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Librarycatalog)) {
            return false;
        }
        Librarycatalog other = (Librarycatalog) object;
        if ((this.idlibrarynewbook == null && other.idlibrarynewbook != null) || (this.idlibrarynewbook != null && !this.idlibrarynewbook.equals(other.idlibrarynewbook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.amon.db.Librarycatalog[ idlibrarynewbook=" + idlibrarynewbook + " ]";
    }
    
}
