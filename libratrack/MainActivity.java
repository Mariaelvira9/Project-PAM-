package ifp.mobile.libratrack;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bookItem = findViewById(R.id.bookItem1);
        View markahNav = findViewById(R.id.markahNav);

        bookItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewbuku) {
                Intent intent = new Intent(MainActivity.this, detailBuku.class);
                startActivity(intent);
            }
        });

        markahNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, bukuTersimpan2.class);
                startActivity(intent);
            }
        });
    }
}


