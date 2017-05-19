package com.mobgen.fernandosouto.testarchitecture.network;

import com.mobgen.fernandosouto.testarchitecture.model.Result;
import com.mobgen.fernandosouto.testarchitecture.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by f.souto.gonzalez on 19/05/2017.
 */

public interface RandomUserApi {

    String URL = "https://randomuser.me/api/";

    @GET("?results=100")
    Call<Result> listRandomUser();

    @GET(URL)
    Call<Result> findByGender(@Query("gender") String gender);
}
