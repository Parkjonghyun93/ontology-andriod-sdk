package com.xiaofei.ontologyandroidsdkuse.kotlin.manager

import com.github.ontio.common.WalletQR
import com.github.ontio.crypto.MnemonicCode
import com.github.ontio.sdk.wallet.Account
import com.github.ontio.sdk.wallet.Identity
import com.github.ontio.sdk.wallet.Wallet

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object OntologyKeyManager {
    fun generateMnemonic() = MnemonicCode.generateMnemonicCodesStr()
    fun getSeedFromMnemonic(mnemonicCodesStr: String) = MnemonicCode.getSeedFromMnemonicCodesStr(mnemonicCodesStr)
    fun getPrivatekeyFromMnemonicBip44(mnemonicCodesStr: String) = MnemonicCode.getPrikeyFromMnemonicCodesStrBip44(mnemonicCodesStr)

    fun exportIdentityQRCode(walletFile: Wallet, identity: Identity) = WalletQR.exportIdentityQRCode(walletFile, identity)
    fun exportAccountQRCode(walletFile: Wallet, account: Account) = WalletQR.exportAccountQRCode(walletFile, account)
    fun getPrivateKeyFromQrCode(qrCodes: String, password: String) = WalletQR.getPriKeyFromQrCode(qrCodes, password)


    fun importMnemonic(mnemonicCodesStr: String) {} // TODO ) save to mnemonic str and address
    fun exportMnemonic(password: String) = decryptMnemonic("", password, "")
    fun importKeystore() {}
    fun exportKeystore() {}

    fun encryptMnemonic(mnemonicCodesStr: String, password: String, address: String) = MnemonicCode.encryptMnemonicCodesStr(mnemonicCodesStr, password, address)
    fun decryptMnemonic(mnemonicCodesStr: String, password: String, address: String) = MnemonicCode.decryptMnemonicCodesStr(mnemonicCodesStr, password, address)

}