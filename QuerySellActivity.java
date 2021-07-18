package com.example.wind_and_liberty.myapplication0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wind_and_liberty.myapplication0.test.sell_record;

import org.litepal.crud.DataSupport;

import java.util.List;

public class QuerySellActivity extends AppCompatActivity {
    private List<sell_record> sell_records;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_sell);
        sell_records= DataSupport.findAll(sell_record.class);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.query_sell_recycleview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        qsellAdapter adapter=new qsellAdapter(sell_records);
        recyclerView.setAdapter(adapter);
    }
}
