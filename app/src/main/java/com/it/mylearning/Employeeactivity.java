package com.it.mylearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.api.RetrofitClient;
import com.modellcass.ResponseItem;
import com.utils.MyUtils;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Employeeactivity extends AppCompatActivity {

    TextView name, email, empid, phone, webiste, comapny_name, siutname, streetname, cityname, zipcode;
    int id;
    String string_siutname, String_streetname;
    Toolbar employee_toolbar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employeeactivity);

        employee_toolbar = findViewById( R.id. employeedetila_toolbar);
        setSupportActionBar(employee_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Employee Detail");


        Intent intent = getIntent();

        id = intent.getIntExtra("id", 0);
        Log.e("tag", "the touch id " + id);


        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        empid = findViewById(R.id.id);
        phone = findViewById(R.id.phone);
        webiste = findViewById(R.id.website);
        comapny_name = findViewById(R.id.companname);
        siutname = findViewById(R.id.siutname);
        streetname = findViewById(R.id.streetname);
        cityname = findViewById(R.id.cityname);
        zipcode = findViewById(R.id.zipcode);

        if (MyUtils.isNetworkAvailable(Employeeactivity.this)) {
            dofetch();
        } else {
            Toast.makeText(getApplicationContext(), "pLease check your connection", Toast.LENGTH_LONG).show();
        }


        dofetch();
    }

    private void dofetch() {

        Call<ResponseItem> call = RetrofitClient.getInstance().getapi().getid(id);
        call.enqueue(new Callback<ResponseItem>() {
            @Override
            public void onResponse(Call<ResponseItem> call, Response<ResponseItem> response) {
                try {

                    name.setText("Name " + " : " + response.body().getName());
                    email.setText(" Eamil" + ": " + response.body().getEmail().toLowerCase( Locale.ROOT ));
                    webiste.setText("website" + " : " + response.body().getWebsite());
                    String id = String.valueOf(response.body().getId());
                    empid.setText("Employee id:" + id);
                    comapny_name.setText("comapny name" + "  -  " + response.body().getCompany().getName());
                    String sphone = response.body().getPhone();
                    phone.setText("phonen no  " + " - " + sphone);
                    siutname.setText(response.body().getAddress().getSuite() );
                    streetname.setText(response.body().getAddress().getStreet());
                    cityname.setText(response.body().getAddress().getCity());
                    zipcode.setText(response.body().getAddress().getZipcode());



                } catch (Exception e) {
                    Log.e("TAG", "THE ERROR IS " + e.toString());
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseItem> call, Throwable t) {
                Log.e("the tag of-----", "Failure__" + t.toString());

            }
        });
    }
}