package com.example.alexander.kurs_4_1.domain.table;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("object1")
    @Expose
    private Long object1;
    @SerializedName("object2")
    @Expose
    private Long object2;
    @SerializedName("object3")
    @Expose
    private Long object3;
    @SerializedName("ind_achivement")
    @Expose
    private Long indAchivement;
    @SerializedName("type_document")
    @Expose
    private String typeDocument;
    @SerializedName("is_benefit")
    @Expose
    private Long isBenefit;
    @SerializedName("is_olymp")
    @Expose
    private Long isOlymp;
    @SerializedName("is_target")
    @Expose
    private Long isTarget;
    @SerializedName("is_enrolled")
    @Expose
    private Long isEnrolled;
    @SerializedName("priority")
    @Expose
    private Long priority;
    @SerializedName("order")
    @Expose
    private String order;
    @SerializedName("oop_base")
    @Expose
    private String oopBase;
    @SerializedName("is_expelled")
    @Expose
    private Long isExpelled;
    @SerializedName("enrollee_code")
    @Expose
    private String enrolleeCode;
    @SerializedName("enrollee_name")
    @Expose
    private String enrolleeName;
    @SerializedName("total_balls")
    @Expose
    private Long totalBalls;
    @SerializedName("is_concurs_out")
    @Expose
    private Long isConcursOut;
    @SerializedName("is_rec_by_priority")
    @Expose
    private Long isRecByPriority;
    @SerializedName("agreement_enroll")
    @Expose
    private Long agreementEnroll;
    @SerializedName("cg_code")
    @Expose
    private String cgCode;
    @SerializedName("date_update")
    @Expose
    private String dateUpdate;
    @SerializedName("own_right")
    @Expose
    private String ownRight;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("enrolled_by_priority")
    @Expose
    private Long enrolledByPriority;
    @SerializedName("count_enrolled")
    @Expose
    private Long countEnrolled;
    @SerializedName("wave")
    @Expose
    private String wave;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObject1() {
        return object1;
    }

    public void setObject1(Long object1) {
        this.object1 = object1;
    }

    public Long getObject2() {
        return object2;
    }

    public void setObject2(Long object2) {
        this.object2 = object2;
    }

    public Long getObject3() {
        return object3;
    }

    public void setObject3(Long object3) {
        this.object3 = object3;
    }

    public Long getIndAchivement() {
        return indAchivement;
    }

    public void setIndAchivement(Long indAchivement) {
        this.indAchivement = indAchivement;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public Long getIsBenefit() {
        return isBenefit;
    }

    public void setIsBenefit(Long isBenefit) {
        this.isBenefit = isBenefit;
    }

    public Long getIsOlymp() {
        return isOlymp;
    }

    public void setIsOlymp(Long isOlymp) {
        this.isOlymp = isOlymp;
    }

    public Long getIsTarget() {
        return isTarget;
    }

    public void setIsTarget(Long isTarget) {
        this.isTarget = isTarget;
    }

    public Long getIsEnrolled() {
        return isEnrolled;
    }

    public void setIsEnrolled(Long isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOopBase() {
        return oopBase;
    }

    public void setOopBase(String oopBase) {
        this.oopBase = oopBase;
    }

    public Long getIsExpelled() {
        return isExpelled;
    }

    public void setIsExpelled(Long isExpelled) {
        this.isExpelled = isExpelled;
    }

    public String getEnrolleeCode() {
        return enrolleeCode;
    }

    public void setEnrolleeCode(String enrolleeCode) {
        this.enrolleeCode = enrolleeCode;
    }

    public String getEnrolleeName() {
        return enrolleeName;
    }

    public void setEnrolleeName(String enrolleeName) {
        this.enrolleeName = enrolleeName;
    }

    public Long getTotalBalls() {
        return totalBalls;
    }

    public void setTotalBalls(Long totalBalls) {
        this.totalBalls = totalBalls;
    }

    public Long getIsConcursOut() {
        return isConcursOut;
    }

    public void setIsConcursOut(Long isConcursOut) {
        this.isConcursOut = isConcursOut;
    }

    public Long getIsRecByPriority() {
        return isRecByPriority;
    }

    public void setIsRecByPriority(Long isRecByPriority) {
        this.isRecByPriority = isRecByPriority;
    }

    public Long getAgreementEnroll() {
        return agreementEnroll;
    }

    public void setAgreementEnroll(Long agreementEnroll) {
        this.agreementEnroll = agreementEnroll;
    }

    public String getCgCode() {
        return cgCode;
    }

    public void setCgCode(String cgCode) {
        this.cgCode = cgCode;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getOwnRight() {
        return ownRight;
    }

    public void setOwnRight(String ownRight) {
        this.ownRight = ownRight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getEnrolledByPriority() {
        return enrolledByPriority;
    }

    public void setEnrolledByPriority(Long enrolledByPriority) {
        this.enrolledByPriority = enrolledByPriority;
    }

    public Long getCountEnrolled() {
        return countEnrolled;
    }

    public void setCountEnrolled(Long countEnrolled) {
        this.countEnrolled = countEnrolled;
    }

    public String getWave() {
        return wave;
    }

    public void setWave(String wave) {
        this.wave = wave;
    }

}