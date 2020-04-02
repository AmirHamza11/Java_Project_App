package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;

public class ProfileUpdateActivity extends AppCompatActivity {

    FirebaseFirestore firebase = FirebaseFirestore.getInstance();

    private EditText fullNameEditText,addressEditText,emailEditText,phoneEditText,firstPLEditText,secondPLEditText;
    public String fullName,address,email,phone,firstPL,secondPL;
    public ProfileDetails pDetails;
    private String currentUserUID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_update);

        fullNameEditText = findViewById(R.id.ProfileUpdateFullNameEditText);
        addressEditText = findViewById(R.id.ProfileUpdateAddressEditText);
        emailEditText = findViewById(R.id.ProfileUpdateEmailEditText);
        phoneEditText = findViewById(R.id.ProfileUpdatePhoneEditText);
        firstPLEditText = findViewById(R.id.ProfileUpdateFirstPLEditText);
        secondPLEditText = findViewById(R.id.ProfileUpdateSecondPLEditText);

//        fullName = fullNameEditText.getText().toString();
//        address = addressEditText.getText().toString();
//        email = emailEditText.getText().toString();
//        phone = phoneEditText.getText().toString();
//        firstPL = firstPLEditText.getText().toString();
//        secondPL = secondPLEditText.getText().toString();


      //  currentUserUID = '"'+ currentUserUID +'"';


//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if(user!= null){
//            if(user.getDisplayName()!=null){
//                fullNameEditText.setText(user.getDisplayName());
//                fullNameEditText.setText(user.getDisplayName().length());
//
//            }
//        }

    }

    public void UpdateButton(View view) {
//        pDetails = new ProfileDetails(fullName,address,email,phone,firstPL,secondPL);

        HashMap<String,Object>map = new HashMap<>();
        map.put("fullName",fullNameEditText.getText().toString());
        map.put("address",addressEditText.getText().toString());
        map.put("email",emailEditText.getText().toString());
        map.put("phone",phoneEditText.getText().toString());
        map.put("firstPL",firstPLEditText.getText().toString());
        map.put("secondPL", secondPLEditText.getText().toString());
        currentUserUID = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

        DocumentReference docref = FirebaseFirestore.getInstance()
                                        .collection("profiles").document(currentUserUID);




        docref.set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(),"Update Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Update not Successful",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
