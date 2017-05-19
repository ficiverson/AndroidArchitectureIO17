package com.mobgen.fernandosouto.testarchitecture.model;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by f.souto.gonzalez on 19/05/2017.
 */

public class Result {

    List<User> results;

    @Nullable
    public User getFirstUser(){
        if(results != null){
            return results.get(0);
        } else {
            return null;
        }
    }
}
