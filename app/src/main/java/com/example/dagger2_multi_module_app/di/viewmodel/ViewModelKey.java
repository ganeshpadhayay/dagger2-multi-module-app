package com.example.dagger2_multi_module_app.di.viewmodel;

import androidx.lifecycle.ViewModel;

import dagger.MapKey;

@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}