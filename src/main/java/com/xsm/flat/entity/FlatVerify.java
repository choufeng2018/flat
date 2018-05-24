package com.xsm.flat.entity;

public class FlatVerify {
    private String fId;

    private String fCity;

    private String fName;

    private String fUnit;

    private String fHouse;

    private String fExpectprice;

    private String fOwnername;

    private String fOwnermobile;

    private String fBuilding;

    private String fStatus;

    private String uId;

    private String fVtime;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getfVtime() {
        return fVtime;
    }

    public void setfVtime(String fVtime) {
        this.fVtime = fVtime;
    }



    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getfId() {
        return fId;
    }

    public void setfId(String fId) {
        this.fId = fId == null ? null : fId.trim();
    }

    public String getfCity() {
        return fCity;
    }

    public void setfCity(String fCity) {
        this.fCity = fCity == null ? null : fCity.trim();
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfUnit() {
        return fUnit;
    }

    public void setfUnit(String fUnit) {
        this.fUnit = fUnit == null ? null : fUnit.trim();
    }

    public String getfHouse() {
        return fHouse;
    }

    public void setfHouse(String fHouse) {
        this.fHouse = fHouse == null ? null : fHouse.trim();
    }

    public String getfExpectprice() {
        return fExpectprice;
    }

    public void setfExpectprice(String fExpectprice) {
        this.fExpectprice = fExpectprice == null ? null : fExpectprice.trim();
    }

    public String getfOwnername() {
        return fOwnername;
    }

    public void setfOwnername(String fOwnername) {
        this.fOwnername = fOwnername == null ? null : fOwnername.trim();
    }

    public String getfOwnermobile() {
        return fOwnermobile;
    }

    public void setfOwnermobile(String fOwnermobile) {
        this.fOwnermobile = fOwnermobile == null ? null : fOwnermobile.trim();
    }

    public String getfBuilding() {
        return fBuilding;
    }

    public void setfBuilding(String fBuilding) {
        this.fBuilding = fBuilding == null ? null : fBuilding.trim();
    }

    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus == null ? null : fStatus.trim();
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
        FlatVerify other = (FlatVerify) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfCity() == null ? other.getfCity() == null : this.getfCity().equals(other.getfCity()))
            && (this.getfName() == null ? other.getfName() == null : this.getfName().equals(other.getfName()))
            && (this.getfUnit() == null ? other.getfUnit() == null : this.getfUnit().equals(other.getfUnit()))
            && (this.getfHouse() == null ? other.getfHouse() == null : this.getfHouse().equals(other.getfHouse()))
            && (this.getfExpectprice() == null ? other.getfExpectprice() == null : this.getfExpectprice().equals(other.getfExpectprice()))
            && (this.getfOwnername() == null ? other.getfOwnername() == null : this.getfOwnername().equals(other.getfOwnername()))
            && (this.getfOwnermobile() == null ? other.getfOwnermobile() == null : this.getfOwnermobile().equals(other.getfOwnermobile()))
            && (this.getfBuilding() == null ? other.getfBuilding() == null : this.getfBuilding().equals(other.getfBuilding()))
            && (this.getfStatus() == null ? other.getfStatus() == null : this.getfStatus().equals(other.getfStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfCity() == null) ? 0 : getfCity().hashCode());
        result = prime * result + ((getfName() == null) ? 0 : getfName().hashCode());
        result = prime * result + ((getfUnit() == null) ? 0 : getfUnit().hashCode());
        result = prime * result + ((getfHouse() == null) ? 0 : getfHouse().hashCode());
        result = prime * result + ((getfExpectprice() == null) ? 0 : getfExpectprice().hashCode());
        result = prime * result + ((getfOwnername() == null) ? 0 : getfOwnername().hashCode());
        result = prime * result + ((getfOwnermobile() == null) ? 0 : getfOwnermobile().hashCode());
        result = prime * result + ((getfBuilding() == null) ? 0 : getfBuilding().hashCode());
        result = prime * result + ((getfStatus() == null) ? 0 : getfStatus().hashCode());
        return result;
    }
}