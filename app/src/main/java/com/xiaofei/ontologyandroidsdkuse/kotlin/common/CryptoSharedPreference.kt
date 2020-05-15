package com.xiaofei.ontologyandroidsdkuse.kotlin.common

import android.content.Context
import com.xiaofei.ontologyandroidsdkuse.kotlin.resource.OntologyResource

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object CryptoSharedPreference {
    private lateinit var context: Context

    private const val KEY_ENCRYPTED_MNEMONIC = "KEY_ENCRYPTED_MNEMONIC"

    public fun init(context: Context) {
        CryptoSharedPreference.context = context
    }

    private val sharedPreferences = context.getSharedPreferences(OntologyResource.KEYSTORE_DIRECTORY_NAME, Context.MODE_PRIVATE)
    private val sharedPreferencesEditor = sharedPreferences.edit()

    fun getEncryptedMnemonic(): String? {
        return sharedPreferences.getString(KEY_ENCRYPTED_MNEMONIC, null)
    }

    fun setEncryptedMnemonic(encryptedMnemonic: String?) {
        sharedPreferencesEditor.putString(KEY_ENCRYPTED_MNEMONIC, encryptedMnemonic)
        sharedPreferencesEditor.commit()
    }
}