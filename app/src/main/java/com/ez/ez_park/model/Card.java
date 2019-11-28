package com.ez.ez_park.model;

public class Card {

    private String cardName;
    private long cardNum;
    private String expiryDate;
    private int CVV;

    public Card() {
    }

    public Card(String cardName, long cardNum, String expiryDate, int CVV) {
        this.cardName = cardName;
        this.cardNum = cardNum;
        this.expiryDate = expiryDate;
        this.CVV = CVV;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public long getCardNum() {
        return cardNum;
    }

    public void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

}
