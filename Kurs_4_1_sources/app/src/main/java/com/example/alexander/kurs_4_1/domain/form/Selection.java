package com.example.alexander.kurs_4_1.domain.form;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Selection {

@SerializedName("id")
@Expose
private long id;
@SerializedName("level")
@Expose
private String level;
@SerializedName("program")
@Expose
private String program;
@SerializedName("form")
@Expose
private String form;
@SerializedName("type")
@Expose
private String type;
@SerializedName("gc_code")
@Expose
private String gcCode;
@SerializedName("gc_view")
@Expose
private String gcView;
@SerializedName("gc_unique")
@Expose
private long gcUnique;
@SerializedName("budget")
@Expose
private String budget;
@SerializedName("gc_feature")
@Expose
private String gcFeature;
@SerializedName("plan")
@Expose
private long plan;
@SerializedName("institute")
@Expose
private String institute;
@SerializedName("place_mon")
@Expose
private long placeMon;
@SerializedName("cipher")
@Expose
private String cipher;

public long getId() {
return id;
}

public void setId(long id) {
this.id = id;
}

public String getLevel() {
return level;
}

public void setLevel(String level) {
this.level = level;
}

public String getProgram() {
return program;
}

public void setProgram(String program) {
this.program = program;
}

public String getForm() {
return form;
}

public void setForm(String form) {
this.form = form;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getGcCode() {
return gcCode;
}

public void setGcCode(String gcCode) {
this.gcCode = gcCode;
}

public String getGcView() {
return gcView;
}

public void setGcView(String gcView) {
this.gcView = gcView;
}

public long getGcUnique() {
return gcUnique;
}

public void setGcUnique(long gcUnique) {
this.gcUnique = gcUnique;
}

public String getBudget() {
return budget;
}

public void setBudget(String budget) {
this.budget = budget;
}

public String getGcFeature() {
return gcFeature;
}

public void setGcFeature(String gcFeature) {
this.gcFeature = gcFeature;
}

public long getPlan() {
return plan;
}

public void setPlan(long plan) {
this.plan = plan;
}

public String getInstitute() {
return institute;
}

public void setInstitute(String institute) {
this.institute = institute;
}

public long getPlaceMon() {
return placeMon;
}

public void setPlaceMon(long placeMon) {
this.placeMon = placeMon;
}

public String getCipher() {
return cipher;
}

public void setCipher(String cipher) {
this.cipher = cipher;
}

}