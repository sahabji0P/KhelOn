package com.example.khelon.mainFragments;

import static com.example.khelon.CheckAdmin.checkAdmin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.khelon.R;
import com.example.khelon.registration.DataClass;
import com.example.khelon.registration.RecyclerAdapter;
import com.example.khelon.registration.RegistrationUpload;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RegistrationFragment extends Fragment {

    ImageButton postButton;

    RecyclerView recyclerView;
    List<DataClass> dataList;

    DatabaseReference databaseReference;
    ValueEventListener eventListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_registration, container, false);

        postButton = v.findViewById(R.id.optionsRegistration);

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = firebaseUser.getUid();

        if (checkAdmin(uid)){
            postButton.setVisibility(View.VISIBLE);
            postButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), RegistrationUpload.class));
//                    finish();
                }
            });
        }else {
            postButton.setVisibility(View.GONE);
        }

        recyclerView = v.findViewById(R.id.registrationRecycler);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        dataList = new ArrayList<>();

        RecyclerAdapter adapter = new RecyclerAdapter(requireActivity(),dataList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Registrations");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for(DataSnapshot itemSnapshot: snapshot.getChildren()){
                    DataClass dataClass = itemSnapshot.getValue(DataClass.class);
                    dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return v;
    }

}