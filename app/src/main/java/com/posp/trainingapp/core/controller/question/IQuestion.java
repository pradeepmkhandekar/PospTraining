package com.posp.trainingapp.core.controller.question;

import com.posp.trainingapp.core.IResponseSubcriber;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public interface IQuestion {
    void getQuestion(int CategoryId,int UserId, IResponseSubcriber iResponseSubcriber);
}
