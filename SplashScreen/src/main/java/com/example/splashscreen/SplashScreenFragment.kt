package com.example.splashscreen

import android.animation.Animator
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder
import androidx.navigation.fragment.findNavController
import com.example.base.BaseFragment
import com.example.splashscreen.databinding.FragmentSplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>(FragmentSplashScreenBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        binding.animationView.playAnimation()
        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {

            }
            override fun onAnimationEnd(animation: Animator?) {
                val action = FragmentS
                findNavController().navigate(action)
            }
            override fun onAnimationStart(animation: Animator?) {

            }
            override fun onAnimationCancel(animation: Animator?) {

            }
        })
    }
}