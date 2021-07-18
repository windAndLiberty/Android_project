package com.example.wind_and_liberty.myapplication0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wind_and_liberty.myapplication0.test.Book;
import com.example.wind_and_liberty.myapplication0.test.buy_record;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BuyBookActivity extends AppCompatActivity {
    private EditText leibie;
    private EditText shuming;
    private EditText shuliang;
    private EditText chengben;
    private EditText jiage;

    private EditText chengben2;
    private EditText book_id2;
    private EditText book_count2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_book);
        leibie=(EditText)findViewById(R.id.buy_book_leibie);
        shuming=(EditText)findViewById(R.id.buy_book_shuming);
        shuliang=(EditText)findViewById(R.id.buy_book_shuliang);
        Button tijiao=(Button)findViewById(R.id.buy_book_tijiao);
        jiage=(EditText)findViewById(R.id.buy_book_jiage);
        chengben=(EditText)findViewById(R.id.buy_book_chengbenjia);
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shuming.getText().toString().isEmpty()){
                    Toast.makeText(BuyBookActivity.this,"书名不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (shuliang.getText().toString().isEmpty()){
                    Toast.makeText(BuyBookActivity.this,"数量不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (jiage.getText().toString().isEmpty()){
                    Toast.makeText(BuyBookActivity.this,"价格不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (chengben.getText().toString().isEmpty()){
                    Toast.makeText(BuyBookActivity.this,"成本价不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //update Book
                Book book=new Book();
                if(!leibie.getText().toString().isEmpty()) {
                    book.setCategory(leibie.getText().toString());
                }
                book.setCount(Integer.parseInt(shuliang.getText().toString()));
                book.setPrice(Double.parseDouble(jiage.getText().toString()));
                book.setName(shuming.getText().toString());
                book.save();

                //产生buy_record
                buy_record br=new buy_record();
                br.setBook_id(book.getId());
                br.setNum(book.getCount());
                br.setCost(br.getNum()*Double.parseDouble(chengben.getText().toString()));
                br.setTime((new SimpleDateFormat("yyyy-M-d H:mm:ss")).format(new Date()));
                br.save();
                Toast.makeText(BuyBookActivity.this,"新书更新完成",Toast.LENGTH_SHORT)
                        .show();
                //用logcat显示信息
                List<Book> book3= DataSupport.findAll(Book.class);
                for (Book book4:book3){
                    Log.d("BuyBook",""+book4.getId());
                    Log.d("BuyBook",book4.getName());
                    Log.d("BuyBook",book4.getCategory());
                    Log.d("BuyBook",""+book4.getCount());
                    Log.d("BuyBook",book4.getPrice()+"");
                    Log.d("BuyBook","-----------------");
                }
                List<buy_record> sr1= DataSupport.findAll(buy_record.class);
                for (buy_record sr2:sr1){
                    Log.d("BuyBook",""+sr2.getId());
                    Log.d("BuyBook",sr2.getTime());
                    Log.d("BuyBook",""+sr2.getBook_id());
                    Log.d("BuyBook",""+sr2.getNum());
                    Log.d("BuyBook",sr2.getCost()+"");
                    Log.d("BuyBook","-----------------");
                }

            }
        });

        book_id2=(EditText)findViewById(R.id.buy_book2_bianhao);
        book_count2=(EditText)findViewById(R.id.buy_book2_shuliang);
        chengben2=(EditText)findViewById(R.id.buy_book2_chengbenjia);
        Button tijiao2=(Button)findViewById(R.id.buy_book2_tijiao);
        tijiao2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (book_count2.getText().toString().isEmpty()){
                    Toast.makeText(BuyBookActivity.this,"数量不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (book_id2.getText().toString().isEmpty()){
                    Toast.makeText(BuyBookActivity.this,"编号不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (chengben2.getText().toString().isEmpty()){
                    Toast.makeText(BuyBookActivity.this,"成本价不可为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Book> book= DataSupport
                        .where("id = ?", book_id2.getText().toString())
                        .find(Book.class);
                if(book.isEmpty()){
                    Toast.makeText(BuyBookActivity.this,"编号不存在",Toast.LENGTH_SHORT)
                            .show();
                    return;
                }
                //update Book
                book.get(0).setCount(book.get(0).getCount()
                        +Integer.parseInt(book_count2.getText().toString()));
                book.get(0).update(book.get(0).getId());
                //产生buy_record
                buy_record br=new buy_record();
                br.setBook_id(book.get(0).getId());
                br.setNum(Integer.parseInt(book_count2.getText().toString()));
                br.setCost(br.getNum()
                        *Double.parseDouble(chengben2.getText().toString()));
                br.setTime((new SimpleDateFormat("yyyy-M-d H:mm:ss")).format(new Date()));
                br.save();
                Toast.makeText(BuyBookActivity.this,"更新成功",Toast.LENGTH_SHORT)
                        .show();
                //用logcat显示信息
                List<Book> book3= DataSupport.findAll(Book.class);
                for (Book book4:book3){
                    Log.d("BuyBook",""+book4.getId());
                    Log.d("BuyBook",book4.getName());
                    Log.d("BuyBook",book4.getCategory());
                    Log.d("BuyBook",""+book4.getCount());
                    Log.d("BuyBook",book4.getPrice()+"");
                    Log.d("BuyBook","-----------------");
                }
                List<buy_record> sr1= DataSupport.findAll(buy_record.class);
                for (buy_record sr2:sr1){
                    Log.d("BuyBook",""+sr2.getId());
                    Log.d("BuyBook",sr2.getTime());
                    Log.d("BuyBook",""+sr2.getBook_id());
                    Log.d("BuyBook",""+sr2.getNum());
                    Log.d("BuyBook",sr2.getCost()+"");
                    Log.d("BuyBook","-----------------");
                }
            }
        });

    }
}
