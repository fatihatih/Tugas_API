package com.example.tugas_api;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailData extends AppCompatActivity {
    DataAlgoritma dataSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        Intent intent = getIntent();
        dataSelected = (DataAlgoritma) intent.getSerializableExtra("DATASELECTED");

        inisialisasi();
    }

    void inisialisasi() {
        TextView judul = findViewById(R.id.judul);
        TextView link = findViewById(R.id.linkList);
        TextView desc = findViewById(R.id.deskrip);
        ImageView img = findViewById(R.id.imageView);

        Glide
            .with(this)
                .asGif()
            .load(dataSelected.getLinkGambar())
            .into(img);
        judul.setText(dataSelected.getJudul());
        link.setText(dataSelected.getLinkweb());
        desc.setText(dataSelected.getDesc());
    }

    public void toLink(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(dataSelected.getLinkweb()));
        startActivity(intent);
    }
}
