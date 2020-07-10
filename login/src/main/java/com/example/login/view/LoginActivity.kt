package com.example.login.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.login.R
import com.example.login.ViewModelFactory
import com.example.login.di.LoginComponent
import com.example.login.di.LoginComponentProvider
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var loginViewModelFactory: ViewModelFactory

    private lateinit var loginComponent: LoginComponent

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginComponent = (applicationContext as LoginComponentProvider).provideLoginComponent()

        loginComponent.inject(this)

        loginViewModel = ViewModelProviders.of(this, loginViewModelFactory).get(LoginViewModel::class.java)

        loginViewModel.loginMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        loginViewModel.observeLoginMessage()
    }
}