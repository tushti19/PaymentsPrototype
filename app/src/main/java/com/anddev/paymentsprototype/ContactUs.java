package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {

    RelativeLayout root, maps,contact,mail,mapPopup,contactPopup,mailPopup;




    RelativeLayout phone1,phone2;

    ImageView p1,p2;

    TextView Email;

    TextView phone_num1,phone_num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        root = findViewById(R.id.rootlayout);
        maps = findViewById(R.id.maps);
        contact = findViewById(R.id.contact);
        mail = findViewById(R.id.mail);
        mapPopup = findViewById(R.id.map_popup);
        contactPopup = findViewById(R.id.contact_popup);
        mailPopup = findViewById(R.id.mail_popup);


        phone1 = findViewById(R.id.phoneRL1);
        phone2 = findViewById(R.id.phoneRL2);

        p1 = findViewById(R.id.white_icon);
        p2 = findViewById(R.id.blue_icon);

        phone_num1 = findViewById(R.id.phone1_dial);
        phone_num2 = findViewById(R.id.phone2_dial);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.setAlpha(0.3f);
                mapPopup.setVisibility(View.VISIBLE);

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.setAlpha(0.3f);
                contactPopup.setVisibility(View.VISIBLE);

            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.setAlpha(0.3f);
                mailPopup.setVisibility(View.VISIBLE);

            }
        });


        phone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = getResources().getDrawable(R.drawable.phone_bg);
                phone1.setBackground(drawable);

                Drawable drawable1 = getResources().getDrawable(R.drawable.phone_white_bg);
                phone2.setBackground(drawable1);

                int colorGrey = Color.parseColor("#757575");

                p1.setImageResource(R.drawable.phonewhite);
                p2.setImageResource(R.drawable.phoneblue);
                phone_num1.setTextColor(Color.WHITE);
                phone_num2.setTextColor(colorGrey);
            }
        });
        phone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = getResources().getDrawable(R.drawable.phone_bg);
                phone2.setBackground(drawable);

                Drawable drawable1 = getResources().getDrawable(R.drawable.phone_white_bg);
                phone1.setBackground(drawable1);

                int colorGrey = Color.parseColor("#757575");

                p2.setImageResource(R.drawable.phonewhite);
                p1.setImageResource(R.drawable.phoneblue);
                phone_num2.setTextColor(Color.WHITE);
                phone_num1.setTextColor(colorGrey);
            }
        });


        Email = findViewById(R.id.email_id_sleefax);



        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Mail Id", "incsleefax@gmail.com");
                clipboard.setPrimaryClip(clip);

                Toast.makeText(ContactUs.this, "Mail Id copied to Clipboard", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
