package com.amon.sch;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.amon.db.*;
import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author amon.sabul
 */
@javax.faces.bean.ManagedBean(name = "sch")
@SessionScoped
public class sch implements Serializable {

    private Logger logger = Logger.getLogger("errorLog");
    @PersistenceContext(unitName = "schPU")
    private EntityManager em;
    @Resource
    private UserTransaction utx;
    private Audit audit = new Audit();
    private Boolean remember = false;
    private List<Audit> auditList = new ArrayList<Audit>();
    private Status status = new Status();
    private List<Status> statusList = new ArrayList<Status>();
    private Users user = new Users();
    private List<Users> usersList = new ArrayList<>();
    private Usergroups group1 = new Usergroups();
    private List<Usergroups> group1List = new ArrayList<>();
    private Assignedresponsibilities assignedResponsibilities = new Assignedresponsibilities();
    private List<Assignedresponsibilities> assignedResponsibilitiesList = new ArrayList<>();
    private Attendance attendance = new Attendance();
    private List<Attendance> attendanceList = new ArrayList<Attendance>();
    private Calterm calterm = new Calterm();
    private List<Calterm> caltermList = new ArrayList<Calterm>();
    private Caltermyear caltermyear = new Caltermyear();
    private List<Caltermyear> caltermyearList = new ArrayList<Caltermyear>();
    private Calyear calyear = new Calyear();
    private List<Calyear> calyearList = new ArrayList<Calyear>();
    private Commsmsgateways smsgateways = new Commsmsgateways();
    private List<Commsmsgateways> smsgatewaysList = new ArrayList<Commsmsgateways>();
    private Constituencies constituencies = new Constituencies();
    private List<Constituencies> constituenciesList = new ArrayList<Constituencies>();
    private Classteacher classteacher = new Classteacher();
    private List<Classteacher> classteacherList = new ArrayList<Classteacher>();
    private Counties counties = new Counties();
    private List<Counties> countiesList = new ArrayList<Counties>();
    private Dept department = new Dept();
    private List<Dept> departmentList = new ArrayList<Dept>();
    private Districts district = new Districts();
    private List<Districts> districtList = new ArrayList<Districts>();
    private Divisions division = new Divisions();
    private List<Divisions> divisionList = new ArrayList<Divisions>();
    private Dorms dorms = new Dorms();
    private List<Dorms> dormsList = new ArrayList<Dorms>();
    private Examgradingnewexamgrades examgradingnewexamgrades = new Examgradingnewexamgrades();
    private List<Examgradingnewexamgrades> examgradingnewexamgradesList = new ArrayList<Examgradingnewexamgrades>();
    private Examgradingsystem examgradingsystem = new Examgradingsystem();
    private List<Examgradingsystem> examgradingsystemList = new ArrayList<Examgradingsystem>();
    private Examgradingsystemglobalsetup examgradingsystemglobalsetup = new Examgradingsystemglobalsetup();
    private List<Examgradingsystemglobalsetup> examgradingsystemglobalsetupList = new ArrayList<Examgradingsystemglobalsetup>();
    private Exammeangrade exammeangrade = new Exammeangrade();
    private List<Exammeangrade> exammeangradeList = new ArrayList<Exammeangrade>();
    private Examsubjectremarks examsubjectremarks = new Examsubjectremarks();
    private List<Examsubjectremarks> examsubjectremarksList = new ArrayList<Examsubjectremarks>();
    private Examteachersetup examteachersetup = new Examteachersetup();
    private List<Examteachersetup> examteachersetupList = new ArrayList<Examteachersetup>();
    private Finbanks finbanks = new Finbanks();
    private List<Finbanks> finbanksList = new ArrayList<Finbanks>();
    private Finfeebalances finfeebalances = new Finfeebalances();
    private List<Finfeebalances> finfeebalancesList = new ArrayList<Finfeebalances>();
    private Finfeeitems finfeeitems = new Finfeeitems();
    private List<Finfeeitems> finfeeitemsList = new ArrayList<Finfeeitems>();
    private Finfeestructure finfeestructure = new Finfeestructure();
    private List<Finfeestructure> ffinfeestructureList = new ArrayList<Finfeestructure>();
    private Finglaccount finglaccount = new Finglaccount();
    private List<Finglaccount> finglaccountList = new ArrayList<Finglaccount>();
    private Fininvoice fininvoice = new Fininvoice();
    private List<Fininvoice> fininvoiceList = new ArrayList<Fininvoice>();
    private Finledgeraccountbudget finledgeraccountbudget = new Finledgeraccountbudget();
    private List<Finledgeraccountbudget> finledgeraccountbudgetList = new ArrayList<Finledgeraccountbudget>();
    private Finledgeraccountgroups finledgeraccountgroups = new Finledgeraccountgroups();
    private List<Finledgeraccountgroups> finledgeraccountgroupstList = new ArrayList<Finledgeraccountgroups>();
    private Finledgeraccounts finledgeraccounts = new Finledgeraccounts();
    private List<Finledgeraccounts> finledgeraccountsList = new ArrayList<Finledgeraccounts>();
    private Finledgeraccountypes finledgeraccountypes = new Finledgeraccountypes();
    private List<Finledgeraccountypes> finledgeraccountypesList = new ArrayList<Finledgeraccountypes>();
    private Finledgergroupcategories finledgergroupcategories = new Finledgergroupcategories();
    private List<Finledgergroupcategories> finledgergroupcategoriesList = new ArrayList<Finledgergroupcategories>();
    private Finpaymentmodes finpaymentmodes = new Finpaymentmodes();
    private List<Finpaymentmodes> finpaymentmodesList = new ArrayList<Finpaymentmodes>();
    private Ntsbog ntsbog = new Ntsbog();
    private List<Ntsbog> ntsbogList = new ArrayList<Ntsbog>();
    private Ntspta ntspta = new Ntspta();
    private List<Ntspta> ntsptaList = new ArrayList<Ntspta>();
    private Ntsptacategory ntsptacategory = new Ntsptacategory();
    private List<Ntsptacategory> ntsptacategoryList = new ArrayList<Ntsptacategory>();
    private Ntsbogcategories ntsbogcategories = new Ntsbogcategories();
    private List<Ntsbogcategories> ntsbogcategoriesList = new ArrayList<Ntsbogcategories>();
    private Finreceipt finreceipt = new Finreceipt();
    private List<Finreceipt> finreceiptList = new ArrayList<Finreceipt>();
    private Finuom finuom = new Finuom();
    private List<Finuom> finuomList = new ArrayList<Finuom>();
    private Finyear finyear = new Finyear();
    private List<Finyear> finyearList = new ArrayList<Finyear>();
    private Forms forms = new Forms();
    private List<Forms> formsList = new ArrayList<Forms>();
    private Houses houses = new Houses();
    private List<Houses> housesList = new ArrayList<Houses>();
    private Kcpegrade kcpegrade = new Kcpegrade();
    private List<Kcpegrade> kcpegradeList = new ArrayList<Kcpegrade>();
    private Library library = new Library();
    private List<Library> libraryList = new ArrayList<Library>();
    private Libraryauthors libraryauthors = new Libraryauthors();
    private List<Libraryauthors> libraryauthorsList = new ArrayList<Libraryauthors>();
    private Librarybookcategories librarybookcategories = new Librarybookcategories();
    private List<Librarybookcategories> librarybookcategoriesList = new ArrayList<>();
    private Librarycatalog librarycatalog = new Librarycatalog();
    private List<Librarycatalog> librarycatalogList = new ArrayList<Librarycatalog>();
    private Libraryfeefines libraryfeefines = new Libraryfeefines();
    private List<Libraryfeefines> libraryfeefinesList = new ArrayList<Libraryfeefines>();
    private Librarylendreceive librarylendreceive = new Librarylendreceive();
    private List<Librarylendreceive> librarylendreceiveList = new ArrayList<Librarylendreceive>();
    private Librarylendstationery librarylendstationery = new Librarylendstationery();
    private List<Librarylendstationery> librarylendstationeryList = new ArrayList<Librarylendstationery>();
    private Librarymember librarymember = new Librarymember();
    private List<Librarymember> librarymemberList = new ArrayList<Librarymember>();
    private Librarymembertypes librarymembertypes = new Librarymembertypes();
    private List<Librarymembertypes> librarymembertypesList = new ArrayList<Librarymembertypes>();
    private Librarynewbookacquisition librarynewbookacquisition = new Librarynewbookacquisition();
    private List<Librarynewbookacquisition> librarynewbookacquisitionList = new ArrayList<Librarynewbookacquisition>();
    private Librarynewstationery librarynewstationery = new Librarynewstationery();
    private List<Librarynewstationery> librarynewstationeryList = new ArrayList<Librarynewstationery>();

    private Librarypublishers librarypublishers = new Librarypublishers();
    private List<Librarypublishers> librarypublishersList = new ArrayList<Librarypublishers>();
    private Libraryshelve libraryshelve = new Libraryshelve();
    private List<Libraryshelve> libraryshelveList = new ArrayList<Libraryshelve>();
    private Librarystationerycategories librarystationerycategories = new Librarystationerycategories();
    private List<Librarystationerycategories> librarystationerycategoriesList = new ArrayList<Librarystationerycategories>();
    private Librarysuppliers librarysuppliers = new Librarysuppliers();
    private List<Librarysuppliers> librarysuppliersList = new ArrayList<Librarysuppliers>();
    private Location location = new Location();
    private List<Location> locationList = new ArrayList<Location>();
    private Responsibilities responsibilities = new Responsibilities();
    private List<Responsibilities> responsibilitiesList = new ArrayList<Responsibilities>();
    private School school = new School();
    private List<School> schoolList = new ArrayList<School>();
    private Streams streams = new Streams();
    private List<Streams> streamsList = new ArrayList<Streams>();
    private Student student = new Student();
    private List<Student> studentList = new ArrayList<Student>();
    private Studentsubjects studentsubjects = new Studentsubjects();
    private List<Studentsubjects> studentsubjectsList = new ArrayList<Studentsubjects>();
    private Subj subj = new Subj();
    private List<Subj> subjList = new ArrayList<Subj>();
    private Subjcombination subjcombination = new Subjcombination();
    private List<Subjcombination> subjcombinationList = new ArrayList<Subjcombination>();
    private Subjectallocation subjectallocation = new Subjectallocation();
    private List<Subjectallocation> subjectallocationList = new ArrayList<Subjectallocation>();
    private Subjgroups subjgroups = new Subjgroups();
    private List<Subjgroups> subjgroupsList = new ArrayList<Subjgroups>();
    private Subjkcpe Subjkcpe = new Subjkcpe();
    private List<Subjkcpe> subjkcpeList = new ArrayList<Subjkcpe>();
    private Sublocation sublocation = new Sublocation();
    private List<Sublocation> sublocationList = new ArrayList<Sublocation>();
    private Teachers teachers = new Teachers();
    private List<Teachers> teachersList = new ArrayList<Teachers>();
    private Zones zones = new Zones();
    private List<Zones> zonesList = new ArrayList<Zones>();
    private String username = new String();
    private String password = new String();
    private UploadedFile file;
    private TreeNode root;
    private boolean skip;
    private String filename;

    /**
     * Creates a new instance of mne
     */
    public sch() {
    }

