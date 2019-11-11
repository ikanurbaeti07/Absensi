package com.example.absensi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiIntJurusan apiInterface;
    private List<Jurusan> jurusan;
    private SemuaJurusan jurusanya;
    LinearLayoutManager layoutManager;
    RecyclerView recyclerView;
    JurusanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager =new LinearLayoutManager(this);
        recyclerView = (RecyclerView)findViewById(R.id.jurusan);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterface=ApiClient.getApiClient().create(ApiIntJurusan.class);
        Call<SemuaJurusan> call=apiInterface.getjurusan();
        call.enqueue(new Callback<SemuaJurusan>() {
            @Override
            public void onResponse(Call<SemuaJurusan> call, Response<SemuaJurusan> response) {
                jurusanya=response.body();
                jurusan=jurusanya.getValues();
                adapter =new JurusanAdapter(jurusan,MainActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<SemuaJurusan> call, Throwable t) {

            }

        });


    }
}
