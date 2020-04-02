package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private TextView fullNameTextView,addressTextView,emailTextView,phoneTextView,firstPLTextView,secondPLTextView;


    private String currentUserUId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullNameTextView = findViewById(R.id.ProfileFullNameTextViewId);
        addressTextView = findViewById(R.id.ProfileAddressTextViewId);
        emailTextView = findViewById(R.id.ProfileEmailTextViewId);
        phoneTextView = findViewById(R.id.ProfilePhoneTextViewId);
        firstPLTextView = findViewById(R.id.ProfileFirstPLTextViewId);
        secondPLTextView = findViewById(R.id.ProfileSecondPLTextViewId);


        currentUserUId = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

        FirebaseFirestore.getInstance()
                .collection("profiles")
                .document(currentUserUId)
                .get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                ProfileDetails pDetails = documentSnapshot.toObject(ProfileDetails.class);

                if(pDetails!= null) {
                    String address = "Address: " +pDetails.getAddress();
                    String email = "Email: "+ pDetails.getEmail();
                    String phone = "Phone: "+ pDetails.getPhone();
                    String firstPL = "1. "+pDetails.getFirstPL();
                    String secondPL = "2. "+pDetails.getSecondPL();
                    fullNameTextView.setText(pDetails.getFullName());
                    addressTextView.setText(address);
                    emailTextView.setText(email);
                    phoneTextView.setText(phone);
                    firstPLTextView.setText(firstPL);
                    secondPLTextView.setText(secondPL);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "onFailure: "+e);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.ProfileMenuLogOutId){
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(getApplicationContext(),StartingActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void UpdateProfileButton(View view) {
        startActivity(new Intent(getApplicationContext(),ProfileUpdateActivity.class));
    }
}
