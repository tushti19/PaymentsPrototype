package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class feedback extends AppCompatActivity {

    ImageView loveditsmall,greatsmall,averagesmall,badsmall,fucksmall;
    ImageView loveditbig,greatbig,averagebig,badbig,fuckbig;
    TextView lovedittext,greattext,averagetext,badtext,fucktext;
    TextView lovedit,great,average,bad,fuck;
    RelativeLayout layout;
    TextView rate,shop;
    int fht,iht;
    boolean flag = false;
    boolean f1 = false;
    boolean f2 = false;
    boolean f3 = false;
    boolean f4 = false;
    boolean f5 = false;
    ImageView cancel;

    EditText feedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        feedback = findViewById(R.id.feedbacktext);
        cancel = findViewById(R.id.cancel);

        rate = findViewById(R.id.rate_your_exp);
        shop = findViewById(R.id.shopName);

        Resources r = getResources();
        iht = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                207,
                r.getDisplayMetrics());
        fht = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                404,
                r.getDisplayMetrics());

        layout = findViewById(R.id.layout);

        loveditsmall = findViewById(R.id.loveditsmall);
        greatsmall = findViewById(R.id.greatsmall);
        averagesmall = findViewById(R.id.averagesmall);
        badsmall = findViewById(R.id.badsmall);
        fucksmall = findViewById(R.id.fucksmall);

        loveditbig = findViewById(R.id.loveditbig);
        greatbig= findViewById(R.id.greatbig);
        averagebig = findViewById(R.id.averagebig);
        badbig = findViewById(R.id.badbig);
        fuckbig = findViewById(R.id.fuckbig);

        lovedittext = findViewById(R.id.lovedittext);
        greattext = findViewById(R.id.greattext);
        averagetext = findViewById(R.id.averagetext);
        badtext = findViewById(R.id.badtext);
        fucktext = findViewById(R.id.fucktext);

        lovedit = findViewById(R.id.lovedit);
        great= findViewById(R.id.great);
        average = findViewById(R.id.average);
        bad= findViewById(R.id.bad);
        fuck = findViewById(R.id.fuck);



        loveditsmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                loveditsmall.startAnimation(animation1);
                if(f2){
                  //  greatbig.startAnimation(animation1);
                  //  great.startAnimation(animation1);
                  //  greattext.startAnimation(animation1);
                    greatbig.setVisibility(View.INVISIBLE);
                    great.setVisibility(View.INVISIBLE);
                    greattext.setVisibility(View.INVISIBLE);
                 //   greatsmall.startAnimation(animation2);
                    greatsmall.setVisibility(View.VISIBLE);
                }
                if(f3){
                 //   averagebig.startAnimation(animation1);
                 //   average.startAnimation(animation1);
                  //  averagetext.startAnimation(animation1);
                    averagebig.setVisibility(View.INVISIBLE);
                    average.setVisibility(View.INVISIBLE);
                    averagetext.setVisibility(View.INVISIBLE);
                 //   averagesmall.startAnimation(animation2);
                    averagesmall.setVisibility(View.VISIBLE);
                }
                if(f4){
                   // badbig.startAnimation(animation1);
                 //   bad.startAnimation(animation1);
                   // badtext.startAnimation(animation1);
                    badbig.setVisibility(View.INVISIBLE);
                    bad.setVisibility(View.INVISIBLE);
                    badtext.setVisibility(View.INVISIBLE);
                   // badsmall.startAnimation(animation2);
                    badsmall.setVisibility(View.VISIBLE);
                }
                if(f5){
                  //  fuckbig.startAnimation(animation1);
                  //  fuck.startAnimation(animation1);
                    //fucktext.startAnimation(animation1);
                    fuckbig.setVisibility(View.INVISIBLE);
                    fuck.setVisibility(View.INVISIBLE);
                    fucktext.setVisibility(View.INVISIBLE);
                 //   fucksmall.startAnimation(animation2);
                    fucksmall.setVisibility(View.VISIBLE);
                }

                loveditbig.startAnimation(animation2);
                f1 = true;
                loveditsmall.setVisibility(View.INVISIBLE);
                rate.setVisibility(View.INVISIBLE);
                shop.setVisibility(View.INVISIBLE);
                loveditbig.setVisibility(View.VISIBLE);
                lovedittext.setText("Looks like we nailed it.\nWe'd love to hear more.");
                lovedittext.startAnimation(animation2);
                lovedittext.setVisibility(View.VISIBLE);
                lovedit.startAnimation(animation2);
                lovedit.setVisibility(View.VISIBLE);
                feedback.setHint("Tell us what you Loved..... (Optional)");

                if(!flag){
                  expandView(layout,iht,fht);
                }


            }
        });
        greatsmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                if(f1){
                  //  loveditbig.startAnimation(animation1);
                  //  lovedit.startAnimation(animation1);
                    //lovedittext.startAnimation(animation1);
                    loveditbig.setVisibility(View.INVISIBLE);
                    lovedit.setVisibility(View.INVISIBLE);
                    lovedittext.setVisibility(View.INVISIBLE);
                    //loveditsmall.startAnimation(animation2);
                    loveditsmall.setVisibility(View.VISIBLE);
                }
                if(f3){
                  //  averagebig.startAnimation(animation1);
                  //  average.startAnimation(animation1);
                    //averagetext.startAnimation(animation1);
                    averagebig.setVisibility(View.INVISIBLE);
                    average.setVisibility(View.INVISIBLE);
                    averagetext.setVisibility(View.INVISIBLE);
                  //  averagesmall.startAnimation(animation2);
                    averagesmall.setVisibility(View.VISIBLE);
                }
                if(f4){
                 //   badbig.startAnimation(animation1);
                 //   bad.startAnimation(animation1);
                   // badtext.startAnimation(animation1);
                    badbig.setVisibility(View.INVISIBLE);
                    bad.setVisibility(View.INVISIBLE);
                    badtext.setVisibility(View.INVISIBLE);
                   // badsmall.startAnimation(animation2);
                    badsmall.setVisibility(View.VISIBLE);
                }
                if(f5){
                  //  fuckbig.startAnimation(animation1);
                  //  fuck.startAnimation(animation1);
                    //fucktext.startAnimation(animation1);
                    fuckbig.setVisibility(View.INVISIBLE);
                    fuck.setVisibility(View.INVISIBLE);
                    fucktext.setVisibility(View.INVISIBLE);
                 //   fucksmall.startAnimation(animation2);
                    fucksmall.setVisibility(View.VISIBLE);
                }

                greatsmall.startAnimation(animation1);
                greatbig.startAnimation(animation2);
                f2 = true;
                greatsmall.setVisibility(View.INVISIBLE);
                rate.setVisibility(View.INVISIBLE);
                shop.setVisibility(View.INVISIBLE);
                greatbig.setVisibility(View.VISIBLE);
                greattext.setText("We're gonna try harder next time.\nWhat were you impressed with?");
                greattext.startAnimation(animation2);
                greattext.setVisibility(View.VISIBLE);
                great.startAnimation(animation2);
                great.setVisibility(View.VISIBLE);
                feedback.setHint("Tell us what you Liked..... (Optional)");

                if(!flag)
                    expandView(layout,iht,fht);




            }
        });
        averagesmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                averagesmall.startAnimation(animation1);
                if(f2){
                  //  greatbig.startAnimation(animation1);
                  //  great.startAnimation(animation1);
                   // greattext.startAnimation(animation1);
                    greatbig.setVisibility(View.INVISIBLE);
                    great.setVisibility(View.INVISIBLE);
                    greattext.setVisibility(View.INVISIBLE);
                //    greatsmall.startAnimation(animation2);
                    greatsmall.setVisibility(View.VISIBLE);
                }
                if(f1){
                  //  loveditbig.startAnimation(animation1);
                  //  lovedit.startAnimation(animation1);
                    //lovedittext.startAnimation(animation1);
                    loveditbig.setVisibility(View.INVISIBLE);
                    lovedit.setVisibility(View.INVISIBLE);
                    lovedittext.setVisibility(View.INVISIBLE);
                 //   loveditsmall.startAnimation(animation2);
                    loveditsmall.setVisibility(View.VISIBLE);
                }
                if(f4){
                 //   badbig.startAnimation(animation1);
                 //   bad.startAnimation(animation1);
                   // badtext.startAnimation(animation1);
                    badbig.setVisibility(View.INVISIBLE);
                    bad.setVisibility(View.INVISIBLE);
                    badtext.setVisibility(View.INVISIBLE);
                 //   badsmall.startAnimation(animation2);
                    badsmall.setVisibility(View.VISIBLE);
                }
                if(f5){
                  //  fuckbig.startAnimation(animation1);
                  //  fuck.startAnimation(animation1);
                   // fucktext.startAnimation(animation1);
                    fuckbig.setVisibility(View.INVISIBLE);
                    fuck.setVisibility(View.INVISIBLE);
                    fucktext.setVisibility(View.INVISIBLE);
                 //   fucksmall.startAnimation(animation2);
                    fucksmall.setVisibility(View.VISIBLE);
                }

                averagebig.startAnimation(animation2);
                f3 = true;
                averagesmall.setVisibility(View.INVISIBLE);
                rate.setVisibility(View.INVISIBLE);
                shop.setVisibility(View.INVISIBLE);
                averagebig.setVisibility(View.VISIBLE);
                averagetext.setText("You don't sound too pleased.\nTell us why.");
                averagetext.startAnimation(animation2);
                averagetext.setVisibility(View.VISIBLE);
                average.startAnimation(animation2);
                average.setVisibility(View.VISIBLE);
                feedback.setHint("Tell us what we can improve..... (Optional)");

                if(!flag)
                    expandView(layout,iht,fht);




            }
        });
        badsmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                badsmall.startAnimation(animation1);
                if(f2){
                    //greatbig.startAnimation(animation1);
                    //great.startAnimation(animation1);
                  //  greattext.startAnimation(animation1);
                    greatbig.setVisibility(View.INVISIBLE);
                    great.setVisibility(View.INVISIBLE);
                    greattext.setVisibility(View.INVISIBLE);
                   // greatsmall.startAnimation(animation2);
                    greatsmall.setVisibility(View.VISIBLE);
                }
                if(f1){
                   // loveditbig.startAnimation(animation1);
                  //  lovedit.startAnimation(animation1);
                  //  lovedittext.startAnimation(animation1);
                    loveditbig.setVisibility(View.INVISIBLE);
                    lovedit.setVisibility(View.INVISIBLE);
                    lovedittext.setVisibility(View.INVISIBLE);
                   // loveditsmall.startAnimation(animation2);
                    loveditsmall.setVisibility(View.VISIBLE);
                }
                if(f3){
                  //  averagebig.startAnimation(animation1);
                  //  average.startAnimation(animation1);
                   // averagetext.startAnimation(animation1);
                    averagebig.setVisibility(View.INVISIBLE);
                    average.setVisibility(View.INVISIBLE);
                    averagetext.setVisibility(View.INVISIBLE);
                  //  averagesmall.startAnimation(animation2);
                    averagesmall.setVisibility(View.VISIBLE);
                }

                if(f5){
                  //  fuckbig.startAnimation(animation1);
                   // fuck.startAnimation(animation1);
                   // fucktext.startAnimation(animation1);
                    fuckbig.setVisibility(View.INVISIBLE);
                    fuck.setVisibility(View.INVISIBLE);
                    fucktext.setVisibility(View.INVISIBLE);
                   // fucksmall.startAnimation(animation2);
                    fucksmall.setVisibility(View.VISIBLE);
                }


                badbig.startAnimation(animation2);
                f4 = true;
                badsmall.setVisibility(View.INVISIBLE);
                rate.setVisibility(View.INVISIBLE);
                shop.setVisibility(View.INVISIBLE);
                badbig.setVisibility(View.VISIBLE);
                badtext.setText("We tried.. we really did.\nWhat went wrong?");
                badtext.startAnimation(animation2);
                badtext.setVisibility(View.VISIBLE);
                bad.startAnimation(animation2);
                bad.setVisibility(View.VISIBLE);
                feedback.setHint("Tell us how we messed up..... (Optional)");

                if(!flag)
                    expandView(layout,iht,fht);




            }
        });
        fucksmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                fucksmall.startAnimation(animation1);

                if(f2){
                //    greatbig.startAnimation(animation1);
                //    great.startAnimation(animation1);
                  //  greattext.startAnimation(animation1);
                    greatbig.setVisibility(View.INVISIBLE);
                    great.setVisibility(View.INVISIBLE);
                    greattext.setVisibility(View.INVISIBLE);
                 //   greatsmall.startAnimation(animation2);
                    greatsmall.setVisibility(View.VISIBLE);
                }
                if(f1){
                //    loveditbig.startAnimation(animation1);
                 //   lovedit.startAnimation(animation1);
                  //  lovedittext.startAnimation(animation1);
                    loveditbig.setVisibility(View.INVISIBLE);
                    lovedit.setVisibility(View.INVISIBLE);
                    lovedittext.setVisibility(View.INVISIBLE);
                   // loveditsmall.startAnimation(animation2);
                    loveditsmall.setVisibility(View.VISIBLE);
                }
                if(f3){
                 //   averagebig.startAnimation(animation1);
                 //   average.startAnimation(animation1);
                   // averagetext.startAnimation(animation1);
                    averagebig.setVisibility(View.INVISIBLE);
                    average.setVisibility(View.INVISIBLE);
                    averagetext.setVisibility(View.INVISIBLE);
                //    averagesmall.startAnimation(animation2);
                    averagesmall.setVisibility(View.VISIBLE);
                }
                if(f4){
                //    badbig.startAnimation(animation1);
                 //   bad.startAnimation(animation1);
                   // badtext.startAnimation(animation1);
                    badbig.setVisibility(View.INVISIBLE);
                    bad.setVisibility(View.INVISIBLE);
                    badtext.setVisibility(View.INVISIBLE);
                  //  badsmall.startAnimation(animation2);
                    badsmall.setVisibility(View.VISIBLE);
                }


                fuckbig.startAnimation(animation2);
                f5 = true;
                fucksmall.setVisibility(View.INVISIBLE);
                rate.setVisibility(View.INVISIBLE);
                shop.setVisibility(View.INVISIBLE);
                fuckbig.setVisibility(View.VISIBLE);
                fucktext.setText("We are awfully sorry.\nPlease tell us what went wrong.");
                fucktext.startAnimation(animation2);
                fucktext.setVisibility(View.VISIBLE);
                fuck.startAnimation(animation2);
                fuck.setVisibility(View.VISIBLE);
                feedback.setHint("Tell us how we screwed up..... (Optional)");

                if(!flag)
                    expandView(layout,iht,fht);




            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                greatbig.setVisibility(View.INVISIBLE);
                great.setVisibility(View.INVISIBLE);
                greattext.setVisibility(View.INVISIBLE);
                loveditbig.setVisibility(View.INVISIBLE);
                lovedit.setVisibility(View.INVISIBLE);
                lovedittext.setVisibility(View.INVISIBLE);
                averagebig.setVisibility(View.INVISIBLE);
                average.setVisibility(View.INVISIBLE);
                averagetext.setVisibility(View.INVISIBLE);
                badbig.setVisibility(View.INVISIBLE);
                bad.setVisibility(View.INVISIBLE);
                badtext.setVisibility(View.INVISIBLE);
                fuckbig.setVisibility(View.INVISIBLE);
                fuck.setVisibility(View.INVISIBLE);
                fucktext.setVisibility(View.INVISIBLE);

                rate.setVisibility(View.VISIBLE);
                shop.setVisibility(View.VISIBLE);
                loveditsmall.setVisibility(View.VISIBLE);
                greatsmall.setVisibility(View.VISIBLE);
                averagesmall.setVisibility(View.VISIBLE);
                badsmall.setVisibility(View.VISIBLE);
                fucksmall.setVisibility(View.VISIBLE);

                expandView(layout,fht,iht);
                flag = false;

            }
        });
    }

    public void expandView(final View v, int initialHt, int finalHt){

        flag = true;




        ValueAnimator slideAnimator = ValueAnimator.ofInt(initialHt,finalHt).setDuration(1000);
        slideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {


                // get the value the interpolator is at
                Integer value = (Integer) animation.getAnimatedValue();
                // I'm going to set the layout's height 1:1 to the tick
                v.getLayoutParams().height = value.intValue();
                // force all layouts to see which ones are affected by
                // this layouts height change
                v.requestLayout();

            }
        });

        AnimatorSet set = new AnimatorSet();
        set.play(slideAnimator);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();
    }

}
