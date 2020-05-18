package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont

import com.github.ontio.sdk.wallet.Account
import com.github.ontio.sdk.wallet.Identity

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-18]
 */
interface MnemonicQRContract {
    fun exportIdentityQRCode(identity: Identity): Map<*, *>
    fun exportAccountQRCode(account: Account): Map<*, *>
    fun getPrivateKeyFromQrCode(qrCodes: String, password: String): String
}