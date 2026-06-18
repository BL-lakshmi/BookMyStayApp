package com.bridgelabz.bookmystayapp;

import java.sql.SQLOutput;

public class BookMyStayApp {
    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();

        inventory.addRoomType("Single", 10, 2000);
        inventory.addRoomType("Double", 5, 3500);
        inventory.addRoomType("Suite", 2, 7000);

        System.out.println("===== HOTEL INVENTORY USECASE-1=====");

        inventory.displayInventory();

        System.out.println("===== SEARCHING ROOMS USECASE-2=====");

        SearchService searchService =
                new SearchService(inventory);

        System.out.println("Searching Single Room");

        searchService.searchRoom("Single");

        System.out.println();

        System.out.println("Searching Double Room");

        searchService.searchRoom("Double");

        System.out.println("BOOKING QUEUE SERVICE USECASE-3");
        BookingQueueService queue = new BookingQueueService();

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
        System.out.println("==============BOOKING CONFIRMATION USECASE-4===================");
        BookingService bookingService =
                new BookingService(inventory);

        while(queue.hasPendingRequests()) {

            Reservation reservation =
                    queue.getNextRequest();

            bookingService.confirmBooking(
                    reservation);
        }

        System.out.println(
                "\nRemaining Rooms : "
                        + inventory.getAvailableRooms(
                        "Single"));

        System.out.println("MORE SERVICES ADDED USECASE-5");
        Reservation reservation =
                new Reservation(
                        "R101",
                        "Lakshmi",
                        "Single");

        ServiceManager serviceManager =
                new ServiceManager();

        serviceManager.addService(
                reservation.getReservationId(),
                new Service(
                        "Breakfast",
                        500));

        serviceManager.addService(
                reservation.getReservationId(),
                new Service(
                        "Spa",
                        1500));

        System.out.println(
                serviceManager
                        .calculateTotalServiceCost(
                                reservation.getReservationId()));
    }

}
