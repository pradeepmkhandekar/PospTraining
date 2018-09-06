package com.posp.trainingapp.core.requestbuilder;

import com.posp.trainingapp.core.RetroRequestBuilder;
import com.posp.trainingapp.core.requestmodels.SyncRequestEntity;
import com.posp.trainingapp.core.response.ModulePracticeResponse;
import com.posp.trainingapp.core.response.SyncTimeResponse;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Rajeev Ranjan on 17/04/2017.
 */

public class ModulePracticeRequestBuilder extends RetroRequestBuilder {
    public ModulePracticeRequestBuilder.ModulePracticeNetworkService getService() {

        return super.build().create(ModulePracticeRequestBuilder.ModulePracticeNetworkService.class);
    }

    public interface ModulePracticeNetworkService {

        @POST(RetroRequestBuilder.secondaryUrl + "/GetPracticeSet")
        Call<ModulePracticeResponse> getModulePractice(@Body HashMap<String, String> bodyParameter);

        @POST(RetroRequestBuilder.secondaryUrl + "/SynchroniseTime")
        Call<SyncTimeResponse> getSyncTime(@Body SyncRequestEntity syncRequestEntity);
    }
}
