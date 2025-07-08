
package com.example.finalproject.model.alljobs;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BusinessMan implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("job_title")
    @Expose
    private Object jobTitle;
    @SerializedName("work_field_id")
    @Expose
    private Object workFieldId;
    @SerializedName("date_of_birth")
    @Expose
    private Object dateOfBirth;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("country_id")
    @Expose
    private Object countryId;
    @SerializedName("nationality")
    @Expose
    private Object nationality;
    @SerializedName("business_name")
    @Expose
    private String businessName;
    @SerializedName("type_business")
    @Expose
    private Integer typeBusiness;
    @SerializedName("employee_no")
    @Expose
    private String employeeNo;
    @SerializedName("user_name")
    @Expose
    private Object userName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("intro_phone")
    @Expose
    private String introPhone;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("intro_telephone")
    @Expose
    private String introTelephone;
    @SerializedName("email_verified_at")
    @Expose
    private Object emailVerifiedAt;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("active_status")
    @Expose
    private Integer activeStatus;
    @SerializedName("verify_code")
    @Expose
    private Object verifyCode;
    @SerializedName("complete_status")
    @Expose
    private Integer completeStatus;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("contact_privacy")
    @Expose
    private Integer contactPrivacy;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("is_from_socialite")
    @Expose
    private Integer isFromSocialite;
    @SerializedName("active_socialite")
    @Expose
    private Integer activeSocialite;
    @SerializedName("fcm_token")
    @Expose
    private Object fcmToken;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("cover_url")
    @Expose
    private String coverUrl;
    @SerializedName("cv_file_url")
    @Expose
    private Object cvFileUrl;
    @SerializedName("experience_years")
    @Expose
    private String experienceYears;
    @SerializedName("number_experience_years")
    @Expose
    private Integer numberExperienceYears;
    @SerializedName("name_with_certifications")
    @Expose
    private Object nameWithCertifications;
    private final static long serialVersionUID = 3581307701714510098L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Object jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Object getWorkFieldId() {
        return workFieldId;
    }

    public void setWorkFieldId(Object workFieldId) {
        this.workFieldId = workFieldId;
    }

    public Object getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Object dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
        this.gender = gender;
    }

    public Object getCountryId() {
        return countryId;
    }

    public void setCountryId(Object countryId) {
        this.countryId = countryId;
    }

    public Object getNationality() {
        return nationality;
    }

    public void setNationality(Object nationality) {
        this.nationality = nationality;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getTypeBusiness() {
        return typeBusiness;
    }

    public void setTypeBusiness(Integer typeBusiness) {
        this.typeBusiness = typeBusiness;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Object getUserName() {
        return userName;
    }

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroPhone() {
        return introPhone;
    }

    public void setIntroPhone(String introPhone) {
        this.introPhone = introPhone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroTelephone() {
        return introTelephone;
    }

    public void setIntroTelephone(String introTelephone) {
        this.introTelephone = introTelephone;
    }

    public Object getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Object emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Object getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(Object verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Integer getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(Integer completeStatus) {
        this.completeStatus = completeStatus;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getContactPrivacy() {
        return contactPrivacy;
    }

    public void setContactPrivacy(Integer contactPrivacy) {
        this.contactPrivacy = contactPrivacy;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getIsFromSocialite() {
        return isFromSocialite;
    }

    public void setIsFromSocialite(Integer isFromSocialite) {
        this.isFromSocialite = isFromSocialite;
    }

    public Integer getActiveSocialite() {
        return activeSocialite;
    }

    public void setActiveSocialite(Integer activeSocialite) {
        this.activeSocialite = activeSocialite;
    }

    public Object getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(Object fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Object getCvFileUrl() {
        return cvFileUrl;
    }

    public void setCvFileUrl(Object cvFileUrl) {
        this.cvFileUrl = cvFileUrl;
    }

    public String getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(String experienceYears) {
        this.experienceYears = experienceYears;
    }

    public Integer getNumberExperienceYears() {
        return numberExperienceYears;
    }

    public void setNumberExperienceYears(Integer numberExperienceYears) {
        this.numberExperienceYears = numberExperienceYears;
    }

    public Object getNameWithCertifications() {
        return nameWithCertifications;
    }

    public void setNameWithCertifications(Object nameWithCertifications) {
        this.nameWithCertifications = nameWithCertifications;
    }

}
