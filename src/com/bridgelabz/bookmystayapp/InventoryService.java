package com.bridgelabz.bookmystayapp;

import java.util.HashMap;

public class InventoryService {
    private HashMap<String,Integer> roomCount = new HashMap<>();
    private HashMap<String,Double> roomPrice = new HashMap<>();

    public void addRoomType(String roomType,
                            int count,
                            double price){

        roomCount.put(roomType,count);
        roomPrice.put(roomType,price);
    }

    public void displayInventory(){
        for(String roomType : roomCount.keySet()){

            System.out.println(
                    roomType +
                            " Available : " +
                            roomCount.get(roomType)
            );
        }
    }

    public int getAvailableRooms(String roomType){
        return roomCount.getOrDefault(roomType,0);
    }

    public double getPrice(String roomType){
        return roomPrice.getOrDefault(roomType,0.0);
    }

    public void decrementRoom(String roomType){

        roomCount.put(
                roomType,
                roomCount.get(roomType)-1
        );
    }
}
