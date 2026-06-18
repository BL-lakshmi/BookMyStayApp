package com.bridgelabz.bookmystayapp;
import java.util.*;

public class ReportService {
    private List<Reservation> reservationHistory = new ArrayList<>();

    public void addReservation(Reservation reservation){
        reservationHistory.add(reservation);
    }

    public void showAllReservations(){
        for(Reservation reservation : reservationHistory){

            System.out.println(reservation.getReservationId()
                            + " | "
                            + reservation.getCustomerName()
                            + " | "
                            + reservation.getAssignedRoomId()
            );
        }
    }
}
