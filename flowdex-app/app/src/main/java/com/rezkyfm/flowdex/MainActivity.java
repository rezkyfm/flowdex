package com.rezkyfm.flowdex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private CardView recognition;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recognition = (CardView) findViewById(R.id.recognition);


        recognition.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });

        getImages();
    }

    public void openCamera(){
        Intent intent = new Intent(this, DetectorActivity.class);
        startActivity(intent);
    }

    private void getImages(){

        mImageUrls.add("android.resource://com.rezkyfm.flowdex/drawable/daisy");
        mNames.add("Daisy");
        mDesc.add(getString(R.string.daisy_desc));

        mImageUrls.add("android.resource://com.rezkyfm.flowdex/drawable/dandelion");
        mNames.add("Dandelion");
        mDesc.add(getString(R.string.daisy_desc));

        mImageUrls.add("android.resource://com.rezkyfm.flowdex/drawable/rose");
        mNames.add("Rose");
        mDesc.add(getString(R.string.rose_desc));

        mImageUrls.add("android.resource://com.rezkyfm.flowdex/drawable/sunflower");
        mNames.add("Sunflower");
        mDesc.add(getString(R.string.sunflower_desc));

        mImageUrls.add("android.resource://com.rezkyfm.flowdex/drawable/tulip");
        mNames.add("Tulip");
        mDesc.add(getString(R.string.tulip_desc));

        initRecyclerView();

    }

    private void initRecyclerView(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mDesc);
        recyclerView.setAdapter(adapter);
    }
}
