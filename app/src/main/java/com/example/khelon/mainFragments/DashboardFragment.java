package com.example.khelon.mainFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.khelon.badminton.BadmintonActivity;
import com.example.khelon.basketball.BasketballActivity;
import com.example.khelon.cricket.CricketActivity;
import com.example.khelon.football.FootballActivity;
import com.example.khelon.R;
import com.example.khelon.tabletennis.TableTennisActivity;
import com.example.khelon.volleyball.VolleyBallActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class DashboardFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        TextView cricketBtn = v.findViewById(R.id.cricketGame);
        TextView footballBtn = v.findViewById(R.id.footballGame);
        TextView badmintonBtn = v.findViewById(R.id.badmintonGame);
        TextView volleyBtn = v.findViewById(R.id.volleyballGame);
        TextView basketBtn = v.findViewById(R.id.basketballGame);
        TextView tableBtn = v.findViewById(R.id.tabletennisGame);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        final String userDisplayName = firebaseUser.getEmail();


        cricketBtn.setOnClickListener(v1 ->
                startActivity(new Intent(getActivity(), CricketActivity.class)));

        footballBtn.setOnClickListener(v12 ->
                startActivity(new Intent(getActivity(), FootballActivity.class)));

        badmintonBtn.setOnClickListener(v13 ->
                startActivity(new Intent(getActivity(), BadmintonActivity.class)));

        basketBtn.setOnClickListener(v14 ->
                startActivity(new Intent(getActivity(), BasketballActivity.class)));

        tableBtn.setOnClickListener(v15 ->
                startActivity(new Intent(getActivity(), TableTennisActivity.class)));

        volleyBtn.setOnClickListener(v16 ->
                startActivity(new Intent(getActivity(), VolleyBallActivity.class)));



        return v;
    }
}