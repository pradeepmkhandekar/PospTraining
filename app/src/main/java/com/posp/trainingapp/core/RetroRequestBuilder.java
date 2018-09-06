package com.posp.trainingapp.core;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public abstract class RetroRequestBuilder {

//http://49.50.95.141:97/EducationAppWebService.svc/GetQuestionsByLogin
//protected String basicUrl = "http://49.50.95.141:97";
///EducationAppWebService.svc/GetQuestionsByLogin

    //live url rupeeboss
    //protected String basicUrl = "http://49.50.95.141:97";
   // public final static String secondaryUrl = "/EducationAppWebService.svc";

    //live url policyboss
    protected String basicUrl = "http://edu.policyboss.com";
    public final static String secondaryUrl = "/eduappservice/EducationAppWebService.svc";


    //uat url
    //protected String basicUrl = "http://49.50.95.141:99";
    //public final static String secondaryUrl = "/EducationAppWebService.svc";

    //uat url
    //protected String basicUrl = "http://uat.oyeraddi.com";
    //public final static String secondaryUrl = "/EducationappUat/EducationAppWebService.svc/";
    static Retrofit restAdapter = null;


    protected Retrofit build() {
        if (restAdapter == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient httpClient = new OkHttpClient();
            httpClient.setReadTimeout(90, TimeUnit.SECONDS);
            httpClient.setConnectTimeout(90, TimeUnit.SECONDS);
            httpClient.interceptors().add(logging);
            restAdapter = new Retrofit.Builder()
                    .baseUrl(basicUrl)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return restAdapter;
    }

}