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

        System.out.println("BOOKING QUEUE SERVICE");
        BookingQueueService queue =
                new BookingQueueService();

        Reservation r1 =
                new Reservation(
                        "R101",
                        "Lakshmi",
                        "Single");

        Reservation r2 =
                new Reservation(
                        "R102",
                        "Kumar",
                        "Double");
        Reservation r3 =
                new Reservation(
                        "R103",
                        "Priya",
                        "Suite");

        queue.addBookingRequest(r1);
        queue.addBookingRequest(r2);
        queue.addBookingRequest(r3);

        System.out.println("\nProcessing Queue");

        while(queue.hasPendingRequests()) {

            Reservation reservation =
                    queue.getNextRequest();

            System.out.println(
                    reservation.getReservationId()
                            + " processed");
        }
    }

}
