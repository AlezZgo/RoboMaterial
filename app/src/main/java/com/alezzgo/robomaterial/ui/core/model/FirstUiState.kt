package com.alezzgo.robomaterial.ui.core.model

import com.google.android.material.textfield.TextInputEditText

data class FirstUiState(
    private val ip: String,
    private val port: String
) {

    fun show(
        ipInputEditText: TextInputEditText,
        portInputEditText: TextInputEditText
    ) {
        ipInputEditText.setText(ip)
        portInputEditText.setText(port)
    }
}