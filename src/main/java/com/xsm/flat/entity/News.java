package com.xsm.flat.entity;

import java.util.Date;

public class News {
    private String nId;

    private Integer fId;

    private String nInfo;

    private String nCreatime;

    private Flat flat;

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public String getnId() {
        return nId;
    }

    public void setnId(String nId) {
        this.nId = nId == null ? null : nId.trim();
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getnInfo() {
        return nInfo;
    }

    public void setnInfo(String nInfo) {
        this.nInfo = nInfo == null ? null : nInfo.trim();
    }

    public String getnCreatime() {
        return nCreatime;
    }

    public void setnCreatime(String nCreatime) {
        this.nCreatime = nCreatime;
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
        News other = (News) that;
        return (this.getnId() == null ? other.getnId() == null : this.getnId().equals(other.getnId()))
            && (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getnInfo() == null ? other.getnInfo() == null : this.getnInfo().equals(other.getnInfo()))
            && (this.getnCreatime() == null ? other.getnCreatime() == null : this.getnCreatime().equals(other.getnCreatime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getnId() == null) ? 0 : getnId().hashCode());
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getnInfo() == null) ? 0 : getnInfo().hashCode());
        result = prime * result + ((getnCreatime() == null) ? 0 : getnCreatime().hashCode());
        return result;
    }
}