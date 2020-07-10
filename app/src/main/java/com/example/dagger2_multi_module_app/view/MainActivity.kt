package com.example.dagger2_multi_module_app.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.base.BaseRepository
import com.example.base.ExternalCommonDataRepository
import com.example.base.data.UserRepository
import com.example.dagger2_multi_module_app.MyApplication
import com.example.dagger2_multi_module_app.R
import com.example.dagger2_multi_module_app.StringProvider
import com.example.login.view.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

/***
 * Note: Field injection should only be used in Android framework classes where constructor injection cannot be used.
 * We can't have constructor injections in our activities/fragments so we should use field injection here and in other custom
 * classes we should be using constructor injection
 */
class MainActivity : AppCompatActivity() {

    //this belongs to the app module
    @Inject
    lateinit var stringProvider: StringProvider

    //these belong to the base module
    @Inject
    lateinit var baseRepository: BaseRepository

    @Inject
    lateinit var externalCommonDataRepository: ExternalCommonDataRepository

    @Inject
    @Named("local")
    lateinit var localUserRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApplication).appComponent.inject(this)

        Toast.makeText(
            this,
            stringProvider.provideWelcomeMessage() + "-" + baseRepository.getBaseURL() + "-" + externalCommonDataRepository.getExternalCommonAPIURL() + "-" + localUserRepository.getUserName() + "-" + localUserRepository.getUserAge(),
            Toast.LENGTH_SHORT
        ).show()

        buttonLoginActivity.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}