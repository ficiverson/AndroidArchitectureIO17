package com.mobgen.fernandosouto.testarchitecture.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.mobgen.fernandosouto.testarchitecture.model.Result;
import com.mobgen.fernandosouto.testarchitecture.model.User;
import com.mobgen.fernandosouto.testarchitecture.network.RandomUserApi;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by f.souto.gonzalez on 19/05/2017.
 */

public class UserRepository {
    private RandomUserApi randomUserApi;

    public UserRepository(RandomUserApi randomUserApi){
        this.randomUserApi = randomUserApi;
    }

    public LiveData<User> getUser(String gender) {
        // This is not an optimal implementation, we'll fix it below
        final MutableLiveData<User> data = new MutableLiveData<>();
        randomUserApi.findByGender(gender).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                // error case is left out for brevity
                data.setValue(response.body().getFirstUser());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}