package com.ihg.devops.coding.test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ihg.devops.coding.HotelDateOperationService;
import com.ihg.devops.coding.HotelDateOperationsImpl;

public class HotelDateOperationsImplTest {

	HotelDateOperationsImpl hotel = new HotelDateOperationsImpl();

	@Test
	public void canCheckInNowTest() {
		LocalDate ld = LocalDate.parse("2019-01-02");
		boolean local = hotel.canCheckInNow("berin", ld);
		if (local) {
			Assert.assertEquals(local, true);
		} else {
			Assert.assertEquals(local, false);
		}
	}

	@Test
	public void canCheckInNowTest1() {
		LocalDate ld = LocalDate.parse("2019-06-17");
		boolean local = hotel.canCheckInNow("berin", ld);
		if (local) {
			Assert.assertEquals(local, true);
		} else {
			Assert.assertEquals(local, false);
		}
	}

	@Test
	public void getReservationDateTest() {
		LocalDate local = hotel.getReservationDateNow("KUHJA");
		ZoneId zoneId = HotelDateOperationService.getTimeZone("KUHJA");
		ZonedDateTime zone = ZonedDateTime.now(zoneId);
		LocalDate tolocal = zone.toLocalDate();
		if (zone.getHour() >= 12) {
			Assert.assertEquals(local, tolocal);
		} else {
			Assert.assertEquals(local, tolocal.minusDays(1));
		}
	}

	@Test
	public void getReservationDateNowTest() {

		ZoneId zoneId = HotelDateOperationService.getTimeZone("ATLCP");
		ZonedDateTime zone = ZonedDateTime.now(zoneId);
		LocalDate local = hotel.getReservationDate("14:11", zone);
		LocalDate tolocal = zone.toLocalDate();
		if (zone.getHour() >= 12) {
			Assert.assertEquals(local, tolocal);
		} else {
			Assert.assertEquals(local, tolocal.minusDays(1));
		}

	}

	@Test
	public void getReservationDateNowTest1() {

		ZoneId zoneId = HotelDateOperationService.getTimeZone("KUHJA");
		ZonedDateTime zone = ZonedDateTime.now(zoneId);
		LocalDate local = hotel.getReservationDate("18:11", zone);
		LocalDate tolocal = zone.toLocalDate();
		if (zone.getHour() >= 12) {
			Assert.assertEquals(local, tolocal);
		} else {
			Assert.assertEquals(local, tolocal.minusDays(1));
		}

	}

	@Test
	public void getReservationDateNowTest2() {

		ZoneId zoneId = HotelDateOperationService.getTimeZone("berin");
		ZonedDateTime zone = ZonedDateTime.now(zoneId);
		LocalDate local = hotel.getReservationDate("08:11", zone);
		LocalDate tolocal = zone.toLocalDate();
		if (zone.getHour() >= 12) {
			Assert.assertEquals(local, tolocal);
		} else {
			Assert.assertEquals(local, tolocal.minusDays(1));
		}

	}
}
