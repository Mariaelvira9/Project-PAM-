package ifp.mobile.libratrack;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class detailBuku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        Button likeButton = findViewById(R.id.likeButton);
        Button borrowButton = findViewById(R.id.borrowButton);

        // Listener untuk likeButton
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(detailBuku.this, "Buku telah disimpan", Toast.LENGTH_SHORT).show();
            }
        });


        // Listener untuk borrowButton
        borrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat AlertDialog konfirmasi Yes/No
                new AlertDialog.Builder(detailBuku.this)
                        .setTitle("Confirmation")
                        .setMessage("Apakah anda yakin ingin meminjam buku ini?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Aksi ketika tombol "Yes" ditekan
                                dialog.dismiss();
                                // Menampilkan toast ketika "Yes" ditekan
                                Toast.makeText(detailBuku.this, "Buku berhasil ditambahkan!!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Menutup dialog ketika "No" ditekan
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert) // Optional: Menambahkan icon alert
                        .show(); // Menampilkan AlertDialog
            }
        });
    }

}
