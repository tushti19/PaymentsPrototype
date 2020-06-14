package com.anddev.paymentsprototype;

public class pdfInfo {

    String Name;
    String Price;
    String Size;

    public pdfInfo() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public pdfInfo(String name, String price, String size) {
        Name = name;
        Price = price;
        Size = size;
    }
}
