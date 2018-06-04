package com.xsm.flat.entity;

/**
 * Created by 薛时鸣 on 2018/5/15.
 */
public class RemarkDetail {
    private String rId;

    private Integer fId;

    private String rSendname;

    private String rBelongname;

    private String rInfo;

    private Flat flat;

    public RemarkDetail(Flat flat) {
        this.flat = flat;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getrSendname() {
        return rSendname;
    }

    public void setrSendname(String rSendname) {
        this.rSendname = rSendname == null ? null : rSendname.trim();
    }

    public String getrBelongname() {
        return rBelongname;
    }

    public void setrBelongname(String rBelongname) {
        this.rBelongname = rBelongname == null ? null : rBelongname.trim();
    }

    public String getrInfo() {
        return rInfo;
    }

    public void setrInfo(String rInfo) {
        this.rInfo = rInfo == null ? null : rInfo.trim();
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
        Remark other = (Remark) that;
        return (this.getrId() == null ? other.getrId() == null : this.getrId().equals(other.getrId()))
                && (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
                && (this.getrSendname() == null ? other.getrSendname() == null : this.getrSendname().equals(other.getrSendname()))
                && (this.getrBelongname() == null ? other.getrBelongname() == null : this.getrBelongname().equals(other.getrBelongname()))
                && (this.getrInfo() == null ? other.getrInfo() == null : this.getrInfo().equals(other.getrInfo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getrId() == null) ? 0 : getrId().hashCode());
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getrSendname() == null) ? 0 : getrSendname().hashCode());
        result = prime * result + ((getrBelongname() == null) ? 0 : getrBelongname().hashCode());
        result = prime * result + ((getrInfo() == null) ? 0 : getrInfo().hashCode());
        return result;
    }

    public RemarkDetail(String rId, Integer fId, String rSendname, String rBelongname, String rInfo) {
        this.rBelongname = rBelongname;
        this.rId = rId;
        this.fId = fId;
        this.rSendname = rSendname;
        this.rInfo = rInfo;
    }


    public RemarkDetail() {

    }
}
