package com.example.kazi.myprofile;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kazi on 1/31/2017.
 */

public class ActivityListAdapter extends RecyclerView.Adapter<ActivityListAdapter.MyViewHolder> {

    private List<Activities> activitiesList;
    private Context context;
    public ActivityListAdapter(List<Activities> activitiesList, Context context){
        this.activitiesList = activitiesList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.activity_row_item, parent, false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Activities activities = activitiesList.get(position);

        holder.txtActivityName.setText(activities.getActivityName());
        holder.activityRatings.setRating(activities.getRatings());

        if (activities.isActivityCompleted()){
            holder.btnDetails.setBackgroundColor(context.getResources().getColor(R.color.btnColorGreen));
            holder.imgActivityCompletionIndicator.setImageDrawable(context.getDrawable(R.drawable.activities_completed));
        }else{
            holder.btnDetails.setBackgroundColor(context.getResources().getColor(R.color.btnColorRed));
            holder.imgActivityCompletionIndicator.setImageDrawable(context.getDrawable(R.drawable.activities_not_completed));
        }


        if (position%2 != 0)
            holder.rowItemContainer.setBackgroundColor(context.getResources().getColor(R.color.oddItemRowColor));

    }

    @Override
    public int getItemCount() {
        return activitiesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtActivityName;
        RatingBar activityRatings;
        ImageView imgActivityCompletionIndicator;
        Button btnDetails;
        RelativeLayout rowItemContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtActivityName = (TextView) itemView.findViewById(R.id.txt_activity_name);
            activityRatings = (RatingBar) itemView.findViewById(R.id.activity_ratings);
            imgActivityCompletionIndicator = (ImageView) itemView.findViewById(R.id.img_activity_completion_indicator);
            btnDetails = (Button) itemView.findViewById(R.id.btn_details);
            rowItemContainer = (RelativeLayout) itemView.findViewById(R.id.row_item_container);
        }
    }
}
