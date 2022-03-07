package com.example.common.ui

import android.animation.Animator
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.example.base.BaseFragment
import com.example.common.databinding.FragmentSplashScreenBinding
import com.example.navigations.NavigationFlow
import com.example.navigations.ToFlowNavigatable

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>(FragmentSplashScreenBinding::inflate) {

    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){
        (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.moviesFlow)
//        binding.animationView.playAnimation()
//        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener{
//            override fun onAnimationRepeat(animation: Animator?) {}
//            override fun onAnimationEnd(animation: Animator?) {
//                // start movies fragment
//                (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.moviesFlow)
//            }
//            override fun onAnimationStart(animation: Animator?) {}
//            override fun onAnimationCancel(animation: Animator?) {}
//        })
    }
}