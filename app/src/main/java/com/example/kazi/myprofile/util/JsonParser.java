package com.example.kazi.myprofile.util;

import android.content.Context;
import android.util.Log;

import com.example.kazi.myprofile.model.Activities;
import com.example.kazi.myprofile.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kazi on 1/31/2017.
 */

public class JsonParser {

    private Context context;
    private JSONObject jsonObject;
    private JSONObject userObject;
    private JSONArray activitiesArray;
    private User user;
    private List<Activities> activitiesList;
    private int pendingActivities = 0;
    private double score = 0;

    public JsonParser(Context context){
        this.context = context;
        try {
            jsonObject = new JSONObject(loadJSONFromAsset());
            Log.i("myJson", jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUser() {

        try {
            userObject = jsonObject.getJSONObject("user");
            user = new User(userObject.getString("name"),
                    userObject.getString("address"),
                    userObject.getString("mail"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<Activities> getActivitiesList() {

        activitiesList = new ArrayList<>();

        try {
            activitiesArray = jsonObject.getJSONArray("activities");
            Log.d("activitiesArray", activitiesArray.toString());
            for (int i = 0; i < activitiesArray.length(); i++){

                JSONObject activitiesObject = activitiesArray.getJSONObject(i);
                String activityName = activitiesObject.getString("activityName");
                float activityRating = (float)activitiesObject.getDouble("activityRating");
                score += activityRating;
                Boolean isCompleted = activitiesObject.getBoolean("isCompleted");
                if (!isCompleted)
                    pendingActivities += 1;
                activitiesList.add(new Activities(activityName,
                        activityRating,
                        isCompleted));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return activitiesList;
    }

    public int getTotalActivities(){

        return activitiesArray.length();
    }

    public int getPendingActivities(){
        return pendingActivities;
    }

    public double getScore(){
        return score/activitiesArray.length();
    }

    public String loadJSONFromAsset() throws IOException {
        String json = null;
        try {
            InputStream is = context.getAssets().open("myProfileJson.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
