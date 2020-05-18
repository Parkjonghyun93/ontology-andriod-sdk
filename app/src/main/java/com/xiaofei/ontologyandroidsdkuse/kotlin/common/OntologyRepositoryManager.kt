package com.xiaofei.ontologyandroidsdkuse.kotlin.common

import android.content.Context
import android.content.ContextWrapper
import com.xiaofei.ontologyandroidsdkuse.kotlin.resource.OntologyResource

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object OntologyRepositoryManager {
    private lateinit var context: Context
    lateinit var keyStoreDirectoryPath: String

    public fun init(context: Context) {
        OntologyRepositoryManager.context = context
        keyStoreDirectoryPath = "${ContextWrapper(context).getDir(OntologyResource.KEYSTORE_DIRECTORY_NAME, Context.MODE_PRIVATE).path}/${OntologyResource.KEYSTORE_DIRECTORY_NAME}"
    }
}