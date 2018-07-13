package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

/**
 * Created by lisa.gray on 6/14/18.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
    +     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }

            //Get the Word object located at this poistion in the list
            Word currentWord = getItem(position);

            //Find the TExtView int he list_item.xml layout with the ID miwok_text_view
            TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
            //Get the miwok translation from the current Word object and set this text on the TextView
            miwokTextView.setText(currentWord.getMiwokTranslation());

            //Find the TextView in the list_item.xml layout with the ID default_text_view
            TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
            //Get the default translation from the current Word object and set this text on the TextView
            defaultTextView.setText(currentWord.getDefaultTranslation());

            //Find the ImageView in the list_item.xml layout with the ID image
            ImageView image = (ImageView) listItemView.findViewById(R.id.image);

            if(currentWord.hasImage()) {
                //Get the image from the current Word object and set this image on the ImageView
                image.setImageResource(currentWord.getImageResourceId());
                //Make sure the view is visible
                image.setVisibility(View.VISIBLE);
            }
            else{
                //Otherwise hide the ImageView (Set visibility to GONE so it doesn't take up space)
                image.setVisibility(View.GONE);
            }

            //Set the correct background color
            View textContainer = listItemView.findViewById(R.id.text_container);
            //Find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
            //Set the background color of the text container View
            textContainer.setBackgroundColor(color);


            //Return the whole list item layout containing 2 TextViews + 1 ImageView so that it can be shown in the ListView
            return listItemView;
        }
    }



