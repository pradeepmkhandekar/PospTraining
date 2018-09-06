package com.posp.trainingapp.core.controller.userpic;

import com.posp.trainingapp.core.IResponseSubcriber;

/**
 * Created by Rajeev Ranjan on 06/04/2017.
 */

public interface IUserPic {
    public void uploadPic(String ImgString, int UserId, IResponseSubcriber iResponseSubcriber);
}
