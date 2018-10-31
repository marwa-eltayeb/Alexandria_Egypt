package com.example.marwa.alexandriaegypt.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.marwa.alexandriaegypt.R;
import com.example.marwa.alexandriaegypt.adapters.MyExpandableAdapter;
import com.example.marwa.alexandriaegypt.models.Description;
import com.example.marwa.alexandriaegypt.models.Place;

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

        View rootView = inflater.inflate(R.layout.description_list, container, false);

        // Create a list of places
        ArrayList<Place> places = new ArrayList<>();
        places = populateContinentData(places);

        //Find the ListView object in the view hierarchy of the {@link Activity}.
        ExpandableListView expandableListView = (ExpandableListView) rootView.findViewById(R.id.ExpandableListView);

        //Create an PlaceAdapter, whose data source is a list of places.
        MyExpandableAdapter adapter = new MyExpandableAdapter(getActivity(), places);

        //Make the ListView use the PlaceAdapter
        expandableListView.setAdapter(adapter);

        return rootView;
    }



    /**
     * Method used to populate continent data
     * @param places
     */
    private ArrayList<Place> populateContinentData(ArrayList<Place> places) {

        Place museum1 = new Place(getResources().getString(R.string.royal_jewelry_museum), getResources().getString(R.string.royal_jewelry_museum_address), R.drawable.royal_jewelry_museum);
        ArrayList<Description> description1 = new ArrayList<>();
        description1.add(new Description(getResources().getString(R.string.description1)));
        museum1.setDescription(description1);
        places.add(museum1);


        Place museum2 = new Place(getResources().getString(R.string.alexandria_aquarium), getResources().getString(R.string.alexandria_aquarium_address), R.drawable.alexandria_aquarium);
        ArrayList<Description> description2 = new ArrayList<>();
        description2.add(new Description(getResources().getString(R.string.description2)));
        museum2.setDescription(description2);
        places.add(museum2);

        Place museum3 = new Place(getResources().getString(R.string.thegrecoroman_museum), getResources().getString(R.string.thegrecoroman_museum_address), R.drawable.the_greco_roman_museum);
        ArrayList<Description> description3 = new ArrayList<>();
        description3.add(new Description(getResources().getString(R.string.description3)));
        museum3.setDescription(description3);
        places.add(museum3);

        Place museum4 = new Place(getResources().getString(R.string.museum_of_fine_arts), getResources().getString(R.string.museum_of_fine_arts_address), R.drawable.museum_of_fine_arts);
        ArrayList<Description> description4 = new ArrayList<>();
        description4.add(new Description(getResources().getString(R.string.description4)));
        museum4.setDescription(description4);
        places.add(museum4);


        Place museum5 = new Place(getResources().getString(R.string.alexandria_national_museum), getResources().getString(R.string.alexandria_national_museum_address), R.drawable.alexandria_national_museum);
        ArrayList<Description> description5 = new ArrayList<>();
        description5.add(new Description(getResources().getString(R.string.description5)));
        museum5.setDescription(description5);
        places.add(museum5);


        Place museum6 = new Place(getResources().getString(R.string.museum_of_calligraphy), getResources().getString(R.string.museum_of_calligraphy_address), R.drawable.museum_of_calligraphy_alexandria);
        ArrayList<Description> description6 = new ArrayList<>();
        description6.add(new Description(getResources().getString(R.string.description6)));
        museum6.setDescription(description6);
        places.add(museum6);


        Place museum7 = new Place(getResources().getString(R.string.the_sadat_museum), getResources().getString(R.string.the_sadat_museum_address), R.drawable.the_sadat_museum);
        ArrayList<Description> description7 = new ArrayList<>();
        description7.add(new Description(getResources().getString(R.string.description7)));
        museum7.setDescription(description7);
        places.add(museum7);


        Place museum8 = new Place(getResources().getString(R.string.cavafy_museum), getResources().getString(R.string.cavafy_museum_address), R.drawable.cavafy_museum);
        ArrayList<Description> description8 = new ArrayList<>();
        description8.add(new Description(getResources().getString(R.string.description8)));
        museum8.setDescription(description8);
        places.add(museum8);

        return places;
    }

}

