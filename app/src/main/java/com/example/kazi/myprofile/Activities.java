package com.example.kazi.myprofile;

/**
 * Created by Kazi on 1/31/2017.
 */
public class Activities {

    private String activityName;
    private float ratings;
    private boolean isActivityCompleted;

    public Activities(String activityName, float ratings, boolean isActivityCompleted) {
        this.activityName = activityName;
        this.ratings = ratings;
        this.isActivityCompleted = isActivityCompleted;
    }

    public String getActivityName() {
        return activityName;
    }

    public float getRatings() {
        return ratings;
    }

    public boolean isActivityCompleted() {
        return isActivityCompleted;
    }

}
