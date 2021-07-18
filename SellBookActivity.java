package com.example.wind_and_liberty.myapplication0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.wind_and_liberty.myapplication0.test.Book;
import com.example.wind_and_liberty.myapplication0.test.sell_record;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SellBookActivity extends AppCompatActivity {
    private EditText bianhao;
    private ProgressBar pb;
    private EditText shuliang;
    private TextView shuming;
    private TextView tijiaoxinxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_book);
        bianhao=(EditText)findViewById(R.id.sell_book_bianhao);
        shuming=(TextView) findViewById(R.id.sell_book_shuming);
        shuliang=(EditText)findViewById(R.id.sell_book_shuliang);
        Button tijiao=(Button)findViewById(R.id.sell_book_tijiao);
        tijiaoxinxi=(TextView) findViewById(R.id.sell_book_tijiaoxinxi);
        pb=(ProgressBar)findViewById(R.id.sell_book_pb);
        tijiao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(tijiaoxinxi.getVisibility()==View.VISIBLE){
                    pb.setVisibility(View.INVISIBLE);
                }
                if(pb.getVisibility()==View.VISIBLE){
                       pb.setVisibility(View.INVISIBLE);
                }
                if (bianhao.getText().toString().isEmpty()){
                    Toast.makeText(SellBookActivity.this,"编号不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Book> book= DataSupport.select("name","price","count")
                        .where("id = ?", bianhao.getText().toString())
                        .find(Book.class);
                if(book.isEmpty()){
                    shuming.setText("不存在此编号的书籍");
                    return;
                }
                shuming.setText(book.get(0).getName());


                if(book.size()>1){
                    Toast.makeText(SellBookActivity.this,"出现同名书籍，程序错误",Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                if (shuliang.getText().toString().isEmpty()){
                    Toast.makeText(SellBookActivity.this,"数量不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //卖的数量不可大于库存的数量
                if (Integer.parseInt(shuliang.getText().toString())>book.get(0).getCount()){
                    Toast.makeText(SellBookActivity.this,"库存不足",Toast.LENGTH_SHORT).show();
                    return;
                }
                //合法的输入

                //产生sell_record
                sell_record sr=new sell_record();
                sr.setBook_id(book.get(0).getId());
                sr.setNum(Integer.parseInt(shuliang.getText().toString()));
                sr.setSalesValue(book.get(0).getPrice()*sr.getNum());
                sr.setTime((new SimpleDateFormat("yyyy-M-d H:mm:ss")).format(new Date()));
                sr.save();
                //更新Book表
                Book book2=new Book();
                book2.setCount(book.get(0).getCount()
                        -Integer.parseInt(shuliang.getText().toString()));
                //正好卖完,在Book表中删除这个元组
                if (book2.getCount()==0){
                    DataSupport.delete(Book.class,Integer.parseInt(bianhao.getText().toString()));
                }
                else{
                    book2.update(Integer.parseInt(bianhao.getText().toString()));
                }
                //用logcat显示信息
                List<Book> book3= DataSupport.findAll(Book.class);
                for (Book book4:book3){
                    Log.d("SellBook",""+book4.getId());
                    Log.d("SellBook",book4.getName());
                    Log.d("SellBook",book4.getCategory());
                    Log.d("SellBook",""+book4.getCount());
                    Log.d("SellBook",book4.getPrice()+"");
                    Log.d("SellBook","-----------------");
                }
                List<sell_record> sr1= DataSupport.findAll(sell_record.class);
                for (sell_record sr2:sr1){
                    Log.d("SellBook",""+sr2.getId());
                    Log.d("SellBook",sr2.getTime());
                    Log.d("SellBook",""+sr2.getBook_id());
                    Log.d("SellBook",""+sr2.getNum());
                    Log.d("SellBook",sr2.getSalesValue()+"");
                    Log.d("SellBook","-----------------");
                }
                tijiaoxinxi.setVisibility(View.VISIBLE);
                if(pb.getVisibility()==View.INVISIBLE){
                    pb.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
