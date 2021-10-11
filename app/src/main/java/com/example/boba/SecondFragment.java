package com.example.boba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.boba.databinding.FragmentSecondBinding;
import com.google.android.material.transition.MaterialContainerTransform;

public class SecondFragment extends Fragment {

private FragmentSecondBinding binding;

    ImageView img;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = FragmentSecondBinding.inflate(inflater, container, false);
      return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        img = getView().findViewById(R.id.bobaman);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startspringanimation(view,600);
                startspringanimation(view,0);
            }
        });


        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }


    public void startspringanimation (View view, float position) {


        final SpringAnimation anim = new SpringAnimation(img, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(SpringForce.STIFFNESS_LOW);
        springForce.setFinalPosition(position);
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        anim.setSpring(springForce);
        anim.start();

    }


@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}