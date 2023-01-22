package com.alezzgo.robomaterial.ui.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alezzgo.robomaterial.ui.core.fragment.AbstractFragment
import com.example.robomaterial.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : AbstractFragment<FragmentFirstBinding, FirstViewModel>(
    FragmentFirstBinding::inflate, FirstViewModel::class.java
) {


}