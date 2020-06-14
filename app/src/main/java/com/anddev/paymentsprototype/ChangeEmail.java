package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeEmail extends AppCompatActivity {

    EditText newEmail;
    TextView validText;
    View divider;
    Button saveChanges;

    String emailId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        newEmail = findViewById(R.id.new_Email);
        validText = findViewById(R.id.valid_text);
        divider = findViewById(R.id.bluediv1);
        saveChanges = findViewById(R.id.save_changes);

        emailId = newEmail.getText().toString();

        newEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int color = Color.parseColor("#227093");
                divider.setBackgroundColor(color);

                emailId = newEmail.getText().toString();


            }

            @Override
            public void afterTextChanged(Editable s) {

                saveChanges.setVisibility(View.VISIBLE);
                int color = Color.parseColor("#227093");
                divider.setBackgroundColor(color);

                emailId = newEmail.getText().toString();



            }
        });

        emailId = newEmail.getText().toString();

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmailValid(emailId))
                    validText.setVisibility(View.VISIBLE);
                else
                {validText.setVisibility(View.INVISIBLE);
                    Toast.makeText(ChangeEmail.this, "Email Changed", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
