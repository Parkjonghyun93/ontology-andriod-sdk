package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.implement

import com.github.ontio.common.Helper
import com.github.ontio.crypto.MnemonicCode
import com.github.ontio.sdk.info.AccountInfo
import com.github.ontio.sdk.wallet.Account
import com.xiaofei.ontologyandroidsdkuse.kotlin.common.CryptoSharedPreference
import com.xiaofei.ontologyandroidsdkuse.kotlin.core.OntologyCore
import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont.OntAccountContract

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object OntologyAccountManager : OntAccountContract {
    private fun setAccountInPreference(password: String, mnemonic: String, address: String) {
        CryptoSharedPreference.setOntologyAddress(address)
        CryptoSharedPreference.setEncryptedMnemonic(MnemonicCode.encryptMnemonicCodesStr(mnemonic, password, address))
    }

    private fun setKeyStoreKeyPair(address: String) {
//        TODO("Save to mnemonic in keystore use alias(account.address)")
    }

    override fun importAccount(encryptedPrivateKey: String, password: String, address: String, salt: ByteArray): Account {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.importAccount(encryptedPrivateKey, password, address, salt)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun createAccount(password: String): Account {
        val mnemonic = OntologyKeyManager.generateMnemonic()
        val privateKey = OntologyKeyManager.getPrivateKeyFromMnemonicBip44(mnemonic)

        return createAccountWithPrivateKey(password, mnemonic, Helper.toHexString(privateKey))
    }

    override fun createAccountWithPrivateKey(password: String, mnemonic: String, privateKey: String): Account {
        OntologyCore.getSdkInstance()?.let {
            val account = it.walletMgr.createAccountFromPriKey(password, privateKey)
            setAccountInPreference(password, mnemonic, account.address)
            setKeyStoreKeyPair(account.address)
            return account
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun createAccountInfo(password: String): AccountInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.createAccountInfo(password)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun createAccountInfo(password: String, privateKey: String): AccountInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.createAccountInfo(password, privateKey)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun getAccountInfo(address: String, password: String, salt: ByteArray): AccountInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.getAccountInfo(address, password, salt)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun getAccount(address: String): com.github.ontio.account.Account {
        OntologyCore.getSdkInstance()?.let {
//            it.walletMgr.getAccount()
//            return it.walletMgr.accc
        }
        throw Exception("") // TODO : create OntSdk NullException
    }
}