    @PostConstruct
    public void init() {
        try {
            setRoot(new DefaultTreeNode("Root", null));
            TreeNode node0 = new DefaultTreeNode("User groups", getRoot());
            TreeNode node1 = new DefaultTreeNode("Users", getRoot());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String orientation = "horizontal";

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
    private LineChartModel projectModel;

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getAttributes().clear();
        return "/index.xhtml?faces-redirect=true";
    }

    public String loginPage() {
        return "/index2.xhtml?faces-redirect=true";
    }

    public String onFlowProcess(FlowEvent event) {
        if (isSkip()) {
            setSkip(false);   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public String login() {
        Usergroups g;
        try {
            setUser((Users) getEm().createQuery("select u from Users u where u.username = '" + getUsername() + "' and u.password = '" + getPassword() + "'").getSingleResult());
            return "index3.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            try {
                teachers = (Teachers) em.createQuery("select t from Teachers t where t.nationalId = '" + username + "' and t.passowrd = '" + password + "'").getSingleResult();
                return "index3.xhtml?faces-redirect=true";
            } catch (Exception e) {
                try {
                    student = (Student) em.createQuery("SELECT s FROM Student s WHERE s.admnum  = '" + username + "' and s.password = '" + password + "'").getSingleResult();
                    return "index3.xhtml?faces-redirect=true";
                } catch (Exception es) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Invalid user credentials"));
                    ex.printStackTrace();
                    getLogger().info(ex.getMessage());
                }
            }
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String createUsers() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("saved user " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getUser());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getUser().getUsername() + " saved successfully."));
            setUser(new Users());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateUsers() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Users user = getEm().find(Users.class, getUser().getIdusers());

            user = user;
            getUtx().begin();
            getAudit().setAction("updated user " + user.getIdusers());
            getAudit().setCreatedby(user);
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(user);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", user.getUsername() + " Updated successfully."));
            user = new Users();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a user."));
        }
        return null;
    }

    public String deleteUsers(Users user) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted user");
            getAudit().setCreatedby(user);
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Users toBeRemoved = (Users) getEm().merge(user);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            user = new Users();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Users deleted", "Users deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Users", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Users", success);
        }

        return null;
    }

    public String createAssignedresponsibilities() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved assignedresponsibilities " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getAssignedResponsibilities());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getAssignedResponsibilities().getResponsibility() + " saved successfully."));
            setAssignedResponsibilities(new Assignedresponsibilities());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateAssignedresponsibilities() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Assignedresponsibilities assignedresponsibilities = getEm().find(Assignedresponsibilities.class, getAssignedResponsibilities().getIdteacherresponsibilities());
            assignedresponsibilities = getAssignedResponsibilities();
            getUtx().begin();
            getAudit().setAction("updated assignedresponsibilities " + getAssignedResponsibilities().getIdteacherresponsibilities());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(assignedresponsibilities);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getAssignedResponsibilities().getIdteacherresponsibilities() + " Updated successfully."));
            assignedresponsibilities = new Assignedresponsibilities();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a assignedresponsibilities."));
        }

        return null;
    }

    public String deleteAssignedresponsibilities(Assignedresponsibilities assignedresponsibilities) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted assignedresponsibilities");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Assignedresponsibilities toBeRemoved = (Assignedresponsibilities) getEm().merge(assignedresponsibilities);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            assignedresponsibilities = new Assignedresponsibilities();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Assignedresponsibilities deleted", "Assignedresponsibilities deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Assignedresponsibilities", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Assignedresponsibilities", success);
        }

        return null;
    }

    public String createAttendance() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved attendance " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getAttendance());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getAttendance().getStream() + " saved successfully."));
            setAttendance(new Attendance());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateAttendance() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Attendance attendance = getEm().find(Attendance.class, getAttendance().getIdattendance());
            attendance = getAttendance();
            getUtx().begin();
            getAudit().setAction("updated attendance " + getAttendance().getIdattendance());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(attendance);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", attendance.getStream() + " Updated successfully."));
            attendance = new Attendance();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a attendance."));
        }

        return null;
    }

    public String deleteAttendance(Attendance attendance) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted attendance");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Attendance toBeRemoved = (Attendance) getEm().merge(attendance);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            attendance = new Attendance();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Attendance deleted", "Attendance deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Attendance", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Attendance", success);
        }

        return null;
    }

    public String createClassteacher() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved class teacher " + getClassteacher().getTeacher().getFullnames());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getClassteacher());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getClassteacher().getTeacher().getFullnames() + " saved successfully."));
            setClassteacher(new Classteacher());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateClassteacher() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Classteacher classteacher = getEm().find(Classteacher.class, getClassteacher().getIdclassteacher());
            classteacher = getClassteacher();
            getUtx().begin();
            getAudit().setAction("updated classteacher " + getClassteacher().getIdclassteacher());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(classteacher);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getClassteacher().getTeacher().getFullnames() + " Updated successfully."));
            classteacher = new Classteacher();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a classteacher."));
        }

        return null;
    }

    public String deleteClassteacher(Classteacher classteacher) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted classteacher");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Classteacher toBeRemoved = (Classteacher) getEm().merge(classteacher);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            classteacher = new Classteacher();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Classteacher deleted", "Classteacher deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Classteacher", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Classteacher", success);
        }

        return null;
    }

    public String createCalterm() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved calterm " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getCalterm());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getCalterm().getName() + " saved successfully."));
            setCalterm(new Calterm());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateCalterm() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Calterm calterm = getEm().find(Calterm.class, getCalterm().getIdcalterm());
            calterm = getCalterm();
            getUtx().begin();
            getAudit().setAction("updated calterm " + getCalterm().getIdcalterm());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(calterm);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", calterm.getName() + " Updated successfully."));
            calterm = new Calterm();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a calterm."));
        }

        return null;
    }

    public String deleteCalterm(Calterm calterm) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted calterm");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Calterm toBeRemoved = (Calterm) getEm().merge(calterm);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            calterm = new Calterm();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Calterm deleted", "Calterm deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Calterm", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Calterm", success);
        }

        return null;
    }

    public String createCaltermyear() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved caltermyear " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getCaltermyear());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getCaltermyear().getYear() + " saved successfully."));
            setCaltermyear(new Caltermyear());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateCaltermyear() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Caltermyear caltermyear = getEm().find(Caltermyear.class, getCaltermyear().getIdcaltermyear());
            caltermyear = this.getCaltermyear();
            getUtx().begin();
            getAudit().setAction("updated caltermyear " + getCaltermyear().getIdcaltermyear());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(caltermyear);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", caltermyear.getYear() + " Updated successfully."));
            caltermyear = new Caltermyear();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a caltermyear."));
        }

        return null;
    }

    public String deleteCaltermyear(Caltermyear caltermyear) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted caltermyear");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Caltermyear toBeRemoved = (Caltermyear) getEm().merge(caltermyear);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            caltermyear = new Caltermyear();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Caltermyear deleted", "Caltermyear deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Caltermyear", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Caltermyear", success);
        }

        return null;
    }

    public String createCalyear() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved calyear " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getCalyear());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getCalyear().getName() + " saved successfully."));
            setCalyear(new Calyear());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateCalyear() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Calyear calyear = getEm().find(Calyear.class, getCalyear().getIdcalyear());
            calyear = this.getCalyear();
            getUtx().begin();
            getAudit().setAction("updated calyear " + getCalyear().getIdcalyear());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(calyear);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", calyear.getName() + " Updated successfully."));
            calyear = new Calyear();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a calyear."));
        }

        return null;
    }

    public String deleteCalyear(Calyear calyear) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted calyear");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Calyear toBeRemoved = (Calyear) getEm().merge(calyear);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            calyear = new Calyear();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Calyear deleted", "Calyear deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Calyear", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Calyear", success);
        }

        return null;
    }

    public String createCommsmsgateways() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved commsmsgateways " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getSmsgateways());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getSmsgateways().getName() + " saved successfully."));
            setSmsgateways(new Commsmsgateways());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateCommsmsgateways() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Commsmsgateways commsmsgateways = getEm().find(Commsmsgateways.class, getSmsgateways().getIdcommsmsgateways());
            commsmsgateways = this.getSmsgateways();
            getUtx().begin();
            getAudit().setAction("updated commsmsgateways " + getSmsgateways().getIdcommsmsgateways());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(commsmsgateways);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", commsmsgateways.getName() + " Updated successfully."));
            commsmsgateways = new Commsmsgateways();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a commsmsgateways."));
        }

        return null;
    }

    public String deleteCommsmsgateways(Commsmsgateways commsmsgateways) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted commsmsgateways");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Commsmsgateways toBeRemoved = (Commsmsgateways) getEm().merge(commsmsgateways);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            commsmsgateways = new Commsmsgateways();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Commsmsgateways deleted", "Commsmsgateways deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Commsmsgateways", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Commsmsgateways", success);
        }

        return null;
    }

    public String createConstituencies() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved constituencies " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getConstituencies());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getConstituencies().getName() + " saved successfully."));
            setConstituencies(new Constituencies());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateConstituencies() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Constituencies constituencies = getEm().find(Constituencies.class, getConstituencies().getIdconstituencies());
            constituencies = this.getConstituencies();
            getUtx().begin();
            getAudit().setAction("updated constituencies " + getConstituencies().getIdconstituencies());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(constituencies);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", constituencies.getName() + " Updated successfully."));
            constituencies = new Constituencies();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a constituencies."));
        }

        return null;
    }

    public String deleteConstituencies(Constituencies constituencies) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted constituencies");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Constituencies toBeRemoved = (Constituencies) getEm().merge(constituencies);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            constituencies = new Constituencies();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Constituencies deleted", "Constituencies deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Constituencies", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Constituencies", success);
        }

        return null;
    }

    public String createCounties() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved counties " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getCounties());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getCounties().getName() + " saved successfully."));
            setCounties(new Counties());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateCounties() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Counties counties = getEm().find(Counties.class, getCounties().getIdcounties());
            counties = getCounties();
            getUtx().begin();
            getAudit().setAction("updated counties " + getCounties().getIdcounties());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(counties);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", counties.getName() + " Updated successfully."));
            counties = new Counties();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a counties."));
        }

        return null;
    }

    public void handleFileUpload(FileUploadEvent event) {
        if (event.getFile() != null) {
            try {
                FacesContext fCtx = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);
                String rootDirectory = session.getServletContext().getRealPath("/");
                Path path2 = Paths.get(rootDirectory + "uploads");

                String prefix = FilenameUtils.getBaseName(event.getFile().getFileName());
                String suffix = FilenameUtils.getExtension(event.getFile().getFileName());
                File save = File.createTempFile(prefix + "-", "." + suffix, path2.toFile());

                Files.write(save.toPath(), event.getFile().getContents(), new OpenOption[0]);
                Path path = save.toPath();

                System.out.println(path2 + "/" + path);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", "Image uploaded successfully"));
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
                logger.info(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    public String deleteCounties(Counties counties) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted counties");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Counties toBeRemoved = (Counties) getEm().merge(counties);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            counties = new Counties();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Counties deleted", "Counties deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Counties", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Counties", success);
        }

        return null;
    }

    public String createDept() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved dept " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getDepartment());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getDepartment().getName() + " saved successfully."));
            setDepartment(new Dept());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateDept() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Dept dept = getEm().find(Dept.class, getDepartment().getIddept());
            dept = this.getDepartment();
            getUtx().begin();
            getAudit().setAction("updated dept " + getDepartment().getIddept());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(dept);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", dept.getName() + " Updated successfully."));
            dept = new Dept();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a dept."));
        }

        return null;
    }

    public String deleteDept(Dept dept) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted dept");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Dept toBeRemoved = (Dept) getEm().merge(dept);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            dept = new Dept();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dept deleted", "Dept deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Dept", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Dept", success);
        }

        return null;
    }

    public String createDistricts() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved districts " + getUser().getUsername());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getDistrict());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getDistrict().getName() + " saved successfully."));
            setDistrict(new Districts());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateDistricts() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Districts districts = getEm().find(Districts.class, getDistrict().getIddistricts());
            districts = this.getDistrict();
            getUtx().begin();
            getAudit().setAction("updated districts " + getDistrict().getIddistricts());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(districts);
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", districts.getName() + " Updated successfully."));
            districts = new Districts();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a districts."));
        }
        return null;
    }

    public String deleteDistricts(Districts districts) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted districts");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Districts toBeRemoved = (Districts) getEm().merge(districts);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            districts = new Districts();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Districts deleted", "Districts deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Districts", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Districts", success);
        }

        return null;
    }

    public String createDivisions() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved division " + getDivision().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getDivision());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getDivision().getName() + " saved successfully."));
            setDivision(new Divisions());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateDivisions() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Divisions division = getEm().find(Divisions.class, getDivision().getIddivisions());

            division = this.getDivision();
            getUtx().begin();
            getAudit().setAction("updated division " + division.getIddivisions());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(division);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", division.getName() + " Updated successfully."));
            division = new Divisions();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a division."));
        }

        return null;
    }

    public String deleteDivisions(Divisions division) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted division");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Divisions toBeRemoved = (Divisions) getEm().merge(division);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            division = new Divisions();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Divisions deleted", "Divisions deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Divisions", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Divisions", success);
        }

        return null;
    }

    public String createDorms() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved dorms " + getDorms().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getDorms());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getDivision().getName() + " saved successfully."));
            setDorms(new Dorms());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateDorms() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Dorms dorms = getEm().find(Dorms.class, getDorms().getIddorms());

            dorms = this.getDorms();
            getUtx().begin();
            getAudit().setAction("updated dorms " + dorms.getIddorms());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(dorms);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", dorms.getName() + " Updated successfully."));
            dorms = new Dorms();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a dorms."));
        }

        return null;
    }

    public String deleteDorms(Dorms dorms) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted dorms");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Dorms toBeRemoved = (Dorms) getEm().merge(dorms);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            dorms = new Dorms();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dorms deleted", "Dorms deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Dorms", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Dorms", success);
        }

        return null;
    }

    public String createExamgradingnewexamgrades() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved examgradingnewexamgrades " + getExamgradingnewexamgrades().getGrade());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getExamgradingnewexamgrades());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getDivision().getName() + " saved successfully."));
            setExamgradingnewexamgrades(new Examgradingnewexamgrades());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateExamgradingnewexamgrades() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Examgradingnewexamgrades examgradingnewexamgrades = getEm().find(Examgradingnewexamgrades.class, getExamgradingnewexamgrades().getIdexamgradingnewexamgrades());

            examgradingnewexamgrades = this.getExamgradingnewexamgrades();
            getUtx().begin();
            getAudit().setAction("updated examgradingnewexamgrades " + examgradingnewexamgrades.getIdexamgradingnewexamgrades());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(examgradingnewexamgrades);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", examgradingnewexamgrades.getGrade() + " Updated successfully."));
            examgradingnewexamgrades = new Examgradingnewexamgrades();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a examgradingnewexamgrades."));
        }

        return null;
    }

    public String deleteExamgradingnewexamgrades(Examgradingnewexamgrades examgradingnewexamgrades) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted examgradingnewexamgrades");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Examgradingnewexamgrades toBeRemoved = (Examgradingnewexamgrades) getEm().merge(examgradingnewexamgrades);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            examgradingnewexamgrades = new Examgradingnewexamgrades();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Examgradingnewexamgrades deleted", "Examgradingnewexamgrades deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examgradingnewexamgrades", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examgradingnewexamgrades", success);
        }

        return null;
    }

    public String createExamgradingsystem() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved examgradingsystem " + getExamgradingsystem().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getExamgradingsystem());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getDivision().getName() + " saved successfully."));
            setExamgradingsystem(new Examgradingsystem());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateExamgradingsystem() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Examgradingsystem examgradingsystem = getEm().find(Examgradingsystem.class, getExamgradingsystem().getIdexamgradingsystem());

            examgradingsystem = this.getExamgradingsystem();
            getUtx().begin();
            getAudit().setAction("updated examgradingsystem " + examgradingsystem.getIdexamgradingsystem());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(examgradingsystem);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", examgradingsystem.getName() + " Updated successfully."));
            examgradingsystem = new Examgradingsystem();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a examgradingsystem."));
        }

        return null;
    }

    public String deleteExamgradingsystem(Examgradingsystem examgradingsystem) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted examgradingsystem");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Examgradingsystem toBeRemoved = (Examgradingsystem) getEm().merge(examgradingsystem);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            examgradingsystem = new Examgradingsystem();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Examgradingsystem deleted", "Examgradingsystem deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examgradingsystem", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examgradingsystem", success);
        }

        return null;
    }

    public String createExamgradingsystemglobalsetup() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved examgradingsystemglobalsetup " + getExamgradingsystemglobalsetup().getForm());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getExamgradingsystemglobalsetup());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getDivision().getName() + " saved successfully."));
            setExamgradingsystemglobalsetup(new Examgradingsystemglobalsetup());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateExamgradingsystemglobalsetup() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Examgradingsystemglobalsetup examgradingsystemglobalsetup = getEm().find(Examgradingsystemglobalsetup.class, getExamgradingsystemglobalsetup().getIdexamgradingsystemglobalsetup());

            examgradingsystemglobalsetup = this.getExamgradingsystemglobalsetup();
            getUtx().begin();
            getAudit().setAction("updated examgradingsystemglobalsetup " + examgradingsystemglobalsetup.getIdexamgradingsystemglobalsetup());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(examgradingsystemglobalsetup);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", examgradingsystemglobalsetup.getForm() + " Updated successfully."));
            examgradingsystemglobalsetup = new Examgradingsystemglobalsetup();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a examgradingsystemglobalsetup."));
        }

        return null;
    }

    public String deleteExamgradingsystemglobalsetup(Examgradingsystemglobalsetup examgradingsystemglobalsetup) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted examgradingsystemglobalsetup");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Examgradingsystemglobalsetup toBeRemoved = (Examgradingsystemglobalsetup) getEm().merge(examgradingsystemglobalsetup);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            examgradingsystemglobalsetup = new Examgradingsystemglobalsetup();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Examgradingsystemglobalsetup deleted", "Examgradingsystemglobalsetup deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examgradingsystemglobalsetup", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examgradingsystemglobalsetup", success);
        }

        return null;
    }

    public String createExammeangrade() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved exammeangrade " + getExammeangrade().getCode());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getExammeangrade());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getExammeangrade().getCode() + " saved successfully."));
            setExammeangrade(new Exammeangrade());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateExammeangrade() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Exammeangrade exammeangrade = getEm().find(Exammeangrade.class, getExammeangrade().getIdexammeangrade());

            exammeangrade = this.getExammeangrade();
            getUtx().begin();
            getAudit().setAction("updated exammeangrade " + exammeangrade.getIdexammeangrade());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(exammeangrade);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", exammeangrade.getCode() + " Updated successfully."));
            exammeangrade = new Exammeangrade();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a exammeangrade."));
        }

        return null;
    }

    public String deleteExammeangrade(Exammeangrade exammeangrade) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted exammeangrade");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Exammeangrade toBeRemoved = (Exammeangrade) getEm().merge(exammeangrade);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            exammeangrade = new Exammeangrade();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exammeangrade deleted", "Exammeangrade deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exammeangrade", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Exammeangrade", success);
        }

        return null;
    }

    public String createExamsubjectremarks() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved examsubjectremarks " + getExamsubjectremarks().getComments());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getExamsubjectremarks());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getExamsubjectremarks().getComments() + " saved successfully."));
            setExamsubjectremarks(new Examsubjectremarks());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateExamsubjectremarks() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Examsubjectremarks examsubjectremarks = getEm().find(Examsubjectremarks.class, getExamsubjectremarks().getIdexamsubjectremarks());

            examsubjectremarks = this.getExamsubjectremarks();
            getUtx().begin();
            getAudit().setAction("updated examsubjectremarks " + examsubjectremarks.getIdexamsubjectremarks());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(examsubjectremarks);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", examsubjectremarks.getComments() + " Updated successfully."));
            examsubjectremarks = new Examsubjectremarks();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a examsubjectremarks."));
        }

        return null;
    }

    public String deleteExamsubjectremarks(Examsubjectremarks examsubjectremarks) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted examsubjectremarks");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Examsubjectremarks toBeRemoved = (Examsubjectremarks) getEm().merge(examsubjectremarks);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            examsubjectremarks = new Examsubjectremarks();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Examsubjectremarks deleted", "Examsubjectremarks deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examsubjectremarks", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examsubjectremarks", success);
        }

        return null;
    }

    public String createExamteachersetup() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved examteachersetup " + getExamteachersetup().getExam());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getExamteachersetup());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getExamteachersetup().getExam() + " saved successfully."));
            setExamteachersetup(new Examteachersetup());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateExamteachersetup() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Examteachersetup examteachersetup = getEm().find(Examteachersetup.class, getExamteachersetup().getIdexamteachersetup());

            examteachersetup = this.getExamteachersetup();
            getUtx().begin();
            getAudit().setAction("updated examteachersetup " + examteachersetup.getIdexamteachersetup());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(examteachersetup);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", examteachersetup.getExam() + " Updated successfully."));
            examteachersetup = new Examteachersetup();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a examteachersetup."));
        }

        return null;
    }

    public String deleteExamteachersetup(Examteachersetup examteachersetup) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted examteachersetup");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Examteachersetup toBeRemoved = (Examteachersetup) getEm().merge(examteachersetup);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            examteachersetup = new Examteachersetup();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Examteachersetup deleted", "Examteachersetup deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examteachersetup", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Examteachersetup", success);
        }

        return null;
    }

    public String createFinbanks() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finbanks " + getFinbanks().getBankname());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinbanks());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinbanks().getBankname() + " saved successfully."));
            setFinbanks(new Finbanks());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinbanks() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finbanks finbanks = getEm().find(Finbanks.class, getFinbanks().getIdfinbanks());

            finbanks = this.getFinbanks();
            getUtx().begin();
            getAudit().setAction("updated finbanks " + finbanks.getIdfinbanks());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finbanks);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finbanks.getBankname() + " Updated successfully."));
            finbanks = new Finbanks();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finbanks."));
        }

        return null;
    }

    public String deleteFinbanks(Finbanks finbanks) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finbanks");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finbanks toBeRemoved = (Finbanks) getEm().merge(finbanks);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finbanks = new Finbanks();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finbanks deleted", "Finbanks deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finbanks", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finbanks", success);
        }

        return null;
    }

    public String createFinfeebalances() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finfeeitems " + getFinfeeitems().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinfeeitems());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinfeebalances().getBalance() + " saved successfully."));
            setFinfeebalances(new Finfeebalances());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinfeebalances() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finfeebalances finfeebalances = getEm().find(Finfeebalances.class, getFinfeebalances().getIdfinfeebalances());

            finfeebalances = this.getFinfeebalances();
            getUtx().begin();
            getAudit().setAction("updated finfeebalances " + finfeebalances.getIdfinfeebalances());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finfeebalances);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finfeebalances.getBalance() + " Updated successfully."));
            finfeebalances = new Finfeebalances();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finfeebalances."));
        }

        return null;
    }

    public String deleteFinfeebalances(Finfeebalances finfeebalances) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finfeebalances");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finfeebalances toBeRemoved = (Finfeebalances) getEm().merge(finfeebalances);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finfeebalances = new Finfeebalances();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finfeebalances deleted", "Finfeebalances deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finfeebalances", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finfeebalances", success);
        }

        return null;
    }

    public String createFinfeeitems() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finfeeitems " + getFinfeeitems().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinfeeitems());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinfeeitems().getName() + " saved successfully."));
            setFinfeeitems(new Finfeeitems());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinfeeitems() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finfeeitems finfeeitems = getEm().find(Finfeeitems.class, getFinfeeitems().getIdfinfeeitems());

            finfeeitems = this.getFinfeeitems();
            getUtx().begin();
            getAudit().setAction("updated finfeeitems " + finfeeitems.getIdfinfeeitems());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finfeeitems);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finfeeitems.getName() + " Updated successfully."));
            finfeeitems = new Finfeeitems();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finfeeitems."));
        }

        return null;
    }

    public String deleteFinfeeitems(Finfeeitems finfeeitems) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finfeeitems");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finfeeitems toBeRemoved = (Finfeeitems) getEm().merge(finfeeitems);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finfeeitems = new Finfeeitems();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finfeeitems deleted", "Finfeeitems deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finfeeitems", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finfeeitems", success);
        }

        return null;
    }

    public String createFinfeestructure() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finfeestructure " + getFinfeestructure().getAmount());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinfeestructure());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinfeestructure().getAmount() + " saved successfully."));
            setFinfeestructure(new Finfeestructure());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinfeestructure() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finfeestructure finfeestructure = getEm().find(Finfeestructure.class, getFinfeestructure().getIdfinfeestructure());

            finfeestructure = this.getFinfeestructure();
            getUtx().begin();
            getAudit().setAction("updated finfeestructure " + finfeestructure.getIdfinfeestructure());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finfeestructure);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finfeestructure.getAmount() + " Updated successfully."));
            finfeestructure = new Finfeestructure();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finfeestructure."));
        }

        return null;
    }

    public String deleteFinfeestructure(Finfeestructure finfeestructure) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finfeestructure");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finfeestructure toBeRemoved = (Finfeestructure) getEm().merge(finfeestructure);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finfeestructure = new Finfeestructure();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finfeestructure deleted", "Finfeestructure deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finfeestructure", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finfeestructure", success);
        }

        return null;
    }

    public String createFinglaccount() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finglaccount " + getFinglaccount().getAccountname());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinglaccount());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinglaccount().getAccountname() + " saved successfully."));
            setFinglaccount(new Finglaccount());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinglaccount() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finglaccount finglaccount = getEm().find(Finglaccount.class, getFinglaccount().getIdfinglaccount());

            finglaccount = this.getFinglaccount();
            getUtx().begin();
            getAudit().setAction("updated finglaccount " + finglaccount.getIdfinglaccount());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finglaccount);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finglaccount.getAccountname() + " Updated successfully."));
            finglaccount = new Finglaccount();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finglaccount."));
        }

        return null;
    }

    public String deleteFinglaccount(Finglaccount finglaccount) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finglaccount");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finglaccount toBeRemoved = (Finglaccount) getEm().merge(finglaccount);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finglaccount = new Finglaccount();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finglaccount deleted", "Finglaccount deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finglaccount", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finglaccount", success);
        }

        return null;
    }

    public String createFininvoice() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved fininvoice " + getFininvoice().getDescription());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFininvoice());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFininvoice().getDescription() + " saved successfully."));
            setFininvoice(new Fininvoice());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFininvoice() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Fininvoice fininvoice = getEm().find(Fininvoice.class, getFininvoice().getIdfininvoice());

            fininvoice = this.getFininvoice();
            getUtx().begin();
            getAudit().setAction("updated fininvoice " + fininvoice.getIdfininvoice());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(fininvoice);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", fininvoice.getDescription() + " Updated successfully."));
            fininvoice = new Fininvoice();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a fininvoice."));
        }

        return null;
    }

    public String deleteFininvoice(Fininvoice fininvoice) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted fininvoice");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Fininvoice toBeRemoved = (Fininvoice) getEm().merge(fininvoice);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            fininvoice = new Fininvoice();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fininvoice deleted", "Fininvoice deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Fininvoice", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Fininvoice", success);
        }

        return null;
    }

    public String createFinledgeraccountbudget() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finledgeraccountbudget " + getFinledgeraccountbudget().getAmount());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinledgeraccountbudget());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinledgeraccountbudget().getAmount() + " saved successfully."));
            setFinledgeraccountbudget(new Finledgeraccountbudget());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinledgeraccountbudget() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finledgeraccountbudget finledgeraccountbudget = getEm().find(Finledgeraccountbudget.class, getFinledgeraccountbudget().getIdfinledgeraccountbudget());

            finledgeraccountbudget = this.getFinledgeraccountbudget();
            getUtx().begin();
            getAudit().setAction("updated finledgeraccountbudget " + finledgeraccountbudget.getIdfinledgeraccountbudget());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finledgeraccountbudget);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finledgeraccountbudget.getAmount() + " Updated successfully."));
            finledgeraccountbudget = new Finledgeraccountbudget();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finledgeraccountbudget."));
        }

        return null;
    }

    public String deleteFinledgeraccountbudget(Finledgeraccountbudget finledgeraccountbudget) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finledgeraccountbudget");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finledgeraccountbudget toBeRemoved = (Finledgeraccountbudget) getEm().merge(finledgeraccountbudget);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finledgeraccountbudget = new Finledgeraccountbudget();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finledgeraccountbudget deleted", "Finledgeraccountbudget deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgeraccountbudget", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgeraccountbudget", success);
        }

        return null;
    }

    public String createFinledgeraccountgroups() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finledgeraccountgroups " + getFinledgeraccountgroups().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinledgeraccountgroups());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinledgeraccountgroups().getName() + " saved successfully."));
            setFinledgeraccountgroups(new Finledgeraccountgroups());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinledgeraccountgroups() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finledgeraccountgroups finledgeraccountgroups = getEm().find(Finledgeraccountgroups.class, getFinledgeraccountgroups().getIdfinledgeraccountgroups());

            finledgeraccountgroups = this.getFinledgeraccountgroups();
            getUtx().begin();
            getAudit().setAction("updated finledgeraccountgroups " + finledgeraccountgroups.getIdfinledgeraccountgroups());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finledgeraccountgroups);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finledgeraccountgroups.getName() + " Updated successfully."));
            finledgeraccountgroups = new Finledgeraccountgroups();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finledgeraccountgroups."));
        }

        return null;
    }

    public String deleteFinledgeraccountgroups(Finledgeraccountgroups finledgeraccountgroups) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finledgeraccountgroups");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finledgeraccountgroups toBeRemoved = (Finledgeraccountgroups) getEm().merge(finledgeraccountgroups);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finledgeraccountgroups = new Finledgeraccountgroups();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finledgeraccountgroups deleted", "Finledgeraccountgroups deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgeraccountgroups", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgeraccountgroups", success);
        }

        return null;
    }

    public String createFinledgeraccounts() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finledgeraccounts " + getFinledgeraccounts().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinledgeraccounts());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinledgeraccounts().getName() + " saved successfully."));
            setFinledgeraccounts(new Finledgeraccounts());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinledgeraccounts() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finledgeraccounts finledgeraccounts = getEm().find(Finledgeraccounts.class, getFinledgeraccounts().getIdfinledgeraccounts());

            finledgeraccounts = this.getFinledgeraccounts();
            getUtx().begin();
            getAudit().setAction("updated finledgeraccounts " + finledgeraccounts.getIdfinledgeraccounts());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finledgeraccounts);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finledgeraccounts.getName() + " Updated successfully."));
            finledgeraccounts = new Finledgeraccounts();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finledgeraccounts."));
        }

        return null;
    }

    public String deleteFinledgeraccounts(Finledgeraccounts finledgeraccounts) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finledgeraccounts");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finledgeraccounts toBeRemoved = (Finledgeraccounts) getEm().merge(finledgeraccounts);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finledgeraccounts = new Finledgeraccounts();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finledgeraccounts deleted", "Finledgeraccounts deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgeraccounts", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgeraccounts", success);
        }

        return null;
    }

    public String createFinledgeraccountypes() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finledgeraccountypes " + getFinledgeraccountypes().getTypename());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinledgeraccountypes());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinledgeraccountypes().getTypename() + " saved successfully."));
            setFinledgeraccountypes(new Finledgeraccountypes());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinledgeraccountypes() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finledgeraccountypes finledgeraccountypes = getEm().find(Finledgeraccountypes.class, getFinledgeraccountypes().getIdfinledgeraccountypes());

            finledgeraccountypes = this.getFinledgeraccountypes();
            getUtx().begin();
            getAudit().setAction("updated finledgeraccountypes " + finledgeraccountypes.getIdfinledgeraccountypes());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finledgeraccountypes);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finledgeraccountypes.getTypename() + " Updated successfully."));
            finledgeraccountypes = new Finledgeraccountypes();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finledgeraccountypes."));
        }

        return null;
    }

    public String deleteFinledgeraccountypes(Finledgeraccountypes finledgeraccountypes) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finledgeraccountypes");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finledgeraccountypes toBeRemoved = (Finledgeraccountypes) getEm().merge(finledgeraccountypes);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finledgeraccountypes = new Finledgeraccountypes();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finledgeraccountypes deleted", "Finledgeraccountypes deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgeraccountypes", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgeraccountypes", success);
        }

        return null;
    }

    public String createFinledgergroupcategories() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finledgergroupcategories " + getFinledgergroupcategories().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinledgergroupcategories());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinledgergroupcategories().getName() + " saved successfully."));
            setFinledgergroupcategories(new Finledgergroupcategories());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinledgergroupcategories() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finledgergroupcategories finledgergroupcategories = getEm().find(Finledgergroupcategories.class, getFinledgergroupcategories().getIdfinledgergroupcategories());

            finledgergroupcategories = this.getFinledgergroupcategories();
            getUtx().begin();
            getAudit().setAction("updated finledgergroupcategories " + finledgergroupcategories.getIdfinledgergroupcategories());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finledgergroupcategories);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finledgergroupcategories.getName() + " Updated successfully."));
            finledgergroupcategories = new Finledgergroupcategories();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finledgergroupcategories."));
        }

        return null;
    }

    public String deleteFinledgergroupcategories(Finledgergroupcategories finledgergroupcategories) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finledgergroupcategories");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finledgergroupcategories toBeRemoved = (Finledgergroupcategories) getEm().merge(finledgergroupcategories);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finledgergroupcategories = new Finledgergroupcategories();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finledgergroupcategories deleted", "Finledgergroupcategories deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgergroupcategories", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finledgergroupcategories", success);
        }

        return null;
    }

    public String createFinpaymentmodes() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finpaymentmodes " + getFinpaymentmodes().getDescription());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getFinpaymentmodes());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinpaymentmodes().getDescription() + " saved successfully."));
            setFinpaymentmodes(new Finpaymentmodes());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinpaymentmodes() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finpaymentmodes finpaymentmodes = getEm().find(Finpaymentmodes.class, getFinpaymentmodes().getIdfinpaymentmodes());

            finpaymentmodes = this.getFinpaymentmodes();
            getUtx().begin();
            getAudit().setAction("updated finpaymentmodes " + finpaymentmodes.getIdfinpaymentmodes());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finpaymentmodes);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finpaymentmodes.getDescription() + " Updated successfully."));
            finpaymentmodes = new Finpaymentmodes();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finpaymentmodes."));
        }

        return null;
    }

    public String deleteFinpaymentmodes(Finpaymentmodes finpaymentmodes) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finpaymentmodes");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finpaymentmodes toBeRemoved = (Finpaymentmodes) getEm().merge(finpaymentmodes);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finpaymentmodes = new Finpaymentmodes();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finpaymentmodes deleted", "Finpaymentmodes deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finpaymentmodes", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finpaymentmodes", success);
        }

        return null;
    }

    public String createFinreceipt() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finreceipt " + getFinreceipt().getAmount());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getFinreceipt());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinreceipt().getAmount() + " saved successfully."));
            setFinreceipt(new Finreceipt());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinreceipt() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finreceipt finreceipt = getEm().find(Finreceipt.class, getFinreceipt().getIdfinreceipt());

            finreceipt = this.getFinreceipt();
            getUtx().begin();
            getAudit().setAction("updated finreceipt " + finreceipt.getIdfinreceipt());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finreceipt);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finreceipt.getAmount() + " Updated successfully."));
            finreceipt = new Finreceipt();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finreceipt."));
        }

        return null;
    }

    public String deleteFinreceipt(Finreceipt finreceipt) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finreceipt");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finreceipt toBeRemoved = (Finreceipt) getEm().merge(finreceipt);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finreceipt = new Finreceipt();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finreceipt deleted", "Finreceipt deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finreceipt", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finreceipt", success);
        }

        return null;
    }

    public String createFinuom() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finuom " + getFinuom().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getFinuom());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinuom().getName() + " saved successfully."));
            setFinuom(new Finuom());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinuom() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finuom finuom = getEm().find(Finuom.class, getFinuom().getIdfinuon());

            finuom = this.getFinuom();
            getUtx().begin();
            getAudit().setAction("updated finuom " + finuom.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finuom);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finuom.getName() + " Updated successfully."));
            finuom = new Finuom();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finuom."));
        }

        return null;
    }

    public String deleteFinuom(Finuom finuom) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finuom");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finuom toBeRemoved = (Finuom) getEm().merge(finuom);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finuom = new Finuom();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finuom deleted", "Finuom deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finuom", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finuom", success);
        }

        return null;
    }

    public String createFinyear() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved finyear " + getFinyear().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getFinyear());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getFinyear().getName() + " saved successfully."));
            setFinyear(new Finyear());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateFinyear() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Finyear finyear = getEm().find(Finyear.class, getFinyear().getIdfiyear());

            finyear = this.getFinyear();
            getUtx().begin();
            getAudit().setAction("updated finyear " + finyear.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(finyear);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", finyear.getName() + " Updated successfully."));
            finyear = new Finyear();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a finyear."));
        }

        return null;
    }

    public String deleteFinyear(Finyear finyear) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted finyear");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Finyear toBeRemoved = (Finyear) getEm().merge(finyear);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            finyear = new Finyear();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Finyear deleted", "Finyear deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finyear", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Finyear", success);
        }

        return null;
    }

    public String createForms() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved forms " + getForms().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getForms());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getForms().getName() + " saved successfully."));
            setForms(new Forms());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateForms() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Forms forms = getEm().find(Forms.class, getForms().getIdforms());

            forms = this.getForms();
            getUtx().begin();
            getAudit().setAction("updated forms " + forms.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(forms);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", forms.getName() + " Updated successfully."));
            forms = new Forms();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a forms."));
        }

        return null;
    }

    public String deleteForms(Forms forms) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted forms");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Forms toBeRemoved = (Forms) getEm().merge(forms);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            forms = new Forms();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Forms deleted", "Forms deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Forms", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Forms", success);
        }

        return null;
    }

    public String createHouses() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved houses " + getHouses().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getHouses());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getHouses().getName() + " saved successfully."));
            setHouses(new Houses());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateHouses() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Houses houses = getEm().find(Houses.class, getHouses().getIdhouses());

            houses = this.getHouses();
            getUtx().begin();
            getAudit().setAction("updated houses " + houses.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(houses);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", houses.getName() + " Updated successfully."));
            houses = new Houses();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a houses."));
        }

        return null;
    }

    public String deleteHouses(Houses houses) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted houses");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Houses toBeRemoved = (Houses) getEm().merge(houses);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            houses = new Houses();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Houses deleted", "Houses deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Houses", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Houses", success);
        }

        return null;
    }

    public String createKcpegrade() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved kcpegrade " + getKcpegrade().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getKcpegrade());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getKcpegrade().getName() + " saved successfully."));
            setKcpegrade(new Kcpegrade());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateKcpegrade() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Kcpegrade kcpegrade = getEm().find(Kcpegrade.class, getKcpegrade().getIdkcpegrade());

            kcpegrade = this.getKcpegrade();
            getUtx().begin();
            getAudit().setAction("updated kcpegrade " + kcpegrade.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(kcpegrade);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", kcpegrade.getName() + " Updated successfully."));
            kcpegrade = new Kcpegrade();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a kcpegrade."));
        }

        return null;
    }

    public String deleteKcpegrade(Kcpegrade kcpegrade) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted kcpegrade");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Kcpegrade toBeRemoved = (Kcpegrade) getEm().merge(kcpegrade);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            kcpegrade = new Kcpegrade();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kcpegrade deleted", "Kcpegrade deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Kcpegrade", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Kcpegrade", success);
        }

        return null;
    }

    public String createLibrary() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved library " + getLibrary().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrary());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrary().getName() + " saved successfully."));
            setLibrary(new Library());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrary() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Library library = getEm().find(Library.class, getLibrary().getIdlibrary());

            library = this.getLibrary();
            getUtx().begin();
            getAudit().setAction("updated library " + library.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(library);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", library.getName() + " Updated successfully."));
            library = new Library();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a library."));
        }

        return null;
    }

    public String deleteLibrary(Library library) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted library");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Library toBeRemoved = (Library) getEm().merge(library);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            library = new Library();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Library deleted", "Library deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Library", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Library", success);
        }

        return null;
    }

    public String createLibraryauthors() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved libraryauthors " + getLibraryauthors().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibraryauthors());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibraryauthors().getName() + " saved successfully."));
            setLibraryauthors(new Libraryauthors());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibraryauthors() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Libraryauthors libraryauthors = getEm().find(Libraryauthors.class, getLibraryauthors().getIdlibraryauthors());

            libraryauthors = this.getLibraryauthors();
            getUtx().begin();
            getAudit().setAction("updated libraryauthors " + libraryauthors.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(libraryauthors);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", libraryauthors.getName() + " Updated successfully."));
            libraryauthors = new Libraryauthors();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a libraryauthors."));
        }

        return null;
    }

    public String deleteLibraryauthors(Libraryauthors libraryauthors) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted libraryauthors");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Libraryauthors toBeRemoved = (Libraryauthors) getEm().merge(libraryauthors);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            libraryauthors = new Libraryauthors();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Libraryauthors deleted", "Libraryauthors deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Libraryauthors", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Libraryauthors", success);
        }

        return null;
    }

    public String createLibrarybookcategories() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarybookcategories " + getLibrarybookcategories().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarybookcategories());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarybookcategories().getName() + " saved successfully."));
            setLibrarybookcategories(new Librarybookcategories());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarybookcategories() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarybookcategories librarybookcategories = getEm().find(Librarybookcategories.class, getLibrarybookcategories().getIdlibrarybookcategories());

            librarybookcategories = this.getLibrarybookcategories();
            getUtx().begin();
            getAudit().setAction("updated librarybookcategories " + librarybookcategories.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarybookcategories);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarybookcategories.getName() + " Updated successfully."));
            librarybookcategories = new Librarybookcategories();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarybookcategories."));
        }

        return null;
    }

    public String deleteLibrarybookcategories(Librarybookcategories librarybookcategories) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarybookcategories");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarybookcategories toBeRemoved = (Librarybookcategories) getEm().merge(librarybookcategories);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarybookcategories = new Librarybookcategories();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarybookcategories deleted", "Librarybookcategories deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarybookcategories", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarybookcategories", success);
        }

        return null;
    }

    public String createLibrarycatalog() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarycatalog " + getLibrarycatalog().getBookseries());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarycatalog());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarycatalog().getBookseries() + " saved successfully."));
            setLibrarycatalog(new Librarycatalog());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarycatalog() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarycatalog librarycatalog = getEm().find(Librarycatalog.class, getLibrarycatalog().getIdlibrarynewbook());

            librarycatalog = this.getLibrarycatalog();
            getUtx().begin();
            getAudit().setAction("updated librarycatalog " + librarycatalog.getBookseries());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarycatalog);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarycatalog.getBookseries() + " Updated successfully."));
            librarycatalog = new Librarycatalog();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarycatalog."));
        }

        return null;
    }

    public String deleteLibrarycatalog(Librarycatalog librarycatalog) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarycatalog");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarycatalog toBeRemoved = (Librarycatalog) getEm().merge(librarycatalog);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarycatalog = new Librarycatalog();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarycatalog deleted", "Librarycatalog deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarycatalog", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarycatalog", success);
        }

        return null;
    }

    public String createLibraryfeefines() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved libraryfeefines " + getLibraryfeefines().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibraryfeefines());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibraryfeefines().getName() + " saved successfully."));
            setLibraryfeefines(new Libraryfeefines());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibraryfeefines() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Libraryfeefines libraryfeefines = getEm().find(Libraryfeefines.class, getLibraryfeefines().getIdlibraryfeefines());

            libraryfeefines = this.getLibraryfeefines();
            getUtx().begin();
            getAudit().setAction("updated libraryfeefines " + libraryfeefines.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(libraryfeefines);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", libraryfeefines.getName() + " Updated successfully."));
            libraryfeefines = new Libraryfeefines();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a libraryfeefines."));
        }

        return null;
    }

    public String deleteLibraryfeefines(Libraryfeefines libraryfeefines) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted libraryfeefines");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Libraryfeefines toBeRemoved = (Libraryfeefines) getEm().merge(libraryfeefines);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            libraryfeefines = new Libraryfeefines();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Libraryfeefines deleted", "Libraryfeefines deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Libraryfeefines", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Libraryfeefines", success);
        }

        return null;
    }

    public String createNtspta() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved nonteaching staff pta " + getNtspta().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getNtspta());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getNtspta().getName() + " saved successfully."));
            setNtspta(new Ntspta());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateNtspta() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Ntspta ntspta = getEm().find(Ntspta.class, getNtspta().getIdntspta());

            this.setNtspta(ntspta);
            getUtx().begin();
            getAudit().setAction("updated ntspta " + ntspta.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(ntspta);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", ntspta.getName() + " Updated successfully."));
            setNtspta(new Ntspta());
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a non teaching staff pta."));
        }

        return null;
    }

    public String deleteNtspta(Ntspta ntspta) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted ntspta");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Ntspta toBeRemoved = (Ntspta) getEm().merge(ntspta);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            setNtspta(new Ntspta());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ntspta deleted", "ntspta deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ntspta", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ntspta", success);
        }

        return null;
    }

    public String createNtsbogcategories() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("saved user " + getNtsbogcategories().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getNtsbogcategories());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getNtsbogcategories().getName() + " saved successfully."));
            setNtsbogcategories(new Ntsbogcategories());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateNtsbogcategories() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Ntsbogcategories ntsbogcategories = getEm().find(Ntsbogcategories.class, getNtsbogcategories().getIdntsbogcategories());

            this.setNtsbogcategories(ntsbogcategories);
            getUtx().begin();
            getAudit().setAction("updated ntsbogcategories " + ntsbogcategories.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(ntsbogcategories);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", ntsbogcategories.getName() + " Updated successfully."));
            setNtsbogcategories(new Ntsbogcategories());
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a farmer group."));
        }

        return null;
    }

    public String deleteNtsbogcategories(Ntsbogcategories ntsbogcategories) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted ntsbogcategories");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Ntsbogcategories toBeRemoved = (Ntsbogcategories) getEm().merge(ntsbogcategories);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            setNtsbogcategories(new Ntsbogcategories());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ntsbogcategories deleted", "ntsbogcategories deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ntsbogcategories", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ntsbogcategories", success);
        }

        return null;
    }

    public String createNtsptacategory() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved user " + getNtsptacategory().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getNtsptacategory());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getNtsptacategory().getName() + " saved successfully."));
            setNtsptacategory(new Ntsptacategory());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateNtsptacategory() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Ntsptacategory ntsptacategory = getEm().find(Ntsptacategory.class, getNtsptacategory().getIdntsptacategory());

            this.setNtsptacategory(ntsptacategory);
            getUtx().begin();
            getAudit().setAction("updated ntsptacategory " + ntsptacategory.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(ntsptacategory);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", ntsptacategory.getName() + " Updated successfully."));
            setNtsptacategory(new Ntsptacategory());
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a farmer group."));
        }

        return null;
    }

    public String deleteNtsptacategory(Ntsptacategory ntsptacategory) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted ntsptacategory");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Ntsptacategory toBeRemoved = (Ntsptacategory) getEm().merge(ntsptacategory);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            setNtsptacategory(new Ntsptacategory());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ntsptacategory deleted", "ntsptacategory deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ntsptacategory", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ntsptacategory", success);
        }

        return null;
    }

    public String createNtsbog() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getStatus().setIdstatus(1);
            getUtx().begin();
            getAudit().setAction("saved ntsbog " + getNtsbog().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());

            getEm().persist(getAudit());
            getEm().persist(getNtsbog());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getNtsbog().getName() + " saved successfully."));
            setNtsbog(new Ntsbog());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        setNtsbog(new Ntsbog());
        return null;
    }

    public String updateNtsbog() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Ntsbog user = getEm().find(Ntsbog.class, getNtsbog().getIdntsbog());
            getUtx().begin();
            getAudit().setAction("updated ntsbog " + getNtsbog().getName());
            getAudit().setCreatedby(this.getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(getNtsbog());
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getNtsbog().getName() + " Updated successfully."));
            setNtsbog(new Ntsbog());
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a dealer."));
        }
        setNtsbog(new Ntsbog());
        return null;
    }

    public String deleteNtsbog(Ntsbog product) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted ntsbog");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Ntsbog toBeRemoved = (Ntsbog) getEm().merge(product);
            getEm().remove(toBeRemoved);
            getUtx().commit();

            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ntsbog deleted", "ntsbog deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ntsbog", success);
            product = new Ntsbog();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("ntsbog", success);
        }
        setNtsbog(new Ntsbog());
        return null;
    }

    public String createLibrarylendreceive() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarylendreceive " + getLibrarylendreceive().getBook().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarylendreceive());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarylendreceive().getBook().getName() + " saved successfully."));
            setLibrarylendreceive(new Librarylendreceive());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarylendreceive() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarylendreceive librarylendreceive = getEm().find(Librarylendreceive.class, getLibrarylendreceive().getIdlibrarylend());

            librarylendreceive = this.getLibrarylendreceive();
            getUtx().begin();
            getAudit().setAction("updated librarylendreceive " + librarylendreceive.getBook().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarylendreceive);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarylendreceive.getBook().getName() + " Updated successfully."));
            librarylendreceive = new Librarylendreceive();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarylendreceive."));
        }

        return null;
    }

    public String deleteLibrarylendreceive(Librarylendreceive librarylendreceive) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarylendreceive");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarylendreceive toBeRemoved = (Librarylendreceive) getEm().merge(librarylendreceive);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarylendreceive = new Librarylendreceive();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarylendreceive deleted", "Librarylendreceive deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarylendreceive", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarylendreceive", success);
        }

        return null;
    }

    public String createLibrarylendstationery() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarylendstationery " + getLibrarylendstationery().getDescription());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarylendstationery());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarylendstationery().getDescription() + " saved successfully."));
            setLibrarylendstationery(new Librarylendstationery());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarylendstationery() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarylendstationery librarylendstationery = getEm().find(Librarylendstationery.class, getLibrarylendstationery().getIdlibrarylendstationery());

            librarylendstationery = this.getLibrarylendstationery();
            getUtx().begin();
            getAudit().setAction("updated librarylendstationery " + librarylendstationery.getDescription());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarylendstationery);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarylendstationery.getDescription() + " Updated successfully."));
            librarylendstationery = new Librarylendstationery();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarylendstationery."));
        }

        return null;
    }

    public String deleteLibrarylendstationery(Librarylendstationery librarylendstationery) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarylendstationery");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarylendstationery toBeRemoved = (Librarylendstationery) getEm().merge(librarylendstationery);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarylendstationery = new Librarylendstationery();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarylendstationery deleted", "Librarylendstationery deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarylendstationery", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarylendstationery", success);
        }

        return null;
    }

    public String createLibrarymember() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarymember " + getLibrarymember().getMember());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarymember());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarymember().getMember() + " saved successfully."));
            setLibrarymember(new Librarymember());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarymember() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarymember librarymember = getEm().find(Librarymember.class, getLibrarymember().getIdlibrarymember());

            librarymember = this.getLibrarymember();
            getUtx().begin();
            getAudit().setAction("updated librarymember " + librarymember.getMember());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarymember);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarymember.getMember() + " Updated successfully."));
            librarymember = new Librarymember();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarymember."));
        }

        return null;
    }

    public String deleteLibrarymember(Librarymember librarymember) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarymember");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarymember toBeRemoved = (Librarymember) getEm().merge(librarymember);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarymember = new Librarymember();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarymember deleted", "Librarymember deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarymember", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarymember", success);
        }

        return null;
    }

    public String createLibrarymembertypes() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarymembertypes " + getLibrarymembertypes().getIdlibrarymembertypes());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarymembertypes());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarymembertypes().getName() + " saved successfully."));
            setLibrarymembertypes(new Librarymembertypes());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarymembertypes() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarymembertypes librarymembertypes = getEm().find(Librarymembertypes.class, getLibrarymembertypes().getIdlibrarymembertypes());

            librarymembertypes = this.getLibrarymembertypes();
            getUtx().begin();
            getAudit().setAction("updated librarymembertypes " + librarymembertypes.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarymembertypes);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarymembertypes.getName() + " Updated successfully."));
            librarymembertypes = new Librarymembertypes();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarymembertypes."));
        }

        return null;
    }

    public String deleteLibrarymembertypes(Librarymembertypes librarymembertypes) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarymembertypes");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarymembertypes toBeRemoved = (Librarymembertypes) getEm().merge(librarymembertypes);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarymembertypes = new Librarymembertypes();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarymembertypes deleted", "Librarymembertypes deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarymembertypes", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarymembertypes", success);
        }

        return null;
    }

    public String createLibrarynewbookacquisition() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarynewbookacquisition " + getLibrarynewbookacquisition().getIdlibrarynewbookacquisition());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarynewbookacquisition());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarynewbookacquisition().getBook().getName() + " saved successfully."));
            setLibrarynewbookacquisition(new Librarynewbookacquisition());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarynewbookacquisition() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarynewbookacquisition librarynewbookacquisition = getEm().find(Librarynewbookacquisition.class, getLibrarynewbookacquisition().getIdlibrarynewbookacquisition());

            librarynewbookacquisition = this.getLibrarynewbookacquisition();
            getUtx().begin();
            getAudit().setAction("updated librarynewbookacquisition " + librarynewbookacquisition.getBook().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarynewbookacquisition);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarynewbookacquisition.getBook().getName() + " Updated successfully."));
            librarynewbookacquisition = new Librarynewbookacquisition();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarynewbookacquisition."));
        }

        return null;
    }

    public String deleteLibrarynewbookacquisition(Librarynewbookacquisition librarynewbookacquisition) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarynewbookacquisition");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarynewbookacquisition toBeRemoved = (Librarynewbookacquisition) getEm().merge(librarynewbookacquisition);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarynewbookacquisition = new Librarynewbookacquisition();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarynewbookacquisition deleted", "Librarynewbookacquisition deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarynewbookacquisition", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarynewbookacquisition", success);
        }

        return null;
    }

    public String createLibrarynewstationery() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarynewstationery " + getLibrarynewstationery().getIdlibrarynewstationery());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarynewstationery());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarynewstationery().getStationery().getName() + " saved successfully."));
            setLibrarynewstationery(new Librarynewstationery());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarynewstationery() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarynewstationery librarynewstationery = getEm().find(Librarynewstationery.class, getLibrarynewstationery().getIdlibrarynewstationery());

            librarynewstationery = this.getLibrarynewstationery();
            getUtx().begin();
            getAudit().setAction("updated librarynewstationery " + librarynewstationery.getStationery().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarynewstationery);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarynewstationery.getStationery().getName() + " Updated successfully."));
            librarynewstationery = new Librarynewstationery();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarynewstationery."));
        }

        return null;
    }

    public String deleteLibrarynewstationery(Librarynewstationery librarynewstationery) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarynewstationery");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarynewstationery toBeRemoved = (Librarynewstationery) getEm().merge(librarynewstationery);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarynewstationery = new Librarynewstationery();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarynewstationery deleted", "Librarynewstationery deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarynewstationery", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarynewstationery", success);
        }

        return null;
    }
