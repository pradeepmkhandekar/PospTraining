package com.posp.trainingapp.core.controller.question;

import android.content.Context;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestbuilder.QuestionRequestBuilder;
import com.posp.trainingapp.core.response.QuestionResponse;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class QuestionController implements IQuestion {


    QuestionRequestBuilder.QuestionNetworkService questionNetworkService;
    Context mContext;

    public QuestionController(Context context) {
        questionNetworkService = new QuestionRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void getQuestion(int CategoryId, int UserId, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameter = new HashMap<String, String>();


        bodyParameter.put("CategoryId", "" + CategoryId);
        bodyParameter.put("UserId", "" + UserId);
        questionNetworkService.getQuestionSet(bodyParameter).enqueue(new Callback<QuestionResponse>() {
            @Override
            public void onResponse(retrofit.Response<QuestionResponse> response, Retrofit retrofit) {
                try {
                    iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
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
