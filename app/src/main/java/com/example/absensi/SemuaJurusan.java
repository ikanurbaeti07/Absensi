package com.example.absensi;

import java.util.List;

public class SemuaJurusan {
    private int satatusnya;
    private List<Jurusan>values;

    public int getStatusnya() {
        return satatusnya;
    }

    public void setStatusnya(int statusnya) {
        this.satatusnya = statusnya;
    }

    public List<Jurusan> getValues() {
        return values;
    }

    public void setValues(List<Jurusan> values) {
        this.values = values;
    }
}
