package com.posp.trainingapp.core.controller.sendemail;

import android.content.Context;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestbuilder.SendEmailRequestBuilder;
import com.posp.trainingapp.core.response.SendEmailResponse;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Rajeev Ranjan on 27/04/2017.
 */

public class SendEmailController implements ISendEmail {


    SendEmailRequestBuilder.SendEmailNetworkService sendEmailNetworkService;
    Context mContext;

    public SendEmailController(Context context) {
        sendEmailNetworkService = new SendEmailRequestBuilder().getService();
        mContext = context;
    }


    @Override
    public void sendEmail(String Email, String UserName, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameters = new HashMap<>();
        bodyParameters.put("Email", Email);
        bodyParameters.put("UserName", UserName);
        sendEmailNetworkService.sendEmail(bodyParameters).enqueue(new Callback<SendEmailResponse>() {
            @Override
            public void onResponse(retrofit.Response<SendEmailResponse> response, Retrofit retrofit) {
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
