package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont


/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-18]
 */
interface OntMnemonicContract {
    fun generateMnemonic(): String
    fun getSeedFromMnemonic(mnemonicCodesStr: String): ByteArray
    fun getPrivateKeyFromMnemonicBip44(mnemonicCodesStr: String): ByteArray
}