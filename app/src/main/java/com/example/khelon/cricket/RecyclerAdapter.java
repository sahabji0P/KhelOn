package com.example.khelon.cricket;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.khelon.DetailedData;
import com.example.khelon.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

    public RecyclerAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_sports,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.teamImage);
        holder.teamHeading.setText(dataList.get(position).getHeading());
        holder.teamDesc.setText(dataList.get(position).getContent());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailedData.class);

                intent.putExtra("Image",dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Heading",dataList.get(holder.getAdapterPosition()).getHeading());
                intent.putExtra("Description",dataList.get(holder.getAdapterPosition()).getContent());

                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView teamImage;
    TextView teamHeading,teamDesc;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        teamImage = itemView.findViewById(R.id.teamImg);
        teamHeading = itemView.findViewById(R.id.teamHeading);

        teamDesc = itemView.findViewById(R.id.cricketPostDescription);
        recCard = itemView.findViewById(R.id.recCard);
    }
}