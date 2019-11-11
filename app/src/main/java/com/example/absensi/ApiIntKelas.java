package com.example.absensi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiIntKelas {
    @GET("kelas/{idjur}")
    Call<Kelasnya>getKelas(@Path("idjur")int idjur);
}