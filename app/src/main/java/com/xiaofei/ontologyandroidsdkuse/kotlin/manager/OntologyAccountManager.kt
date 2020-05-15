package com.xiaofei.ontologyandroidsdkuse.kotlin.manager

import android.util.Log
import com.github.ontio.common.Helper
import com.github.ontio.sdk.info.AccountInfo
import com.github.ontio.sdk.wallet.Account
import com.xiaofei.ontologyandroidsdkuse.kotlin.core.OntologyCore

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */


object OntologyAccountManager {
    fun importAccount(encryptedPrivateKey: String, password: String, address: String, salt: ByteArray): Account {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.importAccount(encryptedPrivateKey, password, address, salt)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    fun createAccount(password: String): Account {
        val code = OntologyKeyManager.generateMnemonic()
        val privateKey = OntologyKeyManager.getPrivatekeyFromMnemonicBip44(code)

        Log.d("TEST", "1")
        return createAccountWithPrivateKey(password, Helper.toHexString(privateKey))
    }

    fun createAccountWithPrivateKey(password: String, privateKey: String) : Account {
        OntologyCore.getSdkInstance()?.let {
            Log.d("TEST", "2")
            Log.d("TEST", " > ${it.walletMgr == null}")
            return it.walletMgr.createAccountFromPriKey(password, privateKey)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    fun createAccountInfo(password: String): AccountInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.createAccountInfo(password)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    fun createAccountInfo(password: String, privateKey: String): AccountInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.createAccountInfo(password, privateKey)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    fun getAccountInfo(address: String, password: String, salt: ByteArray) : AccountInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.getAccountInfo(address, password, salt)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

}