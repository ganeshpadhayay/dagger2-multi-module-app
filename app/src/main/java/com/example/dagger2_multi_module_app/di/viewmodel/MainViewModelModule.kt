package com.example.dagger2_multi_module_app.di.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dagger2_multi_module_app.view.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun mainViewModel(viewModel: MainViewModel): ViewModel
}