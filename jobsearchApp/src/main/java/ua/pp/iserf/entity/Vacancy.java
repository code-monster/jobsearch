package ua.pp.iserf.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vacancy  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacancy_id")
    private Long vacancyId;
    @Column(name = "vacancy_name", nullable = false)
    private String vacancyName;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;
    @Column(name = "salary")
    private String salary;
    @Column(name = "location")
    private String location;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "original_link", nullable = false)
    private String originalLink;

    public Vacancy() {
    }

    /**
     * @return the vacancyId
     */
    public Long getVacancyId() {
        return vacancyId;
    }

    /**
     * @param vacancyId the vacancyId to set
     */
    public void setVacancyId(Long vacancyId) {
        this.vacancyId = vacancyId;
    }

    /**
     * @return the vacancyName
     */
    public String getVacancyName() {
        return vacancyName;
    }

    /**
     * @param vacancyName the vacancyName to set
     */
    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the originalLink
     */
    public String getOriginalLink() {
        return originalLink;
    }

    /**
     * @param originalLink the originalLink to set
     */
    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }

}
