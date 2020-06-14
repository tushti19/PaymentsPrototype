package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.anddev.paymentsprototype.PageSetting.dpToPx;

public class MobileRegistration extends AppCompatActivity {

    RelativeLayout rootlayout;
    RelativeLayout phoneRL;
    Button btn;
    EditText Phone;
    TextView ccTV;
    TextView mobileTV;
    RelativeLayout layoutRegister;
    ImageView phoneIV;
    int top,left;
    TextView mtV;

    TextView validTv;

    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_registration);

        rootlayout= findViewById(R.id.rootlayout);
        mobileTV = findViewById(R.id.mobilenumTV);
        ccTV = findViewById(R.id.country_codeTV);
        Phone = findViewById(R.id.PhoneNumber);
        phoneRL = findViewById(R.id.phoneRL);
        btn = findViewById(R.id.login_with_phoneBtn);
        layoutRegister = findViewById(R.id.relativeLayoutRegister);
        phoneIV = findViewById(R.id.phoneIV);
        mtV = findViewById(R.id.mobileTV);
        next = findViewById(R.id.next_button);
        validTv = findViewById(R.id.valid_text);

        rootlayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int diff = rootlayout.getRootView().getHeight() - rootlayout.getHeight();
                if(diff > dpToPx(getApplicationContext(),200)){


                    Resources r = getResources();
                    int margin = (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP,
                            90,
                            r.getDisplayMetrics());



                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.topMargin = margin;
                    layoutRegister.setLayoutParams(params);

                }





                if(diff < dpToPx(getApplicationContext(),200))
                {

                    Resources r = getResources();
                    int margin = (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP,
                            140,
                            r.getDisplayMetrics());



                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    params.topMargin = margin;
                    layoutRegister.setLayoutParams(params);



                }




            }
        });


        Resources r = getResources();
        top = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                25,
                r.getDisplayMetrics());
        left = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                120,
                r.getDisplayMetrics());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ccTV.setVisibility(View.VISIBLE);
                Phone.setVisibility(View.VISIBLE);
                mobileTV.setVisibility(View.VISIBLE);

                Animation animation1 = new AlphaAnimation(1.0f,0.0f);
                animation1.setDuration(500);


                phoneIV.startAnimation(animation1);
                mtV.startAnimation(animation1);


                Animation animation2 = new AlphaAnimation(0.1f,1.0f);
                animation2.setDuration(500);


                mobileTV.startAnimation(animation2);
                ccTV.startAnimation(animation2);
                Phone.startAnimation(animation2);




                Animation animation = new TranslateAnimation(0,-left,0,-top);
                animation.setDuration(500);
                animation.setFillEnabled(true);
                animation.setFillAfter(true);

                mobileTV.startAnimation(animation);

                btn.setVisibility(View.INVISIBLE);



            }
        });

        Phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                next.setVisibility(View.VISIBLE);









            }

            @Override
            public void afterTextChanged(Editable s) {


                next.setVisibility(View.VISIBLE);




            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Phone.length() >10 || Phone.length() < 10)
                    validTv.setVisibility(View.VISIBLE);
                if(Phone.length() == 10)
                {
                    Toast.makeText(MobileRegistration.this, "Number Registered", Toast.LENGTH_SHORT).show();

                }

            }
        });










    }
}
