package com.example.android.tourguide;

/**
 * {@link Location} represents a location to show in app. It contains a title, a description, an address and an image (if applicable)
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

    /**
     * Address of the location
     */
    private String mLocationAddress;

    /**
     * Image resource ID for the location
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;


    /**
     * Create a new Location object.
     *
     * @param locationTitle is the name of the location
     * @param locationDescription is the description of the location, if applicable
     * @param locationAddress is the address of the location
     */
    public Location(String locationTitle, String locationDescription, String locationAddress) {
        // Check if there is no description. If not, then set the description to the address
        if (locationDescription.equals("")) {
            locationDescription = locationAddress;
        }
        mLocationTitle = locationTitle;
        mLocationDescription = locationDescription;
        mLocationAddress = locationAddress;
    }

    /**
     * Create a new Location object.
     * @param locationTitle is the name of the location
     * @param locationDescription is the description of the location, if applicable
     * @param locationAddress is the address of the location
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Location(String locationTitle, String locationDescription, String locationAddress, int imageResourceId) {
        // Check if there is no description. If not, then set the description to the address
        if (locationDescription.equals("")) {
            locationDescription = locationAddress;
        }
        mLocationTitle = locationTitle;
        mLocationDescription = locationDescription;
        mImageResourceId = imageResourceId;
        mLocationAddress = locationAddress;
    }

    /**
     * Get the title of the location
     */
    public String getLocationTitle() {
        return mLocationTitle;
    }

    /**
     * Get the description of the location
     */
    public String getLocationDescription() {
        return mLocationDescription;
    }

    /**
     * Get the address of the location
     */
    public String getLocationAddress() {
        return mLocationAddress;
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


}