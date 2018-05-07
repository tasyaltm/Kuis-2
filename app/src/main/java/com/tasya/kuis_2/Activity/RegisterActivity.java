package com.tasya.kuis_2.Activity;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tasya.kuis_2.API.ApiClient;
import com.tasya.kuis_2.API.ApiData;
import com.tasya.kuis_2.API.ApiInterface;
import com.tasya.kuis_2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText et_email, et_pass;
    private String email, pass;
    private Button regbtn;
    private ApiData<Integer> account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        regbtn = findViewById(R.id.btn_reg);
        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regis();
            }
        });
    }

    private void regis(){
        email = et_email.getText().toString().trim();
        pass = et_pass.getText().toString().trim();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.progressbar, null);
        builder.setView(view);
        builder.setCancelable(false);
        final Dialog dialog = builder.create();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        dialog.show();

        final Context c = this;
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ApiData<Integer>> call = apiService.postAccount(email, pass);
        call.enqueue(new Callback<ApiData<Integer>>() {
            @Override
            public void onResponse(@NonNull Call<ApiData<Integer>> call, @NonNull Response<ApiData<Integer>> response) {
                account = response.body();
                dialog.dismiss();

                if (account != null) {
                    if (account.getStatus().equals("success")){
                        Toast.makeText(c, "Registered", Toast.LENGTH_LONG).show();
                        finish();
                        //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                    else{
                        Toast.makeText(c, "wrong Email or Password", Toast.LENGTH_LONG).show();
                        //dialog.dismiss();
                        return;
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ApiData<Integer>> call, @NonNull Throwable t) {
                dialog.dismiss();
                Log.e(TAG, "onFailure: ", t);
                Toast.makeText(c, "connection error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
