package com.example.wind_and_liberty.myapplication0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wind_and_liberty.myapplication0.test.Book;

import org.litepal.crud.DataSupport;

import java.util.List;

public class QueryBookActivity extends AppCompatActivity {
    private List<Book>bookList1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_book);
        //初始化数据
        bookList1= DataSupport.findAll(Book.class);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.query_book_recycleview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        qbAdapter adapter=new qbAdapter(bookList1);
        recyclerView.setAdapter(adapter);
    }
}
