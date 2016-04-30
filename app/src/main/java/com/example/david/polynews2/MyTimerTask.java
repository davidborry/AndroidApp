package com.example.david.polynews2;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageSwitcher;

import java.util.TimerTask;

/**
 * Created by justin on 30/04/16.
 */
public class MyTimerTask extends TimerTask {
    private Activity activity;
    private ImageSwitcher sw;
    private int i;
    public MyTimerTask(Activity activity, ImageSwitcher sw){
        i = 0;
        this.activity = activity;
        this.sw = sw;
    }
    @Override
    public void run() {
        try{
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (i == 0)
                        sw.setImageResource(R.drawable.presentation1);
                    else if (i == 1) {
                        sw.setImageResource(R.drawable.presentation2);
                    } else if (i == 2) {
                        sw.setImageResource(R.drawable.presentation3);
                        i = -1;
                    }
                    i++;
                }
            });
        }

        catch(Exception e){
            Log.e("HomeFragment", "Error", e);
        }
    }
}
