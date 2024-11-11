package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Integer> bookCovers;
    private Books booksItems;
    private Context context;
    private OnItemClickListener listener;

    public BookAdapter(List<Integer> bookCovers, Books bookData, Context context) {
        this.bookCovers = bookCovers;
        this.booksItems = bookData;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        int imageResId = bookCovers.get(position);
        List<BooksItem> items = booksItems.getBooks();
        BooksItem item = items.get(position);
        holder.textBook.setText(item.getTitle());
        holder.textAuthor.setText(item.getAuthor());
//        holder.deadline.setText(item.getReturnDate());
//        holder.date.setText(item.getBorrowDate());
        Glide.with(context).load(imageResId).into(holder.bookCover);
    }

    @Override
    public int getItemCount() {
        return bookCovers.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView bookCover;
        TextView textAuthor, textBook, deadline, date;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            bookCover = itemView.findViewById(R.id.bookCover);
            textBook = itemView.findViewById(R.id.textBook);
            textAuthor = itemView.findViewById(R.id.textAuthor);
            deadline = itemView.findViewById(R.id.deadline);
            date = itemView.findViewById(R.id.date);

            itemView.setOnClickListener(v -> {
                if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
