package com.ihg.devops.coding;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class HotelDateOperationsImpl implements HotelDateOperations {

	static HotelDateOperationService service;

	@Override
	public LocalDate getReservationDate(String hotelCode,
			ZonedDateTime literalDateTime) {

		LocalTime lt = LocalTime.parse(hotelCode);
		ZoneId getZone = literalDateTime.getZone();
		LocalDate local = HotelDateOperationService.returnDate(lt.getHour(),
				getZone, literalDateTime);

		return local;
	}

	@Override
	public LocalDate getReservationDateNow(String hotelCode) {
		ZoneId getZone = HotelDateOperationService.getTimeZone(hotelCode);
		ZonedDateTime zone = ZonedDateTime.now(getZone);
		int getHour = zone.getHour();

		LocalDate local = HotelDateOperationService.returnDate(getHour, getZone,
				zone);

		return local;

	}

	@Override
	public boolean canCheckInNow(String hotelCode, LocalDate reservationDate) {

		String date = reservationDate.toString();
		ZoneId zoneId = HotelDateOperationService.getTimeZone(hotelCode);
		ZonedDateTime zone = ZonedDateTime.now(zoneId);
		if (zone.toLocalDate().toString().equalsIgnoreCase(date)) {
			return true;
		} else {
			return false;
		}

	}

}
