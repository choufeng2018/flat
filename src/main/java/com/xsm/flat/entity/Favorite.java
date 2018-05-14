package com.xsm.flat.entity;

import java.util.Date;

public class Favorite {
    private String favId;

    private String uId;

    private Integer fId;

    private String fCreatime;

    public String getFavId() {
        return favId;
    }

    public void setFavId(String favId) {
        this.favId = favId == null ? null : favId.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String  getfCreatime() {
        return fCreatime;
    }

    public void setfCreatime(String fCreatime) {
        this.fCreatime = fCreatime;
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
        Favorite other = (Favorite) that;
        return (this.getFavId() == null ? other.getFavId() == null : this.getFavId().equals(other.getFavId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfCreatime() == null ? other.getfCreatime() == null : this.getfCreatime().equals(other.getfCreatime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFavId() == null) ? 0 : getFavId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfCreatime() == null) ? 0 : getfCreatime().hashCode());
        return result;
    }

    public Favorite(String favId, String uId, Integer fId) {
        this.favId = favId;
        this.uId = uId;
        this.fId = fId;
    }

    public Favorite(String uId, Integer fId) {
        this.uId = uId;
        this.fId = fId;
    }
}