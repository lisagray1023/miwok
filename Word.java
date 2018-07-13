package com.example.android.miwok;

/**
 * Created by lisa.gray on 6/13/18.
 * Word represents a vocabulary word that hte user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word {

     /** Default translation for the word*/
     private String mDefaultTranslation;

     /** Miwok translation for the word */
     private String mMiwokTranslation;

     /** Image associated with each word */
     private int mImageResourceId = NO_IMAGE_PROVIDED;

     private static final int NO_IMAGE_PROVIDED = -1;

    /** Audioi resource ID for the word */
     private int mAudioResourceID;

    /**
     * Create a new Word object.
     * @param defaultTranslation is the word in a alanguage that the user is already familar with (Such as English)
     * @param  miwokTranslation is the word in the Miwok language
     * @param audioResourceID is the audio filed associated with the word
     */

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceID = audioResourceID;
    }

    /**
     * Create a new Word object.
     * @param defaultTranslation is the word in a alanguage that the user is already familar with (Such as English)
     * @param  miwokTranslation is the word in the Miwok language
     * @param imageResourceId is the resource ID for the image associated with the word
     * @param audioResourceID is the audio filed associated with the word
     */

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceID = audioResourceID;
    }

    /**
     * Get the default translation of the word.
     */

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the Image Resource id for the image associated with the word.
     */

    public int getImageResourceId() {return mImageResourceId;}


    /**
     * Returns whether or not there is an image for this word
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**Returns resource ID associated with audio file for word object*/
    public int getAudioResourceID(){return mAudioResourceID; }


    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceID=" + mAudioResourceID +
                '}';
    }
}
