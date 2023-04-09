package com.example.khelon;

import static android.view.animation.ScaleAnimation.*;
import static com.example.khelon.R.drawable.round_back_navoptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private int selectedTab = 1;

    public long pressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout update = findViewById(R.id.updateLayout);
        final LinearLayout events = findViewById(R.id.eventsLayout);
        final LinearLayout live = findViewById(R.id.liveLayout);
        final LinearLayout setting = findViewById(R.id.settingLayout);

        final ImageView updateImage = findViewById(R.id.updateLayoutIcon);
        final ImageView eventsImage = findViewById(R.id.eventsLayoutIcon);
        final ImageView liveImage = findViewById(R.id.liveLayoutIcon);
        final ImageView settingImage = findViewById(R.id.settingIcon);



        final TextView updateText = findViewById(R.id.updateLayoutTxt);
        final TextView eventsTxt = findViewById(R.id.eventsLayoutTxt);
        final TextView liveTxt = findViewById(R.id.liveLayoutTxt);
        final TextView settingTxt = findViewById(R.id.settingTxt);

        final RelativeLayout mainlayout = findViewById(R.id.mainLayout);






        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, DashboardFragment.class,null).commit();


        update.setOnClickListener(v -> {

            if(selectedTab != 1){

                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.fragmentContainer, DashboardFragment.class,null).commit();

                eventsTxt.setVisibility(View.GONE);
                liveTxt.setVisibility(View.GONE);
                settingTxt.setVisibility(View.GONE);

                eventsImage.setImageResource(R.drawable.team_icon);
                liveImage.setImageResource(R.drawable.live_icon);
                settingImage.setImageResource(R.drawable.baseline_settings_24);

                events.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                live.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                update.setBackgroundResource(round_back_navoptions);
                updateText.setVisibility(View.VISIBLE);
                updateImage.setImageResource(R.drawable.dashboard_selected_icon);


                mainlayout.setBackgroundColor(getResources().getColor(R.color.black));

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, RELATIVE_TO_SELF,0.0f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                update.startAnimation(scaleAnimation);


                selectedTab = 1;
            }

        });

        events.setOnClickListener(v -> {

            if(selectedTab != 2){
                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.fragmentContainer, EquipmentFragment.class,null).commit();

                updateText.setVisibility(View.GONE);
                liveTxt.setVisibility(View.GONE);
                settingTxt.setVisibility(View.GONE);

                updateImage.setImageResource(R.drawable.dashboard_icon);
                liveImage.setImageResource(R.drawable.live_icon);
                settingImage.setImageResource(R.drawable.baseline_settings_24);

                update.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                live.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                events.setBackgroundResource(round_back_navoptions);
                eventsTxt.setVisibility(View.VISIBLE);
                eventsImage.setImageResource(R.drawable.team_selected_icon);

                mainlayout.setBackgroundColor(getResources().getColor(R.color.black));

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, RELATIVE_TO_SELF,0.0f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                events.startAnimation(scaleAnimation);

                selectedTab = 2;
            }


        });

        live.setOnClickListener(v -> {

            if(selectedTab != 3){

                getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.fragmentContainer, TeamFragment.class,null).commit();

                eventsTxt.setVisibility(View.GONE);
                updateText.setVisibility(View.GONE);
                settingTxt.setVisibility(View.GONE);

                eventsImage.setImageResource(R.drawable.team_icon);
                updateImage.setImageResource(R.drawable.dashboard_icon);
                settingImage.setImageResource(R.drawable.baseline_settings_24);

                events.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                update.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                live.setBackgroundResource(round_back_navoptions);
                liveTxt.setVisibility(View.VISIBLE);
                liveImage.setImageResource(R.drawable.live_selected_icon);

                mainlayout.setBackgroundColor(getResources().getColor(R.color.black));

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, RELATIVE_TO_SELF,0.0f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                live.startAnimation(scaleAnimation);

                selectedTab = 3;
            }

        });


        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();



//        final String userDisplayName = firebaseUser.getDisplayName();


        checkUser();

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        MainActivity.this,R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                        R.layout.bottomsheet,(LinearLayout)findViewById(R.id.bottomsheetLayout)
                );
                bottomSheetView.findViewById(R.id.logoutLayout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Logout Successful!", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        firebaseAuth.signOut();
                        checkUser();

                    }
                });

                bottomSheetView.findViewById(R.id.aboutUsLayout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "About Us!", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });




                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();


            }
        });

    }

    public void onBackPressed(){
        if (pressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            finish();
        }else {
            Toast.makeText(this, "Please click the back button twice to exit!", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();

    }

//    TextView displayName = findViewById(R.id.username);
//                        displayName.setText(userDisplayName);

    private void checkUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser == null){
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            
            finish();
        }
    }

}