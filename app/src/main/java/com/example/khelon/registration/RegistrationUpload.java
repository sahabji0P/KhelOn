package com.example.khelon.registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.khelon.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class RegistrationUpload extends AppCompatActivity {

    EditText heading,content;
    ImageView backBtn;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_upload);


        backBtn = findViewById(R.id.registrationUploadBackBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrationUpload.super.onBackPressed();
                finish();
            }
        });

        heading = findViewById(R.id.registrationPostHeading);
        content = findViewById(R.id.registrationPostContent);
        saveButton = findViewById(R.id.registrationUploadPostButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });

    }

    public void uploadData() {

        String title = heading.getText().toString();
        String desc = content.getText().toString();

        com.example.khelon.registration.DataClass dataClass = new com.example.khelon.registration.DataClass(title,desc);


        FirebaseDatabase.getInstance().getReference("Registrations").child(title)
                .setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

//                          startActivity(new Intent(Upload_Cricket_Support.this,CricketActivity.class));
                            Toast.makeText(RegistrationUpload.this, "Post uploaded", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(RegistrationUpload.this, Objects.requireNonNull(e.getMessage()).toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}