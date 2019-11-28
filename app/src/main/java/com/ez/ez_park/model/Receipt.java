package com.ez.ez_park.model;

public class Receipt {

    private long receiptNum;
    private String userID;
    private String carPlate;
    private String dateTime;
    private int duration;
    private String buildingCode;
    private double cost;

    public Receipt() {
    }

    public Receipt(long receiptNum, String userId, String carPlate, String dateTime, int duration, String buildingCode, double cost) {
        this.receiptNum = receiptNum;
        this.userID = userId;
        this.carPlate = carPlate;
        this.dateTime = dateTime;
        this.duration = duration;
        this.buildingCode = buildingCode;
        this.cost = cost;
    }

    public long getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(long receiptNum) {
        this.receiptNum = receiptNum;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    private void calculateCost(){

    }
}
