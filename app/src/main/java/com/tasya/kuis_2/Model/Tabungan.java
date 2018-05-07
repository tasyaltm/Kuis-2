package com.tasya.kuis_2.Model;

/**
 * Created by Tasya on 5/7/2018.
 */

public class Tabungan {
    private int user_id, koin;
    private String nama_user;

    public Tabungan(){
    }

    public Tabungan(int user_id, String nama_user, int koin){
        this.user_id = user_id;
        this.nama_user = nama_user;
        this.koin = koin;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getKoin() {
        return koin;
    }

    public void setKoin(int koin) {
        this.koin = koin;
    }

    public String getNama_user() {
        return nama_user;
    }

    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }
}
