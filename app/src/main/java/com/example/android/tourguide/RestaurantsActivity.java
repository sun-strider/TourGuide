package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("father", "әpә", "Baar", R.drawable.family_father));
        locations.add(new Location("mother", "әṭa", "Baar", R.drawable.family_mother));
        locations.add(new Location("son", "angsi", "Baar", R.drawable.family_son));
        locations.add(new Location("daughter", "tune", "Baar", R.drawable.family_daughter));
        locations.add(new Location("older brother", "taachi", "Baar", R.drawable.family_older_brother));
        locations.add(new Location("younger brother", "chalitti", "Baar", R.drawable.family_younger_brother));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_restaurants);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link LocationAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Location} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Location} object at the given position the user clicked on
                Location location = locations.get(position);

                // Get the address of the location and open a map app to show where it is
                String address = location.getLocationAddress();
                showMap(address);

            }
        });
    }


    // Method to start an intent for a map location
    public void showMap(String address) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri mapIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
        intent.setData(mapIntentUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}