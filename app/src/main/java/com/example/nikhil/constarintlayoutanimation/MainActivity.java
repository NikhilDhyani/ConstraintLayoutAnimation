package com.example.nikhil.constarintlayoutanimation;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private  boolean show =false;
    ImageView imageView;

    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        constraintLayout  = findViewById(R.id.constraint);


        imageView = findViewById(R.id.backgroundImage);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (show) {
                    hideComponents();
                         }
                         else
                             {
                                 showComponents();
                             }
            }
        });


    }

    private void hideComponents() {

        show = false;
        ConstraintSet constraintSet = new ConstraintSet();

        constraintSet.clone(this, R.layout.activity_main);

        ChangeBounds transition = new ChangeBounds();

     //   transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(constraintLayout, transition);
        constraintSet.applyTo(constraintLayout);  //here constraint is the name of view to which we are applying the constraintSet

    }


    private void showComponents(){
        show = true;

         ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this, R.layout.circuit_detail);

         ChangeBounds transition = new ChangeBounds();

     //   transition.getInterpolator() = AnticipateOvershootInterpolator(1.0f);
        transition.setDuration(1200);

        TransitionManager.beginDelayedTransition(constraintLayout, transition);

        //TransitionManager.beginDelayedTransition();
        constraintSet.applyTo(constraintLayout) ;//here constraint is the name of view to which we are applying the constraintSet
    }
}
