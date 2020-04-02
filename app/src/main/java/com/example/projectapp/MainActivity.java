package com.example.projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

//    private Posts post;
//    ArrayList<String>title = new ArrayList<>();
//    ArrayList<String>location = new ArrayList<>();
//    ArrayList<String>description = new ArrayList<>();

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private MainActivityRecyclerViewAdapter mARVAdapter;
    private String[] title1 ={
            "A luxurious flat for a family","Mess for Students!","Lowest Cost two room flat"
    };
    private String[] location1 = {
            "Uttara,Dhaka","Akhaliya,Sylhet","Modina Market,Sylhet"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(FirebaseAuth.getInstance().getCurrentUser() == null){
            Intent intent = new Intent( this , StartingActivity.class);
            startActivity(intent);
            finish();
        }

//        FirebaseFirestore.getInstance()
//                .collection("posts")
//                .get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        for(DocumentSnapshot d : queryDocumentSnapshots){
//                            post = d.toObject(Posts.class);
//                            title.add(post.getTitle());
//                            location.add(post.getLocation());
//                            description.add(post.getDescription());
//
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d(TAG, "onFailure: "+e);
//            }
//        });

        recyclerView = findViewById(R.id.MainActivityRecyclerViewId);

        mARVAdapter = new MainActivityRecyclerViewAdapter(this,title1,location1);

        recyclerView.setAdapter(mARVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mARVAdapter.setOnItemClickListener(new MainActivityRecyclerViewAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getApplicationContext(),"Post details will be available soon",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.MainActivityMenuProfileItemId){

            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(intent);
        }else if(item.getItemId()==R.id.MainActivityMenuLogOutItemId){
            FirebaseAuth.getInstance().signOut();

            Intent intent = new Intent(getApplicationContext(),StartingActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
