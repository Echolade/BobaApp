package com.example.boba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button enterBobalog;
    AnimationDrawable bobaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


    }

//    button for new activity also contains change in button text
    public void enter (View v) {
        v.setEnabled(false);
        Button enterBobaLog = (Button) v;
        enterBobaLog.setText("test");
        Intent intent = new Intent(this, BobaLog.class);
        startActivity(intent);
    }

}