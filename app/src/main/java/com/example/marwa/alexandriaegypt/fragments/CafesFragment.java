package com.example.marwa.alexandriaegypt.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.marwa.alexandriaegypt.R;
import com.example.marwa.alexandriaegypt.adapters.PlaceAdapter;
import com.example.marwa.alexandriaegypt.models.Place;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} class.
 */
public class CafesFragment extends Fragment {

    public CafesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getResources().getString(R.string.zanillis), getResources().getString(R.string.zanillis_address)));
        places.add(new Place(getResources().getString(R.string.paplo), getResources().getString(R.string.paplo_address)));
        places.add(new Place(getResources().getString(R.string.costa), getResources().getString(R.string.costa_address)));
        places.add(new Place(getResources().getString(R.string.santos), getResources().getString(R.string.santos_address)));
        places.add(new Place(getResources().getString(R.string.carlos), getResources().getString(R.string.carlos_address)));
        places.add(new Place(getResources().getString(R.string.latino), getResources().getString(R.string.latino_address)));
        places.add(new Place(getResources().getString(R.string.delight), getResources().getString(R.string.delight_address)));
        places.add(new Place(getResources().getString(R.string.roastery), getResources().getString(R.string.roastery_address)));

        //Create an PlaceAdapter, whose data source is a list of places.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        //Find the ListView object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        //Make the ListView use the PlaceAdapter.
        listView.setAdapter(adapter);

        return rootView;
    }
}


