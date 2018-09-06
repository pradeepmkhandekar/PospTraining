package com.posp.trainingapp.core.requestbuilder;

import com.posp.trainingapp.core.RetroRequestBuilder;
import com.posp.trainingapp.core.response.UserPicResponse;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Rajeev Ranjan on 06/04/2017.
 */

public class UserPicRequestBuilder extends RetroRequestBuilder {
    public UserPicRequestBuilder.UserPicNetworkService getService() {

        return super.build().create(UserPicRequestBuilder.UserPicNetworkService.class);
    }

    public interface UserPicNetworkService {

        @POST(RetroRequestBuilder.secondaryUrl + "/CaptureEmployeePic")
        Call<UserPicResponse> uploadPicture(@Body HashMap<String, String> bodyParameter);
    }
}
