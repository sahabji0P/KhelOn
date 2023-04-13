package com.example.khelon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {
    EditText signupName;
    EditText signupEmail;
    EditText signupPassword;
    EditText signupPhone;
    Button signupButton;
    final String emailPattern = "^e[1-2][1-9]cseu\\d\\d\\d\\d@bennett.edu.in";
    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView switchToLogin = findViewById(R.id.moveto_login);
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupPassword = findViewById(R.id.signup_password);
        signupPhone = findViewById(R.id.signup_phone);
        signupButton = findViewById(R.id.signup_button);

        mAuth = FirebaseAuth.getInstance();

        mUser =FirebaseAuth.getInstance().getCurrentUser();

        switchToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signupNameTxt = signupName.getText().toString();
                String signupEmailTxt = signupEmail.getText().toString();
                String signupPasswordTxt = signupPassword.getText().toString();
                String signupPhoneNo = signupPhone.getText().toString();

                if (signupNameTxt.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Some of the fields are empty!", Toast.LENGTH_SHORT).show();
                    signupName.setError("Name Required!");
                    signupName.requestFocus();

                }
                else if (signupEmailTxt.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Email cannot be Empty!", Toast.LENGTH_SHORT).show();
                    signupEmail.setError("Email cannot be Empty");
                    signupEmail.requestFocus();


                }
                else if (!signupEmailTxt.matches(emailPattern)) {
                    Toast.makeText(SignUpActivity.this, "Invalid Email Format!", Toast.LENGTH_SHORT).show();
                    signupEmail.setError("Invalid Email Format");
                    signupEmail.requestFocus();

                }
                else if (signupPasswordTxt.isEmpty() || signupPasswordTxt.length() < 8) {
                    Toast.makeText(SignUpActivity.this, "Please enter at least 8 Characters of Password!", Toast.LENGTH_SHORT).show();
                    signupPassword.setError("Enter a valid password!");
                    signupPassword.requestFocus();

                }
                else if (signupPhoneNo.isEmpty() || signupPhoneNo.length() < 10) {
                    Toast.makeText(SignUpActivity.this, "Please enter a valid Contact No!", Toast.LENGTH_SHORT).show();
                    signupPhone.setError("Enter a valid Contact Number");
                    signupPhone.requestFocus();
                } else {

                    mAuth.createUserWithEmailAndPassword(signupEmailTxt, signupPasswordTxt)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                mUser = mAuth.getCurrentUser();
                                UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(String.valueOf(signupName.getText()))
                                        .build();
                                mUser.updateProfile(userProfileChangeRequest).addOnCompleteListener(
                                        task1 -> {
                                            if (task1.isSuccessful()){
                                                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                                                Toast.makeText(SignUpActivity.this, "Sign Up! Successful, Kindly login", Toast.LENGTH_SHORT).show();
                                            }else {
                                                Toast.makeText(SignUpActivity.this, "Error"+Objects.requireNonNull(task1.getException()).getMessage(), Toast.LENGTH_LONG).show();

                                            }
                                        }
                                );
//                                Toast.makeText(SignUpActivity.this, "Sign Up! Successful, Kindly login", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                            }
                            else {
                                Toast.makeText(SignUpActivity.this, "Sign Up Failed! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
//                FirebaseAuth.getInstance().createUserWithEmailAndPassword(signupEmailTxt,signupPasswordTxt)
//                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                            @Override
//                            public void onSuccess(AuthResult authResult) {
//
//                                UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder()
//                                        .setDisplayName(String.valueOf(signupName))
//                                        .build();
//                                FirebaseUser firebaseUser = authResult.getUser();
//                                firebaseUser.updateProfile(userProfileChangeRequest);
//                                Toast.makeText(SignUpActivity.this, "Sign In Successful, Kindly Login", Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        super.onBackPressed();
    }
}