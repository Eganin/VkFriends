package com.example.vkfriends.presenters

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.vkfriends.R
import com.example.vkfriends.views.LoginView

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {
    fun login(isSuccess: Boolean) {
        viewState.startLoading()
        Handler().postDelayed({
            viewState.endLoading()
            if (isSuccess) {
                viewState.openFriends()
            }else{
                viewState.showError(text= R.string.incorrect_data)
            }
        }, 500)
    }
}