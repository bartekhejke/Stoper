package com.bartekhejke.stoper;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView logoImageView;
    private TextView appNameTextView, textUnderLogoTextView;
    private Button startButton;
    private Animation atg, btngone, btgtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoImageView = (ImageView) findViewById(R.id.logoImageView);
        appNameTextView = (TextView) findViewById(R.id.appNameTextView);
        textUnderLogoTextView = (TextView) findViewById(R.id.textUnderLogoTextView);
        startButton = (Button) findViewById(R.id.startButton);

        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        btngone = AnimationUtils.loadAnimation(this, R.anim.btngone);
        btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        //passing animation
        logoImageView.startAnimation(atg);
        appNameTextView.startAnimation(btngone);
        textUnderLogoTextView.setAnimation(btngone);
        startButton.setAnimation(btgtwo);

        //import font
        Typeface LogoFont = Typeface.createFromAsset(getAssets(),"fonts/brush_script_mt_kursiv.ttf");
        Typeface UnderLogoFont = Typeface.createFromAsset(getAssets(),"fonts/HTOWERT.TTF");

        //customize font
        appNameTextView.setTypeface(LogoFont);
        textUnderLogoTextView.setTypeface(UnderLogoFont);

        startButton.setOnClickListener(new GetStartApp());

    }

    class GetStartApp implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            getStartApp();
        }

        private void getStartApp() {
            Intent intent = new Intent(MainActivity.this, Stoper.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    }
}
