package com.mobgen.fernandosouto.testarchitecture.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.mobgen.fernandosouto.testarchitecture.repository.UserRepository;
import com.mobgen.fernandosouto.testarchitecture.model.User;

import javax.inject.Inject;

/**
 * Created by f.souto.gonzalez on 19/05/2017.
 */

public class UserProfileViewModel extends ViewModel {

    private String gender;
    private LiveData<User> user;
    private UserRepository userRepo;

    @Inject
    public UserProfileViewModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void init(String gender) {
        if (this.user != null) {
            return;
        }
        user = userRepo.getUser(gender);
    }

    public void withGender(String gender) {
        userRepo.getUser(gender);
    }
    public LiveData<User> getUser() {
        return user;
    }
}
