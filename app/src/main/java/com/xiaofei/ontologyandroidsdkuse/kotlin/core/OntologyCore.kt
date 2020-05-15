package com.xiaofei.ontologyandroidsdkuse.kotlin.core

import android.content.SharedPreferences
import com.github.ontio.OntSdk
import com.xiaofei.ontologyandroidsdkuse.kotlin.resource.OntologyResource
import java.net.MalformedURLException

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object OntologyCore {
    private var ontSdkInstance: OntSdk? = null

    @Throws(MalformedURLException::class)
    fun getSdkInstance(): OntSdk? {
        if (ontSdkInstance == null) {
            ontSdkInstance = OntSdk.getInstance().apply {
                setRpc(OntologyResource.rpcUrl)
                setRestful(OntologyResource.restUrl)
                setDefaultConnect(this.restful)
            }
        }
        return ontSdkInstance
    }

    @Throws(MalformedURLException::class)
    fun getSdkInstance(sharedPreferences: SharedPreferences): OntSdk? {
        if (ontSdkInstance == null) {
            ontSdkInstance = OntSdk.getInstance().apply {
                setRpc(OntologyResource.rpcUrl)
                setRestful(OntologyResource.restUrl)
                openWalletFile(sharedPreferences)
                setDefaultConnect(this.restful)
            }
        }
        return ontSdkInstance
    }

    @Throws(MalformedURLException::class)
    fun getSdkInstance(path: String): OntSdk? {
        if (ontSdkInstance == null) {
            ontSdkInstance = OntSdk.getInstance().apply {
                setRpc(OntologyResource.rpcUrl)
                setRestful(OntologyResource.restUrl)
                openWalletFile(path)
                setDefaultConnect(this.restful)

            }
        }
        return ontSdkInstance
    }
}