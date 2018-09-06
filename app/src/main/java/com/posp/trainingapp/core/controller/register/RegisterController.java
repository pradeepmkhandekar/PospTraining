package com.posp.trainingapp.core.controller.register;

import android.content.Context;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestbuilder.RegisterRequestBuilder;
import com.posp.trainingapp.core.requestmodels.RegisterRequestEntity;
import com.posp.trainingapp.core.response.RegisterResponse;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class RegisterController implements IRegister {


    RegisterRequestBuilder.RegisterNetworkService registerNetworkService;
    Context mContext;

    public RegisterController(Context context) {
        registerNetworkService = new RegisterRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void register(RegisterRequestEntity registerRequestEntity, final IResponseSubcriber iResponseSubcriber) {
        registerNetworkService.register(registerRequestEntity).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(retrofit.Response<RegisterResponse> response, Retrofit retrofit) {
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
