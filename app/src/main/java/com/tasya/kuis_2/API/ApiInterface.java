package com.tasya.kuis_2.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Tasya on 5/7/2018.
 */

public interface ApiInterface {
    @GET("users/login/")
    Call<ApiData<Users>> getUserLogin(@Query("email") String email, @Query("pass") String password);

    @FormUrlEncoded
    @POST("users/register/")
    Call<ApiData<Integer>> postAccount(@Field("email") String email, @Field("pass") String password);

    @FormUrlEncoded
    @PUT("users/update/")
    Call<ApiData<Integer>> putAccount(@Query("key") String key,
                                      @Field("email") String email,@Field("pass") String password);

}
