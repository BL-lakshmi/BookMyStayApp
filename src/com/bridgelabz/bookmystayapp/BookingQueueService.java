package com.bridgelabz.bookmystayapp;

import java.util.LinkedList;
import java.util.Queue;

public class BookingQueueService {
    private Queue<Reservation> bookingQueue = new LinkedList<>();

    public void addBookingRequest(
            Reservation reservation){

        bookingQueue.offer(reservation);

        System.out.println(
                reservation.getReservationId()
                        + " added to queue");
    }

    public Reservation getNextRequest(){
        return bookingQueue.poll();
    }

    public boolean hasPendingRequests(){
        return !bookingQueue.isEmpty();
    }
}
