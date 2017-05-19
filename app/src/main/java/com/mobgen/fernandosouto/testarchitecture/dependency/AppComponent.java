package com.mobgen.fernandosouto.testarchitecture.dependency;

import android.content.Context;
import android.support.annotation.NonNull;

import com.mobgen.fernandosouto.testarchitecture.activities.MainActivity;
import com.mobgen.fernandosouto.testarchitecture.activities.MainApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by f.souto.gonzalez on 19/05/2017.
 */

@Component(modules = AppModule.class)
@Singleton
public abstract class AppComponent {

    public static AppComponent from(@NonNull Context context){
        return ((MainApplication) context.getApplicationContext()).getAppComponent();
    }

    public abstract void inject(MainActivity mainActivity);

}