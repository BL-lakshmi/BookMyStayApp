package com.bridgelabz.bookmystayapp;

public class Reservation {
    private String reservationId;
    private String customerName;
    private String roomType;
    private String assignedRoomId;

    public Reservation(String reservationId,
                       String customerName,
                       String roomType) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getAssignedRoomId() {
        return assignedRoomId;
    }

    public void setAssignedRoomId(String assignedRoomId) {
        this.assignedRoomId = assignedRoomId;
    }
}
