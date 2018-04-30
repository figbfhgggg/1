package com.example.alexander.kurs_4_1.domain.entry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("error")
@Expose
private String error;
@SerializedName("success")
@Expose
private Boolean success;

public String getError() {
return error;
}

public void setError(String error) {
this.error = error;
}

public Boolean getSuccess() {
return success;
}

public void setSuccess(Boolean success) {
this.success = success;
}

}