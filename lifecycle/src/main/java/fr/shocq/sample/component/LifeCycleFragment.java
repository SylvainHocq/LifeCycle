package fr.shocq.sample.component;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.LinkedHashSet;
import java.util.Set;

import fr.shocq.sample.lf.LifeCycle;

public class LifeCycleFragment extends Fragment {
    /**
     * Internal list of LifeCycleHanlders to call on each callback
     */
    private Set<LifeCycle<Fragment>> lifeCycleList = new LinkedHashSet<LifeCycle<Fragment>>();

    /**
     * <p>Add a new LifeCycle to this Fragment.
     * </p><p><strong>Only call this method in the {@link #onSetupLifeCycles()} method.</strong>
     * </p><p><strong>Also note that your LifeCycles will be called in the order you added them.</strong>
     * </p>
     *
     * @param lifeCycle the {@link LifeCycle} to add.
     * @see #onSetupLifeCycles()
     */
    public final void addLifeCycle(LifeCycle<Fragment> lifeCycle) {
        lifeCycleList.add(lifeCycle);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onAttach(this);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.onSetupLifeCycles();
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            //lifeCycle.setActivityOrFragment(this);
            lifeCycle.onCreate(this, savedInstanceState);
        }
    }

    /**
     * Override this method to add LifeCycle to your Fragment. Do nothing by default
     *
     * @see #addLifeCycle(LifeCycle)
     */
    protected void onSetupLifeCycles() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onCreateView(this, inflater, container, savedInstanceState);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onActivityCreated(this, savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onStart(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onResume(this);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onSaveInstanceState(this, outState);
        }
    }

    @Override
    public void onPause() {
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onPause(this);
        }
        super.onPause();
    }

    @Override
    public void onStop() {
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onStop(this);
        }
        super.onStop();
    }

    @Override
    public void onDestroy() {
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onDestroy(this);
        }
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        for (LifeCycle<Fragment> lifeCycle : lifeCycleList) {
            lifeCycle.onDetach(this);
        }
        super.onDetach();
    }

}
