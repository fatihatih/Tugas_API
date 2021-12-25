package com.example.tugas_api;

import java.io.Serializable;

public class DataAlgoritma implements Serializable {
    String judul, linkGambar, desc, linkweb;

    public DataAlgoritma(String judul, String linkGambar, String desc, String linkweb) {
        this.judul = judul;
        this.linkGambar = linkGambar;
        this.desc = desc;
        this.linkweb = linkweb;
    }

    public String getJudul() {
        return judul;
    }

    public String getLinkGambar() {
        return linkGambar;
    }

    public String getDesc() {
        return desc;
    }

    public String getLinkweb() {
        return linkweb;
    }
}
