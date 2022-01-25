package com.application.kpti.Preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map


class DataStoreManager(private val context: Context) {
    val USER_DATASTORE = "userdata"
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_DATASTORE)

    companion object {
        val USERNAME = stringPreferencesKey("USERNAME")
        val PASSWORD = stringPreferencesKey("PASSWORD")
    }

    suspend fun saveDatausertoDatastore(userdata: Userdata) {
      context.dataStore.edit {
          it[USERNAME] = userdata.username
          it[PASSWORD] = userdata.password
      }
    }

    suspend fun getDatauserFromDatastore() = context.dataStore.data.map {
        Userdata(
            username = it[USERNAME]?:"",
            password = it[PASSWORD]?:""
        )
    }
}
