package com.example.chaohan.onefamily;

import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.MapView;

public class MainPageActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private Button mHelp, mProfile;

    private MapView mapView;

    private boolean floatClick;

    private FrameLayout mainFrame;

//    private NeighborActivity neighborActivity;
//    private FeedsActivity feedsActivity;
//    private TaskAndEventActivity taskAndEventActivity;
//    private FriendsActivity friendsActivity;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            LayoutInflater layoutInflater = (LayoutInflater)
//                    mainFrame.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View view;
            Intent nextScreen;
            switch (item.getItemId()) {
                case R.id.navigation_feeds:
                    nextScreen = new Intent(MainPageActivity.this,FeedsActivity.class);
                    startActivity(nextScreen);
                    return true;
                case R.id.navigation_task_and_event:
                    nextScreen = new Intent(MainPageActivity.this,FeedsActivity.class);
                    startActivity(nextScreen);
                    return true;
                case R.id.navigation_my_neighbor:
                    nextScreen = new Intent(MainPageActivity.this,FeedsActivity.class);
                    startActivity(nextScreen);
                    return true;
                case R.id.navigation_friends:
                    nextScreen = new Intent(MainPageActivity.this,FeedsActivity.class);
                    startActivity(nextScreen);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

//        feedsActivity = new FeedsActivity();
//        taskAndEventActivity = new TaskAndEventActivity();
//        neighborActivity = new NeighborActivity();
//        friendsActivity = new FriendsActivity();
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View decorView = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

        mainFrame = (FrameLayout) findViewById(R.id.mainPageFrame);
        mapView = (MapView) findViewById(R.id.mapView);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.getMenu().getItem(3).setChecked(true);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout linearLayout = (LinearLayout) findViewById(R.id.popupButtons);
                if (linearLayout.getVisibility() == View.INVISIBLE) {
                    linearLayout.setVisibility(View.VISIBLE);
                } else {
                    linearLayout.setVisibility(View.INVISIBLE);
                }

            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.locFloating);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mHelp = (Button) findViewById(R.id.main_help_button);
        mProfile = (Button) findViewById(R.id.main_profile_button);

        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent
                        (MainPageActivity.this, ProfileActivity.class);
                startActivity(nextScreen);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}