package com.xiaofei.ontologyandroidsdkuse.service;

import com.alibaba.fastjson.JSONObject;
import com.xiaofei.ontologyandroidsdkuse.model.OntopassResult;
import com.xiaofei.ontologyandroidsdkuse.model.TransactionBodyVO;
import com.xiaofei.ontologyandroidsdkuse.model.TransactionHashVO;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

public class OntopassService implements IOntopassService {
    private OntopassServiceApi ontopassServiceApi;
    public OntopassService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.ont.io/")
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
        this.ontopassServiceApi = retrofit.create(OntopassServiceApi.class);
    }
    @Override
    public TransactionHashVO assetTransfer(TransactionBodyVO transactionBodyVO) throws IOException {
        Call<OntopassResult> call = ontopassServiceApi.assetTransfer(transactionBodyVO);
        Response<OntopassResult> response = call.execute();
        OntopassResult ontopassResult = response.body();
        JSONObject jsonObject = ontopassResult.getResult();
        TransactionHashVO transactionHashVO = JSONObject.parseObject(jsonObject.toJSONString(),TransactionHashVO.class);
        return transactionHashVO;
    }
}
