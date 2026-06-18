package com.bridgelabz.bookmystayapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceManager {
    private Map<String, List<Service>> reservationServices = new HashMap<>();

    public void addService(
            String reservationId,
            Service service){
        reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }

    public double calculateTotalServiceCost(String reservationId){
        double total = 0;
        List<Service> services = reservationServices.get(reservationId);
        if(services != null){
            for(Service s : services){
                total += s.getPrice();
            }
        }
        return total;
    }
}
