package com.example.wind_and_liberty.myapplication0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.wind_and_liberty.myapplication0.test.Book;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create DataBase
        LitePal.getDatabase();
        //添加测试数据
        Book book1=new Book();
        book1.setName("the da vinci code");
        book1.setCount(10);
        book1.setPrice(35);
        book1.save();
        //
        Button sellbook=(Button)findViewById(R.id.sell_book);
        sellbook.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,SellBookActivity.class));
            }
        });
        Button buybook=(Button)findViewById(R.id.buy_book);
        buybook.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,BuyBookActivity.class));
            }
        });
        Button querysell=(Button)findViewById(R.id.query_sell);
        querysell.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,QuerySellActivity.class));
            }
        });
        Button querybook=(Button)findViewById(R.id.query_book);
        querybook.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,QueryBookActivity.class));
            }
        });
        Button querybuy=(Button)findViewById(R.id.query_buy);
        querybuy.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,QueryBuyActivity.class));
            }
        });

    }
}
