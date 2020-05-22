package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Setting extends AppCompatActivity {

    ImageView togglenight,togglenot;
    int i=0,j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        togglenight = findViewById(R.id.togglenight);
        togglenot = findViewById(R.id.togglenot);
        togglenight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if(i%2!=0)
                    togglenight.setImageResource(R.drawable.multimedia);
                else
                    togglenight.setImageResource(R.drawable.off);
            }
        });
        togglenot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j++;
                if(j%2!=0)
                    togglenot.setImageResource(R.drawable.multimedia);
                else
                    togglenot.setImageResource(R.drawable.off);
            }
        });
    }
}
