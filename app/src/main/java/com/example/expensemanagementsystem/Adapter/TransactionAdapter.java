package com.example.expensemanagementsystem.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.expensemanagementsystem.R;
import com.example.expensemanagementsystem.Model.TransactionModel;
import com.example.expensemanagementsystem.UpdateActivity;
import com.example.expensemanagementsystem.databinding.OneRecyclerItemBinding;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {

    Context context;
    ArrayList<TransactionModel> transactionModelsArrayList;

    public TransactionAdapter(Context context, ArrayList<TransactionModel> transactionModelsArrayList) {
        this.context = context;
        this.transactionModelsArrayList = transactionModelsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_recycler_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //Color Logic
        TransactionModel model = transactionModelsArrayList.get(position);
        String type = model.getType();
        if(type.equals("Expense"))
        {
            holder.binding.priorityOne.setBackgroundResource(R.drawable.red_shape);


        }
        else
        {
            holder.binding.priorityOne.setBackgroundResource(R.drawable.green_shape);

        }

        holder.binding.amountOne.setText(model.getAmount());
        holder.binding.dateOne.setText(model.getDate());
        holder.binding.noteOne.setText(model.getNote());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id",transactionModelsArrayList.get(position).getId());
                intent.putExtra("amount",transactionModelsArrayList.get(position).getAmount());
                intent.putExtra("note",transactionModelsArrayList.get(position).getNote());
                intent.putExtra("type",transactionModelsArrayList.get(position).getType());

                context.startActivity(intent);

            }
        });

    }



    @Override
    public int getItemCount() {
        return transactionModelsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        OneRecyclerItemBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding= OneRecyclerItemBinding.bind(itemView);
        }
    }

}
