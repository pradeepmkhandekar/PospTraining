package com.posp.trainingapp.core.controller.login;

import android.content.Context;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestbuilder.LoginRequestBuilder;
import com.posp.trainingapp.core.requestmodels.LoginRequestEntity;
import com.posp.trainingapp.core.response.CertificateResponse;
import com.posp.trainingapp.core.response.LoginResponse;
import com.posp.trainingapp.core.response.LogoutResponse;
import com.posp.trainingapp.core.response.SendAdminResponse;
import com.posp.trainingapp.facade.LoginFacade;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.Retrofit;

/**
 * Created by Rajeev Ranjan on 23/03/2017.
 */

public class LoginController implements ILogin {
    LoginRequestBuilder.LoginNetworkService loginNetworkService;
    Context mContext;

    public LoginController(Context context) {
        loginNetworkService = new LoginRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void login(LoginRequestEntity loginRequestEntity, final IResponseSubcriber iResponseSubcriber) {

        loginNetworkService.login(loginRequestEntity).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(retrofit.Response<LoginResponse> response, Retrofit retrofit) {
                try {

                    new LoginFacade(mContext).storeUser(response.body().getResult());
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

    @Override
    public void logout(int UserId, int FBAID, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameters = new HashMap<String, String>();
        bodyParameters.put("UserId", "" + UserId);
        bodyParameters.put("FBAId", "" + FBAID);
        loginNetworkService.logout(bodyParameters).enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(retrofit.Response<LogoutResponse> response, Retrofit retrofit) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        ///new LoginFacade(mContext).storeUser(response.body().getResult());
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

    @Override
    public void requestAdmin(String email, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameters = new HashMap<String, String>();
        bodyParameters.put("email", email);
        loginNetworkService.requestAdmin(bodyParameters).enqueue(new Callback<SendAdminResponse>() {
            @Override
            public void onResponse(retrofit.Response<SendAdminResponse> response, Retrofit retrofit) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        ///new LoginFacade(mContext).storeUser(response.body().getResult());
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

    @Override
    public void getCertificate(final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameters = new HashMap<String, String>();
        bodyParameters.put("UserId", "" + new LoginFacade(mContext).getUser().getUserId());
        loginNetworkService.getCertificate(bodyParameters).enqueue(new Callback<CertificateResponse>() {
            @Override
            public void onResponse(retrofit.Response<CertificateResponse> response, Retrofit retrofit) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        ///new LoginFacade(mContext).storeUser(response.body().getResult());
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
