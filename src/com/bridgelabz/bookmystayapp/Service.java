package com.bridgelabz.bookmystayapp;

public class Service {
    private String serviceName;
    private double price;

    public Service(String serviceName, double price){
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
}
