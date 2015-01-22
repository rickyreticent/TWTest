package tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hotelReservation.domain.Customer.customerType;
import hotelReservation.domain.Reservation;
import hotelReservation.helpers.DataReservation;

import org.junit.Test;

public class DataReservationTest {
	String filename = "C:/Users/Luine/Documents/hotelReservationFile.txt";
	DataReservation dataReservation = new DataReservation(filename);
	
	@Test
	public void readFileTest() throws IOException {
		boolean fileContentResult = dataReservation.readFile();
		
		boolean fileContentExpected = true;
		
		assertEquals(fileContentExpected, fileContentResult);
	}
	
	public void getReservationInformationsTest() throws IOException {
		HashMap<Integer, Reservation> fileContentResult = new HashMap<Integer, Reservation>();
		fileContentResult = dataReservation.getReservationInformations();
		
		HashMap<Integer, Reservation> fileContentExpected = new HashMap<Integer, Reservation>();
		
		List<String> dates = null;
		dates.add("16Mar2009(mon)");
		dates.add("17Mar2009(tues)");
		dates.add("18Mar2009(wed)");
		
		Reservation reservation = new Reservation();
		reservation.setCustomerType(customerType.Regular);
		reservation.setDates(dates);
		
		fileContentExpected.put(1, reservation);
		
		assertEquals(fileContentExpected, fileContentResult);
	}

}
