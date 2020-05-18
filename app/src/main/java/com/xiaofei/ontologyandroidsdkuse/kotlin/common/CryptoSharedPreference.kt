package com.xiaofei.ontologyandroidsdkuse.kotlin.common

import android.content.Context
import android.content.SharedPreferences
import com.xiaofei.ontologyandroidsdkuse.kotlin.resource.OntologyResource

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object CryptoSharedPreference {
    private const val KEY_ENCRYPTED_MNEMONIC = "KEY_ENCRYPTED_MNEMONIC"
    private const val KEY_ONTOLOGY_ADDRESS = "KEY_ONTOLOGY_ADDRESS"
    private const val KEY_ONTOLOGY_KEYSTORE_FILE_DIR = "KEY_ONTOLOGY_KEYSTORE_FILE_DIR"

    private lateinit var context: Context
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedPreferencesEditor: SharedPreferences.Editor

    public fun init(context: Context) {
        this.context = context
        sharedPreferences = context.getSharedPreferences(OntologyResource.KEYSTORE_DIRECTORY_NAME, Context.MODE_PRIVATE)
        sharedPreferencesEditor = sharedPreferences.edit()
    }

    fun getEncryptedMnemonic(): String? {
        return sharedPreferences.getString(KEY_ENCRYPTED_MNEMONIC, null)
    }

    fun setEncryptedMnemonic(encryptedMnemonic: String?) {
        sharedPreferencesEditor.putString(KEY_ENCRYPTED_MNEMONIC, encryptedMnemonic)
        sharedPreferencesEditor.commit()
    }

    fun getOntologyAddress(): String? {
        return sharedPreferences.getString(KEY_ONTOLOGY_ADDRESS, null)
    }

    fun setOntologyAddress(address: String) {
        sharedPreferencesEditor.putString(KEY_ONTOLOGY_ADDRESS, address)
        sharedPreferencesEditor.commit()
    }

    fun getOntologyKeyStoreFileDir(): String? {
        return sharedPreferences.getString(KEY_ONTOLOGY_KEYSTORE_FILE_DIR, null)
    }

    fun setOntologyKeyStoreFileDir(fileDir: String) {
        sharedPreferencesEditor.putString(KEY_ONTOLOGY_KEYSTORE_FILE_DIR, fileDir)
        sharedPreferencesEditor.commit()
    }

}