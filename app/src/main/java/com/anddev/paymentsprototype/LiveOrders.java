package com.anddev.paymentsprototype;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class LiveOrders extends AppCompatActivity {

    ListView listView;
    CustomAdapter adapter;

    ImageView loveditsmall,greatsmall,averagesmall,badsmall,fucksmall;
    ImageView loveditbig,greatbig,averagebig,badbig,fuckbig;
    TextView lovedittext,greattext,averagetext,badtext,fucktext;
    TextView lovedit,great,average,bad,fuck;
    RelativeLayout layout;
    TextView rate,shop;
    int fht,iht;

    boolean f1 = false;
    boolean f2 = false;
    boolean f3 = false;
    boolean f4 = false;
    boolean f5 = false;
    ImageView cancel;

    EditText feedback;

    int mScreenHeight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_orders);



        ArrayList<liveOrdersInfo> arrayList = new ArrayList<>();
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));

        listView = findViewById(R.id.listview);
        adapter = new CustomAdapter(arrayList);
        listView.setAdapter(adapter);

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

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;


       if(layout.getHeight() == 0){
        ValueAnimator slideAnimator = ValueAnimator.ofInt(0,mScreenHeight/4+55).setDuration(1300);
        slideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {


                // get the value the interpolator is at
                Integer value = (Integer) animation.getAnimatedValue();
                // I'm going to set the layout's height 1:1 to the tick
                layout.getLayoutParams().height = value.intValue();
                // force all layouts to see which ones are affected by
                // this layouts height change
                layout.requestLayout();

            }
        });

        AnimatorSet set = new AnimatorSet();
        set.play(slideAnimator);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();}




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

                if(layout.getHeight()<fht){
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

                if(layout.getHeight()<fht)
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

                if(layout.getHeight()<fht)
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

                if(layout.getHeight()<fht)
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

                if(layout.getHeight()<fht)
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

                Log.d("Ht" , " " + layout.getHeight());


                ValueAnimator slideAnimator = ValueAnimator.ofInt(layout.getHeight(),0).setDuration(500);
                slideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {


                        // get the value the interpolator is at
                        Integer value = (Integer) animation.getAnimatedValue();
                        // I'm going to set the layout's height 1:1 to the tick
                        layout.getLayoutParams().height = value.intValue();
                        // force all layouts to see which ones are affected by
                        // this layouts height change
                        layout.requestLayout();

                    }
                });

                AnimatorSet set = new AnimatorSet();
                set.play(slideAnimator);
                set.setInterpolator(new AccelerateDecelerateInterpolator());
                set.start();


            }
        });

        feedback.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Drawable drawable = getResources().getDrawable(R.drawable.edit_layout_blue);
                feedback.setBackground(drawable);

            }

            @Override
            public void afterTextChanged(Editable s) {

                Drawable drawable = getResources().getDrawable(R.drawable.edit_layout_blue);
                feedback.setBackground(drawable);

            }
        });





    }

    public void expandView(final View v, int initialHt, int finalHt){




        ValueAnimator slideAnimator = ValueAnimator.ofInt(initialHt,finalHt).setDuration(500);
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


     public class CustomAdapter extends BaseAdapter{

        private ArrayList<liveOrdersInfo> Data;


         public CustomAdapter(ArrayList<liveOrdersInfo> Data) {
             this.Data = Data;

         }

         @Override
         public int getCount() {
             return Data.size();
         }

         @Override
         public Object getItem(int position) {
             return null;
         }

         @Override
         public long getItemId(int position) {
             return 0;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {




             convertView = getLayoutInflater().inflate(R.layout.current_order_row_livorders,null);
             RelativeLayout relativeLayout;
             relativeLayout = convertView.findViewById(R.id.CurrentOrderRowRL);
             if(position == 0)
             {
                 Resources r = getResources();
                 int top = (int) TypedValue.applyDimension(
                         TypedValue.COMPLEX_UNIT_DIP,
                         30,
                         r.getDisplayMetrics());
                 int bottom = (int) TypedValue.applyDimension(
                         TypedValue.COMPLEX_UNIT_DIP,
                         10,
                         r.getDisplayMetrics());
                 int horizontal = (int) TypedValue.applyDimension(
                         TypedValue.COMPLEX_UNIT_DIP,
                         8,
                         r.getDisplayMetrics());
                  RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                  params.setMargins(horizontal,top,horizontal,bottom);
                  relativeLayout.setLayoutParams(params);
             }

             DisplayMetrics displaymetrics = new DisplayMetrics();
             getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
             mScreenHeight = displaymetrics.heightPixels;






             return convertView;
         }
     }

}
