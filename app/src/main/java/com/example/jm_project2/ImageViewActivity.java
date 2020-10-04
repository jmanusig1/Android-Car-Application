/*
    Name: Jared Manusig
    CS 478 Prof. Mark Hallenbeck
    Project 2

    ImageViewActivity.java

    Desc: Activity for the enlarged image after short-clicking image
 */

package com.example.jm_project2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class ImageViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        // Example of programmatic layout definition
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(MainActivity.EXTRA_RES_ID, 0));

        //get the url of the car we pressed
        final String carUrl =  intent.getStringExtra(MainActivity.EXTRA_URL);

        setContentView(imageView);

        //set a listener for a browser activity
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //use the url we got to create a new browser activity with said url
                Intent intent = new Intent(new Intent(Intent.ACTION_VIEW, Uri.parse(carUrl)));
                startActivity(intent);
            }
        });
    }
}