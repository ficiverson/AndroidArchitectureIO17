package com.mobgen.fernandosouto.testarchitecture.activities;

import android.app.Application;

import com.mobgen.fernandosouto.testarchitecture.dependency.AppComponent;
import com.mobgen.fernandosouto.testarchitecture.dependency.AppModule;
import com.mobgen.fernandosouto.testarchitecture.dependency.DaggerAppComponent;

/**
 * Created by f.souto.gonzalez on 19/05/2017.
 */
public class MainApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}