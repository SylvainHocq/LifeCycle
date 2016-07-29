package fr.shocq.sample.lf;

import android.app.Service;

import java.lang.ref.WeakReference;

public abstract class ServiceLifeCycle {
    private WeakReference<Service> serviceReference;

    public Service getService() {
        Service service = null;

        if (serviceReference != null) {
            service = serviceReference.get();
        }
        return service;
    }

    public void onSetupLifeCycle() {

    }

    public void onCreate(Service service) {
        serviceReference = new WeakReference<>(service);
    }

    public void onDestroy() {

    }

    public void onUnbind() {

    }

    public void onRebind() {
        onBind();
    }

    public void onBind() {

    }

    public void onStartCommand(Service service) {

    }
}
