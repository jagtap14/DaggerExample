package com.puretech.daggerexample.dagger2;

import com.puretech.daggerexample.MainActivity;
import com.puretech.daggerexample.util.GetRatrifit;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    public void inject(MainActivity activity);
    public void inject (GetRatrifit getRatrifit);
}
