package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont

import com.github.ontio.sdk.info.IdentityInfo
import com.github.ontio.sdk.wallet.Identity

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-18]
 */
interface OntIdentityContract {
    fun importIdentity(privateKey: String, password: String, salt: ByteArray, address: String): Identity
    fun createIdentity(password: String): Identity
    fun createIdentityFromPriKey(password: String, privateKey: String) : Identity
    fun createIdentityInfo(password: String): IdentityInfo
    fun createIdentityInfo(password: String, privateKey: String): IdentityInfo
    fun getIdentityInfo(ontId: String, password: String, salt: ByteArray): IdentityInfo
}