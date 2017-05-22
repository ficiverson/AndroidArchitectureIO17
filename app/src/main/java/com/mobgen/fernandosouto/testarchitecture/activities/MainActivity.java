package com.mobgen.fernandosouto.testarchitecture.activities;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gc.materialdesign.views.ButtonFloat;
import com.mobgen.fernandosouto.testarchitecture.R;
import com.mobgen.fernandosouto.testarchitecture.dependency.AppComponent;
import com.mobgen.fernandosouto.testarchitecture.model.User;
import com.mobgen.fernandosouto.testarchitecture.viewmodel.UserProfileViewModel;

import javax.inject.Inject;

public class MainActivity extends LifecycleActivity {

    @Inject
    UserProfileViewModel viewModel;

    TextView userName;
    ImageView userPhoto;
    Context mContext;
    ButtonFloat male, female;
    String gender = "female";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        userName = (TextView)findViewById(R.id.tv_name);
        userPhoto = (ImageView)findViewById(R.id.im_profile);

        male = (ButtonFloat)findViewById(R.id.fb_male);
        female = (ButtonFloat)findViewById(R.id.fb_female);

        AppComponent.from(this).inject(this);
        viewModel.init(gender);

        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if(user != null){
                    userName.setText(user.getName().getFirst());
                    Glide.with(mContext)
                            .load(user.getPicture().getLarge())
                            .into(userPhoto);
                }
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "male";
                viewModel.withGender(gender);
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender = "female";
                viewModel.withGender(gender);
            }
        });

    }
}
