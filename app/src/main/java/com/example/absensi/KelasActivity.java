package com.example.absensi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KelasActivity extends AppCompatActivity {
   public static String KEY_ACTIVITY;
   RecyclerView rvKelas;
   List<Kelas>kelass;
   RecyclerView.LayoutManager layoutManager;
   KelasAdapter adapter;
   ApiIntKelas apiIntKelas;
   Kelasnya kelasnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelas);
        rvKelas=(RecyclerView)findViewById(R.id.rv_kelas);
        layoutManager = new LinearLayoutManager(this);
        rvKelas.setLayoutManager(layoutManager);
        Intent intent = getIntent();
        int i=intent.getIntExtra("idnya",2);
        apiIntKelas=ApiClient.getApiClient().create(ApiIntKelas.class);
        Call<Kelasnya>call=apiIntKelas.getKelas(i);
        call.enqueue(new Callback<Kelasnya>() {
            @Override
            public void onResponse(Call<Kelasnya> call, Response<Kelasnya> response) {
                kelasnya=response.body();
                kelass=kelasnya.getValues();
                adapter=new KelasAdapter(kelass,KelasActivity.this);
                rvKelas.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<Kelasnya> call, Throwable t) {

            }
        });

    }
}
