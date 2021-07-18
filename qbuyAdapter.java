package com.example.wind_and_liberty.myapplication0;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wind_and_liberty.myapplication0.test.buy_record;

import java.util.List;

/**
 * Created by wind_and_liberty on 19-12-9.
 */

public class qbuyAdapter extends RecyclerView.Adapter <qbuyAdapter.ViewHolder>{
    private List<buy_record> buy_records;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView bid;
        TextView btime;
        TextView bbook_name;
        TextView bnum;
        TextView bcost;
        public ViewHolder(View itemView) {
            super(itemView);
            bid=(TextView) itemView.findViewById(R.id.qbuy_id);
            btime=(TextView) itemView.findViewById(R.id.qbuy_time);
            bbook_name=(TextView) itemView.findViewById(R.id.qbuy_book_name);
            bnum=(TextView) itemView.findViewById(R.id.qbuy_num);
            bcost=(TextView) itemView.findViewById(R.id.qbuy_cost);
        }
    }
    public qbuyAdapter(List<buy_record> buy_records1){
        buy_records=buy_records1;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.querybuy_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(qbuyAdapter.ViewHolder holder, int position) {
        buy_record buyRecord=buy_records.get(position);
        holder.bid.setText(String.valueOf(buyRecord.getId()));
        holder.btime.setText(buyRecord.getTime());
        holder.bbook_name.setText(String.valueOf(buyRecord.getBook_id()));
        holder.bnum.setText(String.valueOf(buyRecord.getNum()));
        holder.bcost.setText(String.valueOf(buyRecord.getCost()));
    }

    @Override
    public int getItemCount() {
        return buy_records.size();
    }
}
