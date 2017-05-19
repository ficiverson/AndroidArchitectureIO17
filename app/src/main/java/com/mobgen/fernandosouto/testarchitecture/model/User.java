package com.mobgen.fernandosouto.testarchitecture.model;

/**
 * Created by f.souto.gonzalez on 19/05/2017.
 */

public class User {

    Name name;
    Picture picture;

    public User(Name name, Picture picture) {
        this.name = name;
        this.picture = picture;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Name getName() {

        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
