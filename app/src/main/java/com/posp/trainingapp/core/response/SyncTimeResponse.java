package com.posp.trainingapp.core.response;

import com.posp.trainingapp.core.APIResponse;

/**
 * Created by Rajeev Ranjan on 03/05/2017.
 */

public class SyncTimeResponse extends APIResponse {

    /**
     * CurrentStudyTime : 9223372036854775807
     * TotalStudyTime : 9223372036854775807
     */

    private long CurrentStudyTime;
    private long TotalStudyTime;
    /**
     * IsEligible : true
     */

    private boolean IsEligible;
    /**
     * IsLogin : true
     */

    private boolean IsLogin;
    /**
     * CurrentStudyTimeLI : 9223372036854775807
     * IsGIEligible : true
     * IsLIEligible : true
     * TotalStudyTimeGI : 9223372036854775807
     * TotalStudyTimeLI : 9223372036854775807
     */

    private long CurrentStudyTimeLI;
    private boolean IsGIEligible;
    private boolean IsLIEligible;
    private long TotalStudyTimeGI;
    private long TotalStudyTimeLI;

    public long getCurrentStudyTime() {
        return CurrentStudyTime;
    }

    public void setCurrentStudyTime(long CurrentStudyTime) {
        this.CurrentStudyTime = CurrentStudyTime;
    }

    public long getTotalStudyTime() {
        return TotalStudyTime;
    }

    public void setTotalStudyTime(long TotalStudyTime) {
        this.TotalStudyTime = TotalStudyTime;
    }

    public boolean isIsEligible() {
        return IsEligible;
    }

    public void setIsEligible(boolean IsEligible) {
        this.IsEligible = IsEligible;
    }

    public boolean isIsLogin() {
        return IsLogin;
    }

    public void setIsLogin(boolean IsLogin) {
        this.IsLogin = IsLogin;
    }

    public long getCurrentStudyTimeLI() {
        return CurrentStudyTimeLI;
    }

    public void setCurrentStudyTimeLI(long CurrentStudyTimeLI) {
        this.CurrentStudyTimeLI = CurrentStudyTimeLI;
    }

    public boolean isIsGIEligible() {
        return IsGIEligible;
    }

    public void setIsGIEligible(boolean IsGIEligible) {
        this.IsGIEligible = IsGIEligible;
    }

    public boolean isIsLIEligible() {
        return IsLIEligible;
    }

    public void setIsLIEligible(boolean IsLIEligible) {
        this.IsLIEligible = IsLIEligible;
    }

    public long getTotalStudyTimeGI() {
        return TotalStudyTimeGI;
    }

    public void setTotalStudyTimeGI(long TotalStudyTimeGI) {
        this.TotalStudyTimeGI = TotalStudyTimeGI;
    }

    public long getTotalStudyTimeLI() {
        return TotalStudyTimeLI;
    }

    public void setTotalStudyTimeLI(long TotalStudyTimeLI) {
        this.TotalStudyTimeLI = TotalStudyTimeLI;
    }
}
