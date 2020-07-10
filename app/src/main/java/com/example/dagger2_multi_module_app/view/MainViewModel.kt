package com.example.dagger2_multi_module_app.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.base.BaseRepository
import com.example.base.ExternalCommonDataRepository
import com.example.dagger2_multi_module_app.WelcomeMessageProvider
import javax.inject.Inject

/***
 * @Inject
@Named("local")
lateinit var localUserRepository: UserRepository, need to check how to implement this here
 */
class MainViewModel @Inject constructor(
    private val welcomeMessageProvider: WelcomeMessageProvider,
    private val baseRepository: BaseRepository,
    private val externalCommonDataRepository: ExternalCommonDataRepository
//    ,private val localUserRepository: UserRepository
) : ViewModel() {

    fun observeWelcomeMessage(): MutableLiveData<String> {
        var welcomeMessageLiveData = MutableLiveData<String>()
        welcomeMessageLiveData.postValue(welcomeMessageProvider.provideWelcomeMessage() + "-" + baseRepository.getBaseURL() + "-" + externalCommonDataRepository.getExternalCommonAPIURL())
        return welcomeMessageLiveData
    }

}