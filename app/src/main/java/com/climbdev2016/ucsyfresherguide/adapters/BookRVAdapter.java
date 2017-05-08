package com.climbdev2016.ucsyfresherguide.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.model.Book;

import java.util.List;


/**
 * Created by Myo Lwin Oo on 11/24/2016.
 */

public class BookRVAdapter extends RecyclerView.Adapter<BookRVAdapter.MyViewHolder> {

    private List<Book> dataList;

    public BookRVAdapter(List<Book> dataList) {
        this.dataList = dataList;
    }

    @Override
    public BookRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookRVAdapter.MyViewHolder holder, int position) {
        Book book = dataList.get(position);
        holder.bookName.setText(book.getBookName());
        holder.price.setText(book.getPrice());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bookName, price;
        public MyViewHolder(View itemView) {
            super(itemView);
            bookName = (TextView) itemView.findViewById(R.id.book_name);
            price = (TextView) itemView.findViewById(R.id.book_price);
        }
    }
}
