package com.chwangteng.www.param;

public class UpdateReportParam {

    private int reportid;

    private String thisWeek;

    private String bugMeet;

    private String nextWeek;

    public String getThisWeek() {
        return thisWeek;
    }

    public void setThisWeek(String thisWeek) {
        this.thisWeek = thisWeek;
    }

    public String getBugMeet() {
        return bugMeet;
    }

    public void setBugMeet(String bugMeet) {
        this.bugMeet = bugMeet;
    }

    public String getNextWeek() {
        return nextWeek;
    }

    public void setNextWeek(String nextWeek) {
        this.nextWeek = nextWeek;
    }

    public int getReportid() {
        return reportid;
    }

    public void setReportid(int reportid) {
        this.reportid = reportid;
    }
}
