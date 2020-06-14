package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowFullDetails extends AppCompatActivity {

    ListView billingView;
    ListView orderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_full_details);





        ArrayList<pdfInfo> arrayList = new ArrayList<>();
        arrayList.add(new pdfInfo("Book.pdf","23","25 mb"));
        arrayList.add(new pdfInfo("Science.pdf","23","30 mb"));
        arrayList.add(new pdfInfo("BookExe.docx","21","2 mb"));

        billingViewAdapter billingViewAdapter = new billingViewAdapter(arrayList);



        billingView = findViewById(R.id.billing_pdf_listview);
        billingView.setAdapter(billingViewAdapter);
        setDynamicHeight(billingView);

        orderView = findViewById(R.id.OrdersLV);
        ArrayList<OrderInfo> arrayList1 = new ArrayList<>();
        arrayList1.add(new OrderInfo("Book.pdf","","","","",""));
        arrayList1.add(new OrderInfo("Science.pdf","","","","",""));
        arrayList1.add(new OrderInfo("BookExe.docx","","","","",""));

        OrderViewAdapter orderViewAdapter = new OrderViewAdapter(arrayList1);
        orderView.setAdapter(orderViewAdapter);
        setDynamicHeight(orderView);


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

    private class OrderViewAdapter extends BaseAdapter {

        ArrayList<OrderInfo> Data;

        public OrderViewAdapter(ArrayList<OrderInfo> data) {
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

            convertView =  getLayoutInflater().inflate(R.layout.order_info,null);
            TextView Name;
            Name = convertView.findViewById(R.id.pdfName);


            Name.setText(Data.get(position).getName());



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
