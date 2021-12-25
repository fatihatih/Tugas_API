package com.example.tugas_api;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter {
    ArrayList<DataAlgoritma> dataAlgoritmas = new ArrayList();
    LayoutInflater layoutInflater;
    Context context;

    ImageView img;
    TextView name, web;

    public Adapter(Context context, ArrayList<DataAlgoritma> dataAlgoritmas) {
        super(context, R.layout.row_algoritma, dataAlgoritmas);
        this.dataAlgoritmas = dataAlgoritmas;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.row_algoritma, parent, false);
        DataAlgoritma data = dataAlgoritmas.get(position);

        img = convertView.findViewById(R.id.row_gambar_hewan);
        name = convertView.findViewById(R.id.row_text_name);

        Glide
            .with(context)
                .asGif()
            .load(data.getLinkGambar())
            .into(img);

        name.setText(data.getJudul());

        return convertView;
    }
}
