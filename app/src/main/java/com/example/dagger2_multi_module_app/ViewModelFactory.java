package com.example.dagger2_multi_module_app;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;

/***
 * There are basically two ways to inject this everywhere
 * 1. Constructor injection via @Inject on Constructor
 * 2. By making another Dagger Module for this or maybe putting its @Binds method in one of the Dagger Modules
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    @Inject
    Map<Class<? extends ViewModel>, ViewModel> vmHashMap;

    @Inject
    ViewModelFactory() {
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(vmHashMap.get(modelClass).getClass())) {
            return (T) vmHashMap.get(modelClass);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}