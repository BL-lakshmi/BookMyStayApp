package com.bridgelabz.bookmystayapp;

public class SearchService {
    private InventoryService inventory;

    public SearchService(InventoryService inventory) {
        this.inventory = inventory;
    }

    public void searchRoom(String roomType){

        int available =
                inventory.getAvailableRooms(roomType);

        if(available > 0){

            System.out.println("Available");
            System.out.println("Price : " +
                    inventory.getPrice(roomType));

        }else{
            System.out.println("Not Available");
        }
    }
}
