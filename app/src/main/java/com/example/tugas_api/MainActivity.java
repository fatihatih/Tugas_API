package com.example.tugas_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    ArrayList<DataAlgoritma> dataAlgoritmas = new ArrayList();
    protected final String URLAPI = "https://ewinsutriandi.github.io/mockapi/algoritma_pengurutan.json";
    JSONObject dataALgoritma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataAPI();
    }

    void setupListView() {
        ListView listView = findViewById(R.id.listview_daftar_hewan);
        Adapter adapter = new Adapter(this, dataAlgoritmas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(onItemClick);
    }

    private AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            DataAlgoritma dataSelected = dataAlgoritmas.get(position);

            Intent intent = new Intent(MainActivity.this, DetailData.class);
            intent.putExtra("DATASELECTED", dataSelected);
            startActivity(intent);
        }
    };

    void getDataAPI() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, URLAPI, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dataALgoritma = response;
                        refreshView();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("erorr", error.toString());
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    void refreshView() {
        Iterator<String> key = dataALgoritma.keys();
        while(key.hasNext()) {
            String nameAlgoritma = key.next();
            try {
                JSONObject data = dataALgoritma.getJSONObject(nameAlgoritma);
                String desc = data.getString("deskripsi");
                String linkGambar = data.getString("gambar");
                String web = data.getString("baca_lebih_lanjut");

                dataAlgoritmas.add(new DataAlgoritma(nameAlgoritma, linkGambar, desc, web));
            }catch (JSONException e) {
                e.printStackTrace();
            }
        }
        setupListView();
    }


}