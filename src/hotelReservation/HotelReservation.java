package hotelReservation;

import java.awt.EventQueue;

import hotelReservation.data.Database;
import hotelReservation.gui.HotelReservationGraphic;
import hotelReservation.helpers.ReservationOperations;

public class HotelReservation {
	public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new HotelReservationGraphic().createUI();
            }
        };

        EventQueue.invokeLater(r);
    }
	
	public HotelReservation() {
		Database database = new Database();
		
		ReservationOperations reservationOperations = new ReservationOperations(database);
		
		
	}
}
