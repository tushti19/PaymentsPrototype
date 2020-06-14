package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ReportAnIssue extends AppCompatActivity {


    RelativeLayout crashes,exp;
    TextView issue_tv;

    EditText issue_text;

    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_an_issue);

        crashes = findViewById(R.id.crashes);
        exp = findViewById(R.id.exp);
        issue_tv = findViewById(R.id.issue_tv);

        submitBtn = findViewById(R.id.submit_btn);

        issue_text = findViewById(R.id.issue_text);
        issue_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                Drawable drawable = getResources().getDrawable(R.drawable.edit_layout);
                issue_text.setBackground(drawable);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Drawable drawable = getResources().getDrawable(R.drawable.edit_layout_blue);
                issue_text.setBackground(drawable);

                submitBtn.setVisibility(View.VISIBLE);

            }

            @Override
            public void afterTextChanged(Editable s) {

                Drawable drawable = getResources().getDrawable(R.drawable.edit_layout_blue);
                issue_text.setBackground(drawable);


                submitBtn.setVisibility(View.VISIBLE);

            }
        });

        crashes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Drawable drawable = getResources().getDrawable(R.drawable.toggle_bg_report_an_issue);

                crashes.setBackground(drawable);
                Resources r = getResources();
                int elevation = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        10,
                        r.getDisplayMetrics());
                crashes.setElevation(elevation);
                issue_tv.setText("We really tried our best to humanize this. \n We hate that it broke down like a robot.");

                exp.setBackground(null);
            }
        });

        exp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Drawable drawable = getResources().getDrawable(R.drawable.toggle_bg_report_an_issue);

                exp.setBackground(drawable);
                Resources r = getResources();
                int elevation = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        10,
                        r.getDisplayMetrics());
                exp.setElevation(elevation);
                issue_tv.setText("Aw, Snap! This wasn't part of the plan.\n But working on your feedback is gonna be.");

              crashes.setBackground(null);


            }
        });


    }
}
