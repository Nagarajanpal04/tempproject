package com.ihg.devops.coding;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class HotelDateOperationService {

	public static ZoneId timeZone;

	public static LocalDate returnDate(int lt, ZoneId getZone,
			ZonedDateTime literalDateTime) {

		LocalDate local;
		if (lt < 14 && getZone.toString().equalsIgnoreCase("Europe/Berlin")) {
			local = literalDateTime.toLocalDate().minusDays(1);
		} else if (lt < 16
				&& getZone.toString().equalsIgnoreCase("America/New_York")) {
			local = literalDateTime.toLocalDate().minusDays(1);
		} else if (lt < 15
				&& getZone.toString().equalsIgnoreCase("Asia/Tokyo")) {
			local = literalDateTime.toLocalDate().minusDays(1);
		} else {
			local = literalDateTime.toLocalDate();
		}
		return local;
	}

	public static ZoneId getTimeZone(String hotelCode)
			throws NullPointerException {

		if (hotelCode.equalsIgnoreCase("ATLCP")) {
			timeZone = ZoneId.of("America/New_York");
		} else if (hotelCode.equalsIgnoreCase("KUHJA")) {
			timeZone = ZoneId.of("Asia/Tokyo");
		} else if (hotelCode.equalsIgnoreCase("BERIN")) {
			timeZone = ZoneId.of("Europe/Berlin");
		}

		return timeZone;
	}

}
