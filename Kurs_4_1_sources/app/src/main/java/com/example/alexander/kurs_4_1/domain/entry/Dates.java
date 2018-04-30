package com.example.alexander.kurs_4_1.domain.entry;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dates {

@SerializedName("error")
@Expose
private String error;
@SerializedName("result")
@Expose
private List<String> result = null;

public String getError() {
return error;
}

public void setError(String error) {
this.error = error;
}

public List<String> getResult() {
return result;
}

public void setResult(List<String> result) {
this.result = result;
}

}