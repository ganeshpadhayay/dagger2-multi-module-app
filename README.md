Using Dagger2(not dagger-android) in a Multi-Module app

WHAT IN THE HELL IS DAGGER-ANDROID?

Well, Dagger-Android is a library on top of Dagger 2 that is built specifically for Android to hide away some injection performed on Activity/Fragment.

Using Dagger-Android, you can easily set up the whole DI thing in your android app but when it comes to customising it for multi-module or dynamic-feature-module,
it becomes very cumbersome to manage. 

1. Good thing about the Dagger-Android is that you do not need to mention injections in Activities/Fragments but you still need to put AndroidInjection.inject(this) 
in your services, content providers and broadcast receivers. 

2. Other good point about it is you can handle scoping in a better way by telling what all dependencies/dagger module will be used in a particular activity, like this


@ContributesAndroidInjector(modules = [
        MainBindModule::class
 ])
 abstract fun mainActivity(): MainActivity
 
      
Here MainBindModule will have the dependencies which will be used in MainActivity like Fragments, Implementation of data particular to the MainActivity


@Module
public abstract class MainBindModule {

    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

    @ContributesAndroidInjector
    abstract MPINVerifyFragment customerMpin();

    @Binds
    abstract HomeRouter provideHomeRouter(HomeRouterImpl homeRouterImpl);

    @Binds
    abstract MainRouter provideMainRouter(MainRouterImpl mainRouter);
}


Although, when we deep dive into the multi-module or dynamic-feature-module, it becomes very difficult to manage Dagger as we have given the control to the framework, so in this project, I have implemented the conventional Dagger2 without using Dagger-Android.

It is a multi-module android project with app module, login module and a common base module, I have tried to include everything from Dagger like Components, Modules, Subcomponents, Named, Binds, Provides, Singleton, Scopes, Subcomponent Builder Factory etc.
