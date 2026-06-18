package com.bridgelabz.bookmystayapp;

import java.sql.SQLOutput;

public class BookMyStayApp {
    private static InventoryService inventoryService;
    private static BookingQueueService bookingQueueService;
    private static BookingService bookingService;
    private static ServiceManager serviceManager;
    private static ReportService reportService;

    private static Reservation reservation1;
    private static Reservation reservation2;

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("      BOOK MY STAY APP");
        System.out.println("=================================");

        initializeServices();
        inventorySetup();
        searchRooms();
        bookingRequest();
        reservationConfirmation();
        addOnServices();
        bookingHistoryAndReports();
    }

    private static void initializeServices() {

        inventoryService = new InventoryService();

        bookingQueueService = new BookingQueueService();

        bookingService =
                new BookingService(inventoryService);

        serviceManager =
                new ServiceManager();

        reportService =
                new ReportService();
    }

    // ==========================
    // USE CASE 1
    // ==========================

    private static void inventorySetup() {

        System.out.println("\n===== USE CASE 1 : INVENTORY SETUP =====");

        inventoryService.addRoomType(
                "Single",
                5,
                2000);

        inventoryService.addRoomType(
                "Double",
                3,
                3500);

        inventoryService.addRoomType(
                "Suite",
                2,
                7000);

        inventoryService.displayInventory();
    }

    // ==========================
    // USE CASE 2
    // ==========================

    private static void searchRooms() {

        System.out.println("\n===== USE CASE 2 : ROOM SEARCH =====");

        SearchService searchService =
                new SearchService(inventoryService);

        searchService.searchRoom("Single");

        searchService.searchRoom("Suite");
    }

    // ==========================
    // USE CASE 3
    // ==========================

    private static void bookingRequest() {

        System.out.println("\n===== USE CASE 3 : BOOKING REQUEST =====");

        reservation1 =
                new Reservation(
                        "R101",
                        "Lakshmi",
                        "Single");

        reservation2 =
                new Reservation(
                        "R102",
                        "Kumar",
                        "Double");

        bookingQueueService.addBookingRequest(
                reservation1);

        bookingQueueService.addBookingRequest(
                reservation2);

        System.out.println("Booking requests added to queue");
    }

    // ==========================
    // USE CASE 4
    // ==========================

    private static void reservationConfirmation() {

        System.out.println("\n===== USE CASE 4 : ROOM ALLOCATION =====");

        while (bookingQueueService.hasPendingRequests()) {

            Reservation reservation =
                    bookingQueueService.getNextRequest();

            bookingService.confirmBooking(
                    reservation);

            reportService.addReservation(
                    reservation);
        }

        System.out.println("\nInventory After Booking:");

        inventoryService.displayInventory();
    }

    // ==========================
    // USE CASE 5
    // ==========================

    private static void addOnServices() {

        System.out.println("\n===== USE CASE 5 : ADD-ON SERVICES =====");

        serviceManager.addService(
                reservation1.getReservationId(),
                new Service(
                        "Breakfast",
                        500));

        serviceManager.addService(
                reservation1.getReservationId(),
                new Service(
                        "Airport Pickup",
                        1000));

        serviceManager.addService(
                reservation1.getReservationId(),
                new Service(
                        "Spa",
                        1500));

        double totalCost =
                serviceManager.calculateTotalServiceCost(
                        reservation1.getReservationId());

        System.out.println(
                "Total Add-On Cost = " +
                        totalCost);
    }

    // ==========================
    // USE CASE 6
    // ==========================

    private static void bookingHistoryAndReports() {

        System.out.println("\n===== USE CASE 6 : BOOKING HISTORY =====");

        reportService.showAllReservations();
    }
}
