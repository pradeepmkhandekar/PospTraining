package com.posp.trainingapp.core.controller.login;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestmodels.LoginRequestEntity;

/**
 * Created by Rajeev Ranjan on 23/03/2017.
 */

public interface ILogin {
    void login(LoginRequestEntity loginRequestEntity, IResponseSubcriber iResponseSubcriber);

    void logout(int UserId, int FBAID, IResponseSubcriber iResponseSubcriber);

    void requestAdmin(String email, IResponseSubcriber iResponseSubcriber);

    void getCertificate(IResponseSubcriber iResponseSubcriber);
}
