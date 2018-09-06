package com.posp.trainingapp.core.requestbuilder;

import com.posp.trainingapp.core.RetroRequestBuilder;
import com.posp.trainingapp.core.response.SendEmailResponse;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Rajeev Ranjan on 27/04/2017.
 */

public class SendEmailRequestBuilder extends RetroRequestBuilder {
    public SendEmailRequestBuilder.SendEmailNetworkService getService() {

        return super.build().create(SendEmailRequestBuilder.SendEmailNetworkService.class);
    }

    public interface SendEmailNetworkService {

        @POST(RetroRequestBuilder.secondaryUrl + "/SendEmailLink")
        Call<SendEmailResponse> sendEmail(@Body HashMap<String, String> bodyParameter);
    }
}
