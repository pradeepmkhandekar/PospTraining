package com.posp.trainingapp.core.controller.register;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestmodels.RegisterRequestEntity;

/**
 * Created by Rajeev Ranjan on 24/03/2017.
 */

public interface IRegister {
    void register(RegisterRequestEntity registerRequestEntity, IResponseSubcriber iResponseSubcriber);
}
