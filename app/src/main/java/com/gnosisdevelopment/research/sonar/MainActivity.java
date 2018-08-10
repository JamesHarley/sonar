package com.gnosisdevelopment.research.sonar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;

import com.ultramegasoft.radarchart.RadarEditWidget;
import com.ultramegasoft.radarchart.RadarHolder;
import com.ultramegasoft.radarchart.RadarView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RadarView mRadarView;
    private Animation mEditInAnimation;


    /**
     * The data for the RadarView
     */
    @NonNull
    private ArrayList<RadarHolder> mData = new ArrayList<RadarHolder>() {
        {
            add(new RadarHolder("wall-1", 3));
            add(new RadarHolder("wall-2", 4));
            add(new RadarHolder("obstacle-1", 4));
            add(new RadarHolder("obstacle-2", 4));
            add(new RadarHolder("person-1", 2));

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.video);
        webView.loadUrl("http://192.168.254.18/html/cam_pic_new.php?time=1533660523032&pDelay=40000");
        // Find the views in the layout.
        mRadarView = findViewById(R.id.radar);

        // Set the data for the RadarView to display.
        mRadarView.setData(mData);
        final Button bb = findViewById(R.id.up);
        mEditInAnimation = AnimationUtils.loadAnimation(this, R.anim.flavor_edit_out);
        bb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //upaction
                bb.startAnimation(mEditInAnimation);
            }
        });

        webView.setBackgroundColor(Color.TRANSPARENT);


        // Load the animations.
        //mEditInAnimation = AnimationUtils.loadAnimation(this, R.anim.flavor_edit_in);
        //mEditOutAnimation = AnimationUtils.loadAnimation(this, R.anim.flavor_edit_out);
    }

    /**
     * Enable or disable interactive mode.
     *
     * @param editMode Whether to enable interactive mode
    private void setEditMode(boolean editMode) {
        if(editMode == mRadarView.isInteractive()) {
            return;
        }

        if(editMode) {
            // Enable interactive mode.
            mRadarView.setInteractive(true);

            // Show the RadarEditWidget.
            mEditWidget.startAnimation(mEditInAnimation);
            mEditWidget.setVisibility(View.VISIBLE);
        } else {
            // Disable interactive mode.
            mRadarView.setInteractive(false);

            // Hide the RadarEditWidget.
            mEditWidget.startAnimation(mEditOutAnimation);
            mEditWidget.setVisibility(View.GONE);
        }
    }     */

}
