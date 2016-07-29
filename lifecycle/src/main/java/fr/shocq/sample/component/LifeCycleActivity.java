package fr.shocq.sample.component;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

import fr.shocq.sample.lf.LifeCycle;


public class LifeCycleActivity extends AppCompatActivity {

    private Collection<LifeCycle> lifeCycles = new ConcurrentLinkedQueue<LifeCycle>();

    public final void addLifeCycle(LifeCycle lifeCycle) {
        lifeCycles.add(lifeCycle);
    }

    public final void addLifeCycle(LifeCycle... lifeCycles) {
        this.lifeCycles.addAll(Arrays.asList(lifeCycles));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.onSetupLifeCycles(); // call subclasses to give them a chance to setup some s
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onCreate(this, savedInstanceState);
        }
    }

    protected void onSetupLifeCycles() {

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onPostCreate(this, savedInstanceState);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onConfigurationChanged(this, newConfig);
        }
    }

    @Override
    protected void onStop() {
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onStop(this);
        }
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onPostResume(this);
        }
    }

    @Override
    protected void onDestroy() {
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onDestroy(this);
        }
        super.onDestroy();
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onContentChanged(this);
        }
    }

    @Override
    protected void onPause() {
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onPause(this);
        }
        super.onPause();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onNewIntent(this, intent);
        }
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onResume(this);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onSaveInstanceState(this, outState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onStart(this);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onRestoreInstanceState(this, savedInstanceState);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        for (LifeCycle lifeCycle : lifeCycles) {
            lifeCycle.onRestart(this);
        }
    }
}
