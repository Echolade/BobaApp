package com.example.boba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.app.ActionBar;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button enterBobalog;
    AnimationDrawable bobaAnimation;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


//toggle button for boba animation
        ToggleButton start = (ToggleButton) findViewById(R.id.start);
        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
                ImageView bobaImage = (ImageView) findViewById(R.id.boba_image);
                bobaImage.setImageResource(R.drawable.animation);
                bobaAnimation = (AnimationDrawable) bobaImage.getDrawable();

                if(start.isChecked()) {
                    bobaAnimation.start();
                } else {
                    bobaAnimation.stop();
                }

            }

        });

        img = findViewById(R.id.boba_image);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startspringanimation(view,300);
                startspringanimation(view,0);
            }
        });

    }

    public void startspringanimation (View view, float position) {


        final SpringAnimation anim = new SpringAnimation(img, DynamicAnimation.TRANSLATION_X);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(SpringForce.STIFFNESS_MEDIUM);
        springForce.setFinalPosition(position);
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        anim.setSpring(springForce);
        anim.start();

    }

    //    button for new activity also contains change in button text
    public void enter (View v) {
        v.setEnabled(false);
        Button enterBobaLog = (Button) v;
        enterBobaLog.setText("Welcome 삳");
        Intent intent = new Intent(this, BobaLog.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

}

