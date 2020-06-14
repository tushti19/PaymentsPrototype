package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewYourOrder extends AppCompatActivity {

    ListView pdfView,billingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_your_order);

        ArrayList<pdfInfo> arrayList = new ArrayList<>();
        arrayList.add(new pdfInfo("Book.pdf","23","25 mb"));
        arrayList.add(new pdfInfo("Science.pdf","23","30 mb"));
        arrayList.add(new pdfInfo("BookExe.docx","21","2 mb"));

        pdfViewAdapter pdfViewAdapter = new pdfViewAdapter(arrayList);
        billingViewAdapter billingViewAdapter = new billingViewAdapter(arrayList);

        pdfView = findViewById(R.id.pdfListView);
        pdfView.setAdapter(pdfViewAdapter);
        setDynamicHeight(pdfView);

        billingView = findViewById(R.id.billing_pdf_listview);
        billingView.setAdapter(billingViewAdapter);
        setDynamicHeight(billingView);
    }

    public class pdfViewAdapter extends BaseAdapter{

        ArrayList<pdfInfo> Data;

        public pdfViewAdapter(ArrayList<pdfInfo> data) {
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
            convertView = getLayoutInflater().inflate(R.layout.pdf_row,null);

            TextView Name,Size,Price,customize;
            Name = convertView.findViewById(R.id.pdfName);
            Size = convertView.findViewById(R.id.size);
            Price = convertView.findViewById(R.id.price);
            customize = convertView.findViewById(R.id.text_customize);

            Name.setText(Data.get(position).getName());
            Price.setText(Data.get(position).getPrice());

            customize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(ReviewYourOrder.this,PageSetting.class));
                }
            });

            Name.setText(Data.get(position).getName());
            Size.setText(Data.get(position).getSize());
            Price.setText(Data.get(position).getPrice());


            return convertView;
        }
    }

    public class billingViewAdapter extends BaseAdapter{

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

            convertView =  getLayoutInflater().inflate(R.layout.book_and_price,null);
            TextView Name,Price;
            Name = convertView.findViewById(R.id.pdfName);
            Price = convertView.findViewById(R.id.price);

            Name.setText(Data.get(position).getName());
            Price.setText(Data.get(position).getPrice());





            return convertView;
        }
    }
    public void setDynamicHeight(ListView listView) {
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
