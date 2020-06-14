package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeName extends AppCompatActivity {


    EditText newName;
    View divider;
    Button saveChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);

        newName = findViewById(R.id.new_Name);
        divider = findViewById(R.id.bluediv1);
        saveChanges = findViewById(R.id.save_changes);

        newName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                saveChanges.setVisibility(View.VISIBLE);
                int color = Color.parseColor("#227093");
                divider.setBackgroundColor(color);

            }

            @Override
            public void afterTextChanged(Editable s) {

                saveChanges.setVisibility(View.VISIBLE);
                int color = Color.parseColor("#227093");
                divider.setBackgroundColor(color);

            }
        });

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChangeName.this, "Name Changed", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
