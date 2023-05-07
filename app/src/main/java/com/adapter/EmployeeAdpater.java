package com.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.it.mylearning.Employeeactivity;
import com.it.mylearning.R;
import com.modellcass.ResponseItem;

import java.util.ArrayList;
import java.util.Locale;

public class EmployeeAdpater extends RecyclerView.Adapter<EmployeeAdpater.ViewHolder> {

    public Context context;
    ArrayList<ResponseItem> responseItems;
    String textecno;
    int id;

    public EmployeeAdpater(Context context, ArrayList<ResponseItem> staffItemOmList) {
        this.context = context;
        this.responseItems = staffItemOmList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employeelist, parent, false);
        return new EmployeeAdpater.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.email.setText(responseItems.get(position).getEmail().toLowerCase( Locale.ROOT ));
        holder.name.setText(responseItems.get(position).getName());

        holder.am_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Employeeactivity.class);

                intent.putExtra("id",responseItems.get(holder.getAdapterPosition()).getId());
                Log.e("","the id " + id);
                context.startActivity(intent);


            }
        });


    }


    @Override
    public int getItemCount() {


        return responseItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, email;
        LinearLayout am_layout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            am_layout = itemView.findViewById(R.id.touchlatout);



        }
    }

}