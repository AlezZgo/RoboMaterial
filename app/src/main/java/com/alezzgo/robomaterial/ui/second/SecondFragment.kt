package com.alezzgo.robomaterial.ui.second

import com.alezzgo.robomaterial.ui.core.fragment.AbstractFragment
import com.example.robomaterial.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : AbstractFragment<FragmentSecondBinding, SecondViewModel>(
    FragmentSecondBinding::inflate, SecondViewModel::class.java
)