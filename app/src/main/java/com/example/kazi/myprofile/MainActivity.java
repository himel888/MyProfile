package com.example.kazi.myprofile;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listOfActivity;
    private ActivityListAdapter activityListAdapter;
    private Activities activities;
    private List<Activities> activitiesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listOfActivity = (RecyclerView) findViewById(R.id.activity_list);
        listOfActivity.setLayoutManager(layoutManager);
        listOfActivity.setItemAnimator(new DefaultItemAnimator());
        populateActivitiesList();
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

    }

    private void populateActivitiesList(){
        activitiesList = new ArrayList<>();

        for (int i = 0; i < 10; i++){

            if (i%2 == 0){
                Activities activities = new Activities("Activity " + i, (float)(i)/2, true);
                activitiesList.add(activities);
            }else{
                Activities activities = new Activities("Activity " + i, (float)(i)/2, false);
                activitiesList.add(activities);
            }

        }
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
}
