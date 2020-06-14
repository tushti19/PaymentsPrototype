package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.anddev.paymentsprototype.PageSetting.dpToPx;

public class LoginPage extends AppCompatActivity {

    Button Login, continueBtn;
    TextView mobileTv, ccTv,Terms,loginTV,validTv;
    ImageButton fb,google;
    EditText Phone;

    RelativeLayout signinRL;

    int top,left;

    ImageView phoneIv;
    TextView mtv;

    RelativeLayout rootLayout, phoneRL;

    RelativeLayout loginRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        rootLayout = findViewById(R.id.rootlayout);
        Login = findViewById(R.id.login_with_phoneBtn);
        mobileTv = findViewById(R.id.mobilenumTV);
        ccTv = findViewById(R.id.country_codeTV);
        Phone = findViewById(R.id.PhoneNumber);
        Terms = findViewById(R.id.TermsTV);
        loginTV = findViewById(R.id.loginText);


        continueBtn = findViewById(R.id.continueBtn);

        signinRL = findViewById(R.id.signinRL);


        fb = findViewById(R.id.facebookBtn);
        google = findViewById(R.id.googleBtn);

        phoneRL = findViewById(R.id.phoneRL);



        phoneIv = findViewById(R.id.phoneIV);
        mtv = findViewById(R.id.mobileTV);

        validTv = findViewById(R.id.valid_text);

        loginRL = findViewById(R.id.relativeLayoutLogin);


        rootLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int diff = rootLayout.getRootView().getHeight() - rootLayout.getHeight();
                if(diff > dpToPx(getApplicationContext(),200)){


                    Resources r = getResources();
                    int margin = (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP,
                            50,
                            r.getDisplayMetrics());



                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                     params.topMargin = margin;
                    loginRL.setLayoutParams(params);


                    Terms.setVisibility(View.INVISIBLE);
                    signinRL.setVisibility(View.INVISIBLE);
                }





                    if(diff < dpToPx(getApplicationContext(),200))
                    {

                        Resources r = getResources();
                        int margin = (int) TypedValue.applyDimension(
                                TypedValue.COMPLEX_UNIT_DIP,
                                60,
                                r.getDisplayMetrics());





                        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        params.topMargin = margin;
                        loginRL.setLayoutParams(params);




                        Terms.setVisibility(View.VISIBLE);
                        signinRL.setVisibility(View.VISIBLE);

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

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ccTv.setVisibility(View.VISIBLE);
                Phone.setVisibility(View.VISIBLE);
                mobileTv.setVisibility(View.VISIBLE);

                Animation animation1 = new AlphaAnimation(1.0f,0.0f);
                animation1.setDuration(500);


                phoneIv.startAnimation(animation1);
                mtv.startAnimation(animation1);


                Animation animation2 = new AlphaAnimation(0.1f,1.0f);
                animation2.setDuration(500);


                mobileTv.startAnimation(animation2);
                ccTv.startAnimation(animation2);
                Phone.startAnimation(animation2);




                Animation animation = new TranslateAnimation(0,-left,0,-top);
                animation.setDuration(500);
                animation.setFillEnabled(true);
                animation.setFillAfter(true);

                mobileTv.startAnimation(animation);

                Login.setVisibility(View.INVISIBLE);



            }
        });




        Phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                continueBtn.setVisibility(View.VISIBLE);

                signinRL.setVisibility(View.VISIBLE);







            }

            @Override
            public void afterTextChanged(Editable s) {


                continueBtn.setVisibility(View.VISIBLE);

                signinRL.setVisibility(View.VISIBLE);



            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Phone.length() >10 || Phone.length() < 10)
                    validTv.setVisibility(View.VISIBLE);
                if(Phone.length() == 10)
                {
                    validTv.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(LoginPage.this,OtpActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("Phone", Phone.getText().toString());

                    intent.putExtras(bundle);
                    startActivity(intent);

                }

            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginPage.this,MobileRegistration.class));
            }
        });

    }
}
