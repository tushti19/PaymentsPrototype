package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeNumber extends AppCompatActivity {

    EditText newPhone;
    Button saveChanges;
    View divider;
    TextView validtv;

    String Phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_number);

        newPhone = findViewById(R.id.new_Phone);
        saveChanges = findViewById(R.id.save_changes);
        divider = findViewById(R.id.bluediv1);
        validtv = findViewById(R.id.valid_text);


        newPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



               // saveChanges.setVisibility(View.VISIBLE);
                int color = Color.parseColor("#227093");
                divider.setBackgroundColor(color);

            }

            @Override
            public void afterTextChanged(Editable s) {



                saveChanges.setVisibility(View.VISIBLE);
                int color = Color.parseColor("#227093");
                divider.setBackgroundColor(color);

                Phone = newPhone.getText().toString();

            }
        });



        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(newPhone.length()<10 || newPhone.length()>10){

                    validtv.setVisibility(View.VISIBLE);

                }
                if(newPhone.length() == 10){

                    Intent intent = new Intent(ChangeNumber.this,OtpActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("Phone", Phone);

                    intent.putExtras(bundle);
                    startActivity(intent);
                    validtv.setVisibility(View.INVISIBLE);
                    Toast.makeText(ChangeNumber.this, "Number Changed", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }
}
