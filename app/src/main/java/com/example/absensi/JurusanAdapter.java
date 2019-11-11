package com.example.absensi;

import android.app.Activity;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JurusanAdapter extends RecyclerView.Adapter<JurusanAdapter.JurusanHolder> {
    List<Jurusan>jurusan;
    Activity activity;
    public JurusanAdapter(List<Jurusan>jurusan,Activity activity){
        this.jurusan=jurusan;
        this.activity=activity;

    }
    @NonNull
    @Override
    public JurusanHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item,viewGroup,false);
        return new JurusanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JurusanHolder holder,final int i) {
        holder.namajur.setText(jurusan.get(i).getNamajur());
        holder.kaprog.setText(jurusan.get(i).getKaprog());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idjur = jurusan.get(i).getId();
                Intent intent = new Intent(activity,KelasActivity.class);
                intent.putExtra("idnya",idjur);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return jurusan.size();
    }

    static class JurusanHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView namajur;
        TextView kaprog;
        public JurusanHolder (@NonNull View itemView) {
            super(itemView);
            namajur=(TextView)itemView.findViewById(R.id.namajur);
            kaprog=(TextView)itemView.findViewById(R.id.kaprog);

        }
    }
}
