package com.example.khelon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    TextView switchToSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        switchToSignup = findViewById(R.id.moveto_signup);
        switchToSignup.setOnClickListener(v -> {
            Intent initiate = new Intent(LoginActivity.this,SignUpActivity.class);
            startActivity(initiate);
        });
    }
    // For back button, not to return back to the previous activity, directly
    // close the application when back button is pressed
    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }

}
