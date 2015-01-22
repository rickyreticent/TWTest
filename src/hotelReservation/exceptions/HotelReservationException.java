package hotelReservation.exceptions;

public class HotelReservationException extends Exception {

	/**
	 * @author Luine
	 */
	
	private static final long serialVersionUID = 1L;

	public HotelReservationException(){
		// TODO
	}
	
	public HotelReservationException(String reason){
		super(reason);
	}
}
