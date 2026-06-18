package com.bridgelabz.bookmystayapp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BookingService {
    private Set<String> bookedRoomIds = new HashSet<>();

    private HashMap<String, Set<String>>
            allocatedRooms = new HashMap<>();

    private InventoryService inventory;

    public BookingService(
            InventoryService inventory) {

        this.inventory = inventory;
    }

    public void confirmBooking(
            Reservation reservation) {

        String roomType =
                reservation.getRoomType();

        if (inventory.getAvailableRooms(roomType)
                <= 0) {

            System.out.println(
                    "No rooms available");
            return;
        }

        String roomId =
                roomType.substring(0, 1)
                        + System.currentTimeMillis();

        bookedRoomIds.add(roomId);

        allocatedRooms
                .computeIfAbsent(
                        roomType,
                        k -> new HashSet<>())
                .add(roomId);

        reservation.setAssignedRoomId(roomId);

        inventory.decrementRoom(roomType);

        System.out.println(
                "Booking Confirmed : "
                        + roomId);

    }
}
