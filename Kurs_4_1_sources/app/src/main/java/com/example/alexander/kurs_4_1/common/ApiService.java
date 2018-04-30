package com.example.alexander.kurs_4_1.common;

import com.example.alexander.kurs_4_1.domain.entry.Dates;
import com.example.alexander.kurs_4_1.domain.entry.Entry;
import com.example.alexander.kurs_4_1.domain.entry.Result;
import com.example.alexander.kurs_4_1.domain.form.SelectionBean;
import com.example.alexander.kurs_4_1.domain.table.UserBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Alexander on 27.12.2016.
 */

public interface ApiService {

    @GET("plans")
    Call<SelectionBean> getPlans();

    @GET("getTable")
    Call<UserBean> getAbiturients(
            @Query("level") String level,
            @Query("program") String program,
            @Query("form") String form,
            @Query("type") String type
                                  );

    @GET("consultation")
    Call<Entry> getConsultations(@Query("day_at") String dayAt);

    @FormUrlEncoded
    @POST("consultation")
    Call<Result> sendEntry(
             @Field("name") String name,
             @Field("level") String level,
             @Field("program") String program,
             @Field("form") String form,
             @Field("type") String type,
             @Field("day_at") String dayAt,
             @Field("time_at") String timeAt,
             @Field("user_ip") String userIp,
             @Field("create_at") String createAt
             );

    @GET("day")
    Call<Dates> getDates();
}
