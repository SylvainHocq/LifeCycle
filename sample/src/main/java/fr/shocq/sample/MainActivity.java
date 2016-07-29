package fr.shocq.sample;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import fr.shocq.lifecycle.component.LifeCycleActivity;

public class MainActivity extends LifeCycleActivity {

    @Override
    protected void onSetupLifeCycles() {
        super.onSetupLifeCycles();
        addLifeCycle(new LogLifeCycle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
