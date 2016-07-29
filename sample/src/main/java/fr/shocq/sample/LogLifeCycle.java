package fr.shocq.sample;

import android.util.Log;

import fr.shocq.lifecycle.lf.LifeCycle;

public class LogLifeCycle extends LifeCycle {
    private static final String TAG = LogLifeCycle.class.getSimpleName();

    @Override
    public void onResume(Object activity) {
        super.onResume(activity);
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause(Object activity) {
        super.onPause(activity);
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStart(Object activity) {
        super.onStart(activity);
        Log.d(TAG, "onStart");
    }

    @Override
    public void onStop(Object activity) {
        super.onStop(activity);
        Log.d(TAG, "onStop");
    }
}
