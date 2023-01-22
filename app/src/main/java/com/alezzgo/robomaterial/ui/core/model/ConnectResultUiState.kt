package com.alezzgo.robomaterial.ui.core.model

sealed class ConnectResultUiState {

    abstract fun show(
        successCallback: () -> Unit,
        errorCallback: (errorMessage: String) -> Unit,
        loadingCallback: () -> Unit
    )

    object Loading : ConnectResultUiState() {
        override fun show(
            successCallback: () -> Unit,
            errorCallback: (errorMessage: String) -> Unit,
            loadingCallback: () -> Unit
        ) = loadingCallback.invoke()
    }

    object Success : ConnectResultUiState() {
        override fun show(
            successCallback: () -> Unit,
            errorCallback: (errorMessage: String) -> Unit,
            loadingCallback: () -> Unit
        ) {
            successCallback.invoke()
        }

    }

    data class Error(
        private val errorMessage: String
    ) : ConnectResultUiState() {
        override fun show(
            successCallback: () -> Unit,
            errorCallback: (errorMessage: String) -> Unit,
            loadingCallback: () -> Unit
        ) = errorCallback.invoke(errorMessage)

    }


}