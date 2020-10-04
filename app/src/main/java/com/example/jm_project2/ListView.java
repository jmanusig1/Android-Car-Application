/*
    Name: Jared Manusig
    CS 478 Prof. Mark Hallenbeck
    Project 2

    ListView.java

    Desc: List View for the dealership names and addresses
 */

package com.example.jm_project2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class ListView extends AppCompatActivity {


    //dealers:audi, honda, chevy,dodge,toyota,hyundai
    ArrayList<ArrayList<String>> dealers = new ArrayList<>();

    //list of audi dealers
    ArrayList<String> audi_dealers = new ArrayList<String>(
            Arrays.asList(
            "Fletcher Jones Audi, 1523 W North Ave Chicago, IL 60642",
            "McGrath, 7000 Golf Road Morton Grove,IL 60053",
            "Audi Westmont, 276 E Ogden Ave Westmont, IL 60559",
            "Audi Orland Park, 8021 W 159th St Tinley Park, IL 60477"
            ));

    //list of honda dealers
    ArrayList<String> honda_dealers = new ArrayList<String>(
            Arrays.asList(
            "Castle Honda, 6900 Dempster St Morton Grove, IL 60053 ",
            "Honda of Downtown Chicago, 1111 N Clark St Chicago, IL 60610",
            "Honda City Chicago, 4950 S Pulaski Rd Chicago, IL 60632",
            "McGrath City Honda, 6720 W Grand Ave Chicago, IL 60707"
            ));

    //list of chevrolet dealers
    ArrayList<String> chevy_dealers = new ArrayList<String>(
            Arrays.asList(
            "JENNINGS CHEVROLET, INC, 241 WAUKEGAN RD GLENVIEW, IL 60025",
            "BREDEMANN CHEVROLET, 1401 W DEMPSTER ST, PARK RIDGE, IL 60068",
            "BILL STASEK CHEVROLET, 700 W DUNDEE RD WHEELING, IL 60090"
            ));

    //list of dodge dealers
    ArrayList<String> dodge_dealers = new ArrayList<String>(
            Arrays.asList(
            "Midway Dodge, 4747 S Pulaski Rd Chicago, IL 60632",
            "Marino Chrysler Jeep Dodge Ram, 5133 W Irving Park Road Chicago, IL 60641",
            "Hawk Chrysler Dodge, Jeep 7911 W. Roosevelt Road Forest Park, IL 60130"
            ));

    //list of toyota dealers
    ArrayList<String> toyota_dealers = new ArrayList<String>(
            Arrays.asList(
            "Toyota of Lincoln Park, 1561 North Fremont Street, Chicago, IL 60642",
            "Midtown Toyota, 2700 North Cicero Avenue, Chicago, IL 60639",
            "Toyota On Western, 6941 South Western Ave, Chicago, IL 60636"
            ));

    //list of hyundai dealers
    ArrayList<String> hyundai_dealers = new ArrayList<String>(
            Arrays.asList(
            "Rogers Hyundai, 2700 South Michigan Avenue, Chicago, IL 60616 ",
            "McGrath City Hyundai, 6750 W Grand Ave Chicago, IL 60707",
            "Hyundai of Lincolnwood, 6747 N Lincoln Ave, Lincolnwood, IL 60712"
            ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //add all the dealer information to the master dealer arraylist
        dealers.add(audi_dealers);
        dealers.add(honda_dealers);
        dealers.add(chevy_dealers);
        dealers.add(dodge_dealers);
        dealers.add(toyota_dealers);
        dealers.add(hyundai_dealers);

        //find the list view
        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.dealerList);

        //get the intent extras
        Intent intent = getIntent();
        int pos = (int) intent.getIntExtra("Position", 0);

        //use the array adapter to add the array items to the list view
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dealers.get(pos));
        listView.setAdapter(arrayAdapter);
    }
}