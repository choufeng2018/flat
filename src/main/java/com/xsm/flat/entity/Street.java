package com.xsm.flat.entity;

public class Street {
    private String sId;

    private String sName;

    private String cId;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
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
        Street other = (Street) that;
        return (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getsName() == null ? other.getsName() == null : this.getsName().equals(other.getsName()))
            && (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getsName() == null) ? 0 : getsName().hashCode());
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        return result;
    }
}