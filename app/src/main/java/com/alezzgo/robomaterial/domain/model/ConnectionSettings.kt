package com.alezzgo.robomaterial.domain.model

import com.alezzgo.robomaterial.ui.core.model.FirstUiState

data class ConnectionSettings(
    private val ip: String,
    private val port: String
) {

    fun toUI() = FirstUiState(
        ip = ip,
        port = port
    )
}
