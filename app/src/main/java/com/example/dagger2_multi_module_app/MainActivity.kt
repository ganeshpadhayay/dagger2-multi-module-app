package com.example.dagger2_multi_module_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var stringProvider: StringProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appComponent.inject(this)

        Toast.makeText(this, stringProvider.provideWelcomeMessage(), Toast.LENGTH_SHORT).show()

        buttonLoginActivity.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}