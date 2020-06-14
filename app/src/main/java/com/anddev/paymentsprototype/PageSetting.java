package com.anddev.paymentsprototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class PageSetting extends AppCompatActivity {

    RelativeLayout bw,color;
    RelativeLayout relativeLayout;
    ImageView bw_selected,color_selected;
    CheckBox apply_to_all;
    RelativeLayout done, next;
    Spinner dropdown,pageSizeSpinner;

    RelativeLayout layout;
    int mScreenHeight;

    RelativeLayout rl1,rl2,rl3,rl4,rl5,rl6;

    ScrollView scrollView;

    EditText pdfcopies;

    RelativeLayout rootLayout;

    TextView apply;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("hii","hi");
        return super.onKeyDown(keyCode, event);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_setting);
        relativeLayout = findViewById(R.id.bottom);


        apply = findViewById(R.id.applytv);

        rootLayout = findViewById(R.id.rootlayout);
        rootLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int diff = rootLayout.getRootView().getHeight() - rootLayout.getHeight();
                if(diff > dpToPx(getApplicationContext(),200)){
                      relativeLayout.setVisibility(View.INVISIBLE);
                }
                else
                    relativeLayout.setVisibility(View.VISIBLE);
            }
        });

        scrollView = findViewById(R.id.scrollViewPdfs);
        pdfcopies = findViewById(R.id.PDF_copies);
        pdfcopies.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
              /*  if(hasFocus)
                    relativeLayout.setVisibility(View.INVISIBLE);
                else
                    relativeLayout.setVisibility(View.VISIBLE);*/

            }
        });


        relativeLayout.setVisibility(View.VISIBLE);

        rl1 = findViewById(R.id.color);
        rl2 = findViewById(R.id.copies);
        rl3 = findViewById(R.id.pagesize);
        rl4 = findViewById(R.id.orientation);
        rl5 = findViewById(R.id.sides);
        rl6 = findViewById(R.id.custompages);

        Log.d("View 1","visibility " + isViewVisible(rl1));
        Log.d("View 2","visibility " + isViewVisible(rl2));
        Log.d("View 3","visibility " + isViewVisible(rl3));
        Log.d("View 4","visibility " + isViewVisible(rl4));
        Log.d("View 5","visibility " + isViewVisible(rl5));
        Log.d("View 6","visibility " + isViewVisible(rl6));

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        mScreenHeight = displaymetrics.heightPixels;

        layout = findViewById(R.id.pdfsettingsRL2);
        if(layout.getHeight() == 0)
            expandView(layout,0,mScreenHeight/3);



        pageSizeSpinner = findViewById(R.id.sizeSpinner);

        String[] itemsSize = new String[]{"A2","A3","A4"};

        ArrayAdapter<String> adapterSize = new ArrayAdapter<>(this, R.layout.spinner_text, itemsSize);

        adapterSize.setDropDownViewResource(R.layout.spinner_text);

        pageSizeSpinner.setAdapter(adapterSize);

        pageSizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                       // Toast.makeText(PageSetting.this, "A2 selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                       // Toast.makeText(PageSetting.this, "A3 selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                       // Toast.makeText(PageSetting.this, "A4 selected", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        dropdown = findViewById(R.id.orientationSpinner);

        String[] items = new String[]{"Potrait","Landscape"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_text, items);

        adapter.setDropDownViewResource(R.layout.spinner_text);

        dropdown.setAdapter(adapter);

       dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               switch (position){
                   case 0:
                       //Toast.makeText(PageSetting.this, "Potrait selected", Toast.LENGTH_SHORT).show();
                       break;
                   case 1:
                       //Toast.makeText(PageSetting.this, "Landscape selected", Toast.LENGTH_SHORT).show();
                       break;
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        done = findViewById(R.id.pdfDone);
        next = findViewById(R.id.next);



        apply_to_all = findViewById(R.id.apply_to_all);

        apply_to_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

               if(apply_to_all.isChecked())
               {next.setVisibility(View.INVISIBLE);
                apply.setText("Settings are applied for all documents");
                done.setVisibility(View.VISIBLE);}
               else
               {
                   apply.setText("Apply these settings for all documents");
                   done.setVisibility(View.INVISIBLE);
                   next.setVisibility(View.VISIBLE);
               }

            }
        });

        bw = findViewById(R.id.Pdf_Black_White);
        color = findViewById(R.id.Pdf_Colors);

        bw_selected = findViewById(R.id.bw_selected);
        color_selected = findViewById(R.id.color_selected);


        bw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bw_selected.setVisibility(View.VISIBLE);
                color_selected.setVisibility(View.INVISIBLE);
            }
        });

        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color_selected.setVisibility(View.VISIBLE);
                bw_selected.setVisibility(View.INVISIBLE);
            }
        });


    }

    public void expandView(final View v, int initialHt, int finalHt){




        ValueAnimator slideAnimator = ValueAnimator.ofInt(initialHt,finalHt + 20).setDuration(1000);
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

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("hii","hi");
        if(newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES)
            Toast.makeText(this, "Keyboard Invisible", Toast.LENGTH_SHORT).show();
        if (newConfig.keyboardHidden == Configuration.KEYBOARDHIDDEN_YES)
            Toast.makeText(this, "Keyboard Invisible", Toast.LENGTH_SHORT).show();
        Log.d("Height" ,"dp " + newConfig.screenHeightDp);
    }

    private boolean isViewVisible(View view) {
        Rect scrollBounds = new Rect();
        scrollView.getDrawingRect(scrollBounds);

        float top = view.getY();
        float bottom = top + view.getHeight();

        if (scrollBounds.top < top && scrollBounds.bottom > bottom) {
            Log.d("ISVIEWVIS","true");
            return true;
        } else {
            Log.d("ISVIEWVIS","false");

            return false;
        }

    }

    public static float dpToPx(Context context, float valueInDp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, metrics);
    }


}
