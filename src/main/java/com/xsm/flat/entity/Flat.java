package com.xsm.flat.entity;

import java.io.Serializable;

public class Flat implements Serializable  {

    private static final long serialVersionUID = 1L;

    private Integer fId;

    private String fName;

    private String fType;

    private String fHabitable;

    private String fPrice;

    private String fMinPrice;

    private String fMaxPrice;

    private String uId;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    private String pName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getfMinPrice() {
        return fMinPrice;
    }

    public void setfMinPrice(String fMinPrice) {
        this.fMinPrice = fMinPrice;
    }

    public String getfMaxPrice() {
        return fMaxPrice;
    }

    public void setfMaxPrice(String fMaxPrice) {
        this.fMaxPrice = fMaxPrice;
    }

    private String pId;

    private String sId;

    private String fStreet;

    private String fAge;

    private String fDetails;

    private String fRequire;

    private String fPic;

    private String fArea;

    private String fOrientation;

    private String fFloor;

    private String fToilet;

    private String fShower;

    private String fHeating;

    private String fStatus;

    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName == null ? null : fName.trim();
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType == null ? null : fType.trim();
    }

    public String getfHabitable() {
        return fHabitable;
    }

    public void setfHabitable(String fHabitable) {
        this.fHabitable = fHabitable == null ? null : fHabitable.trim();
    }

    public String getfPrice() {
        return fPrice;
    }

    public void setfPrice(String fPrice) {
        this.fPrice = fPrice == null ? null : fPrice.trim();
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String getfStreet() {
        return fStreet;
    }

    public void setfStreet(String fStreet) {
        this.fStreet = fStreet == null ? null : fStreet.trim();
    }

    public String getfAge() {
        return fAge;
    }

    public void setfAge(String fAge) {
        this.fAge = fAge == null ? null : fAge.trim();
    }

    public String getfDetails() {
        return fDetails;
    }

    public void setfDetails(String fDetails) {
        this.fDetails = fDetails == null ? null : fDetails.trim();
    }

    public String getfRequire() {
        return fRequire;
    }

    public void setfRequire(String fRequire) {
        this.fRequire = fRequire == null ? null : fRequire.trim();
    }

    public String getfPic() {
        return fPic;
    }

    public void setfPic(String fPic) {
        this.fPic = fPic == null ? null : fPic.trim();
    }

    public String getfArea() {
        return fArea;
    }

    public void setfArea(String fArea) {
        this.fArea = fArea == null ? null : fArea.trim();
    }

    public String getfOrientation() {
        return fOrientation;
    }

    public void setfOrientation(String fOrientation) {
        this.fOrientation = fOrientation == null ? null : fOrientation.trim();
    }

    public String getfFloor() {
        return fFloor;
    }

    public void setfFloor(String fFloor) {
        this.fFloor = fFloor == null ? null : fFloor.trim();
    }

    public String getfToilet() {
        return fToilet;
    }

    public void setfToilet(String fToilet) {
        this.fToilet = fToilet == null ? null : fToilet.trim();
    }

    public String getfShower() {
        return fShower;
    }

    public void setfShower(String fShower) {
        this.fShower = fShower == null ? null : fShower.trim();
    }

    public String getfHeating() {
        return fHeating;
    }

    public void setfHeating(String fHeating) {
        this.fHeating = fHeating == null ? null : fHeating.trim();
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
        Flat other = (Flat) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfName() == null ? other.getfName() == null : this.getfName().equals(other.getfName()))
            && (this.getfType() == null ? other.getfType() == null : this.getfType().equals(other.getfType()))
            && (this.getfHabitable() == null ? other.getfHabitable() == null : this.getfHabitable().equals(other.getfHabitable()))
            && (this.getfPrice() == null ? other.getfPrice() == null : this.getfPrice().equals(other.getfPrice()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getfStreet() == null ? other.getfStreet() == null : this.getfStreet().equals(other.getfStreet()))
            && (this.getfAge() == null ? other.getfAge() == null : this.getfAge().equals(other.getfAge()))
            && (this.getfDetails() == null ? other.getfDetails() == null : this.getfDetails().equals(other.getfDetails()))
            && (this.getfRequire() == null ? other.getfRequire() == null : this.getfRequire().equals(other.getfRequire()))
            && (this.getfPic() == null ? other.getfPic() == null : this.getfPic().equals(other.getfPic()))
            && (this.getfArea() == null ? other.getfArea() == null : this.getfArea().equals(other.getfArea()))
            && (this.getfOrientation() == null ? other.getfOrientation() == null : this.getfOrientation().equals(other.getfOrientation()))
            && (this.getfFloor() == null ? other.getfFloor() == null : this.getfFloor().equals(other.getfFloor()))
            && (this.getfToilet() == null ? other.getfToilet() == null : this.getfToilet().equals(other.getfToilet()))
            && (this.getfShower() == null ? other.getfShower() == null : this.getfShower().equals(other.getfShower()))
            && (this.getfHeating() == null ? other.getfHeating() == null : this.getfHeating().equals(other.getfHeating()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfName() == null) ? 0 : getfName().hashCode());
        result = prime * result + ((getfType() == null) ? 0 : getfType().hashCode());
        result = prime * result + ((getfHabitable() == null) ? 0 : getfHabitable().hashCode());
        result = prime * result + ((getfPrice() == null) ? 0 : getfPrice().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getfStreet() == null) ? 0 : getfStreet().hashCode());
        result = prime * result + ((getfAge() == null) ? 0 : getfAge().hashCode());
        result = prime * result + ((getfDetails() == null) ? 0 : getfDetails().hashCode());
        result = prime * result + ((getfRequire() == null) ? 0 : getfRequire().hashCode());
        result = prime * result + ((getfPic() == null) ? 0 : getfPic().hashCode());
        result = prime * result + ((getfArea() == null) ? 0 : getfArea().hashCode());
        result = prime * result + ((getfOrientation() == null) ? 0 : getfOrientation().hashCode());
        result = prime * result + ((getfFloor() == null) ? 0 : getfFloor().hashCode());
        result = prime * result + ((getfToilet() == null) ? 0 : getfToilet().hashCode());
        result = prime * result + ((getfShower() == null) ? 0 : getfShower().hashCode());
        result = prime * result + ((getfHeating() == null) ? 0 : getfHeating().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "fId='" + fId + '\'' +
                ", fName='" + fName + '\'' +
                ", fType='" + fType + '\'' +
                ", fHabitable='" + fHabitable + '\'' +
                ", fPrice='" + fPrice + '\'' +
                ", pId='" + pId + '\'' +
                ", sId='" + sId + '\'' +
                ", fStreet='" + fStreet + '\'' +
                ", fAge='" + fAge + '\'' +
                ", fDetails='" + fDetails + '\'' +
                ", fRequire='" + fRequire + '\'' +
                ", fPic='" + fPic + '\'' +
                ", fArea='" + fArea + '\'' +
                ", fOrientation='" + fOrientation + '\'' +
                ", fFloor='" + fFloor + '\'' +
                ", fToilet='" + fToilet + '\'' +
                ", fShower='" + fShower + '\'' +
                ", fHeating='" + fHeating + '\'' +
                '}';
    }

    public Flat(String uId, Integer fId) {
        this.fId = fId;
        this.uId = uId;
    }

    public Flat() {
    }
}