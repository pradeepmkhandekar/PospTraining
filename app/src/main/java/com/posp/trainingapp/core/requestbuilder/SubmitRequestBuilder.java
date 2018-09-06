package com.posp.trainingapp.core.requestbuilder;

import com.posp.trainingapp.core.RetroRequestBuilder;
import com.posp.trainingapp.core.requestmodels.SubmitRequestEntity;
import com.posp.trainingapp.core.response.SubmitResponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Rajeev Ranjan on 03/04/2017.
 */

public class SubmitRequestBuilder extends RetroRequestBuilder {
    public SubmitRequestBuilder.SubmitNetworkService getService() {

        return super.build().create(SubmitRequestBuilder.SubmitNetworkService.class);
    }

    public interface SubmitNetworkService {
        @POST(RetroRequestBuilder.secondaryUrl+"/SubmitExam")
        Call<SubmitResponse> submitAnswer(@Body SubmitRequestEntity submitRequestEntity);
    }
}
