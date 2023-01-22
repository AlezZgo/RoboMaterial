package com.alezzgo.robomaterial.ui.first

import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alezzgo.robomaterial.core.ManageResources
import com.alezzgo.robomaterial.data.Repository
import com.alezzgo.robomaterial.ui.core.model.ConnectResultUiState
import com.alezzgo.robomaterial.ui.core.viewmodel.AbstractViewModel
import com.example.robomaterial.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.DataOutputStream
import java.net.Socket
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val resources: ManageResources,
    private val repository: Repository
) : AbstractViewModel() {

    private val _connectionResult = MutableLiveData<ConnectResultUiState>()
    val connectionResult: LiveData<ConnectResultUiState> get() = _connectionResult


    var socket: Socket? = null
    var dos: DataOutputStream? = null

    override fun init() {}

    fun connect(ip: String, port: String) {

        _connectionResult.postValue(ConnectResultUiState.Loading)

        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                try {
                    if (ip.isBlank())
                        throw java.lang.RuntimeException(resources.string(R.string.wrong_input_type_of_ip))
                    if (port.isBlank())
                        throw java.lang.RuntimeException(resources.string(R.string.wrong_input_type_of_port))

                    repository.saveConnection(ip,port)

                    socket = Socket(ip, Integer.parseInt(port))
                    dos = DataOutputStream(socket!!.getOutputStream());
                    dos!!.writeUTF(Build.DEVICE + " trying to connect");

                    dos!!.close();
                    socket!!.close();
                    _connectionResult.postValue(ConnectResultUiState.Success)
                } catch (e: Exception) {
                    _connectionResult.postValue(ConnectResultUiState.Error("Error: ${e.message}"))
                }
            }
        }
    }

    fun fetchConnectionSettings() = repository.connectionSettings().toUI()
}