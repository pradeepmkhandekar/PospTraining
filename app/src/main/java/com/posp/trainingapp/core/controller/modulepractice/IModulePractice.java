package com.posp.trainingapp.core.controller.modulepractice;

import com.posp.trainingapp.core.IResponseSubcriber;
import com.posp.trainingapp.core.requestmodels.SyncRequestEntity;

/**
 * Created by Rajeev Ranjan on 17/04/2017.
 */

public interface IModulePractice {
    void getModuleQuestion(int ModuleNo, int CategoryId, int UserId, IResponseSubcriber iResponseSubcriber);

    void getSyncTime(SyncRequestEntity syncRequestEntity, IResponseSubcriber iResponseSubcriber);
}
