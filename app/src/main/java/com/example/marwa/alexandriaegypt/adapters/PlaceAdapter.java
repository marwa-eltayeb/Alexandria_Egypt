package com.example.marwa.alexandriaegypt.adapters;

import android.app.Activity;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marwa.alexandriaegypt.Place;
import com.example.marwa.alexandriaegypt.R;

import java.util.ArrayList;
import java.util.Locale;

public class PlaceAdapter extends ArrayAdapter<Place> {

    /**
     * Create a new {@link PlaceAdapter} object.
     * @param context is the current context (i.e. Activity) that the adapter
     * is being created in.
     * @param places  is the list of {@link Place}s to be displayed.
     */
    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        final Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView name = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the name of the place from the currentPlace object and set this text on name.
        name.setText(currentPlace.getPlaceName());

        //It is used to speak the name of the place
        LinearLayout layout = (LinearLayout) listItemView.findViewById(R.id.parent_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech(currentPlace.getPlaceName());
            }
        });

        // Find the TextView in the list_item.xml layout with the ID address_text_view.
        TextView address = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the address of the place from the currentPlace object and set this text on address.
        address.setText(currentPlace.getPlaceAddress());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        final int image = currentPlace.getImageResourceId();

        // Check if an image is provided for that place or not
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView
            imageView.setVisibility(View.GONE);
        }

        // Zoom the image when the user clicks on it
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Take This Screen Height and width
                DisplayMetrics display = new DisplayMetrics();
                // Find this screen
                ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(display);
                // Get height
                int height = display.heightPixels;
                // Get width
                int width = display.widthPixels;
                // Now make inflater
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // Inflate layout take my layout id , id of layout that have ImageView
                View sub_layout = inflater.inflate(R.layout.zoom_layout, (ViewGroup) ((Activity) getContext()).findViewById(R.id.layout));
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
                Toast toast = new Toast(getContext().getApplicationContext());
                // Set view
                toast.setView(sub_layout);
                // Show this toast
                toast.show();
            }
        });

        // Return the whole list item layout (containing 2 TextViews & 1 ImageView)
        // so that it can be shown in the ListView.
        return listItemView;
    }

    private TextToSpeech tts;

    private void textToSpeech(final String text) {
        // Initialize the TextToSpeech Variable.
        tts = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // TTS is successfully initialized
                if (status == TextToSpeech.SUCCESS) {
                    // Set speech language
                    int result = tts.setLanguage(Locale.US);
                    // If your device does not support language you set above
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(getContext(), "Language not supported", Toast.LENGTH_SHORT).show();
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
