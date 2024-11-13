package ifp.mobile.projek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookmarkFragment extends Fragment {

    private RecyclerView rvListBuku;
    private List<LikedBooks> data;
    private Adapter Adapter;

    public BookmarkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_bookmark, container, false);
        this.rvListBuku = v.findViewById(R.id.rvListBuku);


        List<LikedBooks> data = new ArrayList<>();
        data.add(new LikedBooks("Hujan", "Tere Liye", "2016"));
        data.add(new LikedBooks("Harry Potter", "JK. Rowling", "1997"));
        data.add(new LikedBooks("Hunger Games", "Suzanne Collins", "2008"));
        data.add(new LikedBooks("Matahari", "Tere Liye", "2016"));
        data.add(new LikedBooks("Bumi", "Tere Liye", "2014"));

        this.data = data;
        this.Adapter = new Adapter(requireContext(), this.data);
        this.rvListBuku.setAdapter(this.Adapter);
        this.rvListBuku.setLayoutManager(new LinearLayoutManager(requireContext()));

        return v;
    }
}