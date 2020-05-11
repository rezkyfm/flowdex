package com.rezkyfm.flowdex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class EncyclopediaActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encyclopedia);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")
                && getIntent().hasExtra("image_desc")){

            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("image_name");
            String imageDesc = getIntent().getStringExtra("image_desc");

            setImage(imageUrl, imageName, imageDesc);
        }
    }

    private void setImage(String imageUrl, String imageName, String imageDesc){
        Log.d(TAG, "setImage: setting te image and name to widgets.");

        TextView name = findViewById(R.id.ency_title);
        name.setText(imageName);

        TextView desc = findViewById(R.id.ency_desc);
        desc.setText(imageDesc);

        ImageView image = findViewById(R.id.ency_img);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }
}
