/*
    Name: Jared Manusig
    CS 478 Prof. Mark Hallenbeck
    Project 2

    ImageAdapter.java

    Desc: Custom Adapter to add Text and Image Views to the GridView
 */

package com.example.jm_project2;

import android.content.Context;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;          // This will have to be passed to the ImageView
    private List<Integer> mThumbIds;   // Adapter must store AdapterView's items
    private List<String> names;        // All the names for the textview
    private LayoutInflater layoutInflater;  //to make spacing easier

    // Save the list of image IDs, context, names, and assign the inflater
    public ImageAdapter(Context c, List<Integer> ids, List<String> names) {
        this.mContext = c;
        this.mThumbIds = ids;
        this.names = names;
        this.layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Now the methods inherited from abstract superclass BaseAdapter

    // Return the number of items in the Adapter
    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    // Will get called to provide the ID that
    // is passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    // Return an ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // if convertView's not recycled, initialize some attributes
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item, parent, false);
        }

        //get the text view and image view
        TextView carText = convertView.findViewById(R.id.carText);
        ImageView carImage = convertView.findViewById(R.id.carImage);

        //set the text and images
        carText.setText(names.get(position));
        carImage.setImageResource(mThumbIds.get(position));

        return convertView;
    }
}