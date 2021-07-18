package com.example.wind_and_liberty.myapplication0;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wind_and_liberty.myapplication0.test.Book;

import java.util.List;

/**
 * Created by wind_and_liberty on 19-12-9.
 */

public class qbAdapter extends RecyclerView.Adapter <qbAdapter.ViewHolder>{
    private List<Book> bookList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bid;
        TextView bname;
        TextView bprice;
        TextView bcategory;
        TextView bcount;
        public ViewHolder(View itemView) {
            super(itemView);
            bid=(TextView) itemView.findViewById(R.id.qb_id);
            bname=(TextView) itemView.findViewById(R.id.qb_name);
            bprice=(TextView) itemView.findViewById(R.id.qb_price);
            bcategory=(TextView) itemView.findViewById(R.id.qb_category);
            bcount=(TextView) itemView.findViewById(R.id.qb_count);
        }
    }
    public qbAdapter(List<Book> bookList1){
        bookList=bookList1;
    }
    @Override
    public qbAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.querybook_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(qbAdapter.ViewHolder holder, int position) {
        Book book=bookList.get(position);
        holder.bid.setText(String.valueOf(book.getId()));
        holder.bname.setText(book.getName());
        holder.bprice.setText(String.valueOf(book.getPrice()));
        holder.bcategory.setText(book.getCategory());
        holder.bcount.setText(String.valueOf(book.getCount()));
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