//
//    public String createLibrarynewstationeryacquisition() {
//        try {
//            if (StringUtils.isEmpty(getUsername())) {
//
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
//                return "/index.xhtml";
//            }
//
//            getUtx().begin();
//            getAudit().setAction("saved librarynewstationeryacquisition " + librarynewstationeryacquisition.getIdlibrarynewstationeryacquisition());
//            getAudit().setCreatedby(user);
//            getAudit().setTimer(new Date());
//            getEm().persist(getAudit());
//            getEm().persist(librarynewstationeryacquisition);
//            getUtx().commit();
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarynewstationeryacquisition().getStationery().getName() + " saved successfully."));
//            setLibrarynewstationeryacquisition(new Librarynewstationeryacquisition());
//
//        } catch (Exception ex) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
//            ex.printStackTrace();
//            getLogger().info(ex.getMessage());
//        }
//        return null;
//    }
//
//    public String updateLibrarynewstationeryacquisition() {
//        try {
//            if (StringUtils.isEmpty(getUsername())) {
//
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
//                return "/index.xhtml";
//            }
//            Librarynewstationeryacquisition librarynewstationeryacquisition = getEm().find(Librarynewstationeryacquisition.class, getLibrarynewstationeryacquisition().getIdlibrarynewstationeryacquisition());
//
//            librarynewstationeryacquisition = this.librarynewstationeryacquisition;
//            getUtx().begin();
//            getAudit().setAction("updated librarynewstationeryacquisition " + librarynewstationeryacquisition.getStationery().getName());
//            getAudit().setCreatedby(user);
//            getAudit().setTimer(new Date());
//            getEm().persist(getAudit());
//            getEm().merge(librarynewstationeryacquisition);
//            getUtx().commit();
//
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarynewstationeryacquisition.getStationery().getName() + " Updated successfully."));
//            librarynewstationeryacquisition = new Librarynewstationeryacquisition();
//        } catch (Exception ex) {
//            getLogger().info(ex.getMessage());
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarynewstationeryacquisition."));
//        }
//
//        return null;
//    }
//
//    public String deleteLibrarynewstationeryacquisition(Librarynewstationeryacquisition librarynewstationeryacquisition) {
//        try {
//            if (StringUtils.isEmpty(getUsername())) {
//
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
//                return "/index.xhtml";
//            }
//            getUtx().begin();
//            getAudit().setAction("Deleted librarynewstationeryacquisition");
//            getAudit().setCreatedby(user);
//            getAudit().setTimer(new Date());
//            getEm().persist(getAudit());
//            Librarynewstationeryacquisition toBeRemoved = (Librarynewstationeryacquisition) getEm().merge(librarynewstationeryacquisition);
//            getEm().remove(toBeRemoved);
//            getUtx().commit();
//            librarynewstationeryacquisition = new Librarynewstationeryacquisition();
//            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarynewstationeryacquisition deleted", "Librarynewstationeryacquisition deleted");
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage("Librarynewstationeryacquisition", success);
//
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            getLogger().info(e.getMessage());
//            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage("Librarynewstationeryacquisition", success);
//        }
//
//        return null;
//    }

    public String createLibrarypublishers() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarypublishers " + getLibrarypublishers().getIdlibrarypublishers());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarypublishers());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarypublishers().getName() + " saved successfully."));
            setLibrarypublishers(new Librarypublishers());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarypublishers() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarypublishers librarypublishers = getEm().find(Librarypublishers.class, getLibrarypublishers().getIdlibrarypublishers());

            librarypublishers = this.getLibrarypublishers();
            getUtx().begin();
            getAudit().setAction("updated librarypublishers " + librarypublishers.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarypublishers);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarypublishers.getName() + " Updated successfully."));
            librarypublishers = new Librarypublishers();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarypublishers."));
        }

        return null;
    }

    public String deleteLibrarypublishers(Librarypublishers librarypublishers) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarypublishers");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarypublishers toBeRemoved = (Librarypublishers) getEm().merge(librarypublishers);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarypublishers = new Librarypublishers();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarypublishers deleted", "Librarypublishers deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarypublishers", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarypublishers", success);
        }

        return null;
    }

    public String createLibraryshelve() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved libraryshelve " + getLibraryshelve().getIdlibraryshelve());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibraryshelve());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibraryshelve().getName() + " saved successfully."));
            setLibraryshelve(new Libraryshelve());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibraryshelve() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Libraryshelve libraryshelve = getEm().find(Libraryshelve.class, getLibraryshelve().getIdlibraryshelve());

            libraryshelve = this.getLibraryshelve();
            getUtx().begin();
            getAudit().setAction("updated libraryshelve " + libraryshelve.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(libraryshelve);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", libraryshelve.getName() + " Updated successfully."));
            libraryshelve = new Libraryshelve();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a libraryshelve."));
        }

        return null;
    }

    public String deleteLibraryshelve(Libraryshelve libraryshelve) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted libraryshelve");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Libraryshelve toBeRemoved = (Libraryshelve) getEm().merge(libraryshelve);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            libraryshelve = new Libraryshelve();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Libraryshelve deleted", "Libraryshelve deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Libraryshelve", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Libraryshelve", success);
        }

        return null;
    }

    public String createLibrarystationerycategories() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarystationerycategories " + getLibrarystationerycategories().getIdlibrarystationerycategories());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarystationerycategories());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarystationerycategories().getName() + " saved successfully."));
            setLibrarystationerycategories(new Librarystationerycategories());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarystationerycategories() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarystationerycategories librarystationerycategories = getEm().find(Librarystationerycategories.class, getLibrarystationerycategories().getIdlibrarystationerycategories());

            librarystationerycategories = this.getLibrarystationerycategories();
            getUtx().begin();
            getAudit().setAction("updated librarystationerycategories " + librarystationerycategories.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarystationerycategories);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarystationerycategories.getName() + " Updated successfully."));
            librarystationerycategories = new Librarystationerycategories();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarystationerycategories."));
        }

        return null;
    }

    public String deleteLibrarystationerycategories(Librarystationerycategories librarystationerycategories) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarystationerycategories");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarystationerycategories toBeRemoved = (Librarystationerycategories) getEm().merge(librarystationerycategories);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarystationerycategories = new Librarystationerycategories();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarystationerycategories deleted", "Librarystationerycategories deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarystationerycategories", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarystationerycategories", success);
        }

        return null;
    }

    public String createLibrarysuppliers() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved librarysuppliers " + getLibrarysuppliers().getIdlibrarysuppliers());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLibrarysuppliers());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLibrarysuppliers().getName() + " saved successfully."));
            setLibrarysuppliers(new Librarysuppliers());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLibrarysuppliers() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Librarysuppliers librarysuppliers = getEm().find(Librarysuppliers.class, getLibrarysuppliers().getIdlibrarysuppliers());

            librarysuppliers = this.getLibrarysuppliers();
            getUtx().begin();
            getAudit().setAction("updated librarysuppliers " + librarysuppliers.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(librarysuppliers);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", librarysuppliers.getName() + " Updated successfully."));
            librarysuppliers = new Librarysuppliers();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a librarysuppliers."));
        }

        return null;
    }

    public String deleteLibrarysuppliers(Librarysuppliers librarysuppliers) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted librarysuppliers");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Librarysuppliers toBeRemoved = (Librarysuppliers) getEm().merge(librarysuppliers);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            librarysuppliers = new Librarysuppliers();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Librarysuppliers deleted", "Librarysuppliers deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarysuppliers", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Librarysuppliers", success);
        }

        return null;
    }

    public String createLocation() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved location " + getLocation().getIdlocation());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getLocation());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getLocation().getName() + " saved successfully."));
            setLocation(new Location());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateLocation() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Location location = getEm().find(Location.class, getLocation().getIdlocation());

            location = this.getLocation();
            getUtx().begin();
            getAudit().setAction("updated location " + location.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(location);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", location.getName() + " Updated successfully."));
            location = new Location();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a location."));
        }

        return null;
    }

    public String deleteLocation(Location location) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted location");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Location toBeRemoved = (Location) getEm().merge(location);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            location = new Location();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Location deleted", "Location deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Location", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Location", success);
        }

        return null;
    }

    public String createSubLocation() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved sublocation " + getSublocation().getIdsublocation());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getSublocation());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getSublocation().getName() + " saved successfully."));
            setSublocation(new Sublocation());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateSubLocation() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Sublocation sublocation = getEm().find(Sublocation.class, getSublocation().getIdsublocation());

            sublocation = this.getSublocation();
            getUtx().begin();
            getAudit().setAction("updated sublocation " + sublocation.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(sublocation);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", sublocation.getName() + " Updated successfully."));
            sublocation = new Sublocation();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a sublocation."));
        }

        return null;
    }

    public String deleteSublocation(Sublocation sublocation) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted sublocation");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Sublocation toBeRemoved = (Sublocation) getEm().merge(sublocation);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            sublocation = new Sublocation();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sublocation deleted", "Sublocation deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Sublocation", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Sublocation", success);
        }

        return null;
    }

    public String createResponsibilities() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved responsibilities " + getResponsibilities().getIdresponsibilities());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getResponsibilities());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getResponsibilities().getName() + " saved successfully."));
            setResponsibilities(new Responsibilities());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateResponsibilities() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Responsibilities responsibilities = getEm().find(Responsibilities.class, getResponsibilities().getIdresponsibilities());

            responsibilities = this.getResponsibilities();
            getUtx().begin();
            getAudit().setAction("updated responsibilities " + responsibilities.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(responsibilities);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", responsibilities.getName() + " Updated successfully."));
            responsibilities = new Responsibilities();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a responsibilities."));
        }

        return null;
    }

    public String deleteResponsibilities(Responsibilities responsibilities) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted responsibilities");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Responsibilities toBeRemoved = (Responsibilities) getEm().merge(responsibilities);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            responsibilities = new Responsibilities();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Responsibilities deleted", "Responsibilities deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Responsibilities", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Responsibilities", success);
        }

        return null;
    }

    public String createSchool() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved school " + getSchool().getIdschool());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getSchool());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getSchool().getName() + " saved successfully."));
            setSchool(new School());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateSchool() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            School school = getEm().find(School.class, getSchool().getIdschool());

            school = this.getSchool();
            getUtx().begin();
            getAudit().setAction("updated school " + school.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(school);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", school.getName() + " Updated successfully."));
            school = new School();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a school."));
        }

        return null;
    }

    public String deleteSchool(School school) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted school");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            School toBeRemoved = (School) getEm().merge(school);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            school = new School();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "School deleted", "School deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("School", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("School", success);
        }

        return null;
    }

    public String createStatus() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved status " + getStatus().getIdstatus());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getStatus());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getStatus().getName() + " saved successfully."));
            setStatus(new Status());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateStatus() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Status status = getEm().find(Status.class, getStatus().getIdstatus());

            status = this.getStatus();
            getUtx().begin();
            getAudit().setAction("updated status " + status.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(status);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", status.getName() + " Updated successfully."));
            status = new Status();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a status."));
        }

        return null;
    }

    public String deleteStatus(Status status) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted status");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Status toBeRemoved = (Status) getEm().merge(status);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            status = new Status();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Status deleted", "Status deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Status", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Status", success);
        }

        return null;
    }

    public String createStreams() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved streams " + getStreams().getIdstreams());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getStreams());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getStreams().getName() + " saved successfully."));
            setStreams(new Streams());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateStreams() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Streams streams = getEm().find(Streams.class, getStreams().getIdstreams());

            streams = this.getStreams();
            getUtx().begin();
            getAudit().setAction("updated streams " + streams.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(streams);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", streams.getName() + " Updated successfully."));
            streams = new Streams();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a streams."));
        }

        return null;
    }

    public String deleteStreams(Streams streams) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted streams");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Streams toBeRemoved = (Streams) getEm().merge(streams);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            streams = new Streams();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Streams deleted", "Streams deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Streams", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Streams", success);
        }

        return null;
    }

    public String createStudent() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            student.setPassword("pass@123");
            getUtx().begin();
            getAudit().setAction("saved student " + getStudent().getIdstudent());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            student.setPhotourl(filename);
            getEm().persist(getAudit());
            getEm().persist(getStudent());
            getUtx().commit();
            sendMail("Schole Student Registration", "Dear " + student.getFullnames() + " You have been successfully registered on e-school Your username is " + student.getAdmnum() + " And your password is pass@123 please log in and change it", "", student.getEmail());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getStudent().getFullnames() + " saved successfully."));
            setStudent(new Student());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateStudent() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Student student = getEm().find(Student.class, getStudent().getIdstudent());

            student = this.getStudent();
            getUtx().begin();
            getAudit().setAction("updated student " + student.getFullnames());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(student);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", student.getFullnames() + " Updated successfully."));
            student = new Student();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a student."));
        }

        return null;
    }

    public String deleteStudent(Student student) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted student");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Student toBeRemoved = (Student) getEm().merge(student);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            student = new Student();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student deleted", "Student deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Student", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Student", success);
        }

        return null;
    }

    public String createStudentsubjects() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved studentsubjects " + getStudentsubjects().getIdstudentsubjects());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getStudentsubjects());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getStudentsubjects().getSubject().getName() + " saved successfully."));
            setStudentsubjects(new Studentsubjects());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateStudentsubjects() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Studentsubjects studentsubjects = getEm().find(Studentsubjects.class, getStudentsubjects().getIdstudentsubjects());

            studentsubjects = this.getStudentsubjects();
            getUtx().begin();
            getAudit().setAction("updated studentsubjects " + studentsubjects.getSubject().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(studentsubjects);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", studentsubjects.getSubject().getName() + " Updated successfully."));
            studentsubjects = new Studentsubjects();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a studentsubjects."));
        }

        return null;
    }

    public String deleteStudentsubjects(Studentsubjects studentsubjects) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted studentsubjects");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Studentsubjects toBeRemoved = (Studentsubjects) getEm().merge(studentsubjects);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            studentsubjects = new Studentsubjects();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Studentsubjects deleted", "Studentsubjects deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Studentsubjects", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Studentsubjects", success);
        }

        return null;
    }

    public String createSubj() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved subj " + getSubj().getIdsubj());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getSubj());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getSubj().getName() + " saved successfully."));
            setSubj(new Subj());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateSubj() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Subj subj = getEm().find(Subj.class, getSubj().getIdsubj());

            subj = this.getSubj();
            getUtx().begin();
            getAudit().setAction("updated subj " + subj.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(subj);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", subj.getName() + " Updated successfully."));
            subj = new Subj();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a subj."));
        }

        return null;
    }

    public String deleteSubj(Subj subj) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted subj");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Subj toBeRemoved = (Subj) getEm().merge(subj);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            subj = new Subj();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Subj deleted", "Subj deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subj", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subj", success);
        }

        return null;
    }

    public String createSubjcombination() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved subjcombination " + getSubjcombination().getIdsubjcombination());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getSubjcombination());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getSubjcombination().getCombinationname() + " saved successfully."));
            setSubjcombination(new Subjcombination());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateSubjcombination() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Subjcombination subjcombination = getEm().find(Subjcombination.class, getSubjcombination().getIdsubjcombination());

            subjcombination = this.getSubjcombination();
            getUtx().begin();
            getAudit().setAction("updated subjcombination " + subjcombination.getCombinationname());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(subjcombination);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", subjcombination.getCombinationname() + " Updated successfully."));
            subjcombination = new Subjcombination();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a subjcombination."));
        }

        return null;
    }

    public String deleteSubjcombination(Subjcombination subjcombination) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted subjcombination");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Subjcombination toBeRemoved = (Subjcombination) getEm().merge(subjcombination);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            subjcombination = new Subjcombination();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Subjcombination deleted", "Subjcombination deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subjcombination", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subjcombination", success);
        }

        return null;
    }

    public String createSubjectallocation() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved subjectallocation " + getSubjectallocation().getIdsubjectallocation());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getSubjectallocation());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getSubjectallocation().getSubjectid().getName() + " saved successfully."));
            setSubjectallocation(new Subjectallocation());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateSubjectallocation() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Subjectallocation subjectallocation = getEm().find(Subjectallocation.class, getSubjectallocation().getIdsubjectallocation());

            subjectallocation = this.getSubjectallocation();
            getUtx().begin();
            getAudit().setAction("updated subjectallocation " + subjectallocation.getSubjectid().getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(subjectallocation);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", subjectallocation.getSubjectid().getName() + " Updated successfully."));
            subjectallocation = new Subjectallocation();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a subjectallocation."));
        }

        return null;
    }

    public String deleteSubjectallocation(Subjectallocation subjectallocation) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted subjectallocation");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Subjectallocation toBeRemoved = (Subjectallocation) getEm().merge(subjectallocation);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            subjectallocation = new Subjectallocation();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Subjectallocation deleted", "Subjectallocation deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subjectallocation", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subjectallocation", success);
        }

        return null;
    }

    public String createSubjgroups() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved subjgroups " + getSubjgroups().getIdsubjgroups());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getSubjgroups());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getSubjgroups().getName() + " saved successfully."));
            setSubjgroups(new Subjgroups());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateSubjgroups() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Subjgroups subjgroups = getEm().find(Subjgroups.class, getSubjgroups().getIdsubjgroups());

            subjgroups = this.getSubjgroups();
            getUtx().begin();
            getAudit().setAction("updated subjgroups " + subjgroups.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(subjgroups);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", subjgroups.getName() + " Updated successfully."));
            subjgroups = new Subjgroups();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a subjgroups."));
        }

        return null;
    }

    public String deleteSubjgroups(Subjgroups subjgroups) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted subjgroups");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Subjgroups toBeRemoved = (Subjgroups) getEm().merge(subjgroups);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            subjgroups = new Subjgroups();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Subjgroups deleted", "Subjgroups deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subjgroups", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subjgroups", success);
        }

        return null;
    }

    public String createSubjkcpe() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved subjkcpe " + getSubjkcpe().getIdsubjkcpe());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getSubjkcpe());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getSubjkcpe().getName() + " saved successfully."));
            setSubjkcpe(new Subjkcpe());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateSubjkcpe() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Subjkcpe subjkcpe = getEm().find(Subjkcpe.class, getSubjkcpe().getIdsubjkcpe());

            subjkcpe = this.getSubjkcpe();
            getUtx().begin();
            getAudit().setAction("updated subjkcpe " + subjkcpe.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(subjkcpe);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", subjkcpe.getName() + " Updated successfully."));
            subjkcpe = new Subjkcpe();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a subjkcpe."));
        }

        return null;
    }

    public String deleteSubjkcpe(Subjkcpe subjkcpe) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted subjkcpe");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Subjkcpe toBeRemoved = (Subjkcpe) getEm().merge(subjkcpe);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            subjkcpe = new Subjkcpe();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Subjkcpe deleted", "Subjkcpe deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subjkcpe", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Subjkcpe", success);
        }

        return null;
    }

    public String createTeachers() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            teachers.setPassowrd("pass@123");

            getUtx().begin();
            getAudit().setAction("saved teachers " + getTeachers().getIdteachers());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getTeachers());
            getUtx().commit();
            sendMail("Schole Teacher Registration", "Dear " + teachers.getFullnames() + " You have been successfuly registered with e-school your username is " + teachers.getNationalId() + " and your password is pass@123 please login and change it", "chepseron@gmail.com", teachers.getPersonalemail());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getTeachers().getFullnames() + " saved successfully."));
            setTeachers(new Teachers());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String sendMail(String subject, String messageSent, String mailFrom, String mailTo) {
        String to = mailTo;//change accordingly  
        final String from = "scholeschole18@gmail.com";
        String host = "localhost";//or IP address  
        final String password = "benson32!";//change accordingly  
        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(messageSent);
            // Send message  
            Transport.send(message);
            System.out.println("message sent successfully....");
            return "message sent:";

        } catch (MessagingException mex) {
            mex.printStackTrace();
            return mex.getMessage();
        }
    }

    public String updateTeachers() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Teachers teachers = getEm().find(Teachers.class, getTeachers().getIdteachers());

            teachers = this.getTeachers();
            getUtx().begin();
            getAudit().setAction("updated teachers " + teachers.getFullnames());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(teachers);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", teachers.getFullnames() + " Updated successfully."));
            teachers = new Teachers();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a teachers."));
        }

        return null;
    }

    public String deleteTeachers(Teachers teachers) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted teachers");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Teachers toBeRemoved = (Teachers) getEm().merge(teachers);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            teachers = new Teachers();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Teachers deleted", "Teachers deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Teachers", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Teachers", success);
        }

        return null;
    }

    public String createUsergroups() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved group1 " + getGroup1().getIdusergroups());
            getAudit().setCreatedby(user);
            getAudit().setTimer(new Date());
            group1.setIsteacher(1);
            System.out.println(group1.getCode());
            System.out.println(group1.getIsteacher());
            System.out.println(group1.getName());

            getEm().persist(getAudit());
            getEm().persist(getGroup1());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getGroup1().getName() + " saved successfully."));
            setGroup1(new Usergroups());

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateUsergroups() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Usergroups group1 = getEm().find(Usergroups.class, getGroup1().getIdusergroups());

            group1 = this.getGroup1();
            getUtx().begin();
            getAudit().setAction("updated group1 " + group1.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(group1);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", group1.getName() + " Updated successfully."));
            group1 = new Usergroups();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a group1."));
        }

        return null;
    }

    public String deleteUsergroups(Usergroups group1) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted group1");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Usergroups toBeRemoved = (Usergroups) getEm().merge(group1);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            group1 = new Usergroups();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usergroups deleted", "Usergroups deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Usergroups", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Usergroups", success);
        }

        return null;
    }

    public String createZones() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }

            getUtx().begin();
            getAudit().setAction("saved zones " + getZones().getIdzones());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().persist(getZones());
            getUtx().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", getZones().getName() + " saved successfully."));
            setZones(new Zones());
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
            ex.printStackTrace();
            getLogger().info(ex.getMessage());
        }
        return null;
    }

    public String updateZones() {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            Zones zones = getEm().find(Zones.class, getZones().getIdzones());

            zones = this.getZones();
            getUtx().begin();
            getAudit().setAction("updated zones " + zones.getName());
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            getEm().merge(zones);
            getUtx().commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success!", zones.getName() + " Updated successfully."));
            zones = new Zones();
        } catch (Exception ex) {
            getLogger().info(ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Could not update a zones."));
        }

        return null;
    }

    public String deleteZones(Zones zones) {
        try {
            if (StringUtils.isEmpty(getUsername())) {

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Please login to the system"));
                return "/index.xhtml";
            }
            getUtx().begin();
            getAudit().setAction("Deleted zones");
            getAudit().setCreatedby(getUser());
            getAudit().setTimer(new Date());
            getEm().persist(getAudit());
            Zones toBeRemoved = (Zones) getEm().merge(zones);
            getEm().remove(toBeRemoved);
            getUtx().commit();
            zones = new Zones();
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Zones deleted", "Zones deleted");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Zones", success);

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            getLogger().info(e.getMessage());
            FacesMessage success = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("Zones", success);
        }

        return null;
    }

    /**
     * @return the logger
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * @param logger the logger to set
     */
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the utx
     */
    public UserTransaction getUtx() {
        return utx;
    }

    /**
     * @param utx the utx to set
     */
    public void setUtx(UserTransaction utx) {
        this.utx = utx;
    }

    /**
     * @return the audit
     */
    public Audit getAudit() {
        return audit;
    }

    /**
     * @param audit the audit to set
     */
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    /**
     * @return the auditList
     */
    public List<Audit> getAuditList() {
        auditList = getEm().createQuery("select a from Audit a").getResultList();
        return auditList;
    }

    /**
     * @param auditList the auditList to set
     */
    public void setAuditList(List<Audit> auditList) {
        this.auditList = auditList;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the statusList
     */
    public List<Status> getStatusList() {
        statusList = getEm().createQuery("select s from Status s").getResultList();
        return statusList;
    }

    /**
     * @param statusList the statusList to set
     */
    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return the group1List
     */
    public List<Usergroups> getGroup1List() {
        group1List = getEm().createQuery("select g from Usergroups g").getResultList();
        return group1List;
    }

    /**
     * @param group1List the group1List to set
     */
    public void setGroup1List(List<Usergroups> group1List) {
        this.group1List = group1List;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * @return the projectModel
     */
    public LineChartModel getProjectModel() {
        return projectModel;
    }

    /**
     * @param projectModel the projectModel to set
     */
    public void setProjectModel(LineChartModel projectModel) {
        this.projectModel = projectModel;
    }

    /**
     * @return the skip
     */
    public boolean isSkip() {
        return skip;
    }

    /**
     * @param skip the skip to set
     */
    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    /**
     * @return the usersList
     */
    public List<Users> getUsersList() {
        usersList = getEm().createQuery("select u from Users u").getResultList();
        return usersList;
    }

    /**
     * @param usersList the usersList to set
     */
    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    /**
     * @return the group1
     */
    public Usergroups getGroup1() {
        return group1;
    }

    /**
     * @param group1 the group1 to set
     */
    public void setGroup1(Usergroups group1) {
        this.group1 = group1;
    }

    /**
     * @return the assignedResponsibilities
     */
    public Assignedresponsibilities getAssignedResponsibilities() {
        return assignedResponsibilities;
    }

    /**
     * @param assignedResponsibilities the assignedResponsibilities to set
     */
    public void setAssignedResponsibilities(Assignedresponsibilities assignedResponsibilities) {
        this.assignedResponsibilities = assignedResponsibilities;
    }

    /**
     * @return the assignedResponsibilitiesList
     */
    public List<Assignedresponsibilities> getAssignedResponsibilitiesList() {
        assignedResponsibilitiesList = getEm().createQuery("select a from Assignedresponsibilities a").getResultList();
        return assignedResponsibilitiesList;
    }

    /**
     * @param assignedResponsibilitiesList the assignedResponsibilitiesList to
     * set
     */
    public void setAssignedResponsibilitiesList(List<Assignedresponsibilities> assignedResponsibilitiesList) {
        this.assignedResponsibilitiesList = assignedResponsibilitiesList;
    }

    /**
     * @return the attendance
     */
    public Attendance getAttendance() {
        return attendance;
    }

    /**
     * @param attendance the attendance to set
     */
    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    /**
     * @return the attendanceList
     */
    public List<Attendance> getAttendanceList() {
        attendanceList = getEm().createQuery("select a from Attendance a").getResultList();
        return attendanceList;
    }

    /**
     * @param attendanceList the attendanceList to set
     */
    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    /**
     * @return the calterm
     */
    public Calterm getCalterm() {
        return calterm;
    }

    /**
     * @param calterm the calterm to set
     */
    public void setCalterm(Calterm calterm) {
        this.calterm = calterm;
    }

    /**
     * @return the caltermList
     */
    public List<Calterm> getCaltermList() {
        caltermList = getEm().createQuery("select c from Calterm c").getResultList();
        return caltermList;
    }

    /**
     * @param caltermList the caltermList to set
     */
    public void setCaltermList(List<Calterm> caltermList) {
        this.caltermList = caltermList;
    }

    /**
     * @return the caltermyear
     */
    public Caltermyear getCaltermyear() {
        return caltermyear;
    }

    /**
     * @param caltermyear the caltermyear to set
     */
    public void setCaltermyear(Caltermyear caltermyear) {
        this.caltermyear = caltermyear;
    }

    /**
     * @return the caltermyearList
     */
    public List<Caltermyear> getCaltermyearList() {
        caltermyearList = getEm().createQuery("select c from Caltermyear c").getResultList();
        return caltermyearList;
    }

    /**
     * @param caltermyearList the caltermyearList to set
     */
    public void setCaltermyearList(List<Caltermyear> caltermyearList) {
        this.caltermyearList = caltermyearList;
    }

    /**
     * @return the calyear
     */
    public Calyear getCalyear() {
        return calyear;
    }

    /**
     * @param calyear the calyear to set
     */
    public void setCalyear(Calyear calyear) {
        this.calyear = calyear;
    }

    /**
     * @return the calyearList
     */
    public List<Calyear> getCalyearList() {
        calyearList = getEm().createQuery("select c from Calyear c").getResultList();
        return calyearList;
    }

    /**
     * @param calyearList the calyearList to set
     */
    public void setCalyearList(List<Calyear> calyearList) {
        this.calyearList = calyearList;
    }

    /**
     * @return the smsgateways
     */
    public Commsmsgateways getSmsgateways() {
        return smsgateways;
    }

    /**
     * @param smsgateways the smsgateways to set
     */
    public void setSmsgateways(Commsmsgateways smsgateways) {
        this.smsgateways = smsgateways;
    }

    /**
     * @return the smsgatewaysList
     */
    public List<Commsmsgateways> getSmsgatewaysList() {
        smsgatewaysList = getEm().createQuery("select c from Commsmsgateways c").getResultList();
        return smsgatewaysList;
    }

    /**
     * @param smsgatewaysList the smsgatewaysList to set
     */
    public void setSmsgatewaysList(List<Commsmsgateways> smsgatewaysList) {
        this.smsgatewaysList = smsgatewaysList;
    }

    /**
     * @return the constituencies
     */
    public Constituencies getConstituencies() {
        return constituencies;
    }

    /**
     * @param constituencies the constituencies to set
     */
    public void setConstituencies(Constituencies constituencies) {
        this.constituencies = constituencies;
    }

    /**
     * @return the constituenciesList
     */
    public List<Constituencies> getConstituenciesList() {
        constituenciesList = getEm().createQuery("select c from Constituencies c").getResultList();
        return constituenciesList;
    }

    /**
     * @param constituenciesList the constituenciesList to set
     */
    public void setConstituenciesList(List<Constituencies> constituenciesList) {
        this.constituenciesList = constituenciesList;
    }

    /**
     * @return the counties
     */
    public Counties getCounties() {
        return counties;
    }

    /**
     * @param counties the counties to set
     */
    public void setCounties(Counties counties) {
        this.counties = counties;
    }

    /**
     * @return the countiesList
     */
    public List<Counties> getCountiesList() {
        countiesList = getEm().createQuery("select c from Counties c").getResultList();
        return countiesList;
    }

    /**
     * @param countiesList the countiesList to set
     */
    public void setCountiesList(List<Counties> countiesList) {
        this.countiesList = countiesList;
    }

    /**
     * @return the department
     */
    public Dept getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Dept department) {
        this.department = department;
    }

    /**
     * @return the departmentList
     */
    public List<Dept> getDepartmentList() {
        departmentList = getEm().createQuery("select d from Dept d").getResultList();
        return departmentList;
    }

    /**
     * @param departmentList the departmentList to set
     */
    public void setDepartmentList(List<Dept> departmentList) {
        this.departmentList = departmentList;
    }

    /**
     * @return the district
     */
    public Districts getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(Districts district) {
        this.district = district;
    }

    /**
     * @return the districtList
     */
    public List<Districts> getDistrictList() {
        districtList = getEm().createQuery("select d from Districts d").getResultList();
        return districtList;
    }

    /**
     * @param districtList the districtList to set
     */
    public void setDistrictList(List<Districts> districtList) {
        this.districtList = districtList;
    }

    /**
     * @return the division
     */
    public Divisions getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(Divisions division) {
        this.division = division;
    }

    /**
     * @return the divisionList
     */
    public List<Divisions> getDivisionList() {
        divisionList = getEm().createQuery("select d from Divisions d").getResultList();
        return divisionList;
    }

    /**
     * @param divisionList the divisionList to set
     */
    public void setDivisionList(List<Divisions> divisionList) {
        this.divisionList = divisionList;
    }

    /**
     * @return the dorms
     */
    public Dorms getDorms() {
        return dorms;
    }

    /**
     * @param dorms the dorms to set
     */
    public void setDorms(Dorms dorms) {
        this.dorms = dorms;
    }

    /**
     * @return the dormsList
     */
    public List<Dorms> getDormsList() {
        dormsList = getEm().createQuery("select d from Dorms d").getResultList();
        return dormsList;
    }

    /**
     * @param dormsList the dormsList to set
     */
    public void setDormsList(List<Dorms> dormsList) {
        this.dormsList = dormsList;
    }

    /**
     * @return the examgradingnewexamgrades
     */
    public Examgradingnewexamgrades getExamgradingnewexamgrades() {
        return examgradingnewexamgrades;
    }

    /**
     * @param examgradingnewexamgrades the examgradingnewexamgrades to set
     */
    public void setExamgradingnewexamgrades(Examgradingnewexamgrades examgradingnewexamgrades) {
        this.examgradingnewexamgrades = examgradingnewexamgrades;
    }

    /**
     * @return the examgradingnewexamgradesList
     */
    public List<Examgradingnewexamgrades> getExamgradingnewexamgradesList() {
        examgradingnewexamgradesList = getEm().createQuery("select e from Examgradingnewexamgrades e").getResultList();
        return examgradingnewexamgradesList;
    }

    /**
     * @param examgradingnewexamgradesList the examgradingnewexamgradesList to
     * set
     */
    public void setExamgradingnewexamgradesList(List<Examgradingnewexamgrades> examgradingnewexamgradesList) {
        this.examgradingnewexamgradesList = examgradingnewexamgradesList;
    }

    /**
     * @return the examgradingsystem
     */
    public Examgradingsystem getExamgradingsystem() {
        return examgradingsystem;
    }

    /**
     * @param examgradingsystem the examgradingsystem to set
     */
    public void setExamgradingsystem(Examgradingsystem examgradingsystem) {
        this.examgradingsystem = examgradingsystem;
    }

    /**
     * @return the examgradingsystemList
     */
    public List<Examgradingsystem> getExamgradingsystemList() {
        examgradingsystemList = getEm().createQuery("select e from Examgradingsystem e").getResultList();
        return examgradingsystemList;
    }

    /**
     * @param examgradingsystemList the examgradingsystemList to set
     */
    public void setExamgradingsystemList(List<Examgradingsystem> examgradingsystemList) {
        this.examgradingsystemList = examgradingsystemList;
    }

    /**
     * @return the examgradingsystemglobalsetup
     */
    public Examgradingsystemglobalsetup getExamgradingsystemglobalsetup() {

        return examgradingsystemglobalsetup;
    }

    /**
     * @param examgradingsystemglobalsetup the examgradingsystemglobalsetup to
     * set
     */
    public void setExamgradingsystemglobalsetup(Examgradingsystemglobalsetup examgradingsystemglobalsetup) {
        this.examgradingsystemglobalsetup = examgradingsystemglobalsetup;
    }

    /**
     * @return the examgradingsystemglobalsetupList
     */
    public List<Examgradingsystemglobalsetup> getExamgradingsystemglobalsetupList() {
        examgradingsystemglobalsetupList = getEm().createQuery("select e from Examgradingsystemglobalsetup e").getResultList();
        return examgradingsystemglobalsetupList;
    }

    /**
     * @param examgradingsystemglobalsetupList the
     * examgradingsystemglobalsetupList to set
     */
    public void setExamgradingsystemglobalsetupList(List<Examgradingsystemglobalsetup> examgradingsystemglobalsetupList) {
        this.examgradingsystemglobalsetupList = examgradingsystemglobalsetupList;
    }

    /**
     * @return the exammeangrade
     */
    public Exammeangrade getExammeangrade() {
        return exammeangrade;
    }

    /**
     * @param exammeangrade the exammeangrade to set
     */
    public void setExammeangrade(Exammeangrade exammeangrade) {
        this.exammeangrade = exammeangrade;
    }

    /**
     * @return the exammeangradeList
     */
    public List<Exammeangrade> getExammeangradeList() {
        exammeangradeList = getEm().createQuery("select e from Exammeangrade e").getResultList();
        return exammeangradeList;
    }

    /**
     * @param exammeangradeList the exammeangradeList to set
     */
    public void setExammeangradeList(List<Exammeangrade> exammeangradeList) {
        this.exammeangradeList = exammeangradeList;
    }

    /**
     * @return the examsubjectremarks
     */
    public Examsubjectremarks getExamsubjectremarks() {
        return examsubjectremarks;
    }

    /**
     * @param examsubjectremarks the examsubjectremarks to set
     */
    public void setExamsubjectremarks(Examsubjectremarks examsubjectremarks) {
        this.examsubjectremarks = examsubjectremarks;
    }

    /**
     * @return the examsubjectremarksList
     */
    public List<Examsubjectremarks> getExamsubjectremarksList() {
        examsubjectremarksList = getEm().createQuery("select e from Examsubjectremarks e").getResultList();
        return examsubjectremarksList;
    }

    /**
     * @param examsubjectremarksList the examsubjectremarksList to set
     */
    public void setExamsubjectremarksList(List<Examsubjectremarks> examsubjectremarksList) {
        this.examsubjectremarksList = examsubjectremarksList;
    }

    /**
     * @return the examgroup1etup
     */
    public Examteachersetup getExamteachersetup() {
        return examteachersetup;
    }

    /**
     * @param examteachersetup the examteachersetup to set
     */
    public void setExamteachersetup(Examteachersetup examteachersetup) {
        this.examteachersetup = examteachersetup;
    }

    /**
     * @return the examteachersetupList
     */
    public List<Examteachersetup> getExamteachersetupList() {
        examteachersetupList = getEm().createQuery("select e from Examteachersetup e").getResultList();
        return examteachersetupList;
    }

    /**
     * @param examteachersetupList the examteachersetupList to set
     */
    public void setExamteachersetupList(List<Examteachersetup> examteachersetupList) {
        this.examteachersetupList = examteachersetupList;
    }

    /**
     * @return the finbanks
     */
    public Finbanks getFinbanks() {
        return finbanks;
    }

    /**
     * @param finbanks the finbanks to set
     */
    public void setFinbanks(Finbanks finbanks) {
        this.finbanks = finbanks;
    }

    /**
     * @return the finbanksList
     */
    public List<Finbanks> getFinbanksList() {
        finbanksList = getEm().createQuery("select f from Finbanks f").getResultList();
        return finbanksList;
    }

    /**
     * @param finbanksList the finbanksList to set
     */
    public void setFinbanksList(List<Finbanks> finbanksList) {
        this.finbanksList = finbanksList;
    }

    /**
     * @return the finfeebalances
     */
    public Finfeebalances getFinfeebalances() {
        return finfeebalances;
    }

    /**
     * @param finfeebalances the finfeebalances to set
     */
    public void setFinfeebalances(Finfeebalances finfeebalances) {
        this.finfeebalances = finfeebalances;
    }

    /**
     * @return the finfeebalancesList
     */
    public List<Finfeebalances> getFinfeebalancesList() {
        finfeebalancesList = getEm().createQuery("select f from Finfeebalances f").getResultList();
        return finfeebalancesList;
    }

    /**
     * @param finfeebalancesList the finfeebalancesList to set
     */
    public void setFinfeebalancesList(List<Finfeebalances> finfeebalancesList) {
        this.finfeebalancesList = finfeebalancesList;
    }

    /**
     * @return the finfeeitems
     */
    public Finfeeitems getFinfeeitems() {
        return finfeeitems;
    }

    /**
     * @param finfeeitems the finfeeitems to set
     */
    public void setFinfeeitems(Finfeeitems finfeeitems) {
        this.finfeeitems = finfeeitems;
    }

    /**
     * @return the finfeeitemsList
     */
    public List<Finfeeitems> getFinfeeitemsList() {
        finfeeitemsList = getEm().createQuery("select f from Finfeeitems f").getResultList();
        return finfeeitemsList;
    }

    /**
     * @param finfeeitemsList the finfeeitemsList to set
     */
    public void setFinfeeitemsList(List<Finfeeitems> finfeeitemsList) {
        this.finfeeitemsList = finfeeitemsList;
    }

    /**
     * @return the finglaccount
     */
    public Finfeestructure getFinfeestructure() {
        return finfeestructure;
    }

    /**
     * @param finfeestructure the finfeestructure to set
     */
    public void setFinfeestructure(Finfeestructure finfeestructure) {
        this.finfeestructure = finfeestructure;
    }

    /**
     * @return the ffinfeestructureList
     */
    public List<Finfeestructure> getFfinfeestructureList() {
        ffinfeestructureList = getEm().createQuery("select f from Finfeestructure f").getResultList();
        return ffinfeestructureList;
    }

    /**
     * @param ffinfeestructureList the ffinfeestructureList to set
     */
    public void setFfinfeestructureList(List<Finfeestructure> ffinfeestructureList) {
        this.ffinfeestructureList = ffinfeestructureList;
    }

    /**
     * @return the finglaccount
     */
    public Finglaccount getFinglaccount() {
        return finglaccount;
    }

    /**
     * @param finglaccount the finglaccount to set
     */
    public void setFinglaccount(Finglaccount finglaccount) {
        this.finglaccount = finglaccount;
    }

    /**
     * @return the finglaccountList
     */
    public List<Finglaccount> getFinglaccountList() {
        finglaccountList = getEm().createQuery("select f from Finglaccount f").getResultList();
        return finglaccountList;
    }

    /**
     * @param finglaccountList the finglaccountList to set
     */
    public void setFinglaccountList(List<Finglaccount> finglaccountList) {
        this.finglaccountList = finglaccountList;
    }

    /**
     * @return the fininvoice
     */
    public Fininvoice getFininvoice() {
        return fininvoice;
    }

    /**
     * @param fininvoice the fininvoice to set
     */
    public void setFininvoice(Fininvoice fininvoice) {
        this.fininvoice = fininvoice;
    }

    /**
     * @return the fininvoiceList
     */
    public List<Fininvoice> getFininvoiceList() {
        fininvoiceList = getEm().createQuery("select f from Fininvoice f").getResultList();
        return fininvoiceList;
    }

    /**
     * @param fininvoiceList the fininvoiceList to set
     */
    public void setFininvoiceList(List<Fininvoice> fininvoiceList) {
        this.fininvoiceList = fininvoiceList;
    }

    /**
     * @return the finledgeraccountgroups
     */
    public Finledgeraccountbudget getFinledgeraccountbudget() {
        return finledgeraccountbudget;
    }

    /**
     * @param finledgeraccountbudget the finledgeraccountbudget to set
     */
    public void setFinledgeraccountbudget(Finledgeraccountbudget finledgeraccountbudget) {
        this.finledgeraccountbudget = finledgeraccountbudget;
    }

    /**
     * @return the finledgeraccountbudgetList
     */
    public List<Finledgeraccountbudget> getFinledgeraccountbudgetList() {
        finledgeraccountbudgetList = getEm().createQuery("select f from Finledgeraccountbudget f").getResultList();
        return finledgeraccountbudgetList;
    }

    /**
     * @param finledgeraccountbudgetList the finledgeraccountbudgetList to set
     */
    public void setFinledgeraccountbudgetList(List<Finledgeraccountbudget> finledgeraccountbudgetList) {
        this.finledgeraccountbudgetList = finledgeraccountbudgetList;
    }

    /**
     * @return the finledgeraccountgroups
     */
    public Finledgeraccountgroups getFinledgeraccountgroups() {
        return finledgeraccountgroups;
    }

    /**
     * @param finledgeraccountgroups the finledgeraccountgroups to set
     */
    public void setFinledgeraccountgroups(Finledgeraccountgroups finledgeraccountgroups) {
        this.finledgeraccountgroups = finledgeraccountgroups;
    }

    /**
     * @return the finledgeraccountgroupstList
     */
    public List<Finledgeraccountgroups> getFinledgeraccountgroupstList() {
        finledgeraccountgroupstList = getEm().createQuery("select f from Finledgeraccountgroups f").getResultList();
        return finledgeraccountgroupstList;
    }

    /**
     * @param finledgeraccountgroupstList the finledgeraccountgroupstList to set
     */
    public void setFinledgeraccountgroupstList(List<Finledgeraccountgroups> finledgeraccountgroupstList) {
        this.finledgeraccountgroupstList = finledgeraccountgroupstList;
    }

    /**
     * @return the finledgeraccountypes
     */
    public Finledgeraccounts getFinledgeraccounts() {
        return finledgeraccounts;
    }

    /**
     * @param finledgeraccounts the finledgeraccounts to set
     */
    public void setFinledgeraccounts(Finledgeraccounts finledgeraccounts) {
        this.finledgeraccounts = finledgeraccounts;
    }

    /**
     * @return the finledgeraccountsList
     */
    public List<Finledgeraccounts> getFinledgeraccountsList() {
        finledgeraccountsList = getEm().createQuery("select f from Finledgeraccounts f").getResultList();
        return finledgeraccountsList;
    }

    /**
     * @param finledgeraccountsList the finledgeraccountsList to set
     */
    public void setFinledgeraccountsList(List<Finledgeraccounts> finledgeraccountsList) {
        this.finledgeraccountsList = finledgeraccountsList;
    }

    /**
     * @return the finledgeraccountypes
     */
    public Finledgeraccountypes getFinledgeraccountypes() {
        return finledgeraccountypes;
    }

    /**
     * @param finledgeraccountypes the finledgeraccountypes to set
     */
    public void setFinledgeraccountypes(Finledgeraccountypes finledgeraccountypes) {
        this.finledgeraccountypes = finledgeraccountypes;
    }

    /**
     * @return the finledgeraccountypesList
     */
    public List<Finledgeraccountypes> getFinledgeraccountypesList() {
        finledgeraccountypesList = getEm().createQuery("select f from Finledgeraccountypes f").getResultList();
        return finledgeraccountypesList;
    }

    /**
     * @param finledgeraccountypesList the finledgeraccountypesList to set
     */
    public void setFinledgeraccountypesList(List<Finledgeraccountypes> finledgeraccountypesList) {
        this.finledgeraccountypesList = finledgeraccountypesList;
    }

    /**
     * @return the finledgergroupcategories
     */
    public Finledgergroupcategories getFinledgergroupcategories() {
        return finledgergroupcategories;
    }

    /**
     * @param finledgergroupcategories the finledgergroupcategories to set
     */
    public void setFinledgergroupcategories(Finledgergroupcategories finledgergroupcategories) {
        this.finledgergroupcategories = finledgergroupcategories;
    }

    /**
     * @return the finledgergroupcategoriesList
     */
    public List<Finledgergroupcategories> getFinledgergroupcategoriesList() {
        finledgergroupcategoriesList = getEm().createQuery("select f from Finledgergroupcategories f").getResultList();
        return finledgergroupcategoriesList;
    }

    /**
     * @param finledgergroupcategoriesList the finledgergroupcategoriesList to
     * set
     */
    public void setFinledgergroupcategoriesList(List<Finledgergroupcategories> finledgergroupcategoriesList) {
        this.finledgergroupcategoriesList = finledgergroupcategoriesList;
    }

    /**
     * @return the finpaymentmodes
     */
    public Finpaymentmodes getFinpaymentmodes() {
        return finpaymentmodes;
    }

    /**
     * @param finpaymentmodes the finpaymentmodes to set
     */
    public void setFinpaymentmodes(Finpaymentmodes finpaymentmodes) {
        this.finpaymentmodes = finpaymentmodes;
    }

    /**
     * @return the finpaymentmodesList
     */
    public List<Finpaymentmodes> getFinpaymentmodesList() {
        finpaymentmodesList = getEm().createQuery("select f from Finpaymentmodes f").getResultList();
        return finpaymentmodesList;
    }

    /**
     * @param finpaymentmodesList the finpaymentmodesList to set
     */
    public void setFinpaymentmodesList(List<Finpaymentmodes> finpaymentmodesList) {
        this.finpaymentmodesList = finpaymentmodesList;
    }

    /**
     * @return the finreceipt
     */
    public Finreceipt getFinreceipt() {
        return finreceipt;
    }

    /**
     * @param finreceipt the finreceipt to set
     */
    public void setFinreceipt(Finreceipt finreceipt) {
        this.finreceipt = finreceipt;
    }

    /**
     * @return the finreceiptList
     */
    public List<Finreceipt> getFinreceiptList() {
        finreceiptList = getEm().createQuery("select f from Finreceipt f").getResultList();
        return finreceiptList;
    }

    /**
     * @param finreceiptList the finreceiptList to set
     */
    public void setFinreceiptList(List<Finreceipt> finreceiptList) {
        this.finreceiptList = finreceiptList;
    }

    /**
     * @return the finuom
     */
    public Finuom getFinuom() {
        return finuom;
    }

    /**
     * @param finuom the finuom to set
     */
    public void setFinuom(Finuom finuom) {
        this.finuom = finuom;
    }

    /**
     * @return the finuomList
     */
    public List<Finuom> getFinuomList() {
        finuomList = getEm().createQuery("select f from Finuom f").getResultList();
        return finuomList;
    }

    /**
     * @param finuomList the finuomList to set
     */
    public void setFinuomList(List<Finuom> finuomList) {
        this.finuomList = finuomList;
    }

    /**
     * @return the finyear
     */
    public Finyear getFinyear() {
        return finyear;
    }

    /**
     * @param finyear the finyear to set
     */
    public void setFinyear(Finyear finyear) {
        this.finyear = finyear;
    }

    /**
     * @return the finyearList
     */
    public List<Finyear> getFinyearList() {
        finyearList = getEm().createQuery("select f from Finyear f").getResultList();
        return finyearList;
    }

    /**
     * @param finyearList the finyearList to set
     */
    public void setFinyearList(List<Finyear> finyearList) {
        this.finyearList = finyearList;
    }

    /**
     * @return the forms
     */
    public Forms getForms() {
        return forms;
    }

    /**
     * @param forms the forms to set
     */
    public void setForms(Forms forms) {
        this.forms = forms;
    }

    /**
     * @return the formsList
     */
    public List<Forms> getFormsList() {
        formsList = getEm().createQuery("select f from Forms f").getResultList();
        return formsList;
    }

    /**
     * @param formsList the formsList to set
     */
    public void setFormsList(List<Forms> formsList) {
        this.formsList = formsList;
    }

    /**
     * @return the houses
     */
    public Houses getHouses() {
        return houses;
    }

    /**
     * @param houses the houses to set
     */
    public void setHouses(Houses houses) {
        this.houses = houses;
    }

    /**
     * @return the housesList
     */
    public List<Houses> getHousesList() {
        housesList = getEm().createQuery("select h from Houses h").getResultList();
        return housesList;
    }

    /**
     * @param housesList the housesList to set
     */
    public void setHousesList(List<Houses> housesList) {
        this.housesList = housesList;
    }

    /**
     * @return the library
     */
    public Kcpegrade getKcpegrade() {
        return kcpegrade;
    }

    /**
     * @param kcpegrade the kcpegrade to set
     */
    public void setKcpegrade(Kcpegrade kcpegrade) {
        this.kcpegrade = kcpegrade;
    }

    /**
     * @return the kcpegradeList
     */
    public List<Kcpegrade> getKcpegradeList() {
        kcpegradeList = getEm().createQuery("select k from Kcpegrade k").getResultList();
        return kcpegradeList;
    }

    /**
     * @param kcpegradeList the kcpegradeList to set
     */
    public void setKcpegradeList(List<Kcpegrade> kcpegradeList) {
        this.kcpegradeList = kcpegradeList;
    }

    /**
     * @return the library
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * @param library the library to set
     */
    public void setLibrary(Library library) {
        this.library = library;
    }

    /**
     * @return the libraryList
     */
    public List<Library> getLibraryList() {
        libraryList = getEm().createQuery("select l from Library l").getResultList();
        return libraryList;
    }

    /**
     * @param libraryList the libraryList to set
     */
    public void setLibraryList(List<Library> libraryList) {
        this.libraryList = libraryList;
    }

    /**
     * @return the libraryauthors
     */
    public Libraryauthors getLibraryauthors() {
        return libraryauthors;
    }

    /**
     * @param libraryauthors the libraryauthors to set
     */
    public void setLibraryauthors(Libraryauthors libraryauthors) {
        this.libraryauthors = libraryauthors;
    }

    /**
     * @return the libraryauthorsList
     */
    public List<Libraryauthors> getLibraryauthorsList() {
        libraryauthorsList = getEm().createQuery("select l from Libraryauthors l").getResultList();
        return libraryauthorsList;
    }

    /**
     * @param libraryauthorsList the libraryauthorsList to set
     */
    public void setLibraryauthorsList(List<Libraryauthors> libraryauthorsList) {
        this.libraryauthorsList = libraryauthorsList;
    }

    /**
     * @return the librarybookcategories
     */
    public Librarybookcategories getLibrarybookcategories() {
        return librarybookcategories;
    }

    /**
     * @param librarybookcategories the librarybookcategories to set
     */
    public void setLibrarybookcategories(Librarybookcategories librarybookcategories) {
        this.librarybookcategories = librarybookcategories;
    }

    /**
     * @return the librarybookcategoriesList
     */
    public List<Librarybookcategories> getLibrarybookcategoriesList() {
        librarybookcategoriesList = getEm().createQuery("select l from Librarybookcategories l").getResultList();
        return librarybookcategoriesList;
    }

    /**
     * @param librarybookcategoriesList the librarybookcategoriesList to set
     */
    public void setLibrarybookcategoriesList(List<Librarybookcategories> librarybookcategoriesList) {
        this.librarybookcategoriesList = librarybookcategoriesList;
    }

    /**
     * @return the libraryfeefines
     */
    public Librarycatalog getLibrarycatalog() {
        return librarycatalog;
    }

    /**
     * @param librarycatalog the librarycatalog to set
     */
    public void setLibrarycatalog(Librarycatalog librarycatalog) {
        this.librarycatalog = librarycatalog;
    }

    /**
     * @return the librarycatalogList
     */
    public List<Librarycatalog> getLibrarycatalogList() {
        librarycatalogList = getEm().createQuery("select l from Librarycatalog l").getResultList();
        return librarycatalogList;
    }

    /**
     * @param librarycatalogList the librarycatalogList to set
     */
    public void setLibrarycatalogList(List<Librarycatalog> librarycatalogList) {
        this.librarycatalogList = librarycatalogList;
    }

    /**
     * @return the libraryfeefines
     */
    public Libraryfeefines getLibraryfeefines() {
        return libraryfeefines;
    }

    /**
     * @param libraryfeefines the libraryfeefines to set
     */
    public void setLibraryfeefines(Libraryfeefines libraryfeefines) {
        this.libraryfeefines = libraryfeefines;
    }

    /**
     * @return the libraryfeefinesList
     */
    public List<Libraryfeefines> getLibraryfeefinesList() {
        libraryfeefinesList = getEm().createQuery("select l from Libraryfeefines l").getResultList();
        return libraryfeefinesList;
    }

    /**
     * @param libraryfeefinesList the libraryfeefinesList to set
     */
    public void setLibraryfeefinesList(List<Libraryfeefines> libraryfeefinesList) {
        this.libraryfeefinesList = libraryfeefinesList;
    }

    /**
     * @return the librarylendreceive
     */
    public Librarylendreceive getLibrarylendreceive() {
        return librarylendreceive;
    }

    /**
     * @param librarylendreceive the librarylendreceive to set
     */
    public void setLibrarylendreceive(Librarylendreceive librarylendreceive) {
        this.librarylendreceive = librarylendreceive;
    }

    /**
     * @return the librarylendreceiveList
     */
    public List<Librarylendreceive> getLibrarylendreceiveList() {
        librarylendreceiveList = getEm().createQuery("select l from Librarylendreceive l").getResultList();
        return librarylendreceiveList;
    }

    /**
     * @param librarylendreceiveList the librarylendreceiveList to set
     */
    public void setLibrarylendreceiveList(List<Librarylendreceive> librarylendreceiveList) {
        this.librarylendreceiveList = librarylendreceiveList;
    }

    /**
     * @return the librarylendstationery
     */
    public Librarylendstationery getLibrarylendstationery() {
        return librarylendstationery;
    }

    /**
     * @param librarylendstationery the librarylendstationery to set
     */
    public void setLibrarylendstationery(Librarylendstationery librarylendstationery) {
        this.librarylendstationery = librarylendstationery;
    }

    /**
     * @return the librarylendstationeryList
     */
    public List<Librarylendstationery> getLibrarylendstationeryList() {
        librarylendstationeryList = getEm().createQuery("select l from Librarylendstationery l").getResultList();
        return librarylendstationeryList;
    }

    /**
     * @param librarylendstationeryList the librarylendstationeryList to set
     */
    public void setLibrarylendstationeryList(List<Librarylendstationery> librarylendstationeryList) {
        this.librarylendstationeryList = librarylendstationeryList;
    }

    /**
     * @return the librarymember
     */
    public Librarymember getLibrarymember() {
        return librarymember;
    }

    /**
     * @param librarymember the librarymember to set
     */
    public void setLibrarymember(Librarymember librarymember) {
        this.librarymember = librarymember;
    }

    /**
     * @return the librarymemberList
     */
    public List<Librarymember> getLibrarymemberList() {
        librarymemberList = getEm().createQuery("select l from Librarymember l").getResultList();
        return librarymemberList;
    }

    /**
     * @param librarymemberList the librarymemberList to set
     */
    public void setLibrarymemberList(List<Librarymember> librarymemberList) {
        this.librarymemberList = librarymemberList;
    }

    /**
     * @return the librarymembertypes
     */
    public Librarymembertypes getLibrarymembertypes() {
        return librarymembertypes;
    }

    /**
     * @param librarymembertypes the librarymembertypes to set
     */
    public void setLibrarymembertypes(Librarymembertypes librarymembertypes) {
        this.librarymembertypes = librarymembertypes;
    }

    /**
     * @return the librarymembertypesList
     */
    public List<Librarymembertypes> getLibrarymembertypesList() {
        librarymembertypesList = getEm().createQuery("select l from Librarymembertypes l").getResultList();
        return librarymembertypesList;
    }

    /**
     * @param librarymembertypesList the librarymembertypesList to set
     */
    public void setLibrarymembertypesList(List<Librarymembertypes> librarymembertypesList) {
        this.librarymembertypesList = librarymembertypesList;
    }

    /**
     * @return the librarynewbookacquisition
     */
    public Librarynewbookacquisition getLibrarynewbookacquisition() {
        return librarynewbookacquisition;
    }

    /**
     * @param librarynewbookacquisition the librarynewbookacquisition to set
     */
    public void setLibrarynewbookacquisition(Librarynewbookacquisition librarynewbookacquisition) {
        this.librarynewbookacquisition = librarynewbookacquisition;
    }

    /**
     * @return the librarynewbookacquisitionList
     */
    public List<Librarynewbookacquisition> getLibrarynewbookacquisitionList() {
        librarynewbookacquisitionList = getEm().createQuery("select l from Librarynewbookacquisition l").getResultList();
        return librarynewbookacquisitionList;
    }

    /**
     * @param librarynewbookacquisitionList the librarynewbookacquisitionList to
     * set
     */
    public void setLibrarynewbookacquisitionList(List<Librarynewbookacquisition> librarynewbookacquisitionList) {
        this.librarynewbookacquisitionList = librarynewbookacquisitionList;
    }

    /**
     * @return the librarynewstationery
     */
    public Librarynewstationery getLibrarynewstationery() {
        return librarynewstationery;
    }

    /**
     * @param librarynewstationery the librarynewstationery to set
     */
    public void setLibrarynewstationery(Librarynewstationery librarynewstationery) {
        this.librarynewstationery = librarynewstationery;
    }

    /**
     * @return the librarynewstationeryList
     */
    public List<Librarynewstationery> getLibrarynewstationeryList() {
        librarynewstationeryList = getEm().createQuery("select l from Librarynewstationery l").getResultList();
        return librarynewstationeryList;
    }

    /**
     * @param librarynewstationeryList the librarynewstationeryList to set
     */
    public void setLibrarynewstationeryList(List<Librarynewstationery> librarynewstationeryList) {
        this.librarynewstationeryList = librarynewstationeryList;
    }

//    /**
//     * @return the librarypublishers
//     */
//    public Librarynewstationeryacquisition getLibrarynewstationeryacquisition() {
//        return librarynewstationeryacquisition;
//    }
//
//    /**
//     * @param librarynewstationeryacquisition the
//     * librarynewstationeryacquisition to set
//     */
//    public void setLibrarynewstationeryacquisition(Librarynewstationeryacquisition librarynewstationeryacquisition) {
//        this.librarynewstationeryacquisition = librarynewstationeryacquisition;
//    }
//
//    /**
//     * @return the librarynewstationeryacquisitionList
//     */
//    public List<Librarynewstationeryacquisition> getLibrarynewstationeryacquisitionList() {
//        librarynewstationeryacquisitionList = em.createQuery("select l from Librarynewstationeryacquisition l").getResultList();
//        return librarynewstationeryacquisitionList;
//    }
//
//    /**
//     * @param librarynewstationeryacquisitionList the
//     * librarynewstationeryacquisitionList to set
//     */
//    public void setLibrarynewstationeryacquisitionList(List<Librarynewstationeryacquisition> librarynewstationeryacquisitionList) {
//        this.librarynewstationeryacquisitionList = librarynewstationeryacquisitionList;
//    }
    /**
     * @return the librarypublishers
     */
    public Librarypublishers getLibrarypublishers() {
        return librarypublishers;
    }

    /**
     * @param librarypublishers the librarypublishers to set
     */
    public void setLibrarypublishers(Librarypublishers librarypublishers) {
        this.librarypublishers = librarypublishers;
    }

    /**
     * @return the librarypublishersList
     */
    public List<Librarypublishers> getLibrarypublishersList() {
        librarypublishersList = getEm().createQuery("select l from Librarypublishers l").getResultList();
        return librarypublishersList;
    }

    /**
     * @param librarypublishersList the librarypublishersList to set
     */
    public void setLibrarypublishersList(List<Librarypublishers> librarypublishersList) {
        this.librarypublishersList = librarypublishersList;
    }

    /**
     * @return the libraryshelve
     */
    public Libraryshelve getLibraryshelve() {
        return libraryshelve;
    }

    /**
     * @param libraryshelve the libraryshelve to set
     */
    public void setLibraryshelve(Libraryshelve libraryshelve) {
        this.libraryshelve = libraryshelve;
    }

    /**
     * @return the libraryshelveList
     */
    public List<Libraryshelve> getLibraryshelveList() {
        libraryshelveList = getEm().createQuery("select l from Libraryshelve l").getResultList();
        return libraryshelveList;
    }

    /**
     * @param libraryshelveList the libraryshelveList to set
     */
    public void setLibraryshelveList(List<Libraryshelve> libraryshelveList) {
        this.libraryshelveList = libraryshelveList;
    }

    /**
     * @return the librarystationerycategories
     */
    public Librarystationerycategories getLibrarystationerycategories() {
        return librarystationerycategories;
    }

    /**
     * @param librarystationerycategories the librarystationerycategories to set
     */
    public void setLibrarystationerycategories(Librarystationerycategories librarystationerycategories) {
        this.librarystationerycategories = librarystationerycategories;
    }

    /**
     * @return the librarystationerycategoriesList
     */
    public List<Librarystationerycategories> getLibrarystationerycategoriesList() {
        librarystationerycategoriesList = getEm().createQuery("select l from Librarystationerycategories l").getResultList();
        return librarystationerycategoriesList;
    }

    /**
     * @param librarystationerycategoriesList the
     * librarystationerycategoriesList to set
     */
    public void setLibrarystationerycategoriesList(List<Librarystationerycategories> librarystationerycategoriesList) {
        this.librarystationerycategoriesList = librarystationerycategoriesList;
    }

    /**
     * @return the location
     */
    public Librarysuppliers getLibrarysuppliers() {
        return librarysuppliers;
    }

    /**
     * @param librarysuppliers the librarysuppliers to set
     */
    public void setLibrarysuppliers(Librarysuppliers librarysuppliers) {
        this.librarysuppliers = librarysuppliers;
    }

    /**
     * @return the librarysuppliersList
     */
    public List<Librarysuppliers> getLibrarysuppliersList() {
        librarysuppliersList = getEm().createQuery("select l from Librarysuppliers l").getResultList();
        return librarysuppliersList;
    }

    /**
     * @param librarysuppliersList the librarysuppliersList to set
     */
    public void setLibrarysuppliersList(List<Librarysuppliers> librarysuppliersList) {
        this.librarysuppliersList = librarysuppliersList;
    }

    /**
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @return the locationList
     */
    public List<Location> getLocationList() {
        locationList = getEm().createQuery("select l from Location l").getResultList();
        return locationList;
    }

    /**
     * @param locationList the locationList to set
     */
    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    /**
     * @return the responsibilities
     */
    public Responsibilities getResponsibilities() {
        return responsibilities;
    }

    /**
     * @param responsibilities the responsibilities to set
     */
    public void setResponsibilities(Responsibilities responsibilities) {
        this.responsibilities = responsibilities;
    }

    /**
     * @return the responsibilitiesList
     */
    public List<Responsibilities> getResponsibilitiesList() {
        responsibilitiesList = getEm().createQuery("select r from Responsibilities r").getResultList();
        return responsibilitiesList;
    }

    /**
     * @param responsibilitiesList the responsibilitiesList to set
     */
    public void setResponsibilitiesList(List<Responsibilities> responsibilitiesList) {
        this.responsibilitiesList = responsibilitiesList;
    }

    /**
     * @return the school
     */
    public School getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(School school) {
        this.school = school;
    }

    /**
     * @return the schoolList
     */
    public List<School> getSchoolList() {
        schoolList = getEm().createQuery("select s from School s").getResultList();
        return schoolList;
    }

    /**
     * @param schoolList the schoolList to set
     */
    public void setSchoolList(List<School> schoolList) {
        this.schoolList = schoolList;
    }

    /**
     * @return the streams
     */
    public Streams getStreams() {
        return streams;
    }

    /**
     * @param streams the streams to set
     */
    public void setStreams(Streams streams) {
        this.streams = streams;
    }

    /**
     * @return the streamsList
     */
    public List<Streams> getStreamsList() {
        streamsList = getEm().createQuery("select s from Streams s").getResultList();
        return streamsList;
    }

    /**
     * @param streamsList the streamsList to set
     */
    public void setStreamsList(List<Streams> streamsList) {
        this.streamsList = streamsList;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the studentList
     */
    public List<Student> getStudentList() {
        studentList = getEm().createQuery("select s from Student s").getResultList();
        return studentList;
    }

    /**
     * @param studentList the studentList to set
     */
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * @return the studentsubjects
     */
    public Studentsubjects getStudentsubjects() {
        return studentsubjects;
    }

    /**
     * @param studentsubjects the studentsubjects to set
     */
    public void setStudentsubjects(Studentsubjects studentsubjects) {
        this.studentsubjects = studentsubjects;
    }

    /**
     * @return the studentsubjectsList
     */
    public List<Studentsubjects> getStudentsubjectsList() {
        studentsubjectsList = getEm().createQuery("select s from Studentsubjects s").getResultList();
        return studentsubjectsList;
    }

    /**
     * @param studentsubjectsList the studentsubjectsList to set
     */
    public void setStudentsubjectsList(List<Studentsubjects> studentsubjectsList) {
        this.studentsubjectsList = studentsubjectsList;
    }

    /**
     * @return the subj
     */
    public Subj getSubj() {
        return subj;
    }

    /**
     * @param subj the subj to set
     */
    public void setSubj(Subj subj) {
        this.subj = subj;
    }

    /**
     * @return the subjList
     */
    public List<Subj> getSubjList() {
        subjList = getEm().createQuery("select s from Subj s").getResultList();
        return subjList;
    }

    /**
     * @param subjList the subjList to set
     */
    public void setSubjList(List<Subj> subjList) {
        this.subjList = subjList;
    }

    /**
     * @return the subjcombination
     */
    public Subjcombination getSubjcombination() {
        return subjcombination;
    }

    /**
     * @param subjcombination the subjcombination to set
     */
    public void setSubjcombination(Subjcombination subjcombination) {
        this.subjcombination = subjcombination;
    }

    /**
     * @return the subjcombinationList
     */
    public List<Subjcombination> getSubjcombinationList() {
        subjcombinationList = getEm().createQuery("select s from Subjcombination s").getResultList();
        return subjcombinationList;
    }

    /**
     * @param subjcombinationList the subjcombinationList to set
     */
    public void setSubjcombinationList(List<Subjcombination> subjcombinationList) {
        this.subjcombinationList = subjcombinationList;
    }

    /**
     * @return the subjgroups
     */
    public Subjectallocation getSubjectallocation() {
        return subjectallocation;
    }

    /**
     * @param subjectallocation the subjectallocation to set
     */
    public void setSubjectallocation(Subjectallocation subjectallocation) {
        this.subjectallocation = subjectallocation;
    }

    /**
     * @return the subjectallocationList
     */
    public List<Subjectallocation> getSubjectallocationList() {
        subjectallocationList = getEm().createQuery("SELECT s FROM Subjectallocation s").getResultList();
        return subjectallocationList;
    }

    /**
     * @param subjectallocationList the subjectallocationList to set
     */
    public void setSubjectallocationList(List<Subjectallocation> subjectallocationList) {
        this.subjectallocationList = subjectallocationList;
    }

    /**
     * @return the subjgroups
     */
    public Subjgroups getSubjgroups() {
        return subjgroups;
    }

    /**
     * @param subjgroups the subjgroups to set
     */
    public void setSubjgroups(Subjgroups subjgroups) {
        this.subjgroups = subjgroups;
    }

    /**
     * @return the subjgroupsList
     */
    public List<Subjgroups> getSubjgroupsList() {
        subjgroupsList = getEm().createQuery("select s from Subjgroups s").getResultList();
        return subjgroupsList;
    }

    /**
     * @param subjgroupsList the subjgroupsList to set
     */
    public void setSubjgroupsList(List<Subjgroups> subjgroupsList) {
        this.subjgroupsList = subjgroupsList;
    }

    /**
     * @return the Subjkcpe
     */
    public Subjkcpe getSubjkcpe() {
        return Subjkcpe;
    }

    /**
     * @param Subjkcpe the Subjkcpe to set
     */
    public void setSubjkcpe(Subjkcpe Subjkcpe) {
        this.Subjkcpe = Subjkcpe;
    }

    /**
     * @return the subjkcpeList
     */
    public List<Subjkcpe> getSubjkcpeList() {
        subjkcpeList = getEm().createQuery("select s from Subjkcpe s").getResultList();
        return subjkcpeList;
    }

    /**
     * @param subjkcpeList the subjkcpeList to set
     */
    public void setSubjkcpeList(List<Subjkcpe> subjkcpeList) {
        this.subjkcpeList = subjkcpeList;
    }

    /**
     * @return the sublocation
     */
    public Sublocation getSublocation() {
        return sublocation;
    }

    /**
     * @param sublocation the sublocation to set
     */
    public void setSublocation(Sublocation sublocation) {
        this.sublocation = sublocation;
    }

    /**
     * @return the sublocationList
     */
    public List<Sublocation> getSublocationList() {
        sublocationList = getEm().createQuery("select s from Sublocation s").getResultList();
        return sublocationList;
    }

    /**
     * @param sublocationList the sublocationList to set
     */
    public void setSublocationList(List<Sublocation> sublocationList) {
        this.sublocationList = sublocationList;
    }

    /**
     * @return the teachers
     */
    public Teachers getTeachers() {
        return teachers;
    }

    /**
     * @param teachers the teachers to set
     */
    public void setTeachers(Teachers teachers) {
        this.teachers = teachers;
    }

    /**
     * @return the teachersList
     */
    public List<Teachers> getTeachersList() {
        teachersList = getEm().createQuery("select t from Teachers t").getResultList();
        return teachersList;
    }

    /**
     * @param teachersList the teachersList to set
     */
    public void setTeachersList(List<Teachers> teachersList) {
        this.teachersList = teachersList;
    }

    /**
     * @return the zones
     */
    public Zones getZones() {
        return zones;
    }

    /**
     * @param zones the zones to set
     */
    public void setZones(Zones zones) {
        this.zones = zones;
    }

    /**
     * @return the zonesList
     */
    public List<Zones> getZonesList() {
        zonesList = getEm().createQuery("select z from Zones z").getResultList();
        return zonesList;
    }

    /**
     * @param zonesList the zonesList to set
     */
    public void setZonesList(List<Zones> zonesList) {
        this.zonesList = zonesList;
    }

    /**
     * @return the remember
     */
    public Boolean getRemember() {
        return remember;
    }

    /**
     * @param remember the remember to set
     */
    public void setRemember(Boolean remember) {
        this.remember = remember;
    }

    /**
     * @return the root
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * @return the classteacher
     */
    public Classteacher getClassteacher() {
        return classteacher;
    }

    /**
     * @param classteacher the classteacher to set
     */
    public void setClassteacher(Classteacher classteacher) {
        this.classteacher = classteacher;
    }

    /**
     * @return the classteacherList
     */
    public List<Classteacher> getClassteacherList() {
        return classteacherList;
    }

    /**
     * @param classteacherList the classteacherList to set
     */
    public void setClassteacherList(List<Classteacher> classteacherList) {
        this.classteacherList = classteacherList;
    }

    /**
     * @return the ntsbog
     */
    public Ntsbog getNtsbog() {
        return ntsbog;
    }

    /**
     * @param ntsbog the ntsbog to set
     */
    public void setNtsbog(Ntsbog ntsbog) {
        this.ntsbog = ntsbog;
    }

    /**
     * @return the ntsbogList
     */
    public List<Ntsbog> getNtsbogList() {
        ntsbogList = getEm().createQuery("select n from Ntsbog n").getResultList();
        return ntsbogList;
    }

    /**
     * @param ntsbogList the ntsbogList to set
     */
    public void setNtsbogList(List<Ntsbog> ntsbogList) {
        this.ntsbogList = ntsbogList;
    }

    /**
     * @return the ntspta
     */
    public Ntspta getNtspta() {
        return ntspta;
    }

    /**
     * @param ntspta the ntspta to set
     */
    public void setNtspta(Ntspta ntspta) {
        this.ntspta = ntspta;
    }

    /**
     * @return the ntsptaList
     */
    public List<Ntspta> getNtsptaList() {
        ntsptaList = getEm().createQuery("select n from Ntspta n").getResultList();
        return ntsptaList;
    }

    /**
     * @param ntsptaList the ntsptaList to set
     */
    public void setNtsptaList(List<Ntspta> ntsptaList) {
        this.ntsptaList = ntsptaList;
    }

    /**
     * @return the ntsptacategory
     */
    public Ntsptacategory getNtsptacategory() {
        return ntsptacategory;
    }

    /**
     * @param ntsptacategory the ntsptacategory to set
     */
    public void setNtsptacategory(Ntsptacategory ntsptacategory) {
        this.ntsptacategory = ntsptacategory;
    }

    /**
     * @return the ntsptacategoryList
     */
    public List<Ntsptacategory> getNtsptacategoryList() {
        ntsptacategoryList = getEm().createQuery("select n from Ntsptacategory n").getResultList();
        return ntsptacategoryList;
    }

    /**
     * @param ntsptacategoryList the ntsptacategoryList to set
     */
    public void setNtsptacategoryList(List<Ntsptacategory> ntsptacategoryList) {
        this.ntsptacategoryList = ntsptacategoryList;
    }

    /**
     * @return the ntsbogcategories
     */
    public Ntsbogcategories getNtsbogcategories() {
        return ntsbogcategories;
    }

    /**
     * @param ntsbogcategories the ntsbogcategories to set
     */
    public void setNtsbogcategories(Ntsbogcategories ntsbogcategories) {
        this.ntsbogcategories = ntsbogcategories;
    }

    /**
     * @return the ntsbogcategoriesList
     */
    public List<Ntsbogcategories> getNtsbogcategoriesList() {
        ntsbogcategoriesList = getEm().createQuery("select n from Ntsbogcategories n").getResultList();
        return ntsbogcategoriesList;
    }

    /**
     * @param ntsbogcategoriesList the ntsbogcategoriesList to set
     */
    public void setNtsbogcategoriesList(List<Ntsbogcategories> ntsbogcategoriesList) {
        this.ntsbogcategoriesList = ntsbogcategoriesList;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

}
