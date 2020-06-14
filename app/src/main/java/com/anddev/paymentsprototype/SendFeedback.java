package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SendFeedback extends AppCompatActivity {


    RelativeLayout[] ratings;
    TextView[] textViews;

    EditText feedbackText;

    Button sendFeedback;
    RelativeLayout rateUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);

        ratings = new RelativeLayout[10];
        ratings[0] = findViewById(R.id.rating1);
        ratings[1] = findViewById(R.id.rating2);
        ratings[2] = findViewById(R.id.rating3);
        ratings[3] = findViewById(R.id.rating4);
        ratings[4] = findViewById(R.id.rating5);
        ratings[5] = findViewById(R.id.rating6);
        ratings[6] = findViewById(R.id.rating7);
        ratings[7] = findViewById(R.id.rating8);
        ratings[8] = findViewById(R.id.rating9);
        ratings[9] = findViewById(R.id.rating10);

        textViews = new TextView[10];
        textViews[0] = findViewById(R.id.tv1);
        textViews[1] = findViewById(R.id.tv2);
        textViews[2] = findViewById(R.id.tv3);
        textViews[3] = findViewById(R.id.tv4);
        textViews[4] = findViewById(R.id.tv5);
        textViews[5] = findViewById(R.id.tv6);
        textViews[6] = findViewById(R.id.tv7);
        textViews[7] = findViewById(R.id.tv8);
        textViews[8] = findViewById(R.id.tv9);
        textViews[9] = findViewById(R.id.tv10);


        sendFeedback = findViewById(R.id.sendFeedback);
        rateUs = findViewById(R.id.rate_us_RL);

        feedbackText = findViewById(R.id.feedback_text);
        feedbackText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Drawable drawable = getResources().getDrawable(R.drawable.edit_layout);
                feedbackText.setBackground(drawable);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Drawable drawable = getResources().getDrawable(R.drawable.edit_layout_blue);
                feedbackText.setBackground(drawable);
                sendFeedback.setVisibility(View.VISIBLE);


            }

            @Override
            public void afterTextChanged(Editable s) {

                Drawable drawable = getResources().getDrawable(R.drawable.edit_layout_blue);
                feedbackText.setBackground(drawable);
                sendFeedback.setVisibility(View.VISIBLE);

            }
        });
















        ratings[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =0;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);

                }
            }
        });
        ratings[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =1;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);

                }
            }
        });
        ratings[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =2;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);

                }
            }
        });
        ratings[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =3;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);

                }
            }
        });
        ratings[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =4;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);

                }
            }
        });
        ratings[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =5;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);

                }
            }
        });
        ratings[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =6;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);
                    rateUs.setVisibility(View.VISIBLE);
                }
            }
        });
        ratings[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =7;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);
                    rateUs.setVisibility(View.VISIBLE);
                }
            }
        });
        ratings[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =8;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);
                    rateUs.setVisibility(View.VISIBLE);
                }
            }
        });
        ratings[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i =9;i>=0;i--){

                    int color = getResources().getColor(R.color.colorPrimary);
                    ratings[i].setBackgroundColor(color);
                    textViews[i].setTextColor(Color.WHITE);
                    rateUs.setVisibility(View.VISIBLE);
                }
            }
        });










    }


}
