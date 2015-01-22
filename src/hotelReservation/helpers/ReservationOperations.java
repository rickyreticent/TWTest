package hotelReservation.helpers;

import hotelReservation.data.Database;
import hotelReservation.domain.Customer.customerType;
import hotelReservation.domain.Hotel;
import hotelReservation.domain.Reservation;
import hotelReservation.exceptions.HotelReservationException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReservationOperations {
	private final Database database;
	
	private int numberOfWeekends = 0;
	private int numberOfWeekdays = 0;
	
	private float bestPrice;	//TODO
	private Hotel bestHotel;
	
	public ReservationOperations(Database database) {
		this.database = database;
	}
	
	public void getInformationsReservation(String filename) throws HotelReservationException {
		 DataReservation dataReservation = new DataReservation(filename);
		 try {
			if(dataReservation.readFile()) {
				HashMap<Integer, Reservation> reservationInformation = dataReservation.getReservationInformations();
				
				
				customerType customerType = reservationInformation.get(1).getCustomerType();
				List<String> dates = reservationInformation.get(1).getDates();
				
				//Get how many weekends and weekdays has the reservation
				this.manipulateDates(dates);
				this.checkBestPrice(customerType);
				
			}
			else {
				throw new HotelReservationException("The file could not be opened.");
			}
		} catch (IOException e) {
			
		}
	}
	
	private void checkBestPrice(customerType customerType) {
		HashMap<Integer, Hotel> hotels = this.database.getHotels();
		boolean firstItem = true;
		
		for(Integer hotelKey : hotels.keySet()) {
			Hotel hotel = hotels.get(hotelKey);
			
			float price = calculatePriceByHotel(customerType, hotel);

			if(firstItem || this.bestPrice(price, hotel)) {			//If is the first item, assign values anyway 
				this.setBestPrice(price);
				this.setBestHotel(hotel);
				
				firstItem = false;
			}
		}
		
		System.out.println(this.getBestHotel().name);
	}
	
	public void setBestPrice(float price) {
		this.bestPrice = price;
	}
	
	public void setBestHotel(Hotel hotel) {
		this.bestHotel = hotel;
	}
	
	public Hotel getBestHotel() {
		return this.bestHotel;
	}

	private void manipulateDates(List<String> dates) {
		for (String date : dates) {
			String weekday = getWeekday(date);
			
			switch (weekday) {
				case "mon":
					this.numberOfWeekdays++;
					break;
				case "tues":
					this.numberOfWeekdays++;
					break;
				case "wed":
					this.numberOfWeekdays++;
					break;
				case "thur":
					this.numberOfWeekdays++;
					break;
				case "fri":
					this.numberOfWeekdays++;
					break;
				case "sat":
					this.numberOfWeekends++;
					break;
				case "sun":
					this.numberOfWeekends++;
					break;
				default:
					break;
			}
		}
	}
	
	private static String getWeekday(String date) {
		String weekday = null;
		Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(date);
		
		while(m.find()) {
			weekday = m.group(1);
		}
		
		return weekday;
	}
	
	private float calculatePriceByHotel(customerType customerType, Hotel hotel) {			
		float price = 0;
		
		if(hotel.getWeekdayPrices().containsKey(customerType)) {
			price += (hotel.getWeekdayPrices().get(customerType))*numberOfWeekdays;
		}
		
		if(hotel.getWeekendPrices().containsKey(customerType)) {
			price += (hotel.getWeekendPrices().get(customerType))*numberOfWeekends;
		}

		return price;
	}
	
	private boolean bestPrice(float price, Hotel hotel) {
		if (this.bestPrice > price)
			return true;
		else if (this.bestPrice == price) {			//In case of a tie, is considered the rating
			if(this.bestHotel.getRate() < hotel.getRate())
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
}
