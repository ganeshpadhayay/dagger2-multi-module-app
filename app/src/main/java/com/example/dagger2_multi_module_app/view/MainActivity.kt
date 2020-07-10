package com.example.dagger2_multi_module_app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.dagger2_multi_module_app.MyApplication
import com.example.dagger2_multi_module_app.R
import com.example.dagger2_multi_module_app.ViewModelFactory
import com.example.login.view.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/***
 * Note: Field injection should only be used in Android framework classes where constructor injection cannot be used.
 * We can't have constructor injections in our activities/fragments so we should use field injection here and in other custom
 * classes we should be using constructor injection
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appViewModelFactory: ViewModelFactory

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appComponent.inject(this)

        mainViewModel = ViewModelProviders.of(this, appViewModelFactory).get(MainViewModel::class.java)

        mainViewModel.observeWelcomeMessage().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        buttonLoginActivity.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}