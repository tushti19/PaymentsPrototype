package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class LiveOrdersHomePage extends AppCompatActivity {

    ListView listView;
    CustomAdapterLO adapter;
    ImageButton add,addFiles,addPhotos;
    TextView addFilesText,addPhotosText;
    RelativeLayout upper;
    int i =1;

    BlurView blurView;

    int mScreenWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_orders_home_page);
        listView = findViewById(R.id.listview);
        upper = findViewById(R.id.upperLyout);

        blurView = findViewById(R.id.blurView);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenWidth = displaymetrics.widthPixels;


        add = findViewById(R.id.add_button);
        addFiles = findViewById(R.id.add_files);
        addPhotos = findViewById(R.id.add_photos);
        addFilesText = findViewById(R.id.add_files_text);
        addPhotosText = findViewById(R.id.add_photos_text);
        addPhotosText.animate().translationXBy(-1000f);
        addFilesText.animate().translationXBy(1000f);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
               // add.setRotation(45f);

                Resources r = getResources();
                int xaxistext = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        70,
                        r.getDisplayMetrics());
                int xxaxistext = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        125,
                        r.getDisplayMetrics());
                int yaxis = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        100,
                        r.getDisplayMetrics());
                int xaxis = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        90,
                        r.getDisplayMetrics());
                if(i%2==0){
                    add.setRotation(45f);
                    listView.setAlpha(0.1f);
                    addPhotosText.animate().translationXBy(1000f + mScreenWidth/6 - 10).setDuration(400);
               // addPhotosText.animate().translationXBy(1000f).translationXBy(xaxistext).setDuration(400);
               // addFilesText.setVisibility(View.VISIBLE);
                    addFiles.animate().translationXBy(mScreenWidth/4 - 20).translationYBy(-(float) yaxis).setDuration(400);
                    addFiles.setVisibility(View.VISIBLE);
                    addPhotos.animate().translationXBy(-(mScreenWidth/4)).translationYBy(-(float) yaxis).setDuration(400);
                    addPhotos.setVisibility(View.VISIBLE);
                    addFilesText.animate().translationXBy(-(1000f + mScreenWidth/5 + 10)).setDuration(400);
              //  addPhotosText.setVisibility(View.VISIBLE);
            } else
                {
                    add.setRotation(90f);
                    listView.setAlpha(1);

                    addFiles.animate().translationXBy(-(mScreenWidth/4 - 20)).translationYBy((float) yaxis).setDuration(400);
                    addPhotosText.animate().translationXBy(-(1000f + mScreenWidth/6 - 10)).setDuration(400);
                   // addFiles.setVisibility(View.INVISIBLE);
                  //  addPhotos.animate().translationXBy((float) (xaxis-15)).translationYBy(-(float) yaxis).setDuration(200);
                  //  addPhotos.setVisibility(View.INVISIBLE);
                    addPhotos.animate().translationXBy((mScreenWidth/4)).translationYBy((float) yaxis).setDuration(400);
                    addFilesText.animate().translationXBy(1000f + mScreenWidth/5 + 10).setDuration(400);
                   // addFilesText.setVisibility(View.INVISIBLE);
                   // addPhotosText.setVisibility(View.INVISIBLE);

                }



            }
        });

        ArrayList<liveOrdersInfo> arrayList = new ArrayList<>();
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));



        adapter = new CustomAdapterLO(arrayList);
        listView.setAdapter(adapter);

    }

    public class CustomAdapterLO extends BaseAdapter {

        private ArrayList<liveOrdersInfo> Data;


        public CustomAdapterLO(ArrayList<liveOrdersInfo> Data) {
            this.Data = Data;

        }

        @Override
        public int getCount() {
            return Data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {




            convertView = getLayoutInflater().inflate(R.layout.current_order_row_livorders,null);
            RelativeLayout relativeLayout;
            relativeLayout = convertView.findViewById(R.id.CurrentOrderRowRL);
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
                        8,
                        r.getDisplayMetrics());
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(horizontal,top,horizontal,bottom);
                relativeLayout.setLayoutParams(params);
            }





            return convertView;
        }
    }


    private  void  blurBackground(){

        float radius = 21f;

        View decorView = getWindow().getDecorView();
        //ViewGroup you want to start blur from. Choose root as close to BlurView in hierarchy as possible.
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        //Set drawable to draw in the beginning of each blurred frame (Optional).
        //Can be used in case your layout has a lot of transparent space and your content
        //gets kinda lost after after blur is applied.
        Drawable windowBackground = decorView.getBackground();

        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setHasFixedTransformationMatrix(true);

    }


}
