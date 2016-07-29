package fr.shocq.sample.lf;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.SoftReference;

@SuppressWarnings("unused")
public abstract class ActivityLifeCycle<ActivityOrFragment extends Object> {

    @SuppressWarnings("unused")
    private static final String TAG = "LifeCycleHandler";

    private SoftReference<ActivityOrFragment> activityOrFragment;

    public void onSetupLifeCycles(ActivityOrFragment activity) {
    }

    public void onCreate(ActivityOrFragment activityOrFragment, Bundle savedInstanceState) {
        this.activityOrFragment = new SoftReference<ActivityOrFragment>(activityOrFragment);
    }

    public Activity getActivity() {
        ActivityOrFragment activityOrFragment2 = getActivityOrFragment();
        if (activityOrFragment2 instanceof Activity) {
            return (Activity)activityOrFragment2;
        } else if (activityOrFragment2 instanceof Fragment) {
            return ((Fragment)activityOrFragment2).getActivity();
        }
        return null;
    }

    public ActivityOrFragment getActivityOrFragment() {
        if (activityOrFragment != null) {
            return activityOrFragment.get();
        } else {
            return null;
        }
    }

    public View onCreateView(ActivityOrFragment fragment, LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return null;
    }

    public void onPostCreate(ActivityOrFragment activity, Bundle savedInstanceState) {
    }

    public void onStart(ActivityOrFragment activity) {
    }

    public void onRestart(ActivityOrFragment activity) {
    }

    public void onResume(ActivityOrFragment activity) {
    }

    public void onPostResume(ActivityOrFragment activity) {
    }

    public void onPause(ActivityOrFragment activity) {
    }

    public void onStop(ActivityOrFragment activity) {
    }

    public void onDestroy(ActivityOrFragment activity) {
    }

    public void onSaveInstanceState(ActivityOrFragment activity, Bundle outState) {
    }

    public void onRestoreInstanceState(ActivityOrFragment activity, Bundle savedInstanceState) {
    }

    public void onConfigurationChanged(ActivityOrFragment activity, Configuration newConfig) {
    }

    public void onContentChanged(ActivityOrFragment activity) {
    }

    public void onDetach(ActivityOrFragment baseFragment) {
    }

    public void onAttach(ActivityOrFragment baseFragment) {

    }

    public void onNewIntent(ActivityOrFragment baseFragment, Intent intent) {

    }

    public void onActivityCreated(Fragment baseFragment, Bundle savedInstanceState) {
        // TODO Auto-generated method stub

    }
}
