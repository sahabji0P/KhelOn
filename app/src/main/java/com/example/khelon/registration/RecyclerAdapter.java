package com.example.khelon.registration;

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

import com.example.khelon.DetailedData;
import com.example.khelon.R;



import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
    private Context context;
    private List<DataClass> dataList;

    public RecyclerAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_registration,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.registrationTitle.setText(dataList.get(position).getHeading());
        holder.registrationDescription.setText(dataList.get(position).getContent());

        holder.registrationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RegistrationDetailed.class);

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

    TextView registrationTitle,registrationDescription;
    CardView registrationCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        registrationTitle = itemView.findViewById(R.id.registrationCardHeading);
        registrationDescription = itemView.findViewById(R.id.registrationCardDescription);
        registrationCard = itemView.findViewById(R.id.recyclerRegistrationView);
    }
}