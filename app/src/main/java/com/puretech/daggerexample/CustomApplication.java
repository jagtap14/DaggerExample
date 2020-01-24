package com.puretech.daggerexample;

import android.app.Application;

import com.puretech.daggerexample.dagger2.DaggerNetworkComponent;
import com.puretech.daggerexample.dagger2.NetworkComponent;
import com.puretech.daggerexample.dagger2.NetworkModule;
import com.puretech.daggerexample.util.Constant;

public class CustomApplication extends Application {

    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.baseurl)).build();

    }

    public NetworkComponent getNetworkComponent(){
        return networkComponent;
    }
}
