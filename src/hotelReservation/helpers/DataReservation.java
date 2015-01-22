package hotelReservation.helpers;

import hotelReservation.domain.Customer.customerType;
import hotelReservation.domain.Reservation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DataReservation {
	private String filename;
	private final HashMap<Integer, Reservation> reservationInformations;
	
	public DataReservation(String filename) {
		this.filename = filename;
		this.reservationInformations = new HashMap<Integer, Reservation>();
	}
	
	public boolean readFile() throws IOException {		
		BufferedReader inputFile = null;
		String line;
		
		try {
			inputFile = new BufferedReader(new FileReader(this.filename));
	
			while ((line = inputFile.readLine()) != null) {
				this.splitInformations(line);
			}
			
			inputFile.close();
		}
		finally {
			if (inputFile != null) {
				inputFile.close();
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	
	public HashMap<Integer, Reservation> getReservationInformations() {
		return this.reservationInformations;
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	/*
	 * Split line information beetween customer type and dates 
	 */
	
	private HashMap<Integer, Reservation> splitInformations(String line) {
		String[] reservationLine = line.split(":");

		String customer = reservationLine[0];
		String dates = reservationLine[1];
		
		//Split dates and cast to List<>
		List<String> datesArray = new ArrayList<String>(Arrays.asList(this.splitDate(dates)));
		//Cast to customerType
		customerType customerType = hotelReservation.domain.Customer.customerType.valueOf(customer);
		
		Reservation reservation = new Reservation();
		reservation.setCustomerType(customerType);
		reservation.setDates(datesArray);
		
		this.reservationInformations.put(1, reservation);	 	//In this case, reservation[0] is equal to customer type and reservation[1] is equal to dates
		
		return reservationInformations;
	}
	
	private String[] splitDate(String date) {
		String[] dates = date.split(",");
		
		return dates;
	}
	
	
}
