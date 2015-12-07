package com.kristoff.eyedetection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView eye = (ImageView)findViewById(R.id.imageViewP);
        TextView main = (TextView)findViewById(R.id.splashText1);
        TextView sub = (TextView)findViewById(R.id.splashText2);

        Animation decel = AnimationUtils.loadAnimation(this, R.anim.decelerate);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        eye.startAnimation(decel);
        main.startAnimation(decel);
        sub.startAnimation(fade);

        eye.setVisibility(View.INVISIBLE);
        main.setVisibility(View.INVISIBLE);
        sub.setVisibility(View.INVISIBLE);

        decel.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                // The animation has ended, transition to the Main Menu screen
                startActivity(new Intent(SplashActivity.this,
                        ModifiedFdActivity.class));
                SplashActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        });
    }
}
