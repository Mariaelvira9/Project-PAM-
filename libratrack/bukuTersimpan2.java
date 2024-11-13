package ifp.mobile.libratrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class bukuTersimpan2 extends AppCompatActivity {

    private RecyclerView rvListBuku;
    private Adapter Adapter;
    private List<ListBukuDisukai> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buku_tersimpan2);

        this.rvListBuku = this.findViewById(R.id.rvListBuku);

        List<ListBukuDisukai> data = new ArrayList<>();
        data.add(new ListBukuDisukai("Hujan", "Tere Liye", "2016"));
        data.add(new ListBukuDisukai("Harry Potter", "JK. Rowling", "1997"));
        data.add(new ListBukuDisukai("Hunger Games", "Suzanne Collins", "2008"));
        data.add(new ListBukuDisukai("Matahari", "Tere Liye", "2016"));
        data.add(new ListBukuDisukai("Bumi", "Tere Liye", "2014"));

        this.data = data;

        this.Adapter = new Adapter(this, data);
        this.rvListBuku.setAdapter(this.Adapter);
        this.rvListBuku.setLayoutManager(new LinearLayoutManager(this)
        );
    }
}