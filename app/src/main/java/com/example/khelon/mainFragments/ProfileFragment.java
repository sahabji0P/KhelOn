package com.example.khelon.mainFragments;

import static com.example.khelon.R.id.optionsProfile;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khelon.LoginActivity;
import com.example.khelon.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {


    ImageButton bottomLayout;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View profileF =  inflater.inflate(R.layout.fragment_profile, container, false);


        TextView userName = profileF.findViewById(R.id.profileUsername);
        TextView userEmail = profileF.findViewById(R.id.profileEmail);
        TextView userPhone = profileF.findViewById(R.id.profilePhone);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        assert firebaseUser != null;
        final String nameUser = firebaseUser.getDisplayName();
        userName.setText(nameUser);

        final String  emailUser = firebaseUser.getEmail();
        userEmail.setText(emailUser);

        final String userUID = firebaseUser.getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("users");
        
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String phoneDB = snapshot.child(userUID).child("phoneNo").getValue(String.class);
                userPhone.setText(phoneDB);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });









        bottomLayout = profileF.findViewById(optionsProfile);

        bottomLayout.setOnClickListener(view ->
                showDialog());



        return profileF;
    }






    private void showDialog(){

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                getActivity(),R.style.BottomSheetDialogTheme);

        bottomSheetDialog.setContentView(R.layout.bottomsheet);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        final String nameUser = firebaseUser.getDisplayName();

        LinearLayout aboutUs = bottomSheetDialog.findViewById(R.id.aboutUsLayout);
        TextView UserName = bottomSheetDialog.findViewById(R.id.username);
        LinearLayout logOut = bottomSheetDialog.findViewById(R.id.logoutLayout);

        UserName.setText(nameUser);

        assert aboutUs != null;
        aboutUs.setOnClickListener(view ->{
                bottomSheetDialog.dismiss();
                Toast.makeText(getActivity(), "About Us!", Toast.LENGTH_SHORT).show();
        });

        logOut.setOnClickListener(view -> {
            bottomSheetDialog.dismiss();
            firebaseAuth.signOut();
            checkUser();
            getActivity().finish();
        });


        bottomSheetDialog.show();
    }

    private void checkUser() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser == null){
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }
}