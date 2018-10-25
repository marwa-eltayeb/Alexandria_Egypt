package com.example.marwa.alexandriaegypt.adapters;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.speech.tts.TextToSpeech;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marwa.alexandriaegypt.models.Description;
import com.example.marwa.alexandriaegypt.models.Place;
import com.example.marwa.alexandriaegypt.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Marwa on 10/13/2018.
 */

public class MyExpandableAdapter implements ExpandableListAdapter {


    private Context context = null;
    private ArrayList<Place> museums;

    public MyExpandableAdapter(Context context, ArrayList<Place> data) {
        this.context = context;

        this.museums = new ArrayList<Place>();
        this.museums.addAll(data);
    }


    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return museums.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return museums.get(groupPosition).getDescription().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final Place place = museums.get(groupPosition);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.museum_row, parent, false);
        }

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView name = (TextView) convertView.findViewById(R.id.name_text_view);
        // Get the name of the place from the currentPlace object and set this text on name.
        name.setText(place.getPlaceName());

        //It is used to speak the name of the place
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech(place.getPlaceName());
            }
        });


        // Find the TextView in the list_item.xml layout with the ID address_text_view.
        TextView address = (TextView) convertView.findViewById(R.id.address_text_view);
        // Get the address of the place from the currentPlace object and set this text on address.
        address.setText(place.getPlaceAddress());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image_view);
        final int image = place.getImageResourceId();

        // Check if an image is provided for that place or not
        if (place.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(place.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView
            imageView.setVisibility(View.GONE);
        }


        ImageView map = (ImageView) convertView.findViewById(R.id.image_map);


        // Zoom the image when the user clicks on it
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Take This Screen Height and width
                DisplayMetrics display = new DisplayMetrics();
                // Find this screen
                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(display);
                // Get height
                int height = display.heightPixels;
                // Get width
                int width = display.widthPixels;
                // Now make inflater
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // Inflate layout take my layout id , id of layout that have ImageView
                View sub_layout = inflater.inflate(R.layout.zoom_layout, (ViewGroup) ((Activity) context).findViewById(R.id.layout));
                // Get reference to the ImageView
                ImageView img = (ImageView) sub_layout.findViewById(R.id.zoom_image);
                // Set image
                img.setImageResource(image);
                // Set height of image is height from DisplayMetrics Full Screen
                img.setMinimumHeight(height);
                // Set width of image is width from DisplayMetrics Full Screen
                img.setMinimumWidth(width);
                img.setMaxHeight(height);
                img.setMaxWidth(width);
                // Show this sub_layout in Toast
                Toast toast = new Toast(context.getApplicationContext());
                // Set view
                toast.setView(sub_layout);
                // Show this toast
                toast.show();
            }
        });


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Description description = museums.get(groupPosition).getDescription().get(childPosition);

        if (convertView  == null) {
            convertView  = LayoutInflater.from(context).inflate(R.layout.description_row, parent, false);
        }

        TextView tvCountryName = (TextView) convertView .findViewById(R.id.description_text_view);
        tvCountryName.setText(description.getDescription());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (museums.size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return childId;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return groupId;
    }


    private TextToSpeech tts;

    private void textToSpeech(final String text) {
        // Initialize the TextToSpeech Variable.
        tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // TTS is successfully initialized
                if (status == TextToSpeech.SUCCESS) {
                    // Set speech language
                    int result = tts.setLanguage(Locale.US);
                    // If your device does not support language you set above
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(context, "Language not supported", Toast.LENGTH_SHORT).show();
                        // Otherwise the language is supported.
                    } else {
                        // If there is no text, speak "no text".
                        if (text == null || "".equals(text)) {
                            tts.speak("no Text", TextToSpeech.QUEUE_FLUSH, null);
                        } else {
                            // Otherwise there ia a text, speak it.
                            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                        }
                    }
                }
            }
        });
    }





}



