package org.hillsss.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hillsss.model.base.UpdatedBase;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends UpdatedBase {
    @Id
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "gender", nullable = false, length = 10)
    private String gender;
    @Column(name = "dob", nullable = false)
    private String dob;
    @Column(name = "pob", nullable = false, length = 50)
    private String pob;
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Column(name = "mobile_phone_number", nullable = false, length = 20)
    private String mobilePhoneNumber;
    @Column(name="is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne(targetEntity = JobPosition.class)
    @JsonIgnore
    @JoinColumn(name = "job_position_id", nullable = false)
    private JobPosition jobPosition;

    @ManyToOne(targetEntity = LastEducation.class)
    @JsonIgnore
    @JoinColumn(name = "last_education_id", nullable = false)
    private LastEducation lastEducation;
    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @ManyToOne(targetEntity = User.class)
    @JsonIgnore
    @JoinColumn(name = "updated_by", nullable = false)
    private User updatedBy;

    public Employee() {
        super();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public LastEducation getLastEducation() {
        return lastEducation;
    }

    public void setLastEducation(LastEducation lastEducation) {
        this.lastEducation = lastEducation;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }
}
