/*
    Name: Jared Manusig
    CS 478 Prof. Mark Hallenbeck
    Project 2

    MainActivity.java

    Desc: Main function of the car application
 */

package com.example.jm_project2;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

//This application uses some deprecated methods.
//See UIViewPager for a more modern version of this application

public class MainActivity extends Activity {

    //strings for extra intents
    protected static final String EXTRA_RES_ID = "POS";
    protected static final String EXTRA_URL = "URL";

    //1 = audi; 2 = honda; 3 = corvette; 4 = dodge; 5 = supra; 6 = hyundai
    //arraylist that holds the images for all the cars
    private ArrayList<Integer> mThumbIdsCars = new ArrayList<Integer>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6));

    //arraylist that holds the names for all the cars
    private ArrayList<String> mNames = new ArrayList<String>(
            Arrays.asList(
                "Audi R8", "Honda Civic Type R", "Chevrolet Corvette",
                    "Dodge Challenger", "Toyota Supra", "Hyundai Velostar N"
            )
        );

    //array that holds the car manufacture urls for the cars
    private String[] carUrls = {
            "https://www.audiusa.com/us/web/en/models/r8/r8-coupe/2020/overview.html",
            "https://automobiles.honda.com/civic-type-r",
            "https://www.chevrolet.com/performance/corvette",
            "https://www.dodge.com/challenger.html",
            "https://www.toyota.com/gr-supra/",
            "https://www.hyundai-n.com/en/models/n/veloster-n.do"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Gridview
        GridView gridview = (GridView) findViewById(R.id.gridview);

        // Create a new ImageAdapter and set it as the Adapter for this GridView
        gridview.setAdapter(new ImageAdapter(this, mThumbIdsCars, mNames));

        //long-click for a context menu set-up
        registerForContextMenu(gridview);

        // Set an setOnItemClickListener on the GridView
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create an Intent to start the ImageViewActivity
                Intent intent = new Intent(MainActivity.this,
                        ImageViewActivity.class);

                // Add the ID and name of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, (int) id);
                intent.putExtra(EXTRA_URL, (String) carUrls[position]);

                // Start the ImageViewActivity
                startActivity(intent);
            }
        });
    }

    // Create Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //get the info of the item clicked
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        //switch cases for the various options
        switch (item.getItemId()) {

            //case 1, we want to see the full picture
            case R.id.fullpic:
                Intent intent = new Intent(MainActivity.this,
                        ImageViewActivity.class);

                // Add the ID and name of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, (int) info.id);
                intent.putExtra(EXTRA_URL, (String) carUrls[info.position]);

                startActivity(intent);
                return true;

            //case 2, we want to go to the web page
            case R.id.webpage:
                //create a new intent with the car url
                Intent intent2 = new Intent(new Intent(Intent.ACTION_VIEW, Uri.parse(carUrls[info.position])));
                startActivity(intent2);
                return true;

            //case 3, we want to see chicagoland dealers
            case R.id.dealers:
                //go to the listview activity
                Intent intent3 = new Intent(MainActivity.this,
                        ListView.class);

                // Add the ID, name, and position of the thumbnail to display as an Intent Extra
                intent3.putExtra(EXTRA_RES_ID, (int) info.id);
                intent3.putExtra(EXTRA_URL, (String) carUrls[info.position]);
                intent3.putExtra("Position", info.position);

                startActivity(intent3);
                return true;

            default:
                return false;
        }
    }
}