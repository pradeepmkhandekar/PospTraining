package com.posp.trainingapp.core.requestbuilder;

import com.posp.trainingapp.core.RetroRequestBuilder;
import com.posp.trainingapp.core.requestmodels.RegisterRequestEntity;
import com.posp.trainingapp.core.response.RegisterResponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class RegisterRequestBuilder extends RetroRequestBuilder {
    public RegisterRequestBuilder.RegisterNetworkService getService() {

        return super.build().create(RegisterRequestBuilder.RegisterNetworkService.class);
    }

    public interface RegisterNetworkService {

        @POST(RetroRequestBuilder.secondaryUrl+"/Register")
        Call<RegisterResponse> register(@Body RegisterRequestEntity registerRequestEntity);
    }
}
