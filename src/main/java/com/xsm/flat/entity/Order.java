package com.xsm.flat.entity;

public class Order {
    private String oId;

    private String uId;

    private String onOffShelf;

    private Integer fId;

    private String oTime;

    public String getoTime() {
        return oTime;
    }

    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId == null ? null : oId.trim();
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getOnOffShelf() {
        return onOffShelf;
    }

    public void setOnOffShelf(String onOffShelf) {
        this.onOffShelf = onOffShelf == null ? null : onOffShelf.trim();
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
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
        Order other = (Order) that;
        return (this.getoId() == null ? other.getoId() == null : this.getoId().equals(other.getoId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getOnOffShelf() == null ? other.getOnOffShelf() == null : this.getOnOffShelf().equals(other.getOnOffShelf()))
            && (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getoId() == null) ? 0 : getoId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getOnOffShelf() == null) ? 0 : getOnOffShelf().hashCode());
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        return result;
    }

    public Order(String oId, String uId, Integer fId) {
        this.oId = oId;
        this.uId = uId;
        this.fId = fId;
    }

    public Order(String uId, Integer fId) {
        this.uId = uId;
        this.fId = fId;
    }
}