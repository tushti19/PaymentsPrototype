package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;
import ng.max.slideview.SlideView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PaymentsActivity extends AppCompatActivity {

    RelativeLayout pickup,paytm,phonepay,gpay;
    RelativeLayout slidelayout;
;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        slidelayout = findViewById(R.id.slideviewlayout);

        SlideView slideView = findViewById(R.id.slideView);
        slideView.setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                Toast.makeText(PaymentsActivity.this, "Slide Complete", Toast.LENGTH_SHORT).show();
            }
        });



        pickup= findViewById(R.id.pickup);
        phonepay = findViewById(R.id.phonepay_upi);
        paytm = findViewById(R.id.paytm);
        gpay= findViewById(R.id.gpay);

        pickup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidelayout.setVisibility(View.VISIBLE);
                Drawable drawable = getResources().getDrawable(R.drawable.outline);
                pickup.setBackground(drawable);
                Drawable drawable1 = getResources().getDrawable(R.drawable.white_bg_layout);
                phonepay.setBackground(drawable1);
                paytm.setBackground(drawable1);
                gpay.setBackground(drawable1);



            }
        });
        phonepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidelayout.setVisibility(View.VISIBLE);
                Drawable drawable = getResources().getDrawable(R.drawable.outline);
                phonepay.setBackground(drawable);
                Drawable drawable1 = getResources().getDrawable(R.drawable.white_bg_layout);
                pickup.setBackground(drawable1);
                paytm.setBackground(drawable1);
                gpay.setBackground(drawable1);


            }
        });
        paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidelayout.setVisibility(View.VISIBLE);
                Drawable drawable = getResources().getDrawable(R.drawable.outline);
                paytm.setBackground(drawable);
                Drawable drawable1 = getResources().getDrawable(R.drawable.white_bg_layout);
                pickup.setBackground(drawable1);
                phonepay.setBackground(drawable1);
                gpay.setBackground(drawable1);


            }
        });

        gpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidelayout.setVisibility(View.VISIBLE);
                Drawable drawable = getResources().getDrawable(R.drawable.outline);
                gpay.setBackground(drawable);
                Drawable drawable1 = getResources().getDrawable(R.drawable.white_bg_layout);
                pickup.setBackground(drawable1);
                paytm.setBackground(drawable1);
                phonepay.setBackground(drawable1);


            }
        });

    }
}

