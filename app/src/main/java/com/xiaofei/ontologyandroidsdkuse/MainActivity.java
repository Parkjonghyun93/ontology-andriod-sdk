package com.xiaofei.ontologyandroidsdkuse;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.github.ontio.OntSdk;
import com.github.ontio.sdk.wallet.Account;
import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.OntologyAccountManager;
import com.xiaofei.ontologyandroidsdkuse.kotlin.manager.OntologyKeyManager;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    OkHttpClient client = new OkHttpClient();
    private OntSdk ontSdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        try {
//            ontSdk = OntSdk.getInstance();
//            ontSdk.setRestful("http://polaris1.ont.io:20334");
//            int blockHeight = ontSdk.getConnect().getBlockHeight();
//            Log.i("cjf", "onCreate: "+blockHeight);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    ontSdk = OntSdk.getInstance();
//                    ontSdk.setRestful("http://polaris1.ont.io:20334");
//                    int blockHeight = ontSdk.getConnect().getBlockHeight();
//                    Log.i("cjf", "onCreate: " + blockHeight);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }).start();
        Account account = OntologyAccountManager.INSTANCE.createAccount("123456");
        // TODO : Should i create instance to WalletMgr in OntSdk instance
        Log.d("TEST", "======================ACCOUNT======================");
        Log.d("TEST", " > " + account.key);
        Log.d("TEST", " > " + account.address);
        Log.d("TEST", " > " + account.publicKey);
        Log.d("TEST", "===================================================");

        String mnemonic = OntologyKeyManager.INSTANCE.generateMnemonic();
        Log.d("TEST", " > " + mnemonic);
        Log.d("TEST", " > " + OntologyKeyManager.INSTANCE.getSeedFromMnemonic(mnemonic));
        Log.d("TEST", " > " + OntologyKeyManager.INSTANCE.getPrivatekeyFromMnemonicBip44(mnemonic));


//        FutureTask<Integer> futureBlockHeight = new FutureTask<>(new Callable<Integer>() {
////            @Override
////            public Integer call() throws Exception {
////                OntSdk ontSdk = OntSdk.getInstance();
////                ontSdk.setRestful("http://13.78.112.191:20334");
////
////                int blockHeight = ontSdk.getConnectMgr().getBlockHeight();
////                return blockHeight;
////            }
////        });
////
////        new Thread(futureBlockHeight).start();
////        Flowable.just(futureBlockHeight).subscribe(new Consumer<FutureTask<Integer>>() {
////            @Override
////            public void accept(FutureTask<Integer> integerFutureTask) throws Exception {
////                myBlockHeight = integerFutureTask.get();
////                Log.i("", "alalheight: ");
////            }
////        });
////

//
//
//        FutureTask<Identity> identityFutureTask = new FutureTask<>(new Callable<Identity>() {
//            @Override
//            public Identity call() throws Exception {
//                OntSdk ontSdk = OntSdk.getInstance();
//                ontSdk.setRestful("http://polaris1.ont.io:20334");
//                String filepath = Environment.getExternalStoragePublicDirectory("") + "/wallet.json";
//                //ontSdk.openWalletFile(filepath);
//                ontSdk.setCodeAddress("80b0cc71bda8653599c5666cae084bff587e2de1");
//
//                //Identity identity = ontSdk.getWalletMgr().createIdentity("123456");
//
//                Identity identity1 = ontSdk.getOntIdTx().sendRegisterPreExec("123456");
//                return identity1;
//            }
//        });
//
//        new Thread(identityFutureTask).start();
//        Flowable.just(identityFutureTask).subscribe(new Consumer<FutureTask<Identity>>() {
//            @Override
//            public void accept(FutureTask<Identity> identityFutureTask) throws Exception {
//                myIdentity = identityFutureTask.get();
//                Log.i("haha", "myIdentity: "+myIdentity.toString());
//            }
//        });
    }
}

