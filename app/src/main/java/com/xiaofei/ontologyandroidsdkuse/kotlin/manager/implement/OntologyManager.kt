package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.implement

import android.content.Context
import com.xiaofei.ontologyandroidsdkuse.kotlin.common.CryptoSharedPreference
import com.xiaofei.ontologyandroidsdkuse.kotlin.common.OntologyRepositoryManager
import com.xiaofei.ontologyandroidsdkuse.kotlin.core.OntologyCore

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

// This class wrapper all manager
object OntologyManager {
    public val address: String?
        get() = CryptoSharedPreference.getOntologyAddress()

    public fun initializeOntology(context: Context) {
        CryptoSharedPreference.init(context)
        OntologyRepositoryManager.init(context)
        OntologyCore.init(context)
    }
}