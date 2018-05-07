package com.tasya.kuis_2.API;

/**
 * Created by Tasya on 5/7/2018.
 */

public class ApiData<T> {
    private String status;
    private T data;

    public ApiData(){

    }

    public ApiData(String status, T data){
        this.status = status;
        this.data = data;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public T getData(){return data;}

    public void setData(T data){this.data = data;}
}

