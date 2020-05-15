package com.xiaofei.ontologyandroidsdkuse.kotlin.common

import android.content.Context
import android.content.ContextWrapper
import com.xiaofei.ontologyandroidsdkuse.kotlin.resource.OntologyResource
import java.io.File

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object RepositoryManager {
    private lateinit var context: Context

    public fun init(context: Context) {
        RepositoryManager.context = context
    }
    private val keystoreDirectory: File
        get() {
            val dir = File(ContextWrapper(context).getDir(OntologyResource.KEYSTORE_DIRECTORY_NAME, Context.MODE_PRIVATE), OntologyResource.KEYSTORE_DIRECTORY_NAME)
            if (!dir.exists()) {
                dir.mkdirs()
            }
            return dir
        }

}