package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont

import com.github.ontio.sdk.info.AccountInfo
import com.github.ontio.sdk.wallet.Account

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-18]
 */
interface OntAccountContract {
    fun importAccount(encryptedPrivateKey: String, password: String, address: String, salt: ByteArray): Account
    fun createAccount(password: String): Account
    fun createAccountWithPrivateKey(password: String, mnemonic: String, privateKey: String) : Account
    fun createAccountInfo(password: String): AccountInfo
    fun createAccountInfo(password: String, privateKey: String): AccountInfo
    fun getAccountInfo(address: String, password: String, salt: ByteArray) : AccountInfo
}