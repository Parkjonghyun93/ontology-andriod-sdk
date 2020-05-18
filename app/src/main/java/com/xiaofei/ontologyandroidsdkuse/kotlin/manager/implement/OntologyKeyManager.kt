package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.implement

import com.github.ontio.common.WalletQR
import com.github.ontio.crypto.MnemonicCode
import com.github.ontio.sdk.wallet.Account
import com.github.ontio.sdk.wallet.Identity
import com.github.ontio.sdk.wallet.Wallet
import com.xiaofei.ontologyandroidsdkuse.kotlin.common.CryptoSharedPreference
import com.xiaofei.ontologyandroidsdkuse.kotlin.core.OntologyCore
import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.cobak.CobakOntKeyContract
import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont.MnemonicQRContract
import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont.OntMnemonicContract

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-15]
 */

object OntologyKeyManager : OntMnemonicContract, CobakOntKeyContract, MnemonicQRContract {
    override fun generateMnemonic(): String {
        val mnemonic = MnemonicCode.generateMnemonicCodesStr()
        return mnemonic
    }
    override fun getSeedFromMnemonic(mnemonicCodesStr: String) = MnemonicCode.getSeedFromMnemonicCodesStr(mnemonicCodesStr)
    override fun getPrivateKeyFromMnemonicBip44(mnemonicCodesStr: String) = MnemonicCode.getPrikeyFromMnemonicCodesStrBip44(mnemonicCodesStr)

    override fun exportIdentityQRCode(identity: Identity) = WalletQR.exportIdentityQRCode(exportKeystore(), identity)
    override fun exportAccountQRCode(account: Account) = WalletQR.exportAccountQRCode(exportKeystore(), account)
    override fun getPrivateKeyFromQrCode(qrCodes: String, password: String) = WalletQR.getPriKeyFromQrCode(qrCodes, password)

    override fun importMnemonic(mnemonicCodesStr: String) {} // TODO) save to mnemonic str and address
    override fun exportMnemonic(password: String) = decryptMnemonic("", password, "")
    override fun importKeystore() {}
    override fun exportKeystore(): Wallet {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.walletFile
        }
        throw Exception("TODO EXCEPTION")
    }

    fun exportFileKeystore(): String {
        OntologyCore.getSdkInstance()?.let {
            return it.walletMgr.filePath
        }
        throw Exception("TODO EXCEPTION")
    }

    fun encryptMnemonic(mnemonicCodesStr: String, password: String, address: String) = MnemonicCode.encryptMnemonicCodesStr(mnemonicCodesStr, password, address)
    fun decryptMnemonic(mnemonicCodesStr: String, password: String, address: String) = MnemonicCode.decryptMnemonicCodesStr(mnemonicCodesStr, password, address)
}