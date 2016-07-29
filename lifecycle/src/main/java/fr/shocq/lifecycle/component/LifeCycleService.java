package fr.shocq.lifecycle.component;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

import fr.shocq.lifecycle.lf.ServiceLifeCycle;

/**
 * Service that enable the use of ServiceLifeCycle
 */
public abstract class LifeCycleService extends Service {

    private Collection<ServiceLifeCycle> lifeCycleCollection = new ConcurrentLinkedQueue<>();

    protected void addLifeCycle(ServiceLifeCycle lifeCycle) {
        lifeCycleCollection.add(lifeCycle);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setupLifeCycles();
        for (ServiceLifeCycle lifeCycle : lifeCycleCollection) {
            lifeCycle.onCreate(this);
        }
    }

    protected void setupLifeCycles() {
        for (ServiceLifeCycle lifeCycle : lifeCycleCollection) {
            lifeCycle.onSetupLifeCycle();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        for (ServiceLifeCycle lifeCycle : lifeCycleCollection) {
            lifeCycle.onStartCommand(this);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        for (ServiceLifeCycle lifeCycle : lifeCycleCollection) {
            lifeCycle.onDestroy();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        for (ServiceLifeCycle lifeCycle : lifeCycleCollection) {
            lifeCycle.onBind();
        }
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        for (ServiceLifeCycle lifeCycle : lifeCycleCollection) {
            lifeCycle.onUnbind();
        }
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        for (ServiceLifeCycle lifeCycle : lifeCycleCollection) {
            lifeCycle.onRebind();
        }
    }

}
