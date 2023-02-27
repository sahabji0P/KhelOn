package com.example.khelon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {
//    Timer changeScreen;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        firebaseAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkUser();

            }
        },2000);

//        changeScreen = new Timer();
//        changeScreen.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                checkUser();
//            }
//        },2000);
    }

    private void checkUser() {

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null){
            Intent intent = new Intent(SplashScreenActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }else{
            Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
// Disables the back button on the Splash screen.
    @Override
    public void onBackPressed() {
    }
}
