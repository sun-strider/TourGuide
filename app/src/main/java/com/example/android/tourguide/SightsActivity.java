package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Create a list of locations
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.sight_title_01), getString(R.string.sight_description_01), getString(R.string.sight_address_01), R.drawable.piazza));
        locations.add(new Location(getString(R.string.sight_title_02), getString(R.string.sight_description_02), getString(R.string.sight_address_02), R.drawable.seven_boutique));
        locations.add(new Location(getString(R.string.sight_title_03), getString(R.string.sight_description_03), getString(R.string.sight_address_03), R.drawable.elvezia));
        locations.add(new Location(getString(R.string.sight_title_04), getString(R.string.sight_description_04), getString(R.string.sight_address_04), R.drawable.casa_oliva));
        locations.add(new Location(getString(R.string.sight_title_05), getString(R.string.sight_description_05), getString(R.string.sight_address_05), R.drawable.antica_posta));

        // Create an {@link LocationAdapter}, whose data source is a list of {@link Location}s. The
        // adapter knows how to create list items for each item in the list.
        LocationAdapter adapter = new LocationAdapter(this, locations, R.color.category_sights);

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