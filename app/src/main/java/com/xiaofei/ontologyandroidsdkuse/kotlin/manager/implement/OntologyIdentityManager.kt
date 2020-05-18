package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.implement

import com.github.ontio.sdk.info.IdentityInfo
import com.github.ontio.sdk.wallet.Identity
import com.xiaofei.ontologyandroidsdkuse.kotlin.core.OntologyCore
import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont.OntIdentityContract
import java.lang.Exception

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object OntologyIdentityManager : OntIdentityContract {
    override fun importIdentity(privateKey: String, password: String, salt: ByteArray, address: String): Identity {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.importIdentity(privateKey, password, salt, address)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun createIdentity(password: String): Identity {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.createIdentity(password)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun createIdentityFromPriKey(password: String, privateKey: String) : Identity {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.createIdentityFromPriKey(password, privateKey)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun createIdentityInfo(password: String): IdentityInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.createIdentityInfo(password)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun createIdentityInfo(password: String, privateKey: String): IdentityInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.createIdentityInfo(password, privateKey)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }

    override fun getIdentityInfo(ontId: String, password: String, salt: ByteArray): IdentityInfo {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.getIdentityInfo(ontId, password, salt)
        }
        throw Exception("") // TODO : create OntSdk NullException
    }
}