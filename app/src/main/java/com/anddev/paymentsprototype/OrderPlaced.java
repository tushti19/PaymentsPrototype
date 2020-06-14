package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class OrderPlaced extends AppCompatActivity {

    ImageView borderThick,borderThin;
    ListView billingView;
    TextView showDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);

        showDetails = findViewById(R.id.OrderDetailsBtn);
        showDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderPlaced.this,ShowFullDetails.class));
            }
        });



        billingView = findViewById(R.id.billing_pdf_listview);

        borderThick = findViewById(R.id.Stat1View_bgThick);
        borderThin = findViewById(R.id.Stat1View_bgThin);



        ArrayList<pdfInfo> arrayList = new ArrayList<>();
        arrayList.add(new pdfInfo("Book.pdf","23","25 mb"));
        arrayList.add(new pdfInfo("Science.pdf","23","30 mb"));
        arrayList.add(new pdfInfo("BookExe.docx","21","2 mb"));

        billingViewAdapter billingViewAdapter = new billingViewAdapter(arrayList);



        billingView = findViewById(R.id.billing_pdf_listview);
        billingView.setAdapter(billingViewAdapter);
        setDynamicHeight(billingView);




       /* ValueAnimator animator = ValueAnimator.ofFloat(0.0f,1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(1000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {







            }
        });

        animator.start();*/

        AlphaAnimation alphaAnimation1 = new AlphaAnimation(0.0f,1.0f);
        alphaAnimation1.setRepeatCount(Animation.INFINITE);
        alphaAnimation1.setDuration(1000);
        borderThick.startAnimation(alphaAnimation1);





        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f,0.0f);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setDuration(1000);
        borderThin.setVisibility(View.VISIBLE);
        borderThin.startAnimation(alphaAnimation);







        ScaleAnimation scaleAnimation = new ScaleAnimation( 0.8f, 1.0f, 0.8f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setDuration(500);
        //placedGrey.startAnimation(scaleAnimation);
       // placedBlue.startAnimation(scaleAnimation);
       // placedBlueSmall.startAnimation(scaleAnimation);
      //  placedGreySmall.startAnimation(scaleAnimation);








    }

    private class billingViewAdapter extends BaseAdapter {

        ArrayList<pdfInfo> Data;

        public billingViewAdapter(ArrayList<pdfInfo> data) {
            Data = data;
        }

        @Override
        public int getCount() {
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
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView =  getLayoutInflater().inflate(R.layout.book_size_price,null);
            TextView Name,Price;
            Name = convertView.findViewById(R.id.pdfName);
            Price = convertView.findViewById(R.id.price);

            Name.setText(Data.get(position).getName());
            Price.setText(Data.get(position).getPrice());


            return convertView;
        }
    }
    private void setDynamicHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        //check adapter if null
        if (adapter == null) {
            return;
        }
        int height = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            height += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = height + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

}
