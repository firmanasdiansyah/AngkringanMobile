package com.udinus.a4510_a11201911862_firmanasdiansyah_utsppb;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;

    private Context context;

    public AdapterRecyclerView(ArrayList<ItemModel> data) {
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textHead;
        TextView textSubhead;
        ImageView imageIcon;
        LinearLayout parentLayout;

        ViewHolder(View v) {

            super(v);

            textHead = v.findViewById(R.id.text_headline);
            textSubhead = v.findViewById(R.id.text_subhead);
            imageIcon = v.findViewById(R.id.imageList);
            parentLayout = v.findViewById(R.id.parentLayout);
        }
    }
    AdapterRecyclerView(Context context, ArrayList<ItemModel> data) {

        this.dataItem = data;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        //myonClickListener
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView textHead = holder.textHead;
        TextView textSubhead = holder.textSubhead;
        ImageView imageIcon = holder.imageIcon;

        textHead.setText(dataItem.get(position).getName());
        textSubhead.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());

        holder.parentLayout.setOnClickListener(view -> {
            Toast.makeText(context, dataItem.get(position).getName(), Toast.LENGTH_SHORT).show();

            if (dataItem.get(position).getName().equals("Nasi Kucing")){
                context.startActivity(new Intent(context, NasiKucingActivity.class));
            }
            if (dataItem.get(position).getName().equals("Sate Kepala")){
                context.startActivity(new Intent(context, SateKepalaActivity.class));
            }
            if (dataItem.get(position).getName().equals("Sate Usus")){
                context.startActivity(new Intent(context, SateUsusActivity.class));
            }
            if (dataItem.get(position).getName().equals("Sate Telur")){
                context.startActivity(new Intent(context, SateTelurActivity.class));
            }
            if (dataItem.get(position).getName().equals("Ceker Ayam")){
                context.startActivity(new Intent(context, CekerAyamActivity.class));
            }
            if (dataItem.get(position).getName().equals("Sayap Ayam")){
                context.startActivity(new Intent(context, SayapAyamActivity.class));
            }
            if (dataItem.get(position).getName().equals("Tahu Bacem")){
                context.startActivity(new Intent(context, TahuBacemActivity.class));
            }
            if (dataItem.get(position).getName().equals("Tempe Bacem")){
                context.startActivity(new Intent(context, TempeBacemActivity.class));
            }
            if (dataItem.get(position).getName().equals("Gorengan")){
                context.startActivity(new Intent(context, GorenganActivity.class));
            }
            if (dataItem.get(position).getName().equals("Wedank Jahe")){
                context.startActivity(new Intent(context, WedankJaheActivity.class));
            }
            if (dataItem.get(position).getName().equals("Susu Jahe")){
                context.startActivity(new Intent(context, SusuJaheActivity.class));
            }
            if (dataItem.get(position).getName().equals("Kopi Joss")){
                context.startActivity(new Intent(context, KopiJossActivity.class));
            }
            if (dataItem.get(position).getName().equals("Teh Panas")){
                context.startActivity(new Intent(context, TehPanasActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {

        return dataItem.size();
    }
}