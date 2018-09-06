package com.posp.trainingapp.core.controller.modulepractice;

import android.content.Context;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestbuilder.ModulePracticeRequestBuilder;
import com.posp.trainingapp.core.requestmodels.SyncRequestEntity;
import com.posp.trainingapp.core.response.ModulePracticeResponse;
import com.posp.trainingapp.core.response.SyncTimeResponse;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Rajeev Ranjan on 17/04/2017.
 */

public class ModulePracticeControllar implements IModulePractice {

    ModulePracticeRequestBuilder.ModulePracticeNetworkService questionNetworkService;
    Context mContext;

    public ModulePracticeControllar(Context context) {
        questionNetworkService = new ModulePracticeRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void getModuleQuestion(int ModuleNo, int CategoryId, int UserId, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameter = new HashMap<String, String>();

        bodyParameter.put("ModuleNo", "" + ModuleNo);
        bodyParameter.put("CategoryId", "" + CategoryId);
        bodyParameter.put("UserId", "" + UserId);
        questionNetworkService.getModulePractice(bodyParameter).enqueue(new Callback<ModulePracticeResponse>() {
            @Override
            public void onResponse(retrofit.Response<ModulePracticeResponse> response, Retrofit retrofit) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Check your internet connection"));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Check your internet connection"));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }

    @Override
    public void getSyncTime(SyncRequestEntity syncRequestEntity, final IResponseSubcriber iResponseSubcriber) {
        questionNetworkService.getSyncTime(syncRequestEntity).enqueue(new Callback<SyncTimeResponse>() {
            @Override
            public void onResponse(retrofit.Response<SyncTimeResponse> response, Retrofit retrofit) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Check your internet connection"));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException("Check your internet connection"));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }


}

