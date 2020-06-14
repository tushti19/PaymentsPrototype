package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.anddev.paymentsprototype.PageSetting.dpToPx;

public class OtpActivity extends AppCompatActivity {

    EditText d1,d2,d3,d4,d5,d6;

    TextView valid, Phone;
    Button confirm;

    RelativeLayout rootLayout, otpLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);


        otpLayout = findViewById(R.id.OTP_RL);
        rootLayout = findViewById(R.id.rootlayout);
        rootLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int diff = rootLayout.getRootView().getHeight() - rootLayout.getHeight();
                if(diff > dpToPx(getApplicationContext(),200)){

                    Resources r = getResources();
                    int margin = (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP,
                            80,
                            r.getDisplayMetrics());



                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                   // params.topMargin = margin;
                    params.addRule(RelativeLayout.CENTER_IN_PARENT);
                    otpLayout.setLayoutParams(params);
                }

                if(diff < dpToPx(getApplicationContext(),200)){

                    Resources r = getResources();
                    int margin = (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP,
                            150,
                            r.getDisplayMetrics());



                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                     params.topMargin = margin;
                    params.addRule(RelativeLayout.CENTER_HORIZONTAL);
                    otpLayout.setLayoutParams(params);
                }


            }
        });


        Bundle bundle = getIntent().getExtras();
        String phone = bundle.getString("Phone");

        Phone = findViewById(R.id.Phone);
        Phone.setText("(+91)"+phone);

        Log.d("Phone","(+91)"+phone);

        d1 = findViewById(R.id.digit1);
        d2 = findViewById(R.id.digit2);
        d3 = findViewById(R.id.digit3);
        d4 = findViewById(R.id.digit4);
        d5 = findViewById(R.id.digit5);
        d6 = findViewById(R.id.digit6);

        valid = findViewById(R.id.textview_valid);
        confirm = findViewById(R.id.confirm);

        d1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                confirm.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {


                confirm.setVisibility(View.VISIBLE);

                if(d1.length() == 1)
                    d2.requestFocus();

            }
        });
        d2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                confirm.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {


                confirm.setVisibility(View.VISIBLE);

                if(d2.length() == 1)
                    d3.requestFocus();

            }
        });
        d3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                confirm.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {


                confirm.setVisibility(View.VISIBLE);

                if(d3.length() == 1)
                    d4.requestFocus();

            }
        });
        d4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                confirm.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {



                confirm.setVisibility(View.VISIBLE);

                if(d4.length() == 1)
                    d5.requestFocus();

            }
        });
        d5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                confirm.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {

                confirm.setVisibility(View.VISIBLE);

                if(d5.length() == 1)
                    d6.requestFocus();

            }
        });
        d6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



                confirm.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {


                confirm.setVisibility(View.VISIBLE);


            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d1.length() + d2.length() + d3.length() + d4.length() + d5.length() + d6.length() <6)
                    valid.setVisibility(View.VISIBLE);
                if(d1.length() + d2.length() + d3.length() + d4.length() + d5.length() + d6.length()  == 6)
                {valid.setVisibility(View.GONE);
                    Toast.makeText(OtpActivity.this, "Phone Number Verified", Toast.LENGTH_SHORT).show();
                }
            }
        });








    }
}
