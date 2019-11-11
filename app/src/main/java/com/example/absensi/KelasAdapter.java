package com.example.absensi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KelasAdapter extends RecyclerView.Adapter<KelasAdapter.KelasHolder> {
    List<Kelas>kelasnya;
    Activity activity;

    public KelasAdapter(List<Kelas>kelas,Activity activity){
        this.kelasnya=kelas;
        this.activity=activity;

    }


    @NonNull
    @Override
    public KelasHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_kelas,viewGroup,false);
        return new KelasHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull KelasHolder holder, int i) {
        holder.namakel.setText(kelasnya.get(i).getNamakel());
        holder.walikel.setText(kelasnya.get(i).getNamawali());
        holder.namajur.setText(kelasnya.get(i).getNamajur());
        holder.kaprog.setText(kelasnya.get(i).getKaprog());

    }

    @Override
    public int getItemCount() {
        return kelasnya.size();
    }

    static class KelasHolder extends RecyclerView.ViewHolder{
        TextView namakel,walikel,namajur,kaprog;

        public KelasHolder(@NonNull View itemView) {
            super(itemView);
            namakel=(TextView)itemView.findViewById(R.id.namakel);
            walikel=(TextView)itemView.findViewById(R.id.wali);
            namajur=(TextView)itemView.findViewById(R.id.jurusan);
            kaprog=(TextView)itemView.findViewById(R.id.kaprog);
        }
    }


}
