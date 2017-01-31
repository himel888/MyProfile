package com.example.kazi.myprofile;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.kazi.myprofile.adapter.ActivityListAdapter;
import com.example.kazi.myprofile.model.Activities;
import com.example.kazi.myprofile.model.User;
import com.example.kazi.myprofile.util.JsonParser;

import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listOfActivity;
    private TextView txtUserName, txtUserLocation, txtUserMail;
    private TextView txtTotalActivity, txtPendingActivity, txtMyScore;
    private FloatingActionButton btnTakePicture, btnEditProfile;


    private ActivityListAdapter activityListAdapter;
    private Activities activities;
    private List<Activities> activitiesList;
    private JSONObject jsonObject;
    private User user;

    private int totalActivity;
    private int pendingActivity;
    private double score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initComponent();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listOfActivity = (RecyclerView) findViewById(R.id.activity_list);
        listOfActivity.setLayoutManager(layoutManager);
        listOfActivity.setItemAnimator(new DefaultItemAnimator());



        JsonParser jsonParser = new JsonParser(getApplicationContext());
        activitiesList = jsonParser.getActivitiesList();
        Log.d("activitiesList",activitiesList.toString());
        user = jsonParser.getUser();

        totalActivity = jsonParser.getTotalActivities();
        pendingActivity = jsonParser.getPendingActivities();
        score = jsonParser.getScore();

        txtUserName.setText(user.getUserName());
        txtUserLocation.setText(user.getUserLocation());
        txtUserMail.setText(user.getUserMail());

        txtTotalActivity.setText(String.valueOf(totalActivity));
        txtPendingActivity.setText(String.valueOf(pendingActivity));
        txtMyScore.setText(new DecimalFormat("##.#").format(score));

        activityListAdapter = new ActivityListAdapter(activitiesList, getApplicationContext());
        listOfActivity.setAdapter(activityListAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Picture should capture", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Edit information process should run", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initComponent(){
        txtUserName = (TextView) findViewById(R.id.txt_user_name);
        txtUserLocation = (TextView) findViewById(R.id.txt_location);
        txtUserMail = (TextView) findViewById(R.id.txt_mail_id);
        txtTotalActivity = (TextView) findViewById(R.id.txt_total_activity);
        txtPendingActivity = (TextView) findViewById(R.id.txt_total_pending_activity);
        txtMyScore = (TextView) findViewById(R.id.txt_total_my_score);
        btnTakePicture = (FloatingActionButton) findViewById(R.id.btn_take_pic);
        btnEditProfile = (FloatingActionButton) findViewById(R.id.floatingBtn_edit_info);
    }


}
