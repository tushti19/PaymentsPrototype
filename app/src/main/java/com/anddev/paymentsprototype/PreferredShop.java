package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

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
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Currently Accepting Orders","Yes","null","","6 km"));
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Accepting Orders, \nPickup during open hours","Yes","null","","6 km"));
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Not Accepting Orders","null","yes","","6 km"));
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Currently Accepting Orders","Yes","null","","6 km"));
        arrayList.add(new ShopsInfo("MIT Print Shop","Kothrud, Pune","Currently Accepting Orders","Yes","null","","6 km"));



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
            final TextView ShopsName, location,status;
            final RelativeLayout open,close;
            final RelativeLayout shop;



            shop=convertView.findViewById(R.id.shopone);

            ShopsName = convertView.findViewById(R.id.ShopsName1);
            location = convertView.findViewById(R.id.Location1);
            status = convertView.findViewById(R.id.Files1);
            open = convertView.findViewById(R.id.open1);
            close = convertView.findViewById(R.id.closed1);

            ShopsName.setText(Data.get(position).getShpsName());
            Log.d("Name ", Data.get(position).getShpsName());
            location.setText(Data.get(position).getLocation());
            if(Data.get(position).getStatus().equals("Not Accepting Orders"))
                status.setTextColor(getResources().getColor(R.color.red));
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

                    Drawable drawable = getDrawable(R.drawable.outline);
                    shop.setBackground(drawable);
                    proceed.setVisibility(View.VISIBLE);

                }
            });

            return convertView;
        }
    }

}
