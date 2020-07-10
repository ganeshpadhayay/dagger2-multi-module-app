package com.example.login.view

import androidx.lifecycle.ViewModel

/***
 * So, basically we have 4 ways to inject dependencies in a ViewModel
 * 1. We inject the dependencies in out Activities/Fragments and pass those to our CustomViewModelFactory to create our ViewModel with
 * those dependencies(basically an indirect way of doing constructor injection)--->not preferred as we do not want our views to know
 * what dependencies are in our ViewModels.
 *
 * 2. We can use Map/MultiBinding to achieve the ViewModel injection--->Almost everyone is doing it but it involves boilerplate also
 *
 * 3. We can used field injection into our ViewModel like any other normal class but for this we need to declare self injection either
 * in init block of ViewModel itself or in view by doing appComponent.inject(viewModel), in this way we can directly field-inject
 * ViewModel in our views and other dependencies in our ViewModel without the need of Factory-----> less boilerplate but not a preferred
 * way because it involves injection declaration in Views.
 *
 * 4. Using a simple ServiceLocator class-->involves manual DI approach so advisable for small projects but not for big size projects
 */
class LoginViewModel : ViewModel() {

}