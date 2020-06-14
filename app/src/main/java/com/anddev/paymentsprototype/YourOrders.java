package com.anddev.paymentsprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class YourOrders extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_orders);

        ArrayList<liveOrdersInfo> arrayList = new ArrayList<>();
        arrayList.add(new liveOrdersInfo("","","","","","","","","","yes"));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));
        arrayList.add(new liveOrdersInfo("","","","","","","","","",""));

        CustomYourOrderAdapter adapter = new CustomYourOrderAdapter(arrayList);

        listView = findViewById(R.id.listview);

        listView.setAdapter(adapter);
    }

    private class CustomYourOrderAdapter extends BaseAdapter{


        ArrayList<liveOrdersInfo> Data ;

        public CustomYourOrderAdapter(ArrayList<liveOrdersInfo> data) {
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

            RelativeLayout relativeLayout;
           convertView = getLayoutInflater().inflate(R.layout.your_orders_row,null);

           relativeLayout = convertView.findViewById(R.id.order_rated);

           if(Data.get(position).getRated().equals("yes"))
               relativeLayout.setVisibility(View.VISIBLE);

           return convertView;






        }
    }
}
