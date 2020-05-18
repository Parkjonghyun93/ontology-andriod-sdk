package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.cobak

import com.github.ontio.sdk.wallet.Wallet

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-18]
 */
interface CobakOntKeyContract {
    fun importMnemonic(mnemonicCodesStr: String)
    fun exportMnemonic(password: String): String
    fun importKeystore()
    fun exportKeystore(): Wallet
}