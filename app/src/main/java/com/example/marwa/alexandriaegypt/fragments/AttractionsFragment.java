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
public class AttractionsFragment extends Fragment {

    public AttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        // Create a list of places
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place(getResources().getString(R.string.maamoura), getResources().getString(R.string.maamoura_address), R.drawable.maamoura));
        places.add(new Place(getResources().getString(R.string.montazah), getResources().getString(R.string.montazah_address), R.drawable.montazah));
        places.add(new Place(getResources().getString(R.string.citadel_of_qaitbay), getResources().getString(R.string.citadel_of_qaitbay_address), R.drawable.citadel_of_qaitbay));
        places.add(new Place(getResources().getString(R.string.stanly_bridge), getResources().getString(R.string.stanly_bridge_address), R.drawable.stanley));
        places.add(new Place(getResources().getString(R.string.green_plaza), getResources().getString(R.string.green_plaza_address), R.drawable.green_plaza));
        places.add(new Place(getResources().getString(R.string.san_stefano_mall), getResources().getString(R.string.san_stefano_mall_address), R.drawable.san_stephano_mall));
        places.add(new Place(getResources().getString(R.string.carrefour), getResources().getString(R.string.carrefour_address), R.drawable.carrefour));
        places.add(new Place(getResources().getString(R.string.planetarium_science_center), getResources().getString(R.string.planetarium_science_center_address), R.drawable.planetarium));
        places.add(new Place(getResources().getString(R.string.bibliotheca_alexandrina), getResources().getString(R.string.bibliotheca_alexandrina_address), R.drawable.bibliotheca_alexandrina));
        places.add(new Place(getResources().getString(R.string.san_giovanni), getResources().getString(R.string.san_giovanni_address), R.drawable.san_giovanni));

        //Create an PlaceAdapter, whose data source is a list of places.
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        //Find the ListView object in the view hierarchy of the {@link Activity}.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        //Make the ListView use the PlaceAdapter.
        listView.setAdapter(adapter);

        return rootView;
    }
}
