package com.ihg.devops.coding;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public interface HotelDateOperations {

	/**
	 * Given the hotel code and a literal date/time, return the reservation date
	 */
	public LocalDate getReservationDate(String hotelCode,
			ZonedDateTime literalDateTime);

	/**
	 * Given the hotel code, return th e reservation date at this exact moment
	 */
	public LocalDate getReservationDateNow(String hotelCode);

	/**
	 * Given the hotel code and the reservation date, return whether the guest
	 * can check in to the hotel right now (ie it is not too early and not too
	 * late to check in)
	 */
	public boolean canCheckInNow(String hotelCode, LocalDate reservationDate);
}
