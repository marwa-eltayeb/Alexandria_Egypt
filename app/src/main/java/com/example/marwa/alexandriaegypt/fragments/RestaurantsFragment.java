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
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getResources().getString(R.string.seagull), getResources().getString(R.string.seagull_address), R.drawable.seagull));
        places.add(new Place(getResources().getString(R.string.hosny_grill), getResources().getString(R.string.hosny_grill_address), R.drawable.hosney));
        places.add(new Place(getResources().getString(R.string.balbaa), getResources().getString(R.string.balbaa_address), R.drawable.balbaa));
        places.add(new Place(getResources().getString(R.string.kadoura), getResources().getString(R.string.kadoura_address), R.drawable.kadoura));
        places.add(new Place(getResources().getString(R.string.abo_faris), getResources().getString(R.string.abo_faris_address), R.drawable.abo_fares));
        places.add(new Place(getResources().getString(R.string.tikka), getResources().getString(R.string.tikka_address), R.drawable.tikka));
        places.add(new Place(getResources().getString(R.string.ibn_el_balad), getResources().getString(R.string.ibn_el_balad_address), R.drawable.ibn_elbalad));
        places.add(new Place(getResources().getString(R.string.sultan_ayoub), getResources().getString(R.string.sultan_ayoub_address), R.drawable.sultan_ayoub));

        //Create an PlaceAdapter, whose data source is a list of places.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        //Find the ListView object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        //Make the ListView use the PlaceAdapter
        listView.setAdapter(adapter);

        return rootView;
    }
}
