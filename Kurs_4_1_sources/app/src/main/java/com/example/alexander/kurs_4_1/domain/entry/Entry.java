package com.example.alexander.kurs_4_1.domain.entry;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entry {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result {

        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("isFree")
        @Expose
        private Boolean isFree;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Boolean getIsFree() {
            return isFree;
        }

        public void setIsFree(Boolean isFree) {
            this.isFree = isFree;
        }

    }

}