package com.posp.trainingapp.core.requestbuilder;

import com.posp.trainingapp.core.RetroRequestBuilder;
import com.posp.trainingapp.core.requestmodels.LoginRequestEntity;
import com.posp.trainingapp.core.response.CertificateResponse;
import com.posp.trainingapp.core.response.LoginResponse;
import com.posp.trainingapp.core.response.LogoutResponse;
import com.posp.trainingapp.core.response.SendAdminResponse;

import java.util.HashMap;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public class LoginRequestBuilder extends RetroRequestBuilder {
    public LoginRequestBuilder.LoginNetworkService getService() {

        return super.build().create(LoginRequestBuilder.LoginNetworkService.class);
    }

    public interface LoginNetworkService {

        @POST(RetroRequestBuilder.secondaryUrl + "/Login")
        Call<LoginResponse> login(@Body LoginRequestEntity loginRequestEntity);

        @POST(RetroRequestBuilder.secondaryUrl + "/Logout")
        Call<LogoutResponse> logout(@Body HashMap<String, String> bodyParameter);

        @POST(RetroRequestBuilder.secondaryUrl + "/SendAdminMail")
        Call<SendAdminResponse> requestAdmin(@Body HashMap<String, String> bodyParameter);

        @POST(RetroRequestBuilder.secondaryUrl + "/ViewCertificate")
        Call<CertificateResponse> getCertificate(@Body HashMap<String, String> bodyParameter);

    }
}
