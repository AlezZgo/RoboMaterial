package com.alezzgo.robomaterial.data

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface SharedPrefs {
    fun saveIp(ip: String)
    fun savePort(port: String)
    fun fetchIp(): String
    fun fetchPort(): String

    class Base @Inject constructor(
        @ApplicationContext private val context: Context
    ) : SharedPrefs {

        private val sharedPrefs: SharedPreferences = context.getSharedPreferences(
            APP_PREF, Context.MODE_PRIVATE
        )

        override fun saveIp(ip: String) = sharedPrefs.edit().putString(IP, ip).apply()

        override fun savePort(port: String) = sharedPrefs.edit().putString(PORT, port).apply()

        override fun fetchIp() = sharedPrefs.getString(IP, "") ?: ""

        override fun fetchPort() = sharedPrefs.getString(PORT, "") ?: ""

        companion object {
            private const val APP_PREF = "APP_PREF"
            private const val IP = "IP"
            private const val PORT = "PORT"
        }

    }
}
