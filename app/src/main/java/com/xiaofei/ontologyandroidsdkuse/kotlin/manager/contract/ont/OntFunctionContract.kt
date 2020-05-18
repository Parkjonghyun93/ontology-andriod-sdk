package com.xiaofei.ontologyandroidsdkuse.kotlin.manager.contract.ont

import com.github.ontio.sdk.wallet.Account

/**
 * [Creator : Jonghyun_park(james.park)]
 * [Date : 2020-05-18]
 */
interface OntFunctionContract {
    fun sendTransfer(sendAcct: Account, recvAddr: String, amount: Long, payerAcct: Account, gasLimit: Long, gasPrice: Long): String
    fun queryBalanceOf(address: String): Long
    fun queryAllowance(fromAddr: String, toAddr: String): Long
    fun sendApprove(sendAcct: Account, recvAddr: String, amount: Long, payerAcct: Account, gasLimit: Long, gasPrice: Long): String
    fun sendTransferFrom(sendAcct: Account,fromAddr: String, toAddr: String, amount: Long, payerAcct: Account, gasLimit: Long, gasPrice: Long): String
    fun queryName(): String
    fun querySymbol(): String
    fun queryDecimals(): Long
    fun queryTotalSupply(): Long
}