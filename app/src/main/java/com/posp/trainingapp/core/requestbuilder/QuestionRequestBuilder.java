package com.posp.trainingapp.core.requestbuilder;

import com.posp.trainingapp.core.RetroRequestBuilder;
import com.posp.trainingapp.core.response.QuestionResponse;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class QuestionRequestBuilder extends RetroRequestBuilder {
    public QuestionRequestBuilder.QuestionNetworkService getService() {

        return super.build().create(QuestionRequestBuilder.QuestionNetworkService.class);
    }

    public interface QuestionNetworkService {
        @POST(RetroRequestBuilder.secondaryUrl+"/GetQuestionsByLogin")
        Call<QuestionResponse> getQuestionSet(@Body HashMap<String, String> bodyParameter);
    }
}
