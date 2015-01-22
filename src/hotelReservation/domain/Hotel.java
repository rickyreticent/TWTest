package hotelReservation.domain;

import hotelReservation.domain.Customer.customerType;

import java.util.HashMap;

public class Hotel {
	public String name;
	public int rate;
	public HashMap<customerType, Float> weekdayPrice;
	public HashMap<customerType, Float> weekendPrice;
	
	public void setWeekdayPrices(HashMap<customerType, Float> weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}
	
	public void setWeekendPrices(HashMap<customerType, Float> weekendPrice) {
		this.weekendPrice = weekendPrice;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<customerType, Float> getWeekdayPrices() {
		return this.weekdayPrice;
	}
	
	public HashMap<customerType, Float> getWeekendPrices() {
		return this.weekendPrice;
	}
	
	public int getRate() {
		return this.rate;
	}
	
	public String getName() {
		return this.name;
	}
}
