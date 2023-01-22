package com.alezzgo.robomaterial.ui.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alezzgo.robomaterial.ui.core.fragment.AbstractFragment
import com.example.robomaterial.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : AbstractFragment<FragmentSecondBinding, SecondViewModel>(
    FragmentSecondBinding::inflate, SecondViewModel::class.java
) {

}