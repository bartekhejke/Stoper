package com.bartekhejke.stoper;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Stoper extends AppCompatActivity {

    private Button runButton, stopButton;
    private ImageView pointerImageView;
    private Animation roundingalone;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoper);

        runButton = (Button) findViewById(R.id.runButton);
        stopButton = (Button) findViewById(R.id.stopButton);
        pointerImageView = (ImageView) findViewById(R.id.pointerImageView);
        chronometer = (Chronometer) findViewById(R.id.chronometer);

        stopButton.setAlpha(0);

        //load animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        runButton.setOnClickListener(new GetRunStoper());
        stopButton.setOnClickListener(new GetStopStoper());


    }

    class GetRunStoper implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            getRunStoper();
        }

        private void getRunStoper() {
            //animation
            pointerImageView.startAnimation(roundingalone);
            stopButton.animate().alpha(1).translationY(-80).setDuration(300).start();
            runButton.animate().alpha(0).setDuration(300).start();
            //time
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
        }
    }

    class GetStopStoper implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            getStopStoper();
        }

        private void getStopStoper() {
            pointerImageView.clearAnimation();
            runButton.animate().alpha(1).setDuration(300).start();
            stopButton.animate().alpha(0).translationY(80).setDuration(300).start();
            //time
            chronometer.stop();
        }
    }
}
