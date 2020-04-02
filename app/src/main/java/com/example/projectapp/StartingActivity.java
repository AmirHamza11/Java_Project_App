package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
    }


    public void OwnerButton(View view) {
        Toast.makeText(getApplicationContext(),"Owner Id will be added soon",Toast.LENGTH_SHORT).show();
    }

    public void TenantButton(View view) {
        startActivity(new Intent(getApplicationContext(),SignInActivity.class));
    }
}
