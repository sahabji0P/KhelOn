package com.example.khelon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText loginEmail;
    EditText loginPassword;
    Button loginButton;
    TextView switchToSignup;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    final String emailPattern = "^e[1-2][1-9]cseu\\d\\d\\d\\d@bennett.edu.in";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        switchToSignup = findViewById(R.id.moveto_signup);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        // Move to Sign up Page
        switchToSignup.setOnClickListener(v -> {
            Intent initiate = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(initiate);
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginEmailTxt = loginEmail.getText().toString();
                String loginPasswordTxt = loginPassword.getText().toString();

                if (!loginEmailTxt.isEmpty() && loginEmailTxt.matches(emailPattern)){
                    if (!loginPasswordTxt.isEmpty()){
                        mAuth.signInWithEmailAndPassword(loginEmailTxt,loginPasswordTxt)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(LoginActivity.this, "Login In Successful!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LoginActivity.this, "Email or Password is Wrong!", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }else {
                        loginPassword.setError("Password Cannot be Empty");
                    }
                }else if (loginEmailTxt.isEmpty()){
                    loginEmail.setError("Email cannot be Empty!");
                }else {
                    loginEmail.setError("Enter a valid Email!");
                }

            }
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
