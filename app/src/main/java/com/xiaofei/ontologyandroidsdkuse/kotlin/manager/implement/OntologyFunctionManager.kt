package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.implement

import com.github.ontio.sdk.wallet.Account
import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont.OntFunctionContract

object OntologyFunctionManager: OntFunctionContract {
    override fun sendTransfer(sendAcct: Account, recvAddr: String, amount: Long, payerAcct: Account, gasLimit: Long, gasPrice: Long): String {
        TODO("Not yet implemented")
    }

    override fun queryBalanceOf(address: String): Long {
        TODO("Not yet implemented")
    }

    override fun queryAllowance(fromAddr: String, toAddr: String): Long {
        TODO("Not yet implemented")
    }

    override fun sendApprove(sendAcct: Account, recvAddr: String, amount: Long, payerAcct: Account, gasLimit: Long, gasPrice: Long): String {
        TODO("Not yet implemented")
    }

    override fun sendTransferFrom(sendAcct: Account, fromAddr: String, toAddr: String, amount: Long, payerAcct: Account, gasLimit: Long, gasPrice: Long): String {
        TODO("Not yet implemented")
    }

    override fun queryName(): String {
        TODO("Not yet implemented")
    }

    override fun querySymbol(): String {
        TODO("Not yet implemented")
    }

    override fun queryDecimals(): Long {
        TODO("Not yet implemented")
    }

    override fun queryTotalSupply(): Long {
        TODO("Not yet implemented")
    }
}