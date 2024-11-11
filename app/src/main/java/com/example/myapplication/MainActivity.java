package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns

        List<Integer> bookCovers = new ArrayList<>();
        // Add your book cover resource IDs here
        bookCovers.add(R.drawable.cover1);
        bookCovers.add(R.drawable.cover2);
        bookCovers.add(R.drawable.cover3);
        bookCovers.add(R.drawable.cover4);
        bookCovers.add(R.drawable.cover5);
        bookCovers.add(R.drawable.cover6);
        bookCovers.add(R.drawable.cover7);
        bookCovers.add(R.drawable.cover8);
        bookCovers.add(R.drawable.cover9);
        bookCovers.add(R.drawable.cover10);
        // Add more book covers...

        findData(this, bookCovers);
    }

    private void findData(Context context, List<Integer> bookCovers) {
        Call<Books> client = ApiConfig.getApiService().getBook(); // Pastikan untuk memanggil List<BooksItem>
        client.enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, retrofit2.Response<Books> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new BookAdapter(bookCovers, response.body(), context);
                    recyclerView.setAdapter(adapter);

                    adapter.setOnItemClickListener(position -> {
                        Intent intent = new Intent(MainActivity.this, Pinjam.class);
                        startActivity(intent);
                    });
                } else {
                    Log.e("MainActivity", "Response unsuccessful or empty");
                }
            }

            @Override
            public void onFailure(@NotNull Call<Books> call, @NotNull Throwable t) {
                Log.e("MainActivity", "Request failed: " + t.getMessage());
            }
        });
    }
}