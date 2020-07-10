package com.example.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.di.LoginComponent
import com.example.login.di.LoginComponentProvider
import com.example.login.repository.LoginRepository
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var loginRepository: LoginRepository

    private lateinit var loginComponent: LoginComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginComponent = (applicationContext as LoginComponentProvider).provideLoginComponent()!!

        loginComponent.inject(this)

        Toast.makeText(this, loginRepository.getStringFromLoginRepository(), Toast.LENGTH_SHORT).show()
    }
}