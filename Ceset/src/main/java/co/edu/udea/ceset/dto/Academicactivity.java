/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.ceset.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jufeg
 */
@Entity
@Table(name = "tbl_academicactivity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Academicactivity.findAll", query = "SELECT a FROM Academicactivity a")
    , @NamedQuery(name = "Academicactivity.findByIdAcad", query = "SELECT a FROM Academicactivity a WHERE a.idAcad = :idAcad")
    , @NamedQuery(name = "Academicactivity.findByNameActivity", query = "SELECT a FROM Academicactivity a WHERE a.nameActivity = :nameActivity")
    , @NamedQuery(name = "Academicactivity.findByActivityType", query = "SELECT a FROM Academicactivity a WHERE a.activityType = :activityType")
    , @NamedQuery(name = "Academicactivity.findByDependency", query = "SELECT a FROM Academicactivity a WHERE a.dependency = :dependency")
    , @NamedQuery(name = "Academicactivity.findByInvestigationGroup", query = "SELECT a FROM Academicactivity a WHERE a.investigationGroup = :investigationGroup")
    , @NamedQuery(name = "Academicactivity.findByCoordinatorName", query = "SELECT a FROM Academicactivity a WHERE a.coordinatorName = :coordinatorName")
    , @NamedQuery(name = "Academicactivity.findByContactTelephone", query = "SELECT a FROM Academicactivity a WHERE a.contactTelephone = :contactTelephone")
    , @NamedQuery(name = "Academicactivity.findByContactEmail", query = "SELECT a FROM Academicactivity a WHERE a.contactEmail = :contactEmail")
    , @NamedQuery(name = "Academicactivity.findByDurationMonths", query = "SELECT a FROM Academicactivity a WHERE a.durationMonths = :durationMonths")
    , @NamedQuery(name = "Academicactivity.findByContractType", query = "SELECT a FROM Academicactivity a WHERE a.contractType = :contractType")
    , @NamedQuery(name = "Academicactivity.findByContractEntity", query = "SELECT a FROM Academicactivity a WHERE a.contractEntity = :contractEntity")
    , @NamedQuery(name = "Academicactivity.findByContractInit", query = "SELECT a FROM Academicactivity a WHERE a.contractInit = :contractInit")
    , @NamedQuery(name = "Academicactivity.findByContractEnd", query = "SELECT a FROM Academicactivity a WHERE a.contractEnd = :contractEnd")
    , @NamedQuery(name = "Academicactivity.findByCreationDate", query = "SELECT a FROM Academicactivity a WHERE a.creationDate = :creationDate")
    , @NamedQuery(name = "Academicactivity.findByState", query = "SELECT a FROM Academicactivity a WHERE a.state = :state")})
public class Academicactivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdAcad")
    private Integer idAcad;
    @Size(max = 300)
    @Column(name = "nameActivity")
    private String nameActivity;
    @Size(max = 150)
    @Column(name = "activityType")
    private String activityType;
    @Size(max = 150)
    @Column(name = "dependency")
    private String dependency;
    @Size(max = 200)
    @Column(name = "investigationGroup")
    private String investigationGroup;
    @Size(max = 400)
    @Column(name = "coordinatorName")
    private String coordinatorName;
    @Size(max = 15)
    @Column(name = "contactTelephone")
    private String contactTelephone;
    @Size(max = 150)
    @Column(name = "contactEmail")
    private String contactEmail;
    @Column(name = "durationMonths")
    private Integer durationMonths;
    @Size(max = 100)
    @Column(name = "contractType")
    private String contractType;
    @Size(max = 100)
    @Column(name = "contractEntity")
    private String contractEntity;
    @Column(name = "contractInit")
    @Temporal(TemporalType.DATE)
    private Date contractInit;
    @Column(name = "contractEnd")
    @Temporal(TemporalType.DATE)
    private Date contractEnd;
    @Column(name = "creationDate")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Size(max = 50)
    @Column(name = "state")
    private String state;
    @JoinColumn(name = "idUser", referencedColumnName = "IdUser")
    @ManyToOne(fetch = FetchType.LAZY)
    private User idUser;
    @OneToMany(mappedBy = "idActivity", fetch = FetchType.LAZY)
    private Collection<Budget> budgetCollection;
    @OneToMany(mappedBy = "idAcad", fetch = FetchType.LAZY)
    private Collection<Estimated> estimatedCollection;
    @OneToMany(mappedBy = "idActivity", fetch = FetchType.LAZY)
    private Collection<Cohort> cohortCollection;
    @OneToMany(mappedBy = "idAcad", fetch = FetchType.LAZY)
    private Collection<Discount> discountCollection;

    public Academicactivity() {
    }

    public Academicactivity(Integer idAcad) {
        this.idAcad = idAcad;
    }

    public Integer getIdAcad() {
        return idAcad;
    }

    public void setIdAcad(Integer idAcad) {
        this.idAcad = idAcad;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    public String getInvestigationGroup() {
        return investigationGroup;
    }

    public void setInvestigationGroup(String investigationGroup) {
        this.investigationGroup = investigationGroup;
    }

    public String getCoordinatorName() {
        return coordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        this.coordinatorName = coordinatorName;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getContractEntity() {
        return contractEntity;
    }

    public void setContractEntity(String contractEntity) {
        this.contractEntity = contractEntity;
    }

    public Date getContractInit() {
        return contractInit;
    }

    public void setContractInit(Date contractInit) {
        this.contractInit = contractInit;
    }

    public Date getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(Date contractEnd) {
        this.contractEnd = contractEnd;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public Collection<Budget> getBudgetCollection() {
        return budgetCollection;
    }

    public void setBudgetCollection(Collection<Budget> budgetCollection) {
        this.budgetCollection = budgetCollection;
    }

    @XmlTransient
    public Collection<Estimated> getEstimatedCollection() {
        return estimatedCollection;
    }

    public void setEstimatedCollection(Collection<Estimated> estimatedCollection) {
        this.estimatedCollection = estimatedCollection;
    }

    @XmlTransient
    public Collection<Cohort> getCohortCollection() {
        return cohortCollection;
    }

    public void setCohortCollection(Collection<Cohort> cohortCollection) {
        this.cohortCollection = cohortCollection;
    }

    @XmlTransient
    public Collection<Discount> getDiscountCollection() {
        return discountCollection;
    }

    public void setDiscountCollection(Collection<Discount> discountCollection) {
        this.discountCollection = discountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAcad != null ? idAcad.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "co.edu.udea.ceset.dto.Academicactivity[ idAcad=" + idAcad + " ]";
    }
    
}