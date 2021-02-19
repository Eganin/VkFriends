package com.example.vkfriends.activites

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.vkfriends.databinding.ActivityLoginBinding
import com.example.vkfriends.presenters.LoginPresenter
import com.example.vkfriends.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope

class LoginActivity : MvpAppCompatActivity(), LoginView {

    private var _binding: ActivityLoginBinding? = null

    private val binding get() = _binding!!

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            VK.login(this@LoginActivity, arrayListOf(VKScope.FRIENDS))
        }
    }

    override fun startLoading() {
        binding.progressBar.isVisible = true
        binding.loginButton.isVisible = false
    }

    override fun endLoading() {
        binding.progressBar.isVisible = false
        binding.loginButton.isVisible = true
    }

    override fun showError(text: Int) =
        Toast.makeText(this@LoginActivity, text, Toast.LENGTH_LONG).show()

    override fun openFriends() {
        startActivity(Intent(this@LoginActivity, FriendsActivity::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (loginPresenter.loginVK(
                requestCode = requestCode,
                resultCode = resultCode,
                data = data
            )
        ) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}