package com.example.dagger2_multi_module_app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.base.BaseRepository
import com.example.base.ExternalCommonDataRepository
import com.example.login.view.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //this belongs to the app module
    @Inject
    lateinit var stringProvider: StringProvider

    //these belong to the base module
    @Inject
    lateinit var baseRepository: BaseRepository

    @Inject
    lateinit var externalCommonDataRepository: ExternalCommonDataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appComponent.inject(this)

        Toast.makeText(this, stringProvider.provideWelcomeMessage() + "-" + baseRepository.getBaseURL() + "-" + externalCommonDataRepository.getExternalCommonAPIURL(), Toast.LENGTH_SHORT).show()

        buttonLoginActivity.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}