package hotelReservation.domain;

import hotelReservation.domain.Customer.customerType;

import java.util.List;

public class Reservation {
	private customerType customerType;
	private List<String> dates;
	
	public customerType getCustomerType() {
		return customerType;
	}
	
	public void setCustomerType(customerType customerType) {
		this.customerType = customerType;
	}
	
	public List<String> getDates() {
		return dates;
	}
	
	public void setDates(List<String> dates) {
		this.dates = dates;
	}
	
	
}
