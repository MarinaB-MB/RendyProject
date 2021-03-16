package com.deadely.rendy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.deadely.rendy.ui.MainActivity
import com.deadely.rendy.utils.getBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.collect

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(layoutId: Int) :
    Fragment(layoutId) {
    protected lateinit var auth: FirebaseAuth
    protected abstract val viewModel: VM
    protected var currentUser: FirebaseUser? = null

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            viewModel.events.collect { event ->
                onReceiveEvent(event)
            }
        }
        auth = (activity as MainActivity).auth
        currentUser = auth.currentUser
    }

    open fun onReceiveEvent(event: Event) {}

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
