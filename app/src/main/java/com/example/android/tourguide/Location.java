package com.example.android.tourguide;

/**
 * Created by me74 on 30.05.2017.
 */

/**
 * {@link Location} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Miwok translation, and an image for that word.
 */
public class Location {

    /**
     * Constant value that represents no image was provided for this object
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Title of the location */
    private String mLocationTitle;

    /** Desciption of the location */
    private String mLocationDescription;

    /** Audio resource ID for the word */
    private int mAudioResourceId;
    /**
     * Image resource ID for the location
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new Location object.
     *
     * @param locationDescription is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param locationTitle is the word in the Miwok language
     * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    public Location(String locationTitle, String locationDescription, int audioResourceId) {
        mLocationTitle = locationTitle;
        mLocationDescription = locationDescription;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Location object.
     *
     * @param locationDescription is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param locationTitle is the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     * @param audioResourceId is the resource ID for the audio file associated with this word
     */
    public Location(String locationTitle, String locationDescription, int imageResourceId,
                    int audioResourceId) {
        mLocationTitle = locationTitle;
        mLocationDescription = locationDescription;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }


    /**
     * Get the Miwok translation of the word.
     */
    public String getLocationTitle() {
        return mLocationTitle;
    }

    /**
     * Get the default translation of the word.
     */
    public String getLocationDescription() {
        return mLocationDescription;
    }


    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}