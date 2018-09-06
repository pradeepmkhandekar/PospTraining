package com.posp.trainingapp.core.controller.submit;

import android.content.Context;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestbuilder.SubmitRequestBuilder;
import com.posp.trainingapp.core.requestmodels.SubmitRequestEntity;
import com.posp.trainingapp.core.response.SubmitResponse;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Rajeev Ranjan on 03/04/2017.
 */

public class SubmitController implements ISubmit {


    SubmitRequestBuilder.SubmitNetworkService submitNetworkService;
    Context mContext;

    public SubmitController(Context context) {
        submitNetworkService = new SubmitRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void submitAnswer(SubmitRequestEntity submitRequestEntity, final IResponseSubcriber iResponseSubcriber) {
        submitNetworkService.submitAnswer(submitRequestEntity).enqueue(new Callback<SubmitResponse>() {
            @Override
            public void onResponse(retrofit.Response<SubmitResponse> response, Retrofit retrofit) {
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
