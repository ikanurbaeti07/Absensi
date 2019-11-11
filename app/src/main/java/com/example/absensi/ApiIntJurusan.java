package com.example.absensi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiIntJurusan {
    @GET("jurusan")
    Call<SemuaJurusan> getjurusan();
}
