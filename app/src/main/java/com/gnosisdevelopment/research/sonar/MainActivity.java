package com.gnosisdevelopment.research.sonar;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ultramegasoft.radarchart.RadarHolder;
import com.ultramegasoft.radarchart.RadarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //https://github.com/ultramega/android-radar-chart/blob/master/testapp/src/main/java/com/ultramegasoft/radarchart/testapp/MainActivity.java
    @NonNull
    private ArrayList<RadarHolder> mData = new ArrayList<RadarHolder>() {
        {
            add(new RadarHolder("Body", 3));
            add(new RadarHolder("Charcoal", 4));
            add(new RadarHolder("Oak", 4));
            add(new RadarHolder("Leather", 4));
            add(new RadarHolder("Spice", 2));
            add(new RadarHolder("Alcohol", 3));
            add(new RadarHolder("Astringent", 3));
            add(new RadarHolder("Linger", 4));
            add(new RadarHolder("Sweet", 2));
            add(new RadarHolder("Maple", 2));
            add(new RadarHolder("Fruit", 3));
            add(new RadarHolder("Vanilla", 2));
            add(new RadarHolder("Smoke", 1));
            add(new RadarHolder("Peat", 0));
            add(new RadarHolder("Nut", 1));
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        RadarView mRadarView = (RadarView)findViewById(R.id.radar);
        mRadarView.setData(mData);
        mRadarView.setInteractive(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
