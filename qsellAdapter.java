package com.example.wind_and_liberty.myapplication0;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wind_and_liberty.myapplication0.test.buy_record;
import com.example.wind_and_liberty.myapplication0.test.sell_record;

import java.util.List;

/**
 * Created by wind_and_liberty on 19-12-9.
 */

public class qsellAdapter extends RecyclerView.Adapter <qsellAdapter.ViewHolder>{
    private List<sell_record> sell_records;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView sid;
        TextView stime;
        TextView sbook_id;
        TextView snum;
        TextView ssalesValue;
        public ViewHolder(View itemView) {
            super(itemView);
            sid=(TextView) itemView.findViewById(R.id.qsell_id);
            stime=(TextView) itemView.findViewById(R.id.qsell_time);
            sbook_id=(TextView) itemView.findViewById(R.id.qsell_book_id);
            snum=(TextView) itemView.findViewById(R.id.qsell_num);
            ssalesValue=(TextView) itemView.findViewById(R.id.qsell_salesValue);
        }
    }
    public qsellAdapter(List<sell_record> sell_records1){
        sell_records=sell_records1;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.querysell_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(qsellAdapter.ViewHolder holder, int position) {
        sell_record record=sell_records.get(position);
        holder.sid.setText(String.valueOf(record.getId()));
        holder.stime.setText(record.getTime());
        holder.sbook_id.setText(String.valueOf(record.getBook_id()));
        holder.snum.setText(String.valueOf(record.getNum()));
        holder.ssalesValue.setText(String.valueOf(record.getSalesValue()));
    }

    @Override
    public int getItemCount() {
        return sell_records.size();
    }
}
