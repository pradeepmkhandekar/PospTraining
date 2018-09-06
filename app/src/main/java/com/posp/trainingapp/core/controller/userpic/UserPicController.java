package com.posp.trainingapp.core.controller.userpic;

import android.content.Context;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestbuilder.UserPicRequestBuilder;
import com.posp.trainingapp.core.response.UserPicResponse;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Rajeev Ranjan on 06/04/2017.
 */

public class UserPicController implements IUserPic {
    UserPicRequestBuilder.UserPicNetworkService userPicNetworkService;
    Context mContext;

    public UserPicController(Context context) {
        userPicNetworkService = new UserPicRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void uploadPic(String ImgString, int UserId, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameters = new HashMap<>();
        bodyParameters.put("ImgString", ImgString);
        bodyParameters.put("UserId", "" + UserId);
        userPicNetworkService.uploadPicture(bodyParameters).enqueue(new Callback<UserPicResponse>() {
            @Override
            public void onResponse(retrofit.Response<UserPicResponse> response, Retrofit retrofit) {
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
