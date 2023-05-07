package com.it.mylearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.adapter.EmployeeAdpater;
import com.api.RetrofitClient;
import com.modellcass.ResponseItem;
import com.utils.MyUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ResponseItem>responseItemArrayList;
    EmployeeAdpater staffsummaryadapter;

    Toolbar employee_toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        employee_toolbar = findViewById( R.id. employee_toolbar);
        setSupportActionBar(employee_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Employee List");

        responseItemArrayList = new ArrayList<>();

        if (MyUtils.isNetworkAvailable(MainActivity.this)) {
            dofetch();
        } else {
            Toast.makeText(getApplicationContext(),"Please check your connection", Toast.LENGTH_LONG).show();
        }



        dofetch();
    }



    private void dofetch() {

        Call<ArrayList<ResponseItem>> call = RetrofitClient.getInstance().getapi().responeiteam();
        call.enqueue(new Callback<ArrayList<ResponseItem>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseItem>> call, Response<ArrayList<ResponseItem>> response) {
                try{

                    if (response.isSuccessful()){

                        responseItemArrayList = response.body();
                        for (int y =0;y<responseItemArrayList.size();y++){
                            String name = responseItemArrayList.get(y).getName();
                            String email =  responseItemArrayList.get(y).getEmail();
                            int id  = responseItemArrayList.get(y).getId();
                            String address  = responseItemArrayList.get(y).getCompany().getName();
                            String phno = responseItemArrayList.get(y).getPhone();
                            Log.e("tag","the addres" + address);
                            Log.e("tag","the name" + name);
                            Log.e("tag","the email" + email);
                            Log.e("tag","the phno" + phno);

                            staffsummaryadapter = new EmployeeAdpater(MainActivity.this,responseItemArrayList) ;
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            recyclerView.setHasFixedSize(false);
                            recyclerView.stopScroll();
                            staffsummaryadapter.notifyDataSetChanged();
                            recyclerView.setAdapter(staffsummaryadapter);

                        }

                    }

                } catch (Exception e) {
                    Log.e("TAG", "THE ERROR IS " + e.toString());
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseItem>> call, Throwable t) {
                Log.e("the tag of-----", "Failure__" + t.toString());

            }
        });
    }
}