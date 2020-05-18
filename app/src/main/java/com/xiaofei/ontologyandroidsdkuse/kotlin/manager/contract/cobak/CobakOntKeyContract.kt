package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.cobak

import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.OntologyKeyManager

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-18]
 */
interface CobakOntKeyContract {
    fun importMnemonic(mnemonicCodesStr: String)
    fun exportMnemonic(password: String): String
    fun importKeystore()
    fun exportKeystore()
}