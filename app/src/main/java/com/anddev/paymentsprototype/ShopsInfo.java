package com.anddev.paymentsprototype;

public class ShopsInfo {

    String ShpsName;
    String Location;
    String status;
    String open;
    String close;
    String close_time;
    String Distance;

    public ShopsInfo() {
    }

    public ShopsInfo(String shpsName, String location, String status, String open, String close, String close_time, String Distance) {
        ShpsName = shpsName;
        Location = location;
        this.status = status;
        this.open = open;
        this.close = close;
        this.close_time = close_time;
        this.Distance = Distance;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getShpsName() {
        return ShpsName;
    }

    public void setShpsName(String shpsName) {
        ShpsName = shpsName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getClose_time() {
        return close_time;
    }

    public void setClose_time(String close_time) {
        this.close_time = close_time;
    }
}
