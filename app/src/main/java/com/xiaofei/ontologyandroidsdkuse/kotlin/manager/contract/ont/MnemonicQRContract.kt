package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont

import com.github.ontio.common.WalletQR
import com.github.ontio.sdk.wallet.Account
import com.github.ontio.sdk.wallet.Identity
import com.github.ontio.sdk.wallet.Wallet

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-18]
 */
interface MnemonicQRContract {
    fun exportIdentityQRCode(walletFile: Wallet, identity: Identity): Map<*, *>
    fun exportAccountQRCode(walletFile: Wallet, account: Account): Map<*, *>
    fun getPrivateKeyFromQrCode(qrCodes: String, password: String): String
}