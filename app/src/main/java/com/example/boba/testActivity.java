package com.example.boba;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.boba.databinding.ActivityTestBinding;
import com.google.android.material.transition.MaterialArcMotion;
import com.google.android.material.transition.MaterialContainerTransform;

public class testActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
private ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityTestBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(testActivity.this, BobaLog.class));
                Snackbar.make(view, "Returning to List", Snackbar.LENGTH_LONG)
                        .setAction("Returning to list", null).show();

            }
        });

    }




//    public void materialtransformation () {
//
//        MaterialContainerTransform meta = new MaterialContainerTransform();
//        meta.addTarget(SecondFragment.class);
//        meta.setDuration(500);
//        getWindow().getSharedElementEnterTransition(meta);
//        getWindow().getSharedElementReturnTransition(meta);
//        pathmotion = meta.MaterialArcMotion();
//
//        interloper = FastOutSlowInInterpolator;
//        View startview = findViewById(R.id.fab);
//        Class<SecondFragment> endview = SecondFragment.class;
//
//        meta.getStartView();
//        meta.getEndView() = ""
//
//    }




    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}