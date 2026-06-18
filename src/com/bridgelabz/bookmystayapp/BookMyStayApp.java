package com.bridgelabz.bookmystayapp;

public class BookMyStayApp {
    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();

        inventory.addRoomType("Single", 10, 2000);
        inventory.addRoomType("Double", 5, 3500);
        inventory.addRoomType("Suite", 2, 7000);

        System.out.println("===== HOTEL INVENTORY =====");

        inventory.displayInventory();

        System.out.println("\nSingle Room Price : "
                + inventory.getPrice("Single"));

        System.out.println("Suite Availability : "
                + inventory.getAvailableRooms("Suite"));

        System.out.println("===== SEARCHING ROOMS =====");

        SearchService searchService =
                new SearchService(inventory);

        System.out.println("Searching Single Room");

        searchService.searchRoom("Single");

        System.out.println();

        System.out.println("Searching Double Room");

        searchService.searchRoom("Double");
    }

}
