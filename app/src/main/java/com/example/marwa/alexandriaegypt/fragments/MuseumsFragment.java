package com.example.marwa.alexandriaegypt.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.marwa.alexandriaegypt.Place;
import com.example.marwa.alexandriaegypt.adapters.PlaceAdapter;
import com.example.marwa.alexandriaegypt.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} class.
 */
public class MuseumsFragment extends Fragment {


    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getResources().getString(R.string.royal_jewelry_museum), getResources().getString(R.string.royal_jewelry_museum_address), R.drawable.royal_jewelry_museum));
        places.add(new Place(getResources().getString(R.string.alexandria_aquarium), getResources().getString(R.string.alexandria_aquarium_address), R.drawable.alexandria_aquarium));
        places.add(new Place(getResources().getString(R.string.thegrecoroman_museum), getResources().getString(R.string.thegrecoroman_museum_address), R.drawable.the_greco_roman_museum));
        places.add(new Place(getResources().getString(R.string.museum_of_fine_arts), getResources().getString(R.string.museum_of_fine_arts_address), R.drawable.museum_of_fine_arts));
        places.add(new Place(getResources().getString(R.string.alexandria_national_museum), getResources().getString(R.string.alexandria_national_museum_address), R.drawable.alexandria_national_museum));
        places.add(new Place(getResources().getString(R.string.museum_of_calligraphy), getResources().getString(R.string.museum_of_calligraphy_address), R.drawable.museum_of_calligraphy_alexandria));
        places.add(new Place(getResources().getString(R.string.the_sadat_museum), getResources().getString(R.string.the_sadat_museum_address), R.drawable.the_sadat_museum));
        places.add(new Place(getResources().getString(R.string.cavafy_museum), getResources().getString(R.string.cavafy_museum_address), R.drawable.cavafy_museum));

        //Create an PlaceAdapter, whose data source is a list of places.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        //Find the ListView object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        //Make the ListView use the PlaceAdapter
        listView.setAdapter(adapter);

        return rootView;
    }
}
