package com.example.wind_and_liberty.myapplication0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wind_and_liberty.myapplication0.test.buy_record;

import org.litepal.crud.DataSupport;

import java.util.List;

public class QueryBuyActivity extends AppCompatActivity {
    private List<buy_record>buy_recordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_buy);

        buy_recordList= DataSupport.findAll(buy_record.class);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.query_buy_recycleview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        qbuyAdapter adapter=new qbuyAdapter(buy_recordList);
        recyclerView.setAdapter(adapter);
    }
}
