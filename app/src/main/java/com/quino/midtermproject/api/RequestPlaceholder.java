package com.quino.midtermproject.api;

import com.quino.midtermproject.pojos.login;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RequestPlaceholder {

    @POST("login")
    Call<login>login(@Body login login);

}
