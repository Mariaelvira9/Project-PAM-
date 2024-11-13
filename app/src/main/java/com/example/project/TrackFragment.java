package com.example.project;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class TrackFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tracking, container, false);

        Button returnButton = view.findViewById(R.id.status_button);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(requireActivity())
                        .setTitle("Konfirmasi Pengembalian")
                        .setMessage("Apakah anda yakin ingin mengembalikan buku ini?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Toast.makeText(requireActivity(), "Buku berhasil dikembalikan!", Toast.LENGTH_SHORT).show();

                                TrackCompletedFragment trackCompletedFragment = new TrackCompletedFragment();
                                requireActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.fragContainer, trackCompletedFragment)
                                        .addToBackStack(null)
                                        .commit();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });

        return view;
    }
}
