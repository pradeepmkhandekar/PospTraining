package com.posp.trainingapp.core.requestmodels;

/**
 * Created by Rajeev Ranjan on 03/05/2017.
 */

public class SyncRequestEntity {
    /**
     * CurrentStudyTime : 9223372036854775807
     * FBAId : 2147483647
     * ModuleNo : 2147483647
     * UserId : 2147483647
     */

    private long CurrentStudyTime;
    private int FBAId;
    private int ModuleNo;
    private int UserId;
    /**
     * checkstatus : String content
     */

    private String checkstatus;
    /**
     * CategoryId : 2147483647
     * CurrentStudyTimeLI : 9223372036854775807
     */

    private int CategoryId;
    private long CurrentStudyTimeLI;

    public long getCurrentStudyTime() {
        return CurrentStudyTime;
    }

    public void setCurrentStudyTime(long CurrentStudyTime) {
        this.CurrentStudyTime = CurrentStudyTime;
    }

    public int getFBAId() {
        return FBAId;
    }

    public void setFBAId(int FBAId) {
        this.FBAId = FBAId;
    }

    public int getModuleNo() {
        return ModuleNo;
    }

    public void setModuleNo(int ModuleNo) {
        this.ModuleNo = ModuleNo;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(String checkstatus) {
        this.checkstatus = checkstatus;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public long getCurrentStudyTimeLI() {
        return CurrentStudyTimeLI;
    }

    public void setCurrentStudyTimeLI(long CurrentStudyTimeLI) {
        this.CurrentStudyTimeLI = CurrentStudyTimeLI;
    }
}
