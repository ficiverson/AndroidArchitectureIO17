package com.mobgen.fernandosouto.testarchitecture.dependency;

import android.app.Application;

import com.mobgen.fernandosouto.testarchitecture.model.User;
import com.mobgen.fernandosouto.testarchitecture.network.RandomUserApi;
import com.mobgen.fernandosouto.testarchitecture.repository.UserRepository;

import java.util.List;
import java.util.Random;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

/**
 * Created by f.souto.gonzalez on 19/05/2017.
 */
@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public RandomUserApi provideRandomUserApi(){
        return new Retrofit.Builder()
                .baseUrl(RandomUserApi.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RandomUserApi.class);
    }

    @Provides
    @Singleton
    public UserRepository provideUserRepository(RandomUserApi randomUserApi){
        return new UserRepository(randomUserApi);
    }
}
