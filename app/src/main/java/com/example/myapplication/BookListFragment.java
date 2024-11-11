package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

public class BookListFragment extends Fragment {

    private RecyclerView recyclerView;
    private BookAdapter adapter;

    public BookListFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        List<Integer> bookCovers = new ArrayList<>();
        // Tambahkan resource ID cover buku di sini
        bookCovers.add(R.drawable.cover1);
        bookCovers.add(R.drawable.cover2);
        bookCovers.add(R.drawable.cover3);
        // Tambah lagi sesuai kebutuhan

        findData(getContext(), bookCovers);

        return view;
    }

    private void findData(Context context, List<Integer> bookCovers) {
        Call<Books> client = ApiConfig.getApiService().getBook();
        client.enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, retrofit2.Response<Books> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new BookAdapter(bookCovers, response.body(), context);
                    recyclerView.setAdapter(adapter);

                    adapter.setOnItemClickListener(position -> {
                        Intent intent = new Intent(getActivity(), Pinjam.class);
                        startActivity(intent);
                    });
                } else {
                    Log.e("BookListFragment", "Response unsuccessful or empty");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Books> call, @NonNull Throwable t) {
                Log.e("BookListFragment", "Request failed: " + t.getMessage());
            }
        });
    }
}