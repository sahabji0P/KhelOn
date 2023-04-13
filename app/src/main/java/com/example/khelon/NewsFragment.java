package com.example.khelon;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;


public class NewsFragment extends Fragment {

    ImageButton bottomLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        bottomLayout = v.findViewById(R.id.optionsNews);
        bottomLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });




        return v;
    }

    private void showDialog(){

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                getActivity(),R.style.BottomSheetDialogTheme);

        bottomSheetDialog.setContentView(R.layout.bottomsheet);

        LinearLayout aboutUs = bottomSheetDialog.findViewById(R.id.aboutUsLayout);
        
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "About Us!", Toast.LENGTH_SHORT).show();
            }
        });


        bottomSheetDialog.show();
    }


}