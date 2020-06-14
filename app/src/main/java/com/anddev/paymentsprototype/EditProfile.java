package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {


    TextView Name,Phone,Email;
    TextView verify_text;

    ImageView verified;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        verify_text = findViewById(R.id.verify_email);
        verified = findViewById(R.id.email_verified_iv);
        verify_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                verified.setVisibility(View.VISIBLE);
                verify_text.setVisibility(View.INVISIBLE);

            }
        });








        Name = findViewById(R.id.Name);
        Phone = findViewById(R.id.Phone);
        Email = findViewById(R.id.Email);

        Name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(EditProfile.this,ChangeName.class));


            }
        });
        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(EditProfile.this,ChangeNumber.class));



            }
        });
        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(EditProfile.this,ChangeEmail.class));



            }
        });








    }
}
