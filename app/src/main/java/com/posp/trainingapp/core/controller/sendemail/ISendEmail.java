package com.posp.trainingapp.core.controller.sendemail;

import com.posp.trainingapp.core.IResponseSubcriber;

/**
 * Created by Rajeev Ranjan on 27/04/2017.
 */

public interface ISendEmail {
    void sendEmail(String Email, String UserName, IResponseSubcriber iResponseSubcriber);
}
