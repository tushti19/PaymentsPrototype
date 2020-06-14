package com.anddev.paymentsprototype;

public class liveOrdersInfo {

    String shopName;
    String dateTime;
    String location;
    String Id;
    String Price;
    String recieved;
    String processed;
    String ready;
    String rated;
    String completed;

    public liveOrdersInfo() {
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getRecieved() {
        return recieved;
    }

    public void setRecieved(String recieved) {
        this.recieved = recieved;
    }

    public String getProcessed() {
        return processed;
    }

    public void setProcessed(String processed) {
        this.processed = processed;
    }

    public String getReady() {
        return ready;
    }

    public void setReady(String ready) {
        this.ready = ready;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public liveOrdersInfo(String shopName, String dateTime, String location, String id, String price, String recieved, String processed, String ready, String completed, String rated) {
        this.shopName = shopName;
        this.dateTime = dateTime;
        this.location = location;
        Id = id;
        Price = price;
        this.recieved = recieved;
        this.processed = processed;
        this.ready = ready;
        this.completed = completed;
        this.rated = rated;
    }
}
