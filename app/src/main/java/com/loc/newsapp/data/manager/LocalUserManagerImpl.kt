package com.loc.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.util.Constants
import com.loc.newsapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
/**
 * https://www.youtube.com/watch?v=PDABkIkDE04&list=PLzZEuVaFb9Exi-pc8qtHBrrLg8bUn-TP6&index=7&ab_channel=Landofcoding
 *
 * ** Dependency Injection
 * 클래스 간 결합도를 느슨하게 하기 위해 수행한다. 인터페이스를 기반으로 설계되며, 코드를 유연하게 한다.
 * 아래 Class 를 사용하려면 파라미터로 정의되는 context 인스턴스가 필요하다. (Dependency, 의존성.)
 * Dagger Hilt 를 사용하여 이 Class 의 인스턴스를 간단하게 만들고, context Object 를 inject 할 것이다.
 *
 * 1. Application Class (.NewsApplication) 를 만들고 @HiltAndroidApp 어노테이션을 선언.
 * 2. Manifest 의 <application> 의 name 속성을 위 Application Class 로 지정.
 * */

class LocalUserManagerImpl(private val context : Context) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[PreferencesKeys.APP_ENTRY] ?: false
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferencesKeys{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}