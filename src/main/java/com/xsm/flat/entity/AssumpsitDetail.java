package com.xsm.flat.entity;

public class AssumpsitDetail {
    private String assId;

    private Integer fId;

    private String assCreatetime;

    private String uId;

    private String assOnOff;

    private String assStatus;

    private String assStarttime;

    private String assEndtime;

    private String userName;

    private Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAssId() {
        return assId;
    }

    public void setAssId(String assId) {
        this.assId = assId == null ? null : assId.trim();
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getAssCreatetime() {
        return assCreatetime;
    }

    public void setAssCreatetime(String assCreatetime) {
        this.assCreatetime = assCreatetime;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getAssOnOff() {
        return assOnOff;
    }

    public void setAssOnOff(String assOnOff) {
        this.assOnOff = assOnOff == null ? null : assOnOff.trim();
    }

    public String getAssStatus() {
        return assStatus;
    }

    public void setAssStatus(String assStatus) {
        this.assStatus = assStatus == null ? null : assStatus.trim();
    }

    public String getAssStarttime() {
        return assStarttime;
    }

    public void setAssStarttime(String assStarttime) {
        this.assStarttime = assStarttime == null ? null : assStarttime.trim();
    }

    public String getAssEndtime() {
        return assEndtime;
    }

    public void setAssEndtime(String assEndtime) {
        this.assEndtime = assEndtime == null ? null : assEndtime.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AssumpsitDetail other = (AssumpsitDetail) that;
        return (this.getAssId() == null ? other.getAssId() == null : this.getAssId().equals(other.getAssId()))
            && (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getAssCreatetime() == null ? other.getAssCreatetime() == null : this.getAssCreatetime().equals(other.getAssCreatetime()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getAssOnOff() == null ? other.getAssOnOff() == null : this.getAssOnOff().equals(other.getAssOnOff()))
            && (this.getAssStatus() == null ? other.getAssStatus() == null : this.getAssStatus().equals(other.getAssStatus()))
            && (this.getAssStarttime() == null ? other.getAssStarttime() == null : this.getAssStarttime().equals(other.getAssStarttime()))
            && (this.getAssEndtime() == null ? other.getAssEndtime() == null : this.getAssEndtime().equals(other.getAssEndtime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAssId() == null) ? 0 : getAssId().hashCode());
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getAssCreatetime() == null) ? 0 : getAssCreatetime().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getAssOnOff() == null) ? 0 : getAssOnOff().hashCode());
        result = prime * result + ((getAssStatus() == null) ? 0 : getAssStatus().hashCode());
        result = prime * result + ((getAssStarttime() == null) ? 0 : getAssStarttime().hashCode());
        result = prime * result + ((getAssEndtime() == null) ? 0 : getAssEndtime().hashCode());
        return result;
    }

    public AssumpsitDetail() {
    }

    public AssumpsitDetail(Integer fId, String assStarttime) {
        this.fId = fId;
        this.assStarttime = assStarttime;
    }

    public AssumpsitDetail(Integer fId, String uId, String assStarttime) {
        this.fId = fId;
        this.uId = uId;
        this.assStarttime = assStarttime;
    }

    public AssumpsitDetail(String assId, Integer fId, String uId, String assStarttime) {
        this.assId = assId;
        this.fId = fId;
        this.uId = uId;
        this.assStarttime = assStarttime;
    }
}