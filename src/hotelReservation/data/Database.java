package hotelReservation.data;

import hotelReservation.domain.Hotel;
import hotelReservation.domain.Customer.customerType;

import java.util.HashMap;

public class Database {
	private final HashMap<Integer, Hotel> hotels;
	
	public Database() {
		this.hotels = new HashMap<>();
		this.initializeData();
	}
	
	public void initializeData() {
		Hotel hotelLakewood = initializeDataLakewood();
		Hotel hotelBridgewood = initializeDataBridgewood();
		Hotel hotelRidgewood = initializeDataRidgewood();
		
		this.hotels.put(1, hotelLakewood);
		this.hotels.put(2, hotelBridgewood);
		this.hotels.put(3, hotelRidgewood);
	}

	public HashMap<Integer, Hotel> getHotels() {
		return this.hotels;
	}
	
	public Hotel initializeDataLakewood() {
		Hotel hotelLakewood = new Hotel();
		HashMap<customerType, Float> weekdayPricesLakewood = new HashMap<>();
		HashMap<customerType, Float> weekendPricesLakewood = new HashMap<>();
		
		weekdayPricesLakewood.put(customerType.Regular, (float) 110.0);
		weekdayPricesLakewood.put(customerType.Rewards, (float) 80.0);
		
		weekendPricesLakewood.put(customerType.Regular, (float) 90.0);
		weekendPricesLakewood.put(customerType.Rewards, (float) 80.0);
		
		hotelLakewood.setName("Lakewood");
		hotelLakewood.setRate(3);
		hotelLakewood.setWeekdayPrices(weekdayPricesLakewood);
		hotelLakewood.setWeekendPrices(weekendPricesLakewood);
		
		return hotelLakewood;
	}
	
	public Hotel initializeDataBridgewood() {
		Hotel hotelBridgewood = new Hotel();
		HashMap<customerType, Float> weekdayPricesBridgewood = new HashMap<>();
		HashMap<customerType, Float> weekendPricesBridgewood = new HashMap<>();
		
		weekdayPricesBridgewood.put(customerType.Regular, (float) 160.0);
		weekdayPricesBridgewood.put(customerType.Rewards, (float) 110.0);
		
		weekendPricesBridgewood.put(customerType.Regular, (float) 60.0);
		weekendPricesBridgewood.put(customerType.Rewards, (float) 50.0);
		
		hotelBridgewood.setName("Bridgewood");
		hotelBridgewood.setRate(4);
		hotelBridgewood.setWeekdayPrices(weekdayPricesBridgewood);
		hotelBridgewood.setWeekendPrices(weekendPricesBridgewood);
		
		return hotelBridgewood;
	}
	
	public Hotel initializeDataRidgewood() {
		Hotel hotelRidgewood = new Hotel();
		HashMap<customerType, Float> weekdayPricesRidgewood = new HashMap<>();
		HashMap<customerType, Float> weekendPricesRidgewood = new HashMap<>();
		
		weekdayPricesRidgewood.put(customerType.Regular, (float) 220.0);
		weekdayPricesRidgewood.put(customerType.Rewards, (float) 100.0);
		
		weekendPricesRidgewood.put(customerType.Regular, (float) 150.0);
		weekendPricesRidgewood.put(customerType.Rewards, (float) 40.0);
		
		hotelRidgewood.setName("Ridgewood");
		hotelRidgewood.setRate(5);
		hotelRidgewood.setWeekdayPrices(weekdayPricesRidgewood);
		hotelRidgewood.setWeekendPrices(weekendPricesRidgewood);
		
		return hotelRidgewood;
	}
}
