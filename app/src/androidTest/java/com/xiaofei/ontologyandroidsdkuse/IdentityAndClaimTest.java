package com.xiaofei.ontologyandroidsdkuse;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Base64;

import com.github.ontio.OntSdk;
import com.github.ontio.sdk.info.IdentityInfo;
import com.github.ontio.sdk.manager.ConnectMgr;
import com.github.ontio.sdk.manager.OntAssetTx;
import com.github.ontio.sdk.manager.OntIdTx;
import com.github.ontio.sdk.manager.WalletMgr;
import com.github.ontio.sdk.wallet.Account;
import com.github.ontio.sdk.wallet.Identity;
import com.github.ontio.sdk.wallet.Wallet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class IdentityAndClaimTest {
    private OntSdk ontSdk;
    private ConnectMgr connectMgr;
    private OntAssetTx ontAssetTx;
    private WalletMgr walletMgr;
    private Wallet wallet;
    private Context appContext;
    private OntIdTx ontIdTx;

    @Before
    public void setUp() throws Exception {
        ontSdk = OntSdk.getInstance();
        ontSdk.setRestful("http://polaris1.ont.io:20334");
        appContext  = InstrumentationRegistry.getTargetContext();
        ontSdk.openWalletFile(appContext.getSharedPreferences("wallet",Context.MODE_PRIVATE));
        walletMgr = ontSdk.getWalletMgr();
        wallet = walletMgr.getWallet();
        connectMgr = ontSdk.getConnectMgr();
        ontAssetTx = ontSdk.getOntAssetTx();
        ontIdTx = ontSdk.getOntIdTx();
        ontSdk.setCodeAddress("80b0cc71bda8653599c5666cae084bff587e2de1");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setDefaultIdentity() throws Exception {
        walletMgr.createIdentity("123456");
        walletMgr.createIdentity("123456");
        List<Identity> identityList = wallet.getIdentities();
        assertTrue(identityList.size() >=2);

        Identity identity0 = identityList.get(0);
        Identity identity1 = identityList.get(1);
        wallet.setDefaultIdentity(0);
        assertEquals(identity0.isDefault, true);
        assertEquals(identity1.isDefault, false);

        wallet.setDefaultIdentity(identity1.ontid);
        assertEquals(identity0.isDefault,false);
        assertEquals(identity1.isDefault,true);
    }

    @Test
    public void setDefaultIdentityError() throws Exception {
        List<Identity> identities = wallet.getIdentities();
        String message="";
        try {
            message="";
            wallet.setDefaultIdentity(identities.size()+1);
        }catch (Exception ex){
            message = ex.getMessage();
        }finally {
            assertNotEquals(message,"");
            assertTrue(message.contains("58004"));
        }

        try {
            message="";
            wallet.setDefaultIdentity(-1);
        }catch (Exception ex){
            message = ex.getMessage();
        }finally {
            assertNotEquals(message,"");
        }

        try {
            message="";
            wallet.setDefaultIdentity("");
        }catch (Exception ex){
            message = ex.getMessage();
        }finally {
            assertNotEquals(message,"");
        }

    }

    @Test
    public void setDefaultAccount() throws Exception {
        walletMgr.createAccount("123456");
        walletMgr.createAccount("123456");
        List<Account> accounts = wallet.getAccounts();
        assertTrue(accounts.size() >=2);

        Account account0 = accounts.get(0);
        Account account1 = accounts.get(1);
        wallet.setDefaultAccount(0);
        assertEquals(account0.isDefault,true);
        assertEquals(account1.isDefault, false);
        wallet.setDefaultAccount(account1.address);
        assertEquals(account0.isDefault,false);
        assertEquals(account1.isDefault,true);
    }

    @Test
    public void setDefaultAccountError(){
        List<Account> accounts = wallet.getAccounts();
        String messasge="";
        try {
            messasge="";
            wallet.setDefaultAccount(accounts.size()+1);
        }catch (Exception ex){
            messasge= ex.getMessage();
        }finally {
            assertNotEquals(messasge,"");
            assertTrue(messasge.contains("58004"));
        }

        try {
            messasge="";
            wallet.setDefaultAccount(-1);
        }catch (Exception ex){
            messasge= ex.getMessage();
        }finally {
            assertNotEquals(messasge,"");
        }

        try {
            messasge="";
            wallet.setDefaultAccount("");
        }catch (Exception ex){
            messasge= ex.getMessage();
        }finally {
            assertNotEquals(messasge,"");
        }
    }

    @Test
    public void createOntIdClaim() throws Exception {
        Identity identity1 = ontIdTx.sendRegister("123456");
        Identity identity2 = ontIdTx.sendRegister("123456");
        Thread.sleep(6000);

        Map<String,Object> claimData = new HashMap<>();
        claimData.put("aaa","bbb");

        Map metaData = new HashMap();
        metaData.put("Issuer",identity1.ontid);
        metaData.put("Subject",identity2.ontid);

        String claim = ontIdTx.createOntIdClaim(identity1.ontid,"123456","claim:context",claimData,metaData);
        assertNotNull(claim);
        assertNotEquals(claim,"");
        assertTrue(claim.contains(identity1.ontid));
        assertTrue(claim.contains(identity2.ontid));
        assertTrue(claim.contains("claim:context"));
        assertTrue(claim.contains("aaa"));
        assertTrue(claim.contains("bbb"));

        boolean isVerified = ontIdTx.verifyOntIdClaim(claim);
        assertTrue(isVerified);
    }

    @Test
    public void createOntIdClaimError() throws Exception {
        Identity identity1 = ontIdTx.sendRegister("123456");
        Identity identity2 = ontIdTx.sendRegister("123456");
        Thread.sleep(6000);

        Map<String,Object> claimData = new HashMap<>();
        claimData.put("aaa","bbb");

        Map metaData = new HashMap();
        metaData.put("Issuer",identity1.ontid);
        metaData.put("Subject",identity2.ontid);

        String message="";
        try {
            message="";
            ontIdTx.createOntIdClaim("","123456","claim:context",claimData,metaData);
        }catch (Exception ex){
            message = ex.getMessage();
        }finally {
            assertNotEquals(message,"");
            assertTrue(message.contains("58004"));
        }

        try {
            message="";
            ontIdTx.createOntIdClaim(identity1.ontid,"","claim:context",claimData,metaData);
        }catch (Exception ex){
            message = ex.getMessage();
        }finally {
            assertNotEquals(message,"");
            assertTrue(message.contains("51015"));
        }

    }

    @Test
    public void test(){
        byte[] bytes = Base64.decode("aaa".getBytes(), Base64.DEFAULT);
    }
}