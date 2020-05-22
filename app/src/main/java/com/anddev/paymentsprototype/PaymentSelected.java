package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;
import ng.max.slideview.SlideView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

public class PaymentSelected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_selected);
        SlideView slideView = findViewById(R.id.slideView);
        slideView.setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                Toast.makeText(PaymentSelected.this, "Slide Complete", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
