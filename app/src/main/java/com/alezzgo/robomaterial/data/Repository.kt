package com.alezzgo.robomaterial.data

import com.alezzgo.robomaterial.domain.model.ConnectionSettings
import javax.inject.Inject

interface Repository {

    fun saveConnection(ip: String, port: String)

    fun connectionSettings(): ConnectionSettings

    class Base @Inject constructor(
        private val sharedPrefs: SharedPrefs
    ) : Repository {
        override fun saveConnection(ip: String, port: String) {
            sharedPrefs.saveIp(ip)
            sharedPrefs.savePort(port)
        }

        override fun connectionSettings() = ConnectionSettings(
            sharedPrefs.fetchIp(),
            sharedPrefs.fetchPort()
        )
    }
}