package com.example.khelon;

import static android.view.animation.ScaleAnimation.*;
import static com.example.khelon.R.drawable.round_back_event;
import static com.example.khelon.R.drawable.round_back_live;
import static com.example.khelon.R.drawable.round_back_update;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int selectedTab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout update = findViewById(R.id.updateLayout);
        final LinearLayout events = findViewById(R.id.eventsLayout);
        final LinearLayout live = findViewById(R.id.liveLayout);

        final ImageView updateImage = findViewById(R.id.updateLayoutIcon);
        final ImageView eventsImage = findViewById(R.id.eventsLayoutIcon);
        final ImageView liveImage = findViewById(R.id.liveLayoutIcon);

        final TextView updateText = findViewById(R.id.updateLayoutTxt);
        final TextView eventsTxt = findViewById(R.id.eventsLayoutTxt);
        final TextView liveTxt = findViewById(R.id.liveLayoutTxt);

        final RelativeLayout mainlayout = findViewById(R.id.mainLayout);


        getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, DashboardFragment.class,null).commit();


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedTab != 1){

                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, DashboardFragment.class,null).commit();

                    eventsTxt.setVisibility(View.GONE);
                    liveTxt.setVisibility(View.GONE);

                    eventsImage.setImageResource(R.drawable.event_icon);
                    liveImage.setImageResource(R.drawable.live_icon);

                    events.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    live.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    update.setBackgroundResource(round_back_update);
                    updateText.setVisibility(View.VISIBLE);
                    updateImage.setImageResource(R.drawable.update_selected_icon);

                    mainlayout.setBackgroundColor(getResources().getColor(R.color.updates));

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    update.startAnimation(scaleAnimation);


                    selectedTab = 1;
                }

            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedTab != 2){
                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, EquipmentFragment.class,null).commit();

                    updateText.setVisibility(View.GONE);
                    liveTxt.setVisibility(View.GONE);

                    updateImage.setImageResource(R.drawable.update_icon);
                    liveImage.setImageResource(R.drawable.live_icon);

                    update.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    live.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    events.setBackgroundResource(round_back_event);
                    eventsTxt.setVisibility(View.VISIBLE);
                    eventsImage.setImageResource(R.drawable.event_selected_icon);

                    mainlayout.setBackgroundColor(getResources().getColor(R.color.events));

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    events.startAnimation(scaleAnimation);

                    selectedTab = 2;
                }


            }
        });

        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selectedTab != 3){

                    getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer, TeamFragment.class,null).commit();

                    eventsTxt.setVisibility(View.GONE);
                    updateText.setVisibility(View.GONE);

                    eventsImage.setImageResource(R.drawable.event_icon);
                    updateImage.setImageResource(R.drawable.update_icon);

                    events.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    update.setBackgroundColor(getResources().getColor(android.R.color.transparent));

                    live.setBackgroundResource(round_back_live);
                    liveTxt.setVisibility(View.VISIBLE);
                    liveImage.setImageResource(R.drawable.live_selected_icon);

                    mainlayout.setBackgroundColor(getResources().getColor(R.color.live));

                    ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f,1.0f,1f,1f, RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setDuration(200);
                    scaleAnimation.setFillAfter(true);
                    live.startAnimation(scaleAnimation);

                    selectedTab = 3;
                }

            }
        });



    }
}