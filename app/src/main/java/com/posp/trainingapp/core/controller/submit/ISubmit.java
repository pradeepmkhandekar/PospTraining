package com.posp.trainingapp.core.controller.submit;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestmodels.SubmitRequestEntity;

/**
 * Created by Rajeev Ranjan on 03/04/2017.
 */

public interface ISubmit {
    public void submitAnswer(SubmitRequestEntity submitRequestEntity, IResponseSubcriber iResponseSubcriber);
}
