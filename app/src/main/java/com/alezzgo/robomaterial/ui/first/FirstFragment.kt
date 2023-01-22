package com.alezzgo.robomaterial.ui.first

import com.alezzgo.robomaterial.ui.core.fragment.AbstractFragment
import com.example.robomaterial.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : AbstractFragment<FragmentFirstBinding, FirstViewModel>(
    FragmentFirstBinding::inflate, FirstViewModel::class.java
) {

    override fun setupViews() {
        super.setupViews()
        viewModel.fetchConnectionSettings().show(
            binding.tielIp,
            binding.tielPort
        )
    }

    override fun setupListeners() {
        super.setupListeners()
        binding.btnConnect.setOnClickListener {
            viewModel.connect(binding.tielIp.text.toString(), (binding.tielPort.text.toString()))
        }
    }

    override fun observe() {
        super.observe()
        viewModel.connectionResult.observe(viewLifecycleOwner) { connectionResult ->
            connectionResult.show(
                successCallback = {
                    Snackbar.make(binding.root, "Success connection", Snackbar.LENGTH_LONG).show()
                },
                errorCallback = { errorMessage ->
                    Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_LONG).show()
                },
                loadingCallback = {

                }
            )
        }
    }
}
