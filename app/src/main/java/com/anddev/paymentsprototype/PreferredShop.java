package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PreferredShop extends AppCompatActivity {

    RelativeLayout relativeLayout;

    RelativeLayout proceed;

    ListView listView;

    int mScreenHeight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferred_shop);


        proceed = findViewById(R.id.proceed_for_payment);


        ArrayList<ShopsInfo> arrayList = new ArrayList<>();
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Currently Accepting Orders","Yes","null","Closes at 6 PM","6 km"));
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Accepting Orders, \nPickup during open hours","Yes","null","Opens at 8 AM","6 km"));
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Not Accepting Orders","null","yes","Opens at 8AM","6 km"));
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Currently Accepting Orders","Yes","null","Closes at 6PM","6 km"));
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Currently Accepting Orders","Yes","null","Closes at 6 PM","6 km"));



        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;


       // String[] Array ={"","","","","","","",""};


        listView = findViewById(R.id.ShopsListView);

        ShopsAdapter adapter = new ShopsAdapter(getApplicationContext(),arrayList);
        listView.setAdapter(adapter);

       // ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.shop_row,Array);
        //listView.setAdapter(adapter);


        //time = getResources().getInteger(android.R.integer.config_longAnimTime);

        relativeLayout = findViewById(R.id.view6);
        if(relativeLayout.getHeight() == 0)
           expandView(relativeLayout,0,mScreenHeight/4 );

    }
    public void expandView(final View v, int initialHt, int finalHt){




        ValueAnimator slideAnimator = ValueAnimator.ofInt(initialHt,finalHt + 50).setDuration(1000);
        slideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // get the value the interpolator is at
                Integer value = (Integer) animation.getAnimatedValue();
                // I'm going to set the layout's height 1:1 to the tick
                v.getLayoutParams().height = value.intValue();
                // force all layouts to see which ones are affected by
                // this layouts height change
                v.requestLayout();

            }
        });

        AnimatorSet set = new AnimatorSet();
        set.play(slideAnimator);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.start();

    }

    public class ShopsAdapter extends BaseAdapter{

        private ArrayList<ShopsInfo> Data;

        public ShopsAdapter(Context context,ArrayList<ShopsInfo> data) {
            Data = data;
        }

        @Override
        public int getCount() {
            Log.d("size ", " " + Data.size());
            return Data.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.shop_row,null);
            final TextView ShopsName, location,status,closing_time;
            final RelativeLayout open,close,partially_closed;
            final RelativeLayout shop;
            ImageButton viewTimingPricing;





            shop=convertView.findViewById(R.id.shopone);
            if(position == 0)
            {
                Resources r = getResources();
                int top = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        30,
                        r.getDisplayMetrics());
                int bottom = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        10,
                        r.getDisplayMetrics());
                int horizontal = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        10,
                        r.getDisplayMetrics());
                int ht = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        135,
                        r.getDisplayMetrics());

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, ht);
                params.setMargins(horizontal,top,horizontal,bottom);
                shop.setLayoutParams(params);
            }


            ShopsName = convertView.findViewById(R.id.ShopsName1);
            location = convertView.findViewById(R.id.Location1);
            status = convertView.findViewById(R.id.Files1);
            open = convertView.findViewById(R.id.open1);
            close = convertView.findViewById(R.id.closed1);
            closing_time = convertView.findViewById(R.id.closing_time1);
            partially_closed = convertView.findViewById(R.id.partially_closed1);
            viewTimingPricing = convertView.findViewById(R.id.showtime1);

            ShopsName.setText(Data.get(position).getShpsName());
            closing_time.setText(Data.get(position).getClose_time());
            viewTimingPricing.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(PreferredShop.this,ShopTimingAndPricing.class));
                }
            });
            location.setText(Data.get(position).getLocation());
            if(Data.get(position).getStatus().equals("Not Accepting Orders"))
                status.setTextColor(getResources().getColor(R.color.red));
            if(Data.get(position).getStatus().equals("Accepting Orders, \nPickup during open hours"))
            { partially_closed.setVisibility(View.VISIBLE);
              open.setVisibility(View.INVISIBLE);}
            status.setText(Data.get(position).getStatus());
            if(Data.get(position).getOpen().equals("null"))
            { open.setVisibility(View.INVISIBLE);
                close.setVisibility(View.VISIBLE);}
            else
            {close.setVisibility(View.INVISIBLE);
                open.setVisibility(View.VISIBLE);
            }

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for(int i =0;i<Data.size();i++){
                        if(i!=position){
                            Drawable drawable = getDrawable(R.drawable.white_bg_layout);
                            shop.setBackground(drawable);
                        }
                    }

                    Drawable drawable = getDrawable(R.drawable.outline);
                    shop.setBackground(drawable);
                    proceed.setVisibility(View.VISIBLE);

                }
            });

            return convertView;
        }
    }

}